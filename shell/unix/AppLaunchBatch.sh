#!/bin/sh
# バッチ処理を起動します。

# 実行パスに移動
cd `dirname $0`

# 引数0個の場合、エラー
if [ $# -eq 0 ]; then
  echo バッチサーバーに業務バッチ処理の起動を指示します。
  echo 起動可能なバッチは「AM_Batch に定義された業務バッチ処理」だけです。
  echo.
  echo 使用方法
  echo   LaunchBatch {batchId} ["param1=value1,param2=value2,..."]
  echo     batchId : AM_Batchテーブルに定義された業務バッチ機能の「機能ID」
  echo     param*  : 業務バッチParamBean のプロパティー名
  echo     value*  : ParamBean のプロパティーにセットする値

# 上記以外の場合、処理継続
else

  # 変数設定
  BATCH_ID=$1
  
  # 引数1個の場合
  if [ $# -eq 1 ]; then
    PARAMS="kidouKbn=1"

  # 引数2個以上の場合
  else
    PARAMS="kidouKbn=1,$2"
  fi
    
  # LaunchBatchの実行
  ./LaunchBatch.sh ${BATCH_ID} ${PARAMS}
  
fi
