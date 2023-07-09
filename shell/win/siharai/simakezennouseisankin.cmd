@echo off

  set /P syoriYmd="syoriYmd="
  echo 前納精算金明細リスト作成処理を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch simakezennouseisankin "syoriYmd=%syoriYmd%"
