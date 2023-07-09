@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibSkjtsgkkntksu="ibSkjtsgkkntksu="
  echo 工程履歴・JBPMデータ削除を起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibSkjtsgkkntksu  : %ibSkjtsgkkntksu%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch bzdeleteprocessandjbpmrecord "syoriYmd=%syoriYmd%,ibSkjtsgkkntksu=%ibSkjtsgkkntksu%"
