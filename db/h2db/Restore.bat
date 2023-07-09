@echo off
  setlocal
  call SetVariables.bat
  
  if not exist backup.sql (
    echo.
    echo ----------------------------------------------------------------------
    echo  backup.sql ������܂���B
    echo  �\�� Backup.bat �Ńo�b�N�A�b�v�t�@�C�����쐬���Ă����K�v������܂��B
    echo ----------------------------------------------------------------------
    goto :eof
  )

  echo ------------------------------------------------------------------------------------------
  echo Backup.bat �ō쐬���� backup.sql �X�N���v�g�����s���A
  echo �o�b�N�A�b�v���_�́u%DB_FILE_NAME%.h2.db�v�𕜌����܂��B
  echo.
  echo ���j���݂́u%DB_FILE_NAME%.h2.db�v�̃f�[�^�͊��S�Ɏ����܂��B
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
  if exist %DB_FILE_NAME%.h2.db (
    echo.
    echo ----------------------------------------------------------------------
    echo �u%DB_FILE_NAME%.h2.db�v���폜���Ă��܂��B
    echo ----------------------------------------------------------------------
    del %DB_FILE_NAME%.h2.db
  )
  for %%j in (%H2JAR%) do (
    echo.
    echo ----------------------------------------------------------------------
    echo �u%DB_FILE_NAME%.h2.db�v���č\�z���Ă��܂��B
    echo ----------------------------------------------------------------------
    java -cp %%j org.h2.tools.RunScript -user sa -password sa -url jdbc:h2:file:%DB_FILE_NAME%;AUTO_SERVER=TRUE;MODE=DB2;MV_STORE=FALSE
    if errorlevel 1 goto :errorOccurred
    echo.
    echo ----------------------------------------------------------------------
    echo  �f�[�^�x�[�X�̕������������܂����B
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
