#!/bin/sh
# バッチ処理を起動します。

# LaunchBatchのあるパスに移動
cd `dirname $0`

# 引数0個の場合、エラー
if [ $# -eq 0 ]; then

  echo バッチサーバーにバッチ処理の起動を指示します。
  echo 起動するバッチは「AM_Batch に定義された業務バッチ処理」だけでなく、
  echo swak-batch のビルトインコマンド「abort」「interrupt」「Peek」「shutdown」も指定可能です。
  echo
  echo 使用方法
  echo   LaunchBatch {batchId} ["param1=value1,param2=value2,..."]
  echo     batchId : AM_Batchテーブルに定義された業務バッチ機能の「機能ID」
  echo               または、swak-batch ビルトインコマンド「abort」「interrupt」「Peek」「shutdown」
  echo     param*  : バッチParamBeanのプロパティー名
  echo     value*  : ParamBeanのプロパティーにセットする値

# 上記以外の場合、処理継続
else

  # 変数設定
  BATCH_ID=$1
  PARAMS=$2
  BATCH_SERVER_HOST=${config.base.batchHost}
  BATCH_SERVER_PORT=${config.base.batchPort}
  CP=/usr/SLCS/batch.ear/batch.war/WEB-INF/lib/*
  JAVA_HOME=/usr/IBM/db2/V11.1/java/jdk64/jre

  echo $JAVA_HOME$

  ${JAVA_HOME}/bin/java -cp "${CP}" jp.co.slcs.swak.batch.starter.BatchStarter -host=${BATCH_SERVER_HOST} -port=${BATCH_SERVER_PORT} ${BATCH_ID} ${PARAMS}

fi
