package org.shanzhaozhen.gbpmn.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-29
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("g_process_record")
@Schema(description = "流程记录")
public class ProcessRecord extends BaseEntity {

    private static final long serialVersionUID = 7145679871323543398L;

    @Schema(description = "主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(description = "节点id")
    private String nodeId;

    @Schema(description = "节点名称")
    private String nodeName;

    @Schema(description = "节点内容")
    private String content;

    @Schema(description = "操作人ID")
    private String operatorId;

    @Schema(description = "操作方式")
    private String operatorType;

}
