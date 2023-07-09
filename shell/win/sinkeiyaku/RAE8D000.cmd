@echo off

  set /P syoriYmd="syoriYmd="
  echo 自動入金明細リスト作成を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch skhurikominyuukinlistsakusei "syoriYmd=%syoriYmd%"
