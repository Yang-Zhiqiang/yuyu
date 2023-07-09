#!/bin/sh
# 有効区分更新バッチ（機能ＩＤ停止）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh invalidfunctionupdatebatch "yuukouKbn=DISABLE,kinouIdKinouModeIdKbn=KINOUID,$@"