@echo off
  set /P syoriYmd="syoriYmd="
  echo �h�a�m�q�������ו\�쐬�������ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     syorisikibetukbn : %syorisikibetukbn%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch simakeibnrmeisai "syoriYmd=%syoriYmd%"