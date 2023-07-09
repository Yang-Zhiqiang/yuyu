@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P kessanYmd="kessanYmd="
  echo 決算用前納データ抽出を以下のパラメータで起動します。
  echo     syoriYmd  : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     kessanYmd  : %kessanYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khkessanzennousel "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,kessanYmd=%kessanYmd%"
