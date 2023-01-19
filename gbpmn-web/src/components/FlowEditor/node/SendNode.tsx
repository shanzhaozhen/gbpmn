import React from 'react'
import {Space} from "antd";
import {useEmotionCss} from "@ant-design/use-emotion-css";
import {MailTwoTone} from "@ant-design/icons";

interface SendNodeProps {
  size?: {
    width: number;
    height: number
  } | undefined;
  data: any
}

const SendNode: React.FC<SendNodeProps> = (props) => {
  const { size = { width: 120, height: 40 }, data } = props
  const { width, height } = size
  const { label, stroke, fill, fontFill, fontSize } = data

  const sendNodeClassName = useEmotionCss(() => ({
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
      className={sendNodeClassName}
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
        <MailTwoTone />
        <span>{label}</span>
      </Space>
    </div>
  )
};

export default SendNode;

