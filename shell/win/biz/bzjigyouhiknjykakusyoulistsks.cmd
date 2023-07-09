@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo 事業費勘定確証リスト作成 を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch bzjigyouhiknjykakusyoulistsks "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"
