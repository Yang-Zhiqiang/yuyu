@echo off
  set /P syoriYmd="syoriYmd="
  echo �V�_�񌈎Z�p�f�[�^�ۑ����ԊǗ����ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause
  
  %~dp0\..\AppLaunchBatch srskkessandataretentionperiod "syoriYmd=%syoriYmd%"
