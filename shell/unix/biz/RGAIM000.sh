#!/bin/sh
#新契約本社用伝票リスト(月末２営業日前)を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzskhonsyadenpyoulist $@
