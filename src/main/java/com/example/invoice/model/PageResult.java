package com.example.invoice.model;

import lombok.Data;

import java.util.Objects;

/**
 * @Classname PageResult
 * @Description TODO
 * @Date 2022/3/28 14:53
 * @Author by fuxf
 */
@Data
public class PageResult extends BaseResult{

    private long total;
    private long pageNo;
    private long pageSize;

    public PageResult() {
        this.setCode(CODE_SUCCESS);
        this.setMsg(MSG_SUCCESS);
    }

    public PageResult(BaseResult ajaxResult) {
        this();
        if (Objects.nonNull(ajaxResult)) {
            setCode(ajaxResult.getCode());
            setMsg(ajaxResult.getMsg());
        }
    }

}
