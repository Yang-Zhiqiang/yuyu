@echo off
  set /P syoriYmd="syoriYmd="
  echo �ǉ��捞���ރ��X�g�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch siaddtorikomidocs "syoriYmd=%syoriYmd%"