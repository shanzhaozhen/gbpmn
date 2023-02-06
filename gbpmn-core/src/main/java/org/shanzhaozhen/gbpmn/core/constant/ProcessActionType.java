package org.shanzhaozhen.gbpmn.core.constant;

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
public enum ProcessActionType {

    LAUNCH("发起", "LAUNCH"),
    TEMPORIZE("暂存", "TEMPORIZE"),
    NOTIFY("通知", "NOTIFY"),
    AGREE("同意", "AGREE"),
    REJECT("驳回", "REJECT"),
    TRANSFER("转办", "TRANSFER"),
    COUNTERSIGN("加签", "COUNTERSIGN"),
    ABANDON("废弃", "ABANDON"),
    ;

    private String name;
    private String code;

}
