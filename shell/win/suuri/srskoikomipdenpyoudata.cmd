@echo off
  set /P syoriYmd="syoriYmd="
  set /P ksnbiymd="ksnbiymd="
  echo �V�_��Ǎ��ی����`�[�f�[�^���o���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ksnbiymd         : %ksnbiymd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch srskoikomipdenpyoudata "syoriYmd=%syoriYmd%,ksnbiymd=%ksnbiymd%"
