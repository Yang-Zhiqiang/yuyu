#!/bin/sh
# 工程履歴・JBPMデータ削除処理を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzdeleteprocessandjbpmrecord $@
