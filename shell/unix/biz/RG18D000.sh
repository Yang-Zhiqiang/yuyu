#!/bin/sh
# マスタ取込（代理店法人商号マスタ）処理を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzdairitensyougoutorikomi $@
