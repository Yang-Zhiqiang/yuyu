#!/bin/sh
# MQ緊急停止状態更新バッチ（緊急停止終了）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh mqemgcystopstatusupdate "mqEmgcyStopStatus=MQEMGCYSTOP_END"