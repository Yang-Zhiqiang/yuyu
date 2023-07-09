#!/bin/sh
# 新契約追込保険料伝票データ抽出処理を起動します。
cd `dirname $0`
../AppLaunchBatch.sh srskoikomipdenpyoudata $@
