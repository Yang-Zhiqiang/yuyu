@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P heisoukbn="heisoukbn="
  echo �L�����m�F���ʔ��f���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     heisoukbn        : %heisoukbn%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khyuukouseikekkahanei "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,heisoukbn=%heisoukbn%"
