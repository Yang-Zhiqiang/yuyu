@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibKsnbiymd="ibKsnbiymd="
  echo �V�_�񌈎Z�p�Ǎ��f�[�^�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd           : %syoriYmd%
  echo     ibKsnbiymd         : %ibKsnbiymd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause
  
  %~dp0\..\AppLaunchBatch srskkessanoikmdata "syoriYmd=%syoriYmd%,ibKsnbiymd=%ibKsnbiymd%"
