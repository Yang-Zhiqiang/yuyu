#!/bin/sh
# マスタ取込（住所マスタ）処理を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzaddresstorikomi $@
