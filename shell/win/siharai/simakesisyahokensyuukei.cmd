@echo off

  set /P syoriYmd="syoriYmd="
  echo 支社別保険金種類別集計情報作成を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch simakesisyahokensyuukei "syoriYmd=%syoriYmd%"
