package com.agileboot.orm.base.entity;

import com.agileboot.common.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 楼盘资料
 * </p>
 *
 * @author payne.zhuang
 * @since 2023-04-02
 */
@Getter
@Setter
@TableName("base_real_estate")
@ApiModel(value = "BaseRealEstateEntity对象", description = "楼盘资料")
public class BaseRealEstateEntity extends BaseEntity<BaseRealEstateEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("楼盘ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("楼盘大厦名称")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("楼盘大厦地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("建筑面积")
    @TableField("construction_area")
    private String constructionArea;

    @ApiModelProperty("发展商名称")
    @TableField("developer_name")
    private String developerName;

    @ApiModelProperty("收楼时间")
    @TableField("repossession_time")
    private String repossessionTime;

    @ApiModelProperty("总高度")
    @TableField("total_height")
    private String totalHeight;

    @ApiModelProperty("电梯数量")
    @TableField("elevators_number")
    private String elevatorsNumber;

    @ApiModelProperty("标准层面积")
    @TableField("layer_area")
    private String layerArea;

    @ApiModelProperty("电力")
    @TableField("electricity")
    private String electricity;

    @ApiModelProperty("是否后备供电(0否 1是)")
    @TableField("electricity_backup")
    private String electricityBackup;

    @ApiModelProperty("使用率/面积")
    @TableField("utilization_rate")
    private String utilizationRate;

    @ApiModelProperty("标准层承重")
    @TableField("layer_bearing")
    private String layerBearing;

    @ApiModelProperty("层高")
    @TableField("storey_height")
    private String storeyHeight;

    @ApiModelProperty("净深")
    @TableField("net_depth")
    private String netDepth;

    @ApiModelProperty("空调系统/品牌")
    @TableField("air_conditioning")
    private String airConditioning;

    @ApiModelProperty("加装空调")
    @TableField("air_conditioning_install")
    private String airConditioningInstall;

    @ApiModelProperty("交通情况")
    @TableField("traffic_condition")
    private String trafficCondition;

    @ApiModelProperty("大厦配套")
    @TableField("building_supporting")
    private String buildingSupporting;

    @ApiModelProperty("物业公司")
    @TableField("property_company")
    private String propertyCompany;

    @ApiModelProperty("空调开放时间")
    @TableField("air_conditioning_hours")
    private String airConditioningHours;

    @ApiModelProperty("大厦停车数量")
    @TableField("parking_number")
    private String parkingNumber;

    @ApiModelProperty("停车收费")
    @TableField("parking_fee")
    private String parkingFee;

    @ApiModelProperty("水电周转金")
    @TableField("hydropower_turnover")
    private String hydropowerTurnover;

    @ApiModelProperty("装修押金")
    @TableField("decoration_deposit")
    private String decorationDeposit;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
