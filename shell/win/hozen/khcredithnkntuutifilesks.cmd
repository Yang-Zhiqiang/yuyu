@echo off
  set /P kijyunymd="kijyunymd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo クレカ返金通知Ｆ作成を以下のパラメータで起動します。
  echo     kijyunymd  : %kijyunymd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khcredithnkntuutifilesks "kijyunymd=%kijyunymd%,ibKakutyoujobcd=%ibKakutyoujobcd%"
