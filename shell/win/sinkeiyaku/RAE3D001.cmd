@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P kouzaSyuruiKbn="kouzaSyuruiKbn="
  echo 振込入金データ振分を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     kouzaSyuruiKbn   : %kouzaSyuruiKbn%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch skhurikomihuriwake "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,kouzaSyuruiKbn=%kouzaSyuruiKbn%"
