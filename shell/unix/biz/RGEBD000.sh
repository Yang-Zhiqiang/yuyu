#!/bin/sh
#外貨ＦＢ送金データ取込（契約保全）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzgkfbsoukintrkmkh $@
