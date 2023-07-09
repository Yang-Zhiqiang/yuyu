#!/bin/sh
# マスタ取込（金融機関普保預振情報マスタ）処理を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzkinyuukikanhuhoyohuriinfotorikomi $@
