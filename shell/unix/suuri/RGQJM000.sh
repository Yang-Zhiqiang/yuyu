#!/bin/sh
# 新契約決算用データ保存期間管理処理を起動します。
cd `dirname $0`
../AppLaunchBatch.sh srskkessandataretentionperiod $@
