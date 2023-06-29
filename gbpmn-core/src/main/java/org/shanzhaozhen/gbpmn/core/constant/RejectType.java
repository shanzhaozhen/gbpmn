package org.shanzhaozhen.gbpmn.core.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-02-07
 * @Description:
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum RejectType {

    DEFAULT("默认", "0"),
    BACK_MYSELF("返回本人", "1"),
    BACK_NODE("返回本节点", "2"),

    ;

    private String name;

    private String code;

}
