@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P nykkeiro="nykkeiro="
  echo �����f�[�^���o���ȉ��̃p�����[�^�ŋN�����܂��B
  echo �����敪�́A00�`09��Ώۂɏ������܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     nykkeiro         : %nykkeiro%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  set FIX_NUMBER=0
  set key=0
  set heisoukbn=0

  :loop
      set heisoukbn=%FIX_NUMBER%%key%
      start %~dp0\..\AppLaunchBatch khkesikomisel "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,nykkeiro=%nykkeiro%,heisoukbn=%heisoukbn%"
      set /a key=key+1
      if %key%==10 exit /b
  goto :loop
