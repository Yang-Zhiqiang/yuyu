@echo off
  set /P syoriYmd="syoriYmd="
  echo 新契約追込集計表（保険料伝票リスト）作成を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch srskoikomisyuukeihyoupdenpyoulist "syoriYmd=%syoriYmd%"
