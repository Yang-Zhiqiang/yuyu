@echo off
  set /P syoriYmd="syoriYmd="
  echo �m�F�o�^���X�g�o�͂��ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch simakekakunintourokulist "syoriYmd=%syoriYmd%"