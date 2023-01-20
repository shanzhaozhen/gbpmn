import type { IAppLoad } from '@antv/xflow'
import React, { useRef, useEffect } from 'react'
/** 交互组件 */
import {
  /** XFlow核心组件 */
    XFlow,
  /** 流程图画布组件 */
    FlowchartCanvas,
  /** 流程图配置扩展 */
    FlowchartExtension,
  /** 流程图节点组件 */
    FlowchartNodePanel,
  /** 流程图表单组件 */
    FlowchartFormPanel,
  /** 通用组件：快捷键 */
    KeyBindings,
  /** 通用组件：画布缩放 */
    CanvasScaleToolbar,
  /** 通用组件：右键菜单 */
    CanvasContextMenu,
  /** 通用组件：工具栏 */
    CanvasToolbar,
  /** 通用组件：对齐线 */
    CanvasSnapline,
  /** 通用组件：节点连接桩 */
    CanvasNodePortTooltip, NodeCollapsePanel, CanvasMiniMap,
} from '@antv/xflow'
import type { Graph } from '@antv/x6'
/** 配置Command*/
import { useCmdConfig } from './config/config-cmd'
/** 配置Menu */
import { useMenuConfig } from './config/config-menu'
/** 配置Toolbar */
import { useToolbarConfig } from './config/config-toolbar'
/** 配置快捷键 */
import { useKeybindingConfig } from './config/config-keybinding'
/** 配置节点面板 */
import * as panelConfig from './config/config-panel';

import './index.less'
import '@antv/xflow/dist/index.css';
import EndNode from "@/components/FlowEditor/node/EndNode";
import ApprovalNode from "@/components/FlowEditor/node/ApprovalNode";
import SendNode from "@/components/FlowEditor/node/SendNode";
import RobotNode from "@/components/FlowEditor/node/RobotNode";
import StartNode from "@/components/FlowEditor/node/StartNode";
import SwitchNode from "@/components/FlowEditor/node/SwitchNode";
import ParallelNode from "@/components/FlowEditor/node/ParallelNode";

export interface IProps {
  meta: { flowId: string }
}

export const FlowEditor: React.FC<IProps> = props => {
  const { meta } = props
  const toolbarConfig = useToolbarConfig()
  const menuConfig = useMenuConfig()
  const keybindingConfig = useKeybindingConfig()
  const graphRef = useRef<Graph>()
  const commandConfig = useCmdConfig()

  const nodesList = [
    {
      component: StartNode,
      popover: () => <div>开始节点</div>,
      name: 'flow-node-start',
      width: 120,
      height: 40,
      label: '开始节点',
    },
    {
      component: EndNode,
      popover: () => <div>结束节点</div>,
      name: 'flow-node-end',
      width: 120,
      height: 40,
      label: '开始节点',
    },
    {
      component: ApprovalNode,
      popover: () => <div>审批节点</div>,
      name: 'flow-node-approval',
      width: 120,
      height: 40,
      label: '审批节点',
    },
    {
      component: SendNode,
      popover: () => <div>抄送节点</div>,
      name: 'flow-node-send',
      width: 120,
      height: 40,
      label: '抄送节点',
    },
    {
      component: RobotNode,
      popover: () => <div>机器人节点</div>,
      name: 'flow-node-robot',
      width: 120,
      height: 40,
      label: '机器人节点',
    },
    {
      component: SwitchNode,
      popover: () => <div>条件分支</div>,
      name: 'flow-node-switch',
      width: 120,
      height: 40,
      label: '条件分支',
    },
    {
      component: ParallelNode,
      popover: () => <div>并行分支</div>,
      name: 'flow-node-parallel',
      width: 120,
      height: 40,
      label: '并行分支',
    },
  ];


  /**
   * @param app 当前XFlow工作空间
   * @param extensionRegistry 当前XFlow配置项
   */
  const onLoad: IAppLoad = async app => {
    graphRef.current = await app.getGraphInstance();
  }

  useEffect(() => {
    if (graphRef.current) {
      graphRef.current.on('node:click', (...arg) => {
        console.log(arg)
      })
    }
  }, [graphRef])

  return (
    // @ts-ignore
    <XFlow
      className="flow-user-custom-clz"
      commandConfig={commandConfig}
      onLoad={onLoad}
      meta={meta}
    >
      <FlowchartExtension />
      <FlowchartNodePanel
        // showOfficial={false}
        defaultActiveKey={['custom']}
        // @ts-ignore
        registerNode={{
          key: 'custom',
          title: '流程节点',
          nodes: nodesList,
        }}
        position={{ width: 162, top: 40, bottom: 0, left: 0 }}
      />
      <CanvasToolbar
        className="xflow-workspace-toolbar-top"
        layout="horizontal"
        config={toolbarConfig}
        position={{ top: 0, left: 0, right: 0, bottom: 0 }}
      />
      {/* @ts-ignore */}
      <FlowchartCanvas position={{ top: 40, left: 0, right: 0, bottom: 0 }}>
        <CanvasScaleToolbar
          layout="horizontal"
          position={{ top: -40, right: 0 }}
          style={{
            width: 150,
            left: 'auto',
            height: 39,
          }}
        />
        <CanvasContextMenu config={menuConfig} />
        <CanvasSnapline color="#faad14" />
        <CanvasNodePortTooltip />
      </FlowchartCanvas>
      <FlowchartFormPanel show={true} position={{ width: 200, top: 40, bottom: 0, right: 0 }} />
      <KeyBindings config={keybindingConfig} />
      {/*<NodeCollapsePanel
        searchService={panelConfig.searchService}
        // header={<h4 style={{lineHeight: 0}}> 组件面板 </h4>}
        footer={<div> Foorter </div>}
        onNodeDrop={panelConfig.onNodeDrop}
        nodeDataService={panelConfig.nodeDataService}
        position={{ top: 40, bottom: 0, left: 162, width: 290 }}
      />*/}
      {/*<CanvasMiniMap
        miniMapClz="xflow-custom-minimap"
        nodeFillColor="#ccc"
        minimapOptions={{
          width: 200,
          height: 120,
        }}
        position={{ top: 40, right: 60 }}
      />*/}
    </XFlow>
  )
}

export default FlowEditor
