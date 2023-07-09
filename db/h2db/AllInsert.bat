@echo off
  setlocal
  call SetVariables.bat

  echo ------------------------------------------------------------------------------------------
  echo 「%DB_FILE_NAME%.h2.db」を対象に
  echo  アプリケーション開発者向けの初期データを insert します
  echo  (この bat では、ST環境用の初期データは insert しません)。
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
  set TEMP_FILE=%~n0.sql
  for %%j in (%H2JAR%) do (
    echo.
    echo ----------------------------------------------------------------------
    echo  初期データを insert するSQLスクリプトを生成しています。
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
    echo  SQLスクリプトを実行しています。
    echo ----------------------------------------------------------------------
    java -cp %%j org.h2.tools.RunScript -showResults -user sa -password sa -script %TEMP_FILE% -url jdbc:h2:file:%DB_FILE_NAME%;AUTO_SERVER=TRUE;MODE=DB2;MV_STORE=FALSE
    if errorlevel 1 goto :errorOccurred
    echo.
    echo ----------------------------------------------------------------------
    echo  実行が完了しました。
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
