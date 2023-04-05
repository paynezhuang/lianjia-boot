package com.agileboot.domain.base.realestate.model;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.agileboot.common.exception.ApiException;
import com.agileboot.common.exception.error.ErrorCode;
import com.agileboot.domain.system.role.model.RoleModel;
import com.agileboot.orm.base.entity.BaseRealEstateEntity;
import com.agileboot.orm.base.service.IBaseRealEstateService;
import com.agileboot.orm.system.entity.SysRoleMenuEntity;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 楼盘资料 Model 模型工厂
 *
 * @Author payne.zhuang <paynezhuang@gmail.com>
 * @ProjectName lianjia-boot
 * @ClassName com.agileboot.domain.base.realestate.model.RealestateModelFactory
 * @CreateTime 2023/4/5 - 11:41
 */

@Component
@RequiredArgsConstructor
public class RealestateModelFactory {

    @NonNull
    private IBaseRealEstateService baseRealEstateService;

    public RealestateModel create() {
        return new RealestateModel(baseRealEstateService);
    }

    public RealestateModel loadById(Long realestateId) {
        BaseRealEstateEntity byId = baseRealEstateService.getById(realestateId);
        if (byId == null) {
            throw new ApiException(ErrorCode.Business.OBJECT_NOT_FOUND, realestateId, "楼盘");
        }

        return new RealestateModel(byId, baseRealEstateService);
    }
}
