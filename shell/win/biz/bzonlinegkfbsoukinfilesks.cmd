@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo �O�݃I�����C���e�a�����t�@�C���쐬 ���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch bzonlinegkfbsoukinfilesks "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"
