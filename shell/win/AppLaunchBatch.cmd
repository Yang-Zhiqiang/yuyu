@echo off
  rem �o�b�`�������N�����܂��B
  setlocal
  if "%1"=="" goto :Error
  set BATCH_ID=%1
  if "%~2"=="" ( set PARAMS="kidouKbn=1"
  ) else       ( set PARAMS="kidouKbn=1,%~2"
  )
  %~dp0\LaunchBatch %BATCH_ID% %PARAMS%

:Error
  echo �o�b�`�T�[�o�[�ɋƖ��o�b�`�����̋N�����w�����܂��B
  echo �N���\�ȃo�b�`�́uAM_Batch �ɒ�`���ꂽ�Ɩ��o�b�`�����v�����ł��B
  echo.
  echo �g�p���@)
  echo   LaunchBatch {batchId} ["param1=value1,param2=value2,..."]
  echo     batchId : AM_Batch�e�[�u���ɒ�`���ꂽ�Ɩ��o�b�`�@�\�́u�@�\ID�v
  echo     param*  : �Ɩ��o�b�`ParamBean �̃v���p�e�B�[��
  echo     value*  : ParamBean �̃v���p�e�B�[�ɃZ�b�g����l
