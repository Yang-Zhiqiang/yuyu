@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo �O�݌��_��ҒʒmF�쐬�i�~���ύX��j�������N�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khgaikakokyakutuutisksyendt "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"
