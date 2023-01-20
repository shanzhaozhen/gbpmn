import React, {FC, PropsWithChildren, useState} from "react";
import {Provider} from "@/components/X6Editor/GraphContext";
import {Graph} from "@antv/x6";

const X6Flow: FC<PropsWithChildren> = ({ children }) => {
  const [graph, setGraph] = useState<Graph | null>(null)

  return <Provider value={{ graph, setGraph }}>{children}</Provider>
}

export default X6Flow
