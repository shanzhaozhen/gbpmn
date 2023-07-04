import React, {FC, useRef, useEffect, useCallback, useState} from 'react'
import { useGraph } from '../../hooks/graph'

import {IPosition, IToolbarLayout} from "@/components/X6Editor/types";
import {Toolbar} from "@antv/x6-react-components";
import {
  AlignCenterOutlined,
  CompressOutlined, FullscreenExitOutlined,
  FullscreenOutlined,
  OneToOneOutlined,
  ZoomInOutlined,
  ZoomOutOutlined
} from "@ant-design/icons";

import Item = Toolbar.Item;
import {useEmotionCss} from "@ant-design/use-emotion-css";

import './index.less'

export interface IToolbarProps {
  // toolbarConfig 用于设置model的toolbarItems
  // config: ToolbarConfig
  // 用于确定toolbar 的布局: "horizontal" | "vertical" | "horizontal-center"
  layout: IToolbarLayout
  // 用于定位元素
  position?: IPosition
  // 样式
  style?: React.CSSProperties
  // classname
  className?: string
}


export const ScaleToolbar: FC<IToolbarProps> = (props) => {
  const graph = useGraph()
  const toolBarRef = useRef<HTMLDivElement | null>(null)
  const [fullscreen, setFullscreen] = useState(false);

  const {
    position = { top: 12, left: 12 },
  } = props

  // 全屏监听
  const handleFullScreenChange = async () => {
    const fullscreen = !!document.fullscreenElement
    setFullscreen(fullscreen)
  }
  document.addEventListener('fullscreenchange', handleFullScreenChange, false)

  const initMinimap = useCallback(() => {
    if (toolBarRef.current && graph) {

    }
  }, [toolBarRef, props, graph])

  useEffect(() => {
    initMinimap()
  }, [toolBarRef, graph, initMinimap])

  return <div className="vertical scale-toolbar" style={position} ref={toolBarRef} >
    <div className="vertical x6-toolbar-root">
      <Toolbar hoverEffect={true}>
        <Item
          name="zoomIn"
          tooltip="放大"
          icon={<ZoomInOutlined />}
          onClick={() => {
            graph?.zoom(0.1)
          }}
        />
        <Item
          name="zoomOut"
          tooltip="缩小"
          icon={<ZoomOutOutlined />}
          onClick={() => {
            graph?.zoom(-0.1)
          }}
        />
        <Item
          name="scale-to-one"
          tooltip="缩放到1:1"
          icon={<OneToOneOutlined />}
          onClick={() => {
            graph?.zoomTo(1)
          }}
        />
        <Item
          name="scale-to-fit"
          tooltip="缩放到适应屏幕"
          icon={<CompressOutlined />}
          onClick={() => {
            graph?.zoomToFit()
          }}
        />
        <Item
          name="align-center"
          tooltip="居中"
          icon={<AlignCenterOutlined />}
          onClick={() => {
            graph?.centerContent()
          }}
        />
        <Item
          name="fullscreen"
          tooltip={fullscreen ? '退出全屏' : '全屏'}
          icon={fullscreen ? <FullscreenExitOutlined /> : <FullscreenOutlined/>}
          onClick={() => {
            if (!document.fullscreenElement) {
              if (toolBarRef?.current?.parentElement) {
                toolBarRef.current.parentElement.requestFullscreen?.()
              }
            } else {
              document.exitFullscreen?.()
            }
          }}
        />
      </Toolbar>
    </div>
  </div>
}
