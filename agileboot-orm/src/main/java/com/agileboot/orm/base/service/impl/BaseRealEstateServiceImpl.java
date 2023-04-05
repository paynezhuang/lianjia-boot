package com.agileboot.orm.base.service.impl;


import com.agileboot.orm.base.entity.BaseRealEstateEntity;
import com.agileboot.orm.base.mapper.BaseRealEstateMapper;
import com.agileboot.orm.base.service.IBaseRealEstateService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.var;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 楼盘资料 服务实现类
 * </p>
 *
 * @author payne.zhuang
 * @since 2023-04-02
 */
@Service
public class BaseRealEstateServiceImpl extends ServiceImpl<BaseRealEstateMapper, BaseRealEstateEntity> implements IBaseRealEstateService {

    @Override
    public boolean isNameDuplicated(String name) {
        var queryWrapper = new LambdaQueryWrapper<BaseRealEstateEntity>()
                .eq(BaseRealEstateEntity::getName, name);
        return this.baseMapper.exists(queryWrapper);
    }
}
