@echo off
  set /P syoriYmd="syoriYmd="
  set /P ksnbiymd="ksnbiymd="
  echo �V�_��Ǎ���v����f�[�^���o���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ksnbiymd         : %ksnbiymd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch srskoikmkaikeityusyutu "syoriYmd=%syoriYmd%,ksnbiymd=%ksnbiymd%"
