@echo off

  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P rinji1Ymd="rinji1Ymd="
  echo 契約保全臨時処理１を以下のパラメータで起動します。
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     rinji1Ymd         : %rinji1Ymd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khrin1 "ibKakutyoujobcd=%ibKakutyoujobcd%,rinji1Ymd=%rinji1Ymd%,"
