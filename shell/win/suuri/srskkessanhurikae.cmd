@echo off
  set /P syoriYmd="syoriYmd="
  echo �V�_�񌈎Z�p�U�֓`�[�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch srskkessanhurikae "syoriYmd=%syoriYmd%"
