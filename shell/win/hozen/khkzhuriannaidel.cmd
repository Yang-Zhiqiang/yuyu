@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo �����U�ֈē��f�[�^�폜���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khkzhuriannaidel "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"
