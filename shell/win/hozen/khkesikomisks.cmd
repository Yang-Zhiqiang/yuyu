@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P nykkeiro="nykkeiro="
  echo 消込送信Ｆ作成を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     nykkeiro         : %nykkeiro%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khkesikomisks "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,nykkeiro=%nykkeiro%"
