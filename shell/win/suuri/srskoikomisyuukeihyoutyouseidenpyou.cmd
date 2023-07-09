@echo off
  set /P syoriYmd="syoriYmd="
  echo 新契約追込集計表（調整伝票）作成を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch srskoikomisyuukeihyoutyouseidenpyou "syoriYmd=%syoriYmd%"
