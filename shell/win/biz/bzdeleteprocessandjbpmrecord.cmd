@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibSkjtsgkkntksu="ibSkjtsgkkntksu="
  echo �H�������EJBPM�f�[�^�폜���N�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibSkjtsgkkntksu  : %ibSkjtsgkkntksu%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch bzdeleteprocessandjbpmrecord "syoriYmd=%syoriYmd%,ibSkjtsgkkntksu=%ibSkjtsgkkntksu%"
