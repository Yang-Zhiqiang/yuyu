@echo off

  set /P syoriYmd="syoriYmd="
  set /P syorikyktuukasyu="syorikyktuukasyu="
  set /P syoriymdhoseinissuu="syoriymdhoseinissuu="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo �l����������ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd               : %syoriYmd%
  echo     syorikyktuukasyu       : %syorikyktuukasyu%
  echo     syoriymdhoseinissuu    : %syoriymdhoseinissuu%
  echo     ibKakutyoujobcd        : %ibKakutyoujobcd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch dsneugokihantei "syoriYmd=%syoriYmd%,syorikyktuukasyu=%syorikyktuukasyu%,syoriymdhoseinissuu=%syoriymdhoseinissuu%,ibKakutyoujobcd=%ibKakutyoujobcd%"
