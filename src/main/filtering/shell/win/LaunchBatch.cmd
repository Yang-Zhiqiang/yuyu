@echo off
  rem �o�b�`�������N�����܂��B
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
  echo �o�b�`�T�[�o�[�Ƀo�b�`�����̋N�����w�����܂��B
  echo �N������o�b�`�́uAM_Batch �ɒ�`���ꂽ�Ɩ��o�b�`�����v�����łȂ��A
  echo swak-batch �̃r���g�C���R�}���h�uabort�v�uinterrupt�v�uPeek�v�ushutdown�v���w��\�ł��B
  echo.
  echo �g�p���@)
  echo   LaunchBatch {batchId} ["param1=value1,param2=value2,..."]
  echo     batchId : AM_Batch�e�[�u���ɒ�`���ꂽ�Ɩ��o�b�`�@�\�́u�@�\ID�v
  echo               �܂��́Aswak-batch �r���g�C���R�}���h�uabort�v�uinterrupt�v�uPeek�v�ushutdown�v
  echo     param*  : �o�b�`ParamBean�̃v���p�e�B�[��
  echo     value*  : ParamBean�̃v���p�e�B�[�ɃZ�b�g����l
