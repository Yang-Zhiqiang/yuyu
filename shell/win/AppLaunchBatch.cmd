@echo off
  rem バッチ処理を起動します。
  setlocal
  if "%1"=="" goto :Error
  set BATCH_ID=%1
  if "%~2"=="" ( set PARAMS="kidouKbn=1"
  ) else       ( set PARAMS="kidouKbn=1,%~2"
  )
  %~dp0\LaunchBatch %BATCH_ID% %PARAMS%

:Error
  echo バッチサーバーに業務バッチ処理の起動を指示します。
  echo 起動可能なバッチは「AM_Batch に定義された業務バッチ処理」だけです。
  echo.
  echo 使用方法)
  echo   LaunchBatch {batchId} ["param1=value1,param2=value2,..."]
  echo     batchId : AM_Batchテーブルに定義された業務バッチ機能の「機能ID」
  echo     param*  : 業務バッチParamBean のプロパティー名
  echo     value*  : ParamBean のプロパティーにセットする値
