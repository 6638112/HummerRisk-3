package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.CloudEventRegionLog;
import com.hummerrisk.base.domain.CloudEventRegionLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CloudEventRegionLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_event_region_log
     *
     * @mbg.generated Sat Sep 10 00:01:27 CST 2022
     */
    long countByExample(CloudEventRegionLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_event_region_log
     *
     * @mbg.generated Sat Sep 10 00:01:27 CST 2022
     */
    int deleteByExample(CloudEventRegionLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_event_region_log
     *
     * @mbg.generated Sat Sep 10 00:01:27 CST 2022
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_event_region_log
     *
     * @mbg.generated Sat Sep 10 00:01:27 CST 2022
     */
    int insert(CloudEventRegionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_event_region_log
     *
     * @mbg.generated Sat Sep 10 00:01:27 CST 2022
     */
    int insertSelective(CloudEventRegionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_event_region_log
     *
     * @mbg.generated Sat Sep 10 00:01:27 CST 2022
     */
    List<CloudEventRegionLog> selectByExample(CloudEventRegionLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_event_region_log
     *
     * @mbg.generated Sat Sep 10 00:01:27 CST 2022
     */
    CloudEventRegionLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_event_region_log
     *
     * @mbg.generated Sat Sep 10 00:01:27 CST 2022
     */
    int updateByExampleSelective(@Param("record") CloudEventRegionLog record, @Param("example") CloudEventRegionLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_event_region_log
     *
     * @mbg.generated Sat Sep 10 00:01:27 CST 2022
     */
    int updateByExample(@Param("record") CloudEventRegionLog record, @Param("example") CloudEventRegionLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_event_region_log
     *
     * @mbg.generated Sat Sep 10 00:01:27 CST 2022
     */
    int updateByPrimaryKeySelective(CloudEventRegionLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cloud_event_region_log
     *
     * @mbg.generated Sat Sep 10 00:01:27 CST 2022
     */
    int updateByPrimaryKey(CloudEventRegionLog record);
}