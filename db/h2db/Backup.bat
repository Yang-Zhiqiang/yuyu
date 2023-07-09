@echo off
  setlocal
  call SetVariables.bat

  echo ------------------------------------------------------------------------------------------
  echo �u%DB_FILE_NAME%.h2.db�v�̑S�f�[�^��
  echo  backup.sql �Ƀo�b�N�A�b�v���܂��B
  echo ------------------------------------------------------------------------------------------
  set /P YN="���s���܂����H (y) / n �F"
  echo.
  if "%YN%"=="y" goto mainProc
  if "%YN%"=="Y" goto mainProc
  if "%YN%"==""  goto mainProc

  echo.
  echo ----------------------------------------------------------------------
  echo  �������L�����Z�����܂����B
  echo ----------------------------------------------------------------------
  goto :eof

:mainProc
  pushd %~dp0
  set D=%DATE:/=%
  set T=%TIME:~0,8%
  set T=%T::=%
  set BACKUP_FILE=backup\backup_%D%%T%.sql
  for %%j in (%H2JAR%) do (
    echo.
    echo ----------------------------------------------------------------------
    echo  �f�[�^�x�[�X�̑S�f�[�^���o�b�N�A�b�v���Ă��܂��B
    echo ----------------------------------------------------------------------
    java -cp %%j org.h2.tools.Script -user sa -password sa -url jdbc:h2:file:%DB_FILE_NAME%;AUTO_SERVER=TRUE;MODE=DB2;MV_STORE=FALSE
    if errorlevel 1 goto :errorOccurred
    echo.
    echo ----------------------------------------------------------------------
    echo  backup.sql �� %BACKUP_FILE% �ɃR�s�[���Ă��܂��B
    echo ----------------------------------------------------------------------
    copy backup.sql %BACKUP_FILE%
    echo.
    echo ----------------------------------------------------------------------
    echo  �f�[�^�x�[�X�̃o�b�N�A�b�v���������܂����B
    echo ----------------------------------------------------------------------
    popd
    goto :eof
  )

:errorOccurred
  echo.
  echo ----------------------------------------------------------------------
  echo  �G���[���������܂����B
  echo ----------------------------------------------------------------------
  popd
  goto :eof
