@echo off

  set /P syoriYmd="syoriYmd="
  echo ���������_�񒊏o�i�_��ۑS�j�������ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch bzkijitutouraikeiyakutyusyutukh "syoriYmd=%syoriYmd%"
