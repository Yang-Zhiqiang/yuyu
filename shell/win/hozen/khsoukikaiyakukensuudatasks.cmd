@echo off

  set /P syoriYmd="syoriYmd="
  echo 契約保全早期解約件数データ作成を起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khsoukikaiyakukensuudatasks "syoriYmd=%syoriYmd%"