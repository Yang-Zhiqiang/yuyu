@echo off
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P syoriYmd="syoriYmd="
  echo 為替レート通知データ作成を以下のパラメータで起動します。
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     syoriYmd  : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khkawaseratetuutidatasks "ibKakutyoujobcd=%ibKakutyoujobcd%,syoriYmd=%syoriYmd%"
