@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibKsnbiymd="ibKsnbiymd="
  echo 新契約決算用追込データ作成を以下のパラメータで起動します。
  echo     syoriYmd           : %syoriYmd%
  echo     ibKsnbiymd         : %ibKsnbiymd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause
  
  %~dp0\..\AppLaunchBatch srskkessanoikmdata "syoriYmd=%syoriYmd%,ibKsnbiymd=%ibKsnbiymd%"
