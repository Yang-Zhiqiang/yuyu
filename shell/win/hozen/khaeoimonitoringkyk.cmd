@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P tysytKikan="tysytKikan="
  echo �`�d�n�h���j�^�����O�_�񒊏o�������ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     tysytKikan       : %tysytKikan%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khaeoimonitoringkyk "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,tysytKikan=%tysytKikan%"
