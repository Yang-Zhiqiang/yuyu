#!/bin/sh
# MQ緊急停止状態更新バッチ（緊急停止開始）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh mqemgcystopstatusupdate "mqEmgcyStopStatus=MQEMGCYSTOP_START"