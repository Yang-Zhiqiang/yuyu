#!/bin/sh
# 有効区分更新バッチ（機能モードＩＤ再開）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh invalidfunctionupdatebatch "yuukouKbn=ENABLE,kinouIdKinouModeIdKbn=KINOUMODEID,$@"