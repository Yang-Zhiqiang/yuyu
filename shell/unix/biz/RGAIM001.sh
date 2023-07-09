#!/bin/sh
#新契約本社用伝票リスト(伝票締切日)を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzskhonsyadenpyoulist $@
