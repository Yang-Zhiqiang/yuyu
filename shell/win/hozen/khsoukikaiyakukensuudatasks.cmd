@echo off

  set /P syoriYmd="syoriYmd="
  echo �_��ۑS������񌏐��f�[�^�쐬���N�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khsoukikaiyakukensuudatasks "syoriYmd=%syoriYmd%"