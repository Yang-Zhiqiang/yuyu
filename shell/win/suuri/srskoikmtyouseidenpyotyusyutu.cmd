@echo off
  set /P syoriYmd="syoriYmd="
  set /P ksnbiymd="ksnbiymd="
  echo �V�_��Ǎ������`�[�f�[�^���o���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ksnbiymd         : %ksnbiymd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause
  
  %~dp0\..\AppLaunchBatch srskoikmtyouseidenpyotyusyutu "syoriYmd=%syoriYmd%,ksnbiymd=%ksnbiymd%"
