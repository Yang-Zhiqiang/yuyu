@echo off
  setlocal
  call SetVariables.bat

  echo ------------------------------------------------------------------------------------------
  echo �u%DB_FILE_NAME%.h2.db�v��Ώۂ�
  echo  �A�v���P�[�V�����J���Ҍ����̏����f�[�^�� insert ���܂�
  echo  (���� bat �ł́AST���p�̏����f�[�^�� insert ���܂���)�B
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
  set TEMP_FILE=%~n0.sql
  for %%j in (%H2JAR%) do (
    echo.
    echo ----------------------------------------------------------------------
    echo  �����f�[�^�� insert ����SQL�X�N���v�g�𐶐����Ă��܂��B
    echo ----------------------------------------------------------------------
    (
      for %%d in (%INSERT_DIRS%) do (
        for %%f in (%%d\*.sql) do (
          type %%f
        )
      )
    ) > %TEMP_FILE%
    echo.
    echo ----------------------------------------------------------------------
    echo  SQL�X�N���v�g�����s���Ă��܂��B
    echo ----------------------------------------------------------------------
    java -cp %%j org.h2.tools.RunScript -showResults -user sa -password sa -script %TEMP_FILE% -url jdbc:h2:file:%DB_FILE_NAME%;AUTO_SERVER=TRUE;MODE=DB2;MV_STORE=FALSE
    if errorlevel 1 goto :errorOccurred
    echo.
    echo ----------------------------------------------------------------------
    echo  ���s���������܂����B
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
