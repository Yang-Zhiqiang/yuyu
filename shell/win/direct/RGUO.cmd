@echo off

  set /P syoriYmd="syoriYmd="
  set /P syorikyktuukasyu="syorikyktuukasyu="
  set /P syoriymdhoseinissuu="syoriymdhoseinissuu="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo 値動き判定を以下のパラメータで起動します。
  echo     syoriYmd               : %syoriYmd%
  echo     syorikyktuukasyu       : %syorikyktuukasyu%
  echo     syoriymdhoseinissuu    : %syoriymdhoseinissuu%
  echo     ibKakutyoujobcd        : %ibKakutyoujobcd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch dsneugokihantei "syoriYmd=%syoriYmd%,syorikyktuukasyu=%syorikyktuukasyu%,syoriymdhoseinissuu=%syoriymdhoseinissuu%,ibKakutyoujobcd=%ibKakutyoujobcd%"
