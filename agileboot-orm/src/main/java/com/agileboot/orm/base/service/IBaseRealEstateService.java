package com.agileboot.orm.base.service;

import com.agileboot.orm.base.entity.BaseRealEstateEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 楼盘资料 服务类
 * </p>
 *
 * @author payne.zhuang
 * @since 2023-04-02
 */
public interface IBaseRealEstateService extends IService<BaseRealEstateEntity> {

    public boolean isNameDuplicated(String name);

}
