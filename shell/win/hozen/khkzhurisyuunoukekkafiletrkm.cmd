@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo �����U�֎��[���ʂe�捞���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khkzhurisyuunoukekkafiletrkm "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"
