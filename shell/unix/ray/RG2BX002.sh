#!/bin/sh
# 組織限定登録解除バッチ（組織登録）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh orglimitregistrationreleasebatch "tourokuKaijoKbn=TOUROKU,$@"