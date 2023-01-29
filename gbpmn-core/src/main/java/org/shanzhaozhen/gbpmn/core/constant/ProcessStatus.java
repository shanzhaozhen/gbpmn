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
public enum ProcessStatus {

    ABANDON("废弃", "00"),
    DRAFT("草稿", "10"),
    REJECT("驳回", "11"),
    PENDING("待审", "20"),
    PUBLISH("发布", "30"),
    EXPIRE("过期", "40"),
    ;

    private String name;

    private String code;

}
