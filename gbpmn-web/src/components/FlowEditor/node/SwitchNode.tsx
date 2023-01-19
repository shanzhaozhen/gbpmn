import React from 'react'
import {SwitcherTwoTone} from "@ant-design/icons";
import {Space} from "antd";
import {useEmotionCss} from "@ant-design/use-emotion-css";

interface SwitchNodeProps {
  size?: {
    width: number;
    height: number
  } | undefined;
  data: any
}

const SwitchNode: React.FC<SwitchNodeProps> = (props) => {
  const { size = { width: 120, height: 40 }, data } = props
  const { width, height } = size
  const { label, stroke, fill, fontFill, fontSize } = data

  const switchNodeClassName = useEmotionCss(() => ({
    position: 'relative',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    padding: '10px 12px',
    overflow: 'hidden',
    background: '#fff',
    border: '1px solid #84b2e8',
    borderRadius: '5px',
    boxShadow: '0 1px 4px 0 rgba(0, 0, 0, 0.2)',
  }));

  return (
    <div
      className={switchNodeClassName}
      style={{
        width,
        height,
        borderColor: stroke,
        backgroundColor: fill,
        color: fontFill,
        fontSize,
      }}
    >
      <Space>
        <SwitcherTwoTone />
        <span>{label}</span>
      </Space>
    </div>
  )
};

export default SwitchNode;

