package com.agileboot.domain.base.realestate.query;

import cn.hutool.core.text.CharSequenceUtil;
import com.agileboot.orm.base.entity.BaseRealEstateEntity;
import com.agileboot.orm.common.query.AbstractPageQuery;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;

/**
 * 楼盘资料查询
 *
 * @Author payne.zhuang <paynezhuang@gmail.com>
 * @ProjectName lianjia-boot
 * @ClassName com.agileboot.domain.base.realestate.query.BaseRealestateQuery
 * @CreateTime 2023/4/5 - 14:51
 */
@Data
public class BaseRealestateQuery extends AbstractPageQuery<BaseRealEstateEntity> {

    private String name;

    @Override
    public QueryWrapper<BaseRealEstateEntity> toQueryWrapper() {
        return new QueryWrapper<BaseRealEstateEntity>()
                .like(CharSequenceUtil.isNotEmpty(name), "name", name)
                .last("order by create_time desc");
    }
}
