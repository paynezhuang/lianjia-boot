package com.agileboot.admin.controller.base;

import com.agileboot.common.core.base.BaseController;
import com.agileboot.common.core.dto.ResponseDTO;
import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.base.realestate.RealestateApplicationService;
import com.agileboot.domain.base.realestate.dto.RealestateDTO;
import com.agileboot.domain.base.realestate.query.BaseRealestateQuery;
import com.agileboot.infrastructure.annotations.AccessLog;
import com.agileboot.orm.base.service.IBaseRealEstateService;
import com.agileboot.orm.common.enums.BusinessTypeEnum;
import com.agileboot.orm.system.service.ISysNoticeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 楼盘资料 前端控制器
 * </p>
 *
 * @author payne.zhuang
 * @since 2023-04-02
 */
@RestController
@RequestMapping("/base/real_estate")
@RequiredArgsConstructor
public class BaseRealEstateController extends BaseController {

    @NonNull
    private IBaseRealEstateService baseRealEstateService;

    @NonNull
    private RealestateApplicationService realestateApplicationService;

    @Operation(summary = "楼盘资料列表")
    @PreAuthorize("@permission.has('base:real_estate:list')")
    @GetMapping("/list")
    public ResponseDTO<PageDTO<RealestateDTO>> list(BaseRealestateQuery query) {
        PageDTO<RealestateDTO> page = realestateApplicationService.getRealestateList(query);
        return ResponseDTO.ok(page);
    }

    @Operation(summary = "楼盘资料导入")
    @AccessLog(title = "楼盘资料", businessType = BusinessTypeEnum.IMPORT)
    @PreAuthorize("@permission.has('base:real_estate:import')")
    @PostMapping("/importData")
    public ResponseDTO<Void> importData(MultipartFile file) {
        boolean result = realestateApplicationService.importExcelData(file);
        return ResponseDTO.status(result);
    }

    @Operation(summary = "删除楼盘")
    @PreAuthorize("@permission.has('base:real_estate:remove')")
    @AccessLog(title = "楼盘资料", businessType = BusinessTypeEnum.DELETE)
    @DeleteMapping(value = "/{realestateId}")
    public ResponseDTO<Void> remove(@PathVariable("realestateId") List<Long> realestateIds) {
        baseRealEstateService.removeBatchByIds(realestateIds);
        return ResponseDTO.ok();
    }
}

