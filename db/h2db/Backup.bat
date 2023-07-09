@echo off
  setlocal
  call SetVariables.bat

  echo ------------------------------------------------------------------------------------------
  echo 「%DB_FILE_NAME%.h2.db」の全データを
  echo  backup.sql にバックアップします。
  echo ------------------------------------------------------------------------------------------
  set /P YN="実行しますか？ (y) / n ："
  echo.
  if "%YN%"=="y" goto mainProc
  if "%YN%"=="Y" goto mainProc
  if "%YN%"==""  goto mainProc

  echo.
  echo ----------------------------------------------------------------------
  echo  処理をキャンセルしました。
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
    echo  データベースの全データをバックアップしています。
    echo ----------------------------------------------------------------------
    java -cp %%j org.h2.tools.Script -user sa -password sa -url jdbc:h2:file:%DB_FILE_NAME%;AUTO_SERVER=TRUE;MODE=DB2;MV_STORE=FALSE
    if errorlevel 1 goto :errorOccurred
    echo.
    echo ----------------------------------------------------------------------
    echo  backup.sql を %BACKUP_FILE% にコピーしています。
    echo ----------------------------------------------------------------------
    copy backup.sql %BACKUP_FILE%
    echo.
    echo ----------------------------------------------------------------------
    echo  データベースのバックアップが完了しました。
    echo ----------------------------------------------------------------------
    popd
    goto :eof
  )

:errorOccurred
  echo.
  echo ----------------------------------------------------------------------
  echo  エラーが発生しました。
  echo ----------------------------------------------------------------------
  popd
  goto :eof
