@echo off

  set /P syoriYmd="syoriYmd="
  echo �U�������폜���X�g�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch skhurikomisakujyolistsakusei "syoriYmd=%syoriYmd%"
