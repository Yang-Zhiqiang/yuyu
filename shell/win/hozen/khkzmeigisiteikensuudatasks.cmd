@echo off

  set /P syoriYmd="syoriYmd="
  echo �_��ۑS�ی��������������`�w�茏���f�[�^�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khkzmeigisiteikensuudatasks "syoriYmd=%syoriYmd%"
