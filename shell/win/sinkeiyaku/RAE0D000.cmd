@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P kzsyuruikbn="kzsyuruikbn="
  echo 振込入金データ訂正を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     kouzaSyuruiKbn   : %kzsyuruikbn%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch skhurikomiteisei "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,kzsyuruikbn=%kzsyuruikbn%"
