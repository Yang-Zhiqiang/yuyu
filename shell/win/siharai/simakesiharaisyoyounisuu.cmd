@echo off
  set /P syoriYmd="syoriYmd="
  echo 支払所要日数情報作成を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch simakesiharaisyoyounisuu "syoriYmd=%syoriYmd%"