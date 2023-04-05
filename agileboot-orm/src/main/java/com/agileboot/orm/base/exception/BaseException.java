package com.agileboot.orm.base.exception;

import com.agileboot.common.exception.error.ErrorCodeInterface;
import com.agileboot.common.exception.error.Module;

/**
 * Base 通用异常枚举
 *
 * @Author payne.zhuang <paynezhuang@gmail.com>
 * @ProjectName lianjia-boot
 * @ClassName com.agileboot.orm.base.exception.BaseException
 * @CreateTime 2023/4/5 - 14:23
 */
public enum BaseException implements ErrorCodeInterface {

    REALESTATE_NAME_IS_NOT_UNIQUE(Module.BASE_REALESTATE, 1, "大厦名称不允许重复"),

    ;

    private static final int BASE_CODE = 40000;
    private final int code;
    private final String msg;

    BaseException(Module module, int code, String msg) {
        this.code = BASE_CODE + module.code() + code;
        this.msg = msg;
    }

    @Override
    public int code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.msg;
    }
}
