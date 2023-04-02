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
 * 楼盘扩展表
 * </p>
 *
 * @author payne.zhuang
 * @since 2023-04-02
 */
@Getter
@Setter
@TableName("base_real_estate_info")
@ApiModel(value = "BaseRealEstateInfoEntity对象", description = "楼盘扩展表")
public class BaseRealEstateInfoEntity extends BaseEntity<BaseRealEstateInfoEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("楼盘扩展表ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("楼盘ID")
    @TableField("real_estate_id")
    private Long realEstateId;

    @ApiModelProperty("楼盘大厦名称")
    @TableField("real_estate_name")
    private String realEstateName;

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


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
