@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P heisoukbn="heisoukbn="
  echo �T���ؖ����e�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     heisoukbn        : %heisoukbn%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khtyouhyoukoujyosyoumei "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,heisoukbn=%heisoukbn%"
