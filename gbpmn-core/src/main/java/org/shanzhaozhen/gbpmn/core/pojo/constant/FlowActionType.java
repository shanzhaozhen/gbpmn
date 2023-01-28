package org.shanzhaozhen.gbpmn.core.pojo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-25
 * @Description: 流程操作种类
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum FlowActionType {

    LAUNCH("发起"),
    TEMPORIZE("暂存"),
    NOTIFY("通知"),
    AGREE("同意"),
    REJECT("驳回"),
    TRANSFER("转办"),
    COUNTERSIGN("加签"),
    ABANDON("废弃"),
    ;

    private String name;

}