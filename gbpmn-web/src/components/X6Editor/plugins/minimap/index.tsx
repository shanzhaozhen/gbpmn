import React, { FC, useRef, useEffect, useCallback } from 'react'
import { MiniMap } from '@antv/x6-plugin-minimap'
import { useGraph } from '../../hooks/graph'

export const Minimap: FC<Omit<MiniMap.Options, 'container'>> = (props) => {
  const graph = useGraph()
  const mapRef = useRef<HTMLDivElement | null>(null)

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

  return <div ref={mapRef} />
}
