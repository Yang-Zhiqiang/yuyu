@echo off

  set /P syoriYmd="syoriYmd="
  echo �\�����ޖ������b�r�u�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch skmosmaticsvsks "syoriYmd=%syoriYmd%"
