import React, {useEffect, useRef, useState} from "react";

import { Graph, Shape } from '@antv/x6';
import { Stencil } from '@antv/x6-plugin-stencil';
import { Transform } from '@antv/x6-plugin-transform';
import { Selection } from '@antv/x6-plugin-selection';
import { Snapline } from '@antv/x6-plugin-snapline';
import { Keyboard } from '@antv/x6-plugin-keyboard';
import { Clipboard } from '@antv/x6-plugin-clipboard';
import { History } from '@antv/x6-plugin-history';
// import insertCss from 'insert-css'

export interface X6EditorProps {
  meta: { flowId: string }
}

const data = {
  nodes: [
    {
      id: 'node1',
      shape: 'rect',
      x: 40,
      y: 40,
      width: 100,
      height: 40,
      label: 'hello',
      attrs: {
        // body 是选择器名称，选中的是 rect 元素
        body: {
          stroke: '#8f8f8f',
          strokeWidth: 1,
          fill: '#fff',
          rx: 6,
          ry: 6,
        },
      },
    },
    {
      id: 'node2',
      shape: 'rect',
      x: 160,
      y: 180,
      width: 100,
      height: 40,
      label: 'world',
      attrs: {
        body: {
          stroke: '#8f8f8f',
          strokeWidth: 1,
          fill: '#fff',
          rx: 6,
          ry: 6,
        },
      },
    },
  ],
  edges: [
    {
      shape: 'edge',
      source: 'node1',
      target: 'node2',
      label: 'x6',
      attrs: {
        // line 是选择器名称，选中的边的 path 元素
        line: {
          stroke: '#8f8f8f',
          strokeWidth: 1,
        },
      },
    },
  ],
}

const X6Editor: React.FC<X6EditorProps> = (props) => {

  const container = useRef<HTMLDivElement>(null);
  const [graph, setGraph] = useState<Graph>()

  const init = () => {
    const tmp = new Graph({
      container: container,
      // 设置画布背景颜色
      background: {
        color: '#F2F7FA',
      },
    })

    tmp.fromJSON(data) // 渲染元素
    tmp.centerContent() // 居中显示

    setGraph(tmp);
  }

  useEffect(() => {

    return () => {
      init();
    }
  }, [])



  return (
    <div>
      <div ref={container} />
    </div>
  );

}

export default X6Editor;
