package com.hummerrisk.base.domain;

import java.io.Serializable;

public class CloudNativeResultKubenchWithBLOBs extends CloudNativeResultKubench implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result_kubench.title
     *
     * @mbg.generated Sun Dec 25 23:41:12 CST 2022
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cloud_native_result_kubench.description
     *
     * @mbg.generated Sun Dec 25 23:41:12 CST 2022
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cloud_native_result_kubench
     *
     * @mbg.generated Sun Dec 25 23:41:12 CST 2022
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result_kubench.title
     *
     * @return the value of cloud_native_result_kubench.title
     *
     * @mbg.generated Sun Dec 25 23:41:12 CST 2022
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result_kubench.title
     *
     * @param title the value for cloud_native_result_kubench.title
     *
     * @mbg.generated Sun Dec 25 23:41:12 CST 2022
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cloud_native_result_kubench.description
     *
     * @return the value of cloud_native_result_kubench.description
     *
     * @mbg.generated Sun Dec 25 23:41:12 CST 2022
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cloud_native_result_kubench.description
     *
     * @param description the value for cloud_native_result_kubench.description
     *
     * @mbg.generated Sun Dec 25 23:41:12 CST 2022
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}