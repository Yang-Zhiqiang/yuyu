#!/bin/sh
# 新契約追込集計表（保険料伝票リスト）作成処理を起動します。
cd `dirname $0`
../AppLaunchBatch.sh srskoikomisyuukeihyoupdenpyoulist $@
