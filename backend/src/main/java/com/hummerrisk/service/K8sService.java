package com.hummerrisk.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hummerrisk.base.domain.*;
import com.hummerrisk.base.mapper.*;
import com.hummerrisk.base.mapper.ext.ExtCloudNativeResultMapper;
import com.hummerrisk.commons.constants.*;
import com.hummerrisk.commons.utils.*;
import com.hummerrisk.controller.request.k8s.K8sResultRequest;
import com.hummerrisk.proxy.k8s.K8sRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author harris
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class K8sService {

    @Resource
    private CloudNativeMapper cloudNativeMapper;
    @Resource
    private CloudNativeResultMapper cloudNativeResultMapper;
    @Resource
    private ExtCloudNativeResultMapper extCloudNativeResultMapper;
    @Resource
    private CloudNativeResultLogMapper cloudNativeResultLogMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private HistoryService historyService;
    @Resource
    private NoticeService noticeService;
    @Resource
    private CloudNativeResultItemMapper cloudNativeResultItemMapper;

    public void scan(String id) throws Exception {
        CloudNative cloudNative = cloudNativeMapper.selectByPrimaryKey(id);
        Integer scanId = historyService.insertScanHistory(cloudNative);
        if(StringUtils.equalsIgnoreCase(cloudNative.getStatus(), CloudAccountConstants.Status.VALID.name())) {
            CloudNativeResultWithBLOBs result = new CloudNativeResultWithBLOBs();

            deleteResultByCloudNativeId(id);

            BeanUtils.copyBean(result, cloudNative);
            result.setId(UUIDUtil.newUUID());
            result.setCloudNativeId(id);
            result.setApplyUser(SessionUtils.getUserId());
            result.setCreateTime(System.currentTimeMillis());
            result.setUpdateTime(System.currentTimeMillis());
            result.setResultStatus(CloudTaskConstants.TASK_STATUS.APPROVED.toString());
            result.setUserName(SessionUtils.getUser().getName());
            cloudNativeResultMapper.insertSelective(result);

            saveCloudNativeResultLog(result.getId(), "i18n_start_k8s_result", "", true);
            OperationLogService.log(SessionUtils.getUser(), result.getId(), result.getName(), ResourceTypeConstants.CLOUD_NATIVE.name(), ResourceOperation.CREATE, "i18n_start_k8s_result");

            historyService.insertScanTaskHistory(result, scanId, cloudNative.getId(), TaskEnum.k8sAccount.getType());

            historyService.insertHistoryCloudNativeResult(BeanUtils.copyBean(new HistoryCloudNativeResultWithBLOBs(), result));
        }
    }

    public String reScan(String id) throws Exception {
        CloudNativeResultWithBLOBs result = cloudNativeResultMapper.selectByPrimaryKey(id);

        result.setUpdateTime(System.currentTimeMillis());
        result.setResultStatus(CloudTaskConstants.TASK_STATUS.APPROVED.toString());
        result.setUserName(SessionUtils.getUser().getName());
        cloudNativeResultMapper.updateByPrimaryKeySelective(result);

        reScanDeleteCloudNativeResult(id);

        saveCloudNativeResultLog(result.getId(), "i18n_restart_k8s_result", "", true);

        OperationLogService.log(SessionUtils.getUser(), result.getId(), result.getName(), ResourceTypeConstants.CLOUD_NATIVE.name(), ResourceOperation.CREATE, "i18n_restart_k8s_result");

        historyService.updateHistoryCloudNativeResult(BeanUtils.copyBean(new HistoryCloudNativeResultWithBLOBs(), result));

        return result.getId();
    }

    public void createScan (CloudNativeResultWithBLOBs result) throws Exception {
        try {
            CloudNative cloudNative = cloudNativeMapper.selectByPrimaryKey(result.getCloudNativeId());
            if (StringUtils.equalsIgnoreCase(PlatformUtils.k8s, cloudNative.getPluginId())) {
                K8sRequest k8sRequest = new K8sRequest();
                k8sRequest.setCredential(cloudNative.getCredential());
                String token = "Bearer " + k8sRequest.getToken();
                String url = k8sRequest.getUrl();
                if (url.endsWith("/")) {
                    url = url + CloudNativeConstants.URL2;
                } else {
                    url = url + CloudNativeConstants.URL1;
                }
                Map<String, String> param = new HashMap<>();
                param.put("Accept", CloudNativeConstants.Accept);
                param.put("Authorization", token);
                String reponse1 = HttpClientUtil.HttpGet(url, param);
                result.setConfigAuditReport(reponse1);
                String url2 = k8sRequest.getUrl();
                if (url2.endsWith("/")) {
                    url2 = url2 + CloudNativeConstants.URL4;
                } else {
                    url2 = url2 + CloudNativeConstants.URL3;
                }
                String reponse2 = HttpClientUtil.HttpGet(url2, param);
                result.setVulnerabilityReport(reponse2);
            } else if(StringUtils.equalsIgnoreCase(PlatformUtils.rancher, cloudNative.getPluginId())) {

            } else if(StringUtils.equalsIgnoreCase(PlatformUtils.openshift, cloudNative.getPluginId())) {

            } else if(StringUtils.equalsIgnoreCase(PlatformUtils.kubesphere, cloudNative.getPluginId())) {

            }
            result.setUpdateTime(System.currentTimeMillis());
            result.setResultStatus(CloudTaskConstants.TASK_STATUS.FINISHED.toString());

            long count = saveResultItem(result);
            result.setReturnSum(count);
            cloudNativeResultMapper.updateByPrimaryKeySelective(result);

            noticeService.createCloudNativeMessageOrder(result);
            saveCloudNativeResultLog(result.getId(), "i18n_end_k8s_result", "", true);

            historyService.updateHistoryCloudNativeResult(BeanUtils.copyBean(new HistoryCloudNativeResultWithBLOBs(), result));
        } catch (Exception e) {
            LogUtil.error("create ImageResult: " + e.getMessage());
            result.setUpdateTime(System.currentTimeMillis());
            result.setResultStatus(CloudTaskConstants.TASK_STATUS.ERROR.toString());
            cloudNativeResultMapper.updateByPrimaryKeySelective(result);
            historyService.updateHistoryCloudNativeResult(BeanUtils.copyBean(new HistoryCloudNativeResultWithBLOBs(), result));
            saveCloudNativeResultLog(result.getId(), "i18n_operation_ex" + ": " + e.getMessage(), e.getMessage(), false);
        }
    }

    public void deleteResultByCloudNativeId(String id) throws Exception {
        CloudNativeResultExample example = new CloudNativeResultExample();
        example.createCriteria().andCloudNativeIdEqualTo(id);
        List<CloudNativeResult> list = cloudNativeResultMapper.selectByExample(example);

        for (CloudNativeResult result : list) {
            CloudNativeResultItemExample cloudNativeResultItemExample = new CloudNativeResultItemExample();
            cloudNativeResultItemExample.createCriteria().andResultIdEqualTo(result.getId());
            cloudNativeResultItemMapper.deleteByExample(cloudNativeResultItemExample);
            CloudNativeResultLogExample logExample = new CloudNativeResultLogExample();
            logExample.createCriteria().andResultIdEqualTo(result.getId());
            cloudNativeResultLogMapper.deleteByExample(logExample);
        }
        cloudNativeResultMapper.deleteByExample(example);
    }

    public void reScanDeleteCloudNativeResult(String id) throws Exception {
        CloudNativeResultItemExample cloudNativeResultItemExample = new CloudNativeResultItemExample();
        cloudNativeResultItemExample.createCriteria().andResultIdEqualTo(id);
        cloudNativeResultItemMapper.deleteByExample(cloudNativeResultItemExample);
    }

    void saveCloudNativeResultLog(String resultId, String operation, String output, boolean result) throws Exception {
        CloudNativeResultLog cloudNativeResultLog = new CloudNativeResultLog();
        String operator = "system";
        try {
            if (SessionUtils.getUser() != null) {
                operator = SessionUtils.getUser().getId();
            }
        } catch (Exception e) {
            //防止单元测试无session
        }
        cloudNativeResultLog.setOperator(operator);
        cloudNativeResultLog.setResultId(resultId);
        cloudNativeResultLog.setCreateTime(System.currentTimeMillis());
        cloudNativeResultLog.setOperation(operation);
        cloudNativeResultLog.setOutput(output);
        cloudNativeResultLog.setResult(result);
        cloudNativeResultLogMapper.insertSelective(cloudNativeResultLog);

        historyService.insertHistoryCloudNativeResultLog(BeanUtils.copyBean(new HistoryCloudNativeResultLog(), cloudNativeResultLog));
    }

    long saveResultItem(CloudNativeResultWithBLOBs result) throws Exception {

        String json = result.getVulnerabilityReport();
        JSONObject jsonObject1 = JSON.parseObject(json);
        JSONArray jsonArray1 = jsonObject1.getJSONArray("items");
        int i = 0;
        for(Object object : jsonArray1) {
            JSONObject obj1 = (JSONObject) object;
            JSONObject jsonObject2 = obj1.getJSONObject("report");
            JSONArray jsonArray = jsonObject2.getJSONArray("vulnerabilities");
            for(Object object2 : jsonArray) {
                JSONObject obj2 = (JSONObject) object2;
                CloudNativeResultItem cloudNativeResultItem = new CloudNativeResultItem();
                cloudNativeResultItem.setId(UUIDUtil.newUUID());
                cloudNativeResultItem.setResultId(result.getId());
                cloudNativeResultItem.setPrimaryLink(obj2.getString("primaryLink"));
                cloudNativeResultItem.setScore(obj2.getString("score"));
                cloudNativeResultItem.setSeverity(obj2.getString("severity"));
                cloudNativeResultItem.setTarget(obj2.getString("target"));
                cloudNativeResultItem.setTitle(obj2.getString("title"));
                cloudNativeResultItem.setVulnerabilityId(obj2.getString("vulnerabilityID"));
                cloudNativeResultItem.setInstalledVersion(obj2.getString("installedVersion"));
                cloudNativeResultItem.setFixedVersion(obj2.getString("fixedVersion"));
                cloudNativeResultItem.setLinks(obj2.getString("links"));
                cloudNativeResultItem.setCreateTime(System.currentTimeMillis());
                cloudNativeResultItemMapper.insertSelective(cloudNativeResultItem);

                historyService.insertHistoryCloudNativeResultItem(BeanUtils.copyBean(new HistoryCloudNativeResultItem(), cloudNativeResultItem));
                i++;
            }
        }


        return i;
    }

    public List<CloudNativeResult> resultList(K8sResultRequest request) {
        List<CloudNativeResult> list = extCloudNativeResultMapper.resultList(request);
        return list;
    }

    public void deleteCloudNativeResult(String id) throws Exception {

        CloudNativeResultLogExample logExample = new CloudNativeResultLogExample();
        logExample.createCriteria().andResultIdEqualTo(id);
        cloudNativeResultLogMapper.deleteByExample(logExample);

        cloudNativeResultMapper.deleteByPrimaryKey(id);
    }

}