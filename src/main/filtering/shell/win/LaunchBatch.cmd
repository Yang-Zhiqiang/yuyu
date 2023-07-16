@echo off
  rem バッチ処理を起動します。
  setlocal
  pushd %~dp0
  if "%1"=="" goto :Error
  set BATCH_ID=%1
  set PARAMS=%2
  set BATCH_SERVER_HOST=${config.base.batchHost}
  set BATCH_SERVER_PORT=${config.base.batchPort}
  set BATCH_ERREXITCODE=${config.base.batchErrExitCode}
  set CP=../../src/main/webapp/WEB-INF/classes;../../src/main/webapp/WEB-INF/lib/*
  %JAVA_HOME%\bin\java -cp "%CP%" jp.co.slcs.swak.batch.starter.BatchStarter -host=%BATCH_SERVER_HOST% -port=%BATCH_SERVER_PORT% -errCode=%BATCH_ERREXITCODE% %BATCH_ID% %PARAMS%
  popd
  goto :eof

:Error
  popd
  echo バッチサーバーにバッチ処理の起動を指示します。
  echo 起動するバッチは「AM_Batch に定義された業務バッチ処理」だけでなく、
  echo swak-batch のビルトインコマンド「abort」「interrupt」「Peek」「shutdown」も指定可能です。
  echo.
  echo 使用方法)
  echo   LaunchBatch {batchId} ["param1=value1,param2=value2,..."]
  echo     batchId : AM_Batchテーブルに定義された業務バッチ機能の「機能ID」
  echo               または、swak-batch ビルトインコマンド「abort」「interrupt」「Peek」「shutdown」
  echo     param*  : バッチParamBeanのプロパティー名
  echo     value*  : ParamBeanのプロパティーにセットする値
