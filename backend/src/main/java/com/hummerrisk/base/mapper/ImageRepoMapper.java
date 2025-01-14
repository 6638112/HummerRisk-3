package com.hummerrisk.base.mapper;

import com.hummerrisk.base.domain.ImageRepo;
import com.hummerrisk.base.domain.ImageRepoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageRepoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    long countByExample(ImageRepoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    int deleteByExample(ImageRepoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    int insert(ImageRepo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    int insertSelective(ImageRepo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    List<ImageRepo> selectByExampleWithBLOBs(ImageRepoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    List<ImageRepo> selectByExample(ImageRepoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    ImageRepo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    int updateByExampleSelective(@Param("record") ImageRepo record, @Param("example") ImageRepoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    int updateByExampleWithBLOBs(@Param("record") ImageRepo record, @Param("example") ImageRepoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    int updateByExample(@Param("record") ImageRepo record, @Param("example") ImageRepoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    int updateByPrimaryKeySelective(ImageRepo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    int updateByPrimaryKeyWithBLOBs(ImageRepo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table image_repo
     *
     * @mbg.generated Tue Mar 14 11:30:39 CST 2023
     */
    int updateByPrimaryKey(ImageRepo record);
}