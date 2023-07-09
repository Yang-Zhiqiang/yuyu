@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo 目標額到達時円建変更対象抽出を以下のパラメータで起動します。
  echo     syoriYmd  : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khmkhgktttyendthnksel "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"
