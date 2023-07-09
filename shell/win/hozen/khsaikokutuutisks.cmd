@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P syoriKbn="syoriKbn="
  echo 催告通知作成を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     syoriKbn         : %syoriKbn%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khsaikokutuutisks "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,syoriKbn=%syoriKbn%"
