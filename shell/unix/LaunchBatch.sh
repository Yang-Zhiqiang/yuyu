#!/bin/sh
# バッチ�?�?��起動します�?

# LaunchBatchのあるパスに移�?cd `dirname $0`

# 引数0個�?場合�?エラー
if [ $# -eq 0 ]; then

  echo バッチサーバ�?にバッチ�?�??起動を�?��します�?
  echo 起動するバ�?��は「AM_Batch に定義された業務バ�?��処�??�?��でなく�?
  echo swak-batch のビルトインコマンド�?abort」�?interrupt」�?Peek」�?shutdown」も�?��可能です�?
  echo
  echo 使用方�?  echo   LaunchBatch {batchId} ["param1=value1,param2=value2,..."]
  echo     batchId : AM_Batch�??ブルに定義された業務バ�?��機�?の「機�?ID�?  echo               また�?、swak-batch ビルトインコマンド�?abort」�?interrupt」�?Peek」�?shutdown�?  echo     param*  : バッチParamBeanのプロパティー�?  echo     value*  : ParamBeanのプロパティーにセ�?��する値

# 上記以外�?場合�?処�?���?else

  # 変数設�?  BATCH_ID=$1
  PARAMS=$2
  BATCH_SERVER_HOST=localhost
  BATCH_SERVER_PORT=8099
  CP=/usr/SLCS/batch.ear/batch.war/WEB-INF/lib/*
  JAVA_HOME=/usr/IBM/db2/V11.1/java/jdk64/jre

  echo $JAVA_HOME$

  ${JAVA_HOME}/bin/java -cp "${CP}" jp.co.slcs.swak.batch.starter.BatchStarter -host=${BATCH_SERVER_HOST} -port=${BATCH_SERVER_PORT} ${BATCH_ID} ${PARAMS}

fi
