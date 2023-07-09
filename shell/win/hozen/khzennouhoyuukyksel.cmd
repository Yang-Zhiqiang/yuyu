@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P kessanYmd="kessanYmd="
  echo 前納保有契約データ抽出を以下のパラメータで起動します。
  echo     syoriYmd  : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     kessanYmd  : %kessanYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khzennouhoyuukyksel "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,kessanYmd=%kessanYmd%"
