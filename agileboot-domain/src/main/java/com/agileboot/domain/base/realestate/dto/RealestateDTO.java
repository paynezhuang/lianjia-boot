package com.agileboot.domain.base.realestate.dto;

import cn.hutool.core.bean.BeanUtil;
import com.agileboot.orm.base.entity.BaseRealEstateEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * 楼盘资料 DTO 对象
 *
 * @Author payne.zhuang <paynezhuang@gmail.com>
 * @ProjectName lianjia-boot
 * @ClassName com.agileboot.domain.base.realestate.dto.RealestateDTO
 * @CreateTime 2023/4/5 - 11:42
 */

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RealestateDTO {

    /**
     * 楼盘ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 楼盘大厦名称
     */
    private String name;
    /**
     * 楼盘大厦地址
     */
    private String address;
    /**
     * 建筑面积
     */
    private String constructionArea;
    /**
     * 发展商名称
     */
    private String developerName;
    /**
     * 收楼时间
     */
    private String repossessionTime;
    /**
     * 总高度
     */
    private String totalHeight;
    /**
     * 电梯数量
     */
    private String elevatorsNumber;
    /**
     * 标准层面积
     */
    private String layerArea;
    /**
     * 电力
     */
    private String electricity;
    /**
     * 是否后备供电(0否 1是)
     */
    private String electricityBackup;
    /**
     * 使用率/面积
     */
    private String utilizationRate;
    /**
     * 标准层承重
     */
    private String layerBearing;
    /**
     * 层高
     */
    private String storeyHeight;
    /**
     * 净深
     */
    private String netDepth;
    /**
     * 空调系统/品牌
     */
    private String airConditioning;
    /**
     * 加装空调
     */
    private String airConditioningInstall;
    /**
     * 交通情况
     */
    private String trafficCondition;
    /**
     * 大厦配套
     */
    private String buildingSupporting;
    /**
     * 物业公司
     */
    private String propertyCompany;
    /**
     * 管理费
     */
    private String managementFee;
    /**
     * 空调开放时间
     */
    private String airConditioningHours;
    /**
     * 大厦停车数量
     */
    private String parkingNumber;
    /**
     * 停车收费
     */
    private String parkingFee;
    /**
     * 水电周转金
     */
    private String hydropowerTurnover;
    /**
     * 装修押金
     */
    private String decorationDeposit;
    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    public RealestateDTO(BaseRealEstateEntity entity) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
    }
}
