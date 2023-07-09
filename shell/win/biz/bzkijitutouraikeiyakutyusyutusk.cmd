@echo off

  set /P syoriYmd="syoriYmd="
  echo 期日到来契約抽出（新契約）処理を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch bzkijitutouraikeiyakutyusyutusk "syoriYmd=%syoriYmd%"
