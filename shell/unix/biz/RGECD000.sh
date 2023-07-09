#!/bin/sh
#外貨ＦＢ送金データ取込（支払）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzgkfbsoukintrkmsi $@
