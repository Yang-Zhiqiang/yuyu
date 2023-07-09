#!/bin/sh
# オンライン終了信号受信バッチを起動します。
cd `dirname $0`
../AppLaunchBatch.sh mqcontrolsignalreceive "mqOnlineStatus=MQONLINE_HUKA"