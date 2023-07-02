import React, {FC, useRef, useEffect, useCallback, useState, MutableRefObject} from 'react'
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

  const { layout, position } = props

  const layoutClassName = useEmotionCss(() => {
    return layout === 'vertical' ? {
      right: 'unset',
      left: 'unset',
      width: '32px',
      height: 'auto',
      border: '1px solid rgba(0,0,0,.04)',
      borderRadius: '4px',
      boxShadow: '0 0 20px rgb(0 0 0/1%)',
    } : {}
  })


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

  return <div className={layoutClassName} ref={toolBarRef} >
    <Toolbar>
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
          console.log(document.fullscreenEnabled)
          // if (fullscreen) {
          //   if (!document.fullscreenEnabled) {
          //     document.exitFullscreen();
          //   }
          //   setFullscreen(false)
          // } else {
          //   // toolBarRef.current?.parentElement?.parentElement?.requestFullscreen();
          //   container?.current?.requestFullscreen();
          //   setFullscreen(true)
          // }
          console.log(document.fullscreenElement)
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
}
