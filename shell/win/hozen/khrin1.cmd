@echo off

  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P rinji1Ymd="rinji1Ymd="
  echo �_��ۑS�Վ������P���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     rinji1Ymd         : %rinji1Ymd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khrin1 "ibKakutyoujobcd=%ibKakutyoujobcd%,rinji1Ymd=%rinji1Ymd%,"
