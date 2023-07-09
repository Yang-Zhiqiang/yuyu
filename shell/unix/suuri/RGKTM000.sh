#!/bin/sh
#区分経理用備金契約精算Ｄ集計リスト作成を起動します。
cd `dirname $0`
../AppLaunchBatch.sh srkbnkeiriyoubikinkykseisandlistsks $@
