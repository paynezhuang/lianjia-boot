package com.agileboot.domain.base.realestate.model;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.agileboot.common.exception.ApiException;
import com.agileboot.common.exception.error.ErrorCode;
import com.agileboot.orm.base.entity.BaseRealEstateEntity;
import com.agileboot.orm.base.exception.BaseException;
import com.agileboot.orm.base.service.IBaseRealEstateService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 楼盘资料 Model
 *
 * @Author payne.zhuang <paynezhuang@gmail.com>
 * @ProjectName lianjia-boot
 * @ClassName com.agileboot.domain.base.realestate.model.RealestateModel
 * @CreateTime 2023/4/5 - 11:39
 */

@Data
@NoArgsConstructor
public class RealestateModel extends BaseRealEstateEntity {

    private transient IBaseRealEstateService baseRealEstateService;

    public RealestateModel(IBaseRealEstateService baseRealEstateService) {
        this.baseRealEstateService = baseRealEstateService;
    }

    public RealestateModel(BaseRealEstateEntity entity, IBaseRealEstateService baseRealEstateService) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
        this.baseRealEstateService = baseRealEstateService;
    }

    /**
     * 检查大厦名字是否重复
     *
     * @author payne.zhuang
     * @CreateTime 2023-04-05 14:21
     */
    public void checkNameIsUnique() {
        if (baseRealEstateService.isNameDuplicated(getName())) {
            throw new ApiException(BaseException.REALESTATE_NAME_IS_NOT_UNIQUE, getName());
        }
    }

    /**
     * 解析文件
     *
     * @param file Excel 文件
     * @author payne.zhuang
     * @CreateTime 2023-04-05 14:13
     */
    public void analyzeFile(MultipartFile file) {
        try {
            ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
            // 大厦名称
            this.setName(readCellValue(reader, 1, 1));
            // 大厦地址
            this.setAddress(readCellValue(reader, 7, 1));
            // 建筑面积
            this.setConstructionArea(readCellValue(reader, 6, 2));
            // 发展商名称
            this.setDeveloperName(readCellValue(reader, 1, 3));
            // 收楼时间
            this.setRepossessionTime(readCellValue(reader, 10, 3));
            // 总高度
            this.setTotalHeight(readCellValue(reader, 1, 4));
            // 电梯数量
            this.setElevatorsNumber(readCellValue(reader, 10, 4));
            // 标准层面积
            this.setLayerArea(readCellValue(reader, 1, 6));
            // 电力
            this.setElectricity(readCellValue(reader, 1, 6));
            // 是否后备供电(0否 1是)
            this.setElectricityBackup(readCellValue(reader, 7, 6));
            // 使用率/面积
            this.setUtilizationRate(readCellValue(reader, 10, 6));
            // 标准层承重
            this.setLayerBearing(readCellValue(reader, 1, 7));
            // 层高
            this.setStoreyHeight(readCellValue(reader, 6, 7));
            // 净深
            this.setNetDepth(readCellValue(reader, 10, 7));
            // 空调系统/品牌
            this.setAirConditioning(readCellValue(reader, 1, 9));
            // 加装空调
            this.setAirConditioningInstall(readCellValue(reader, 6, 9));
            // 交通情况
            this.setTrafficCondition(readCellValue(reader, 1, 15));
            // 大厦配套
            this.setBuildingSupporting(readCellValue(reader, 1, 16));
            // 物业公司
            this.setPropertyCompany(readCellValue(reader, 1, 20));
            // 空调开放时间
            this.setAirConditioningHours(readCellValue(reader, 1, 22));
            // 大厦停车数量
            this.setParkingNumber(readCellValue(reader, 6, 22));
            // 停车收费
            this.setParkingFee(readCellValue(reader, 10, 22));
            // 水电周转金
            this.setHydropowerTurnover(readCellValue(reader, 1, 23));
            // 装修押金
            this.setDecorationDeposit(readCellValue(reader, 10, 23));
        } catch (IOException e) {
            throw new ApiException(ErrorCode.Internal.UNKNOWN_ERROR);
        }
    }

    /**
     * 坐标读取文件
     *
     * @param reader ExcelReader 解析对象
     * @param x      x 轴
     * @param y      y 轴
     * @return {@link String} 读取值，去除空格
     * @author payne.zhuang
     * @CreateTime 2023-04-05 14:13
     */
    private String readCellValue(ExcelReader reader, int x, int y) {
        Object value = reader.readCellValue(x, y);
        // 去除所有空格
        return CharSequenceUtil.cleanBlank(value.toString());
    }

}
