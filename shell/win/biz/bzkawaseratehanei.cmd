@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P kwsrendouKbn="kwsrendouKbn="
  echo 為替レートマスタ反映を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     kwsrendouKbn     : %kwsrendouKbn%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch bzkawaseratehanei "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,kwsrendouKbn=%kwsrendouKbn%"
