package org.shanzhaozhen.gbpmn.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-29
 * @Description: 流程状态持久化
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("g_process_record")
@Schema(description = "流程实例")
public class ProcessRuntime extends BaseEntity {

    private static final long serialVersionUID = 7145679871323543398L;

    @Schema(description = "主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(description = "流程实例ID")
    private String processId;

    @Schema(description = "模板ID")
    private String templateId;

    @Schema(description = "模板版本")
    private String templateVersion;

    @Schema(description = "流程图数据，复制对应流程图版本，因为可能存在流程途中修改的情况")
    private String detail;

    @Schema(description = "当前节点")
    private String nodeId;

    @Schema(description = "当前状态")
    private String status;

    @Schema(description = "发布时间")
    private LocalDateTime publishDate;

}
