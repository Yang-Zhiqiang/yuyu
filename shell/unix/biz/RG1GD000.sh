#!/bin/sh
# マスタ取込（代理店委託商品情報テーブル）処理を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzdairitenitakutorikomi $@
