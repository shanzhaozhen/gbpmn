import type { Node, Edge, Graph } from '@antv/x6'

export interface NodeMeta extends Node.Metadata {
  selectable?: boolean
  movable?: boolean
}

export interface EdgeMeta extends Edge.Metadata {
  animated?: boolean
}

export type GraphData = (NodeMeta | EdgeMeta)[]

export interface GraphOptions {
  configs: Graph.Options
  data: (NodeMeta | EdgeMeta)[]
  nodeOptions?: Node.Metadata
  edgeOptions?: Edge.Metadata

  readonly?: boolean
  centerContent?: boolean
  zoomToFit?: boolean
  layout?: any // todo
}

/**
 * 用于定位元素
 */
export interface IPosition {
  width?: number
  height?: number
  lineHeight?: number
  top?: number
  left?: number
  right?: number
  bottom?: number
}

export interface IMiniMapProps {
  nodeFillColor?: string
  borderColor?: string
  handlerColor?: string
  miniMapClz?: string
  position?: IPosition
}

export type IToolbarLayout = 'horizontal' | 'vertical' | 'vertical' | 'horizontal-center'
