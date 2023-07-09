#!/bin/sh
#契約保全モニタリングデータ抽出（ＰＥＰｓ）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh khmonitoringdatapeps $@
