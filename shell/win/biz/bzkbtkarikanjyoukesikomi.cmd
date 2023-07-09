@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo 個別仮勘定消込 を以下のパラメータで起動します。
  echo     syoriYmd        : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch bzkbtkarikanjyoukesikomi "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"
