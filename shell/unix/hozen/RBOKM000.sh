#!/bin/sh
#ＳＭＢＣ月次契約明細Ｆ作成処理を起動します。
cd `dirname $0`
../AppLaunchBatch.sh khsmbcgetujikykmeisaifsks $@
