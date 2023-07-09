#!/bin/sh

JAVA_HOME=/usr/IBM/db2/V10.5/java/jdk64/jre

# バッチサーバを停止します。
./LaunchBatch.sh shutdown

# エラーチェック
if [ $? -ne 0 ]; then
  echo バッチサーバの停止に失敗しました。
else
  echo Server#shutdown
fi
