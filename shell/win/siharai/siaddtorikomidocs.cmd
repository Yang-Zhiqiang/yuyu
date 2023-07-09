@echo off
  set /P syoriYmd="syoriYmd="
  echo 追加取込書類リスト作成を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch siaddtorikomidocs "syoriYmd=%syoriYmd%"