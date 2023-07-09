@echo off
  set /P syoriYmd="syoriYmd="
  echo ＩＢＮＲ備金明細表作成処理を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     syorisikibetukbn : %syorisikibetukbn%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch simakeibnrmeisai "syoriYmd=%syoriYmd%"