#!/bin/sh
# オンライン開始信号受信処理（代理店）を起動します。

###############################################################################
### ■シェル名　　　　　　：オンライン開始信号受信（代理店）
###
### ■製作日　　　　　　　：2016年10月20日
###
### ■製作者／改変者　　　：SLC
###
### ■使用目的　　　　　　：ホストからのオンライン開始信号の受信（代理店インスタンス）
###
### ■使用方法　　　　　　：第一引数：ポート番号
###                                       社内（ray）     : 9080
###                                       代理店（ray_ag）: 9083
###                                       ＤＳ（ray_ds）  : 9082
###
###　　　　　　　　　　　　 第二引数：インスタンス名（ray/ray_ds/ray_ag）
###
### ■実行結果　　　　　　：正常（0)　httpレスポンス204の場合
### 　　　　　　　　　　　：異常（1)　httpレスポンス上記以外の場合
###
###############################################################################

###RESPONSE=`curl -s http://localhost:$1/$2/webservice/yuyu.infrext.mq.MqControlSignalReceiveService/execMqOnlineStartSignalReceive -o /dev/null -w "%{http_code}\n"`


RESPONSE=`curl -s http://localhost:9083/ray_ag/webservice/yuyu.infrext.mq.MqControlSignalReceiveService/execMqOnlineStartSignalReceive -o /dev/null -w "%{http_code}\n"`

if [ ${RESPONSE} -eq 204 ]; then
  echo "OK"
  echo ${RESPONSE}
  exit 0
else
  echo "NG"
  echo ${RESPONSE}
  exit 1
fi

