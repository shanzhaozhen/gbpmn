import React, { FC, useCallback, useEffect, useMemo } from 'react'
import { Scroller as X6Scroll } from '@antv/x6-plugin-scroller'
import {useGraph} from "@/components/X6Editor/hooks/graph";

export const Scroller: FC<X6Scroll.Options> = (props) => {
  const graph = useGraph()
  const initScroller = useCallback(() => {
    if (graph) {
      const scroller = graph.getPlugin<X6Scroll>(X6Scroll.name)

      if (scroller) {
        // TODO: add setOptions function to handle
        // scroller.setOptions(options)
      } else {
        const graphScroller = new X6Scroll(props)

        graph.use(graphScroller)
      }
    }
  }, [graph, props])

  useEffect(() => {
    initScroller()
  }, [graph, props, initScroller])

  return <></>
}

export const useScroller = () => {
  const graph = useGraph()

  return useMemo(
    () => graph && graph.getPlugin<X6Scroll>(X6Scroll.name),
    [graph],
  )
}
