@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P tyouhyouybdskinou="tyouhyouybdskinou="
  echo 帳票本番確認処理を以下のパラメータで起動します。
  echo     syoriYmd          : %syoriYmd%
  echo     ibKakutyoujobcd   : %ibKakutyoujobcd%
  echo     tyouhyouybdskinou : %tyouhyouybdskinou%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch tyohyouhonbankakunin "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,tyouhyouybdskinou=%tyouhyouybdskinou%"
