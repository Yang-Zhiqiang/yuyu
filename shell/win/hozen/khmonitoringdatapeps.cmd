@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P kessanYmd="kessanYmd="
  echo 契約保全モニタリングデータ抽出（ＰＥＰｓ）を起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khmonitoringdatapeps "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"