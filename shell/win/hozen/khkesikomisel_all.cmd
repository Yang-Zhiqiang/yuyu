@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P nykkeiro="nykkeiro="
  echo 消込データ抽出を以下のパラメータで起動します。
  echo 並走区分は、00～09を対象に処理します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     nykkeiro         : %nykkeiro%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  set FIX_NUMBER=0
  set key=0
  set heisoukbn=0

  :loop
      set heisoukbn=%FIX_NUMBER%%key%
      start %~dp0\..\AppLaunchBatch khkesikomisel "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,nykkeiro=%nykkeiro%,heisoukbn=%heisoukbn%"
      set /a key=key+1
      if %key%==10 exit /b
  goto :loop
