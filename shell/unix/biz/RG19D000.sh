#!/bin/sh
# マスタ取込（特定関係法人マスタ）処理を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bztokuteikankeihoujintorikomi $@
