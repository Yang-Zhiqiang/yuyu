@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo ＡＥＯＩ暦年報告抽出処理を起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khaeoirekinenhoukoku "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"