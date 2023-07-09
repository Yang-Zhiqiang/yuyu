@echo off
  setlocal
  pushd %~dp0
  set MAX_HEAP=2048M
  set MAX_PERM=348M
  set CP=../../src/main/webapp/WEB-INF/classes;../../src/main/webapp/WEB-INF/lib/*;
  start %JAVA_HOME%\bin\java -Xmx%MAX_HEAP% -XX:MaxPermSize=%MAX_PERM% -cp "%CP%" jp.co.slcs.swak.batch.Server
  if errorlevel 1 goto :Error
  popd
  goto :eof

:Error
  popd
  echo バッチサーバーの起動に失敗しました。
