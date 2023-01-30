package org.shanzhaozhen.gbpmn.core.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-30
 * @Description:
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum RuntimeStatus {

    ERROR("错误", "00"),
    READY("预备", "10"),
    RUNNING("执行中", "20"),
    FINISH("完成", "30"),

    ;

    private String name;

    private String code;

}
