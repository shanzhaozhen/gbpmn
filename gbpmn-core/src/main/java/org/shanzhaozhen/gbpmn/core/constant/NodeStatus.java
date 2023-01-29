package org.shanzhaozhen.gbpmn.core.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-29
 * @Description: 流程状态
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum NodeStatus {

    ERROR("错误", "00"),
    DRAFT("起稿", "10"),
    PENDING("待审", "20"),
    FINISH("完成", "30"),
    ;

    private String name;

    private String code;

}
