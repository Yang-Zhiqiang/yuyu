@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P nykkeiro="nykkeiro="
  set /P heisoukbn="heisoukbn="
  echo 消込データ抽出を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     nykkeiro         : %nykkeiro%
  echo     heisoukbn        : %heisoukbn%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khkesikomisel "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,nykkeiro=%nykkeiro%,heisoukbn=%heisoukbn%"
