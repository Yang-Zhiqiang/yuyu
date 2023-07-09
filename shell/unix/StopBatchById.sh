#!/bin/sh
# 引数チェック
if [ $# -ne 0 ] ; then

  # バッチを停止
  ./LaunchBatch.sh abort "batchId=$1"

else

  echo 中断したいバッチの機能IDを指定してください。

fi
