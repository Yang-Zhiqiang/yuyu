@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo 外貨建契約者通知F作成（円建変更後）処理を起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khgaikakokyakutuutisksyendt "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"
