#!/bin/sh
# 有効区分更新バッチ（一斉停止）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh invalidfunctionupdatebatch "yuukouKbn=DISABLE,kinouIdKinouModeIdKbn=KINOUID,kousinData=ALL"