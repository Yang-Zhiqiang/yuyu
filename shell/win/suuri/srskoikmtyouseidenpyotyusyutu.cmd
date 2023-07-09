@echo off
  set /P syoriYmd="syoriYmd="
  set /P ksnbiymd="ksnbiymd="
  echo 新契約追込調整伝票データ抽出を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ksnbiymd         : %ksnbiymd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause
  
  %~dp0\..\AppLaunchBatch srskoikmtyouseidenpyotyusyutu "syoriYmd=%syoriYmd%,ksnbiymd=%ksnbiymd%"
