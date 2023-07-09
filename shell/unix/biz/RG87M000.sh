#!/bin/sh
#アクセスログ作成（月次）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzaccesslogsksmonthly $@
