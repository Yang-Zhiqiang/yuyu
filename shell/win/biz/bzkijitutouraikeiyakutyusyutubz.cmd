@echo off

  set /P syoriYmd="syoriYmd="
  echo ���������_�񒊏o�i�Ɩ����ʁj�������ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch bzkijitutouraikeiyakutyusyutubz "syoriYmd=%syoriYmd%"
