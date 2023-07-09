@echo off

  set /P syoriYmd="syoriYmd="
  echo 振込口座不一致リスト作成を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch skhurikomikouzahuittilistsks "syoriYmd=%syoriYmd%"

