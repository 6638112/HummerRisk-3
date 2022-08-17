package com.hummerrisk.base.domain;

import java.io.Serializable;

public class CloudNativeResult implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result.id
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result.cloud_native_id
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    private String cloudNativeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result.name
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result.plugin_icon
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    private String pluginIcon;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result.result_status
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    private String resultStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result.create_time
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result.update_time
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    private Long updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result.apply_user
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    private String applyUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result.user_name
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result.return_sum
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    private Long returnSum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cloud_native_result
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result.id
     *
     * @return the value of cloud_native_result.id
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result.id
     *
     * @param id the value for cloud_native_result.id
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result.cloud_native_id
     *
     * @return the value of cloud_native_result.cloud_native_id
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public String getCloudNativeId() {
        return cloudNativeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result.cloud_native_id
     *
     * @param cloudNativeId the value for cloud_native_result.cloud_native_id
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public void setCloudNativeId(String cloudNativeId) {
        this.cloudNativeId = cloudNativeId == null ? null : cloudNativeId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result.name
     *
     * @return the value of cloud_native_result.name
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result.name
     *
     * @param name the value for cloud_native_result.name
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result.plugin_icon
     *
     * @return the value of cloud_native_result.plugin_icon
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public String getPluginIcon() {
        return pluginIcon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result.plugin_icon
     *
     * @param pluginIcon the value for cloud_native_result.plugin_icon
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public void setPluginIcon(String pluginIcon) {
        this.pluginIcon = pluginIcon == null ? null : pluginIcon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result.result_status
     *
     * @return the value of cloud_native_result.result_status
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public String getResultStatus() {
        return resultStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result.result_status
     *
     * @param resultStatus the value for cloud_native_result.result_status
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus == null ? null : resultStatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result.create_time
     *
     * @return the value of cloud_native_result.create_time
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result.create_time
     *
     * @param createTime the value for cloud_native_result.create_time
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result.update_time
     *
     * @return the value of cloud_native_result.update_time
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result.update_time
     *
     * @param updateTime the value for cloud_native_result.update_time
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result.apply_user
     *
     * @return the value of cloud_native_result.apply_user
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public String getApplyUser() {
        return applyUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result.apply_user
     *
     * @param applyUser the value for cloud_native_result.apply_user
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser == null ? null : applyUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result.user_name
     *
     * @return the value of cloud_native_result.user_name
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result.user_name
     *
     * @param userName the value for cloud_native_result.user_name
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result.return_sum
     *
     * @return the value of cloud_native_result.return_sum
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public Long getReturnSum() {
        return returnSum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result.return_sum
     *
     * @param returnSum the value for cloud_native_result.return_sum
     *
     * @mbg.generated Wed Aug 17 03:08:41 CST 2022
     */
    public void setReturnSum(Long returnSum) {
        this.returnSum = returnSum;
    }
}