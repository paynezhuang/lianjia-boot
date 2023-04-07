package com.agileboot.domain.base.realestate;

import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.base.realestate.dto.RealestateDTO;
import com.agileboot.domain.base.realestate.model.RealestateModelFactory;
import com.agileboot.domain.base.realestate.query.BaseRealestateQuery;
import com.agileboot.orm.base.entity.BaseRealEstateEntity;
import com.agileboot.orm.base.service.IBaseRealEstateService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 楼盘资料
 *
 * @Author payne.zhuang <paynezhuang@gmail.com>
 * @ProjectName lianjia-boot
 * @ClassName com.agileboot.domain.base.realestate.RealestateApplicationService
 * @CreateTime 2023/4/2 - 19:52
 */

@Service
@RequiredArgsConstructor
public class RealestateApplicationService {

    @NonNull
    private RealestateModelFactory realestateModelFactory;

    @NonNull
    private IBaseRealEstateService baseRealEstateService;

    public PageDTO<RealestateDTO> getRealestateList(BaseRealestateQuery query) {
        Page<BaseRealEstateEntity> page = baseRealEstateService.page(query.toPage(), query.toQueryWrapper());
        List<RealestateDTO> records = page.getRecords().stream().map(RealestateDTO::new).collect(Collectors.toList());
        return new PageDTO<>(records, page.getTotal());
    }

    public boolean importExcelData(MultipartFile file) {
        var realestateModel = realestateModelFactory.create();
        // 解析文件
        realestateModel.analyzeFile(file);
        // 检查大厦名字是否重复
        realestateModel.checkNameIsUnique();
        // 保存
        return realestateModel.insert();
    }
}
