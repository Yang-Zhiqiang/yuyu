@echo off
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P syoriYmd="syoriYmd="
  echo �בփ��[�g�ʒm�f�[�^�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     syoriYmd  : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khkawaseratetuutidatasks "ibKakutyoujobcd=%ibKakutyoujobcd%,syoriYmd=%syoriYmd%"
