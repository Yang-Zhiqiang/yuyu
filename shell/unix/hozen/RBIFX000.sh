#!/bin/sh
#契約保全モニタリングデータ抽出（クーリングオフ）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh khmonitoringdatacoolingoff $@
