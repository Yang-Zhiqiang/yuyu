#!/bin/sh
# オンライン開始信号受信バッチを起動します。
cd `dirname $0`
../AppLaunchBatch.sh mqcontrolsignalreceive "mqOnlineStatus=MQONLINE_KA"