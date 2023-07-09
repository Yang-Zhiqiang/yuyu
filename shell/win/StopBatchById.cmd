@echo off
  if "%1"=="" goto :Error
  %~dp0\LaunchBatch abort "batchId=%1"
  goto :eof

:Error
  echo 中断したいバッチの機能IDを指定してください。

