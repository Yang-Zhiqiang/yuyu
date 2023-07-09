@echo off
  set /P syoriYmd="syoriYmd="
  echo 新契約決算用データ保存期間管理を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause
  
  %~dp0\..\AppLaunchBatch srskkessandataretentionperiod "syoriYmd=%syoriYmd%"
