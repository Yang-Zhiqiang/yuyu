#!/bin/sh
# ユーザー権限自動反映処理を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzuserrolemake $@
