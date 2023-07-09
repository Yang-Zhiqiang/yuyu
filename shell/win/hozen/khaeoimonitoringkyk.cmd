@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P tysytKikan="tysytKikan="
  echo ＡＥＯＩモニタリング契約抽出処理を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     tysytKikan       : %tysytKikan%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khaeoimonitoringkyk "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,tysytKikan=%tysytKikan%"
