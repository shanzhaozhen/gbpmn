import React, { FC, useRef, useEffect, useCallback } from 'react'
import { MiniMap } from '@antv/x6-plugin-minimap'
import { useGraph } from '../../hooks/graph'

import {useEmotionCss} from "@ant-design/use-emotion-css";
import {IMiniMapProps} from "@/components/X6Editor/types";

export const Minimap: FC<Omit<MiniMap.Options, 'container'> & IMiniMapProps> = (props) => {
  const graph = useGraph()
  const mapRef = useRef<HTMLDivElement | null>(null)

  const {
    // nodeFillColor,
    borderColor = '#ced4de',
    handlerColor = 'rgba(0,0,0,.3)',
    // miniMapClz = '',
    position = { bottom: 12, right: 12 },
  } = props

  const appMinimapClassName = useEmotionCss(() => ({
      position: 'absolute',
      zIndex: 999,
      background: '#fff',
      boxShadow: '0 0 10px 0 rgba(0,0,0,.15)',
      '.x6-widget-minimap': {
        border: '1px solid rgba(0, 0, 0, 0.1)',
        background: 'rgba(34,34,34,.05)',
        // background: 'hsla(0,0%,100%,.9)',
        '.x6-graph': {
          background: 'hsla(0,0%,100%,.9)',
        },
        '.x6-widget-minimap-viewport': {
          border: `1px solid ${borderColor}`,
          margin: 0
        },
        '.x6-widget-minimap-viewport-zoom': {
          border: `1px solid ${handlerColor}`
        },
      },
      // ...(position || defaultPosition)
    }));

  const positionClassName = useEmotionCss(() => ({
    ...position
  }))


  const initMinimap = useCallback(() => {
    if (mapRef.current && graph) {
      const options = { ...props, container: mapRef.current }
      const minimap = graph.getPlugin<MiniMap>(MiniMap.name)

      if (minimap) {
        // TODO: add setOption function
        // minimap.setOptions(options)
      } else {
        const GraphMinimap = new MiniMap(options)

        graph.use(GraphMinimap)
      }
    }
  }, [mapRef, props, graph])

  useEffect(() => {
    initMinimap()
  }, [mapRef, graph, initMinimap])

  return <div className={`${appMinimapClassName} ${positionClassName}`} ref={mapRef} />
}
