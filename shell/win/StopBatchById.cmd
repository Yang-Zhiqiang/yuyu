@echo off
  if "%1"=="" goto :Error
  %~dp0\LaunchBatch abort "batchId=%1"
  goto :eof

:Error
  echo ���f�������o�b�`�̋@�\ID���w�肵�Ă��������B

