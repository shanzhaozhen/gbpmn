package org.shanzhaozhen.gbpmn.core.pojo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "流程执行")
public class ProcessAction {

    @Schema(description = "流程ID")
    private String processId;

    @Schema(description = "操作方式")
    private String actionType;

    @Schema(description = "内容")
    private String content;

    @Schema(description = "附件")
    private List<String> annexes;

    @Schema(description = "驳回方式")
    private String rejectType;

    @Schema(description = "转办人员")
    private List<String> transferors;

    @Schema(description = "沟通人员")
    private List<String> communicationMembers;


}
