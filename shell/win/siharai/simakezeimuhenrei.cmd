@echo off
  set /P syoriYmd="syoriYmd="
  echo 税務及び返戻金備金明細表作成処理を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch simakezeimuhenrei "syoriYmd=%syoriYmd%"
