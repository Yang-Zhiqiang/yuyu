@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo �T���ؖ����쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo �����敪�́A00�`09��Ώۂɏ������܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  set FIX_NUMBER=0
  set key=0
  set heisoukbn=0

  :loop
      set heisoukbn=%FIX_NUMBER%%key%
      start %~dp0\..\AppLaunchBatch khkoujyosyoumeisks "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,heisoukbn=%heisoukbn%"
      set /a key=key+1
      if %key%==10 exit /b
  goto :loop
