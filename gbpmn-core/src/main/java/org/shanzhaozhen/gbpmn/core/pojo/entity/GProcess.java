package org.shanzhaozhen.gbpmn.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("g_process")
@Schema(description = "流程")
public class GProcess {

    @Schema(description = "主键ID")
    private String id;

    @Schema(description = "开始")
    private GNode start;

    @Schema(description = "流程图实例节点")
    private Map<String, GNode> nodes;

    @Schema(description = "流程图实例线")
    private Map<String, GEdge> edges;

    /**
     * 获取开始节点
     * @return
     */
    public GNode getStartNode() {
        return null;
    }

    public GNode gNodeWithID(String peNodeID) {
        return null;
    }
}
