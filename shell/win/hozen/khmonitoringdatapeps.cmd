@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P kessanYmd="kessanYmd="
  echo �_��ۑS���j�^�����O�f�[�^���o�i�o�d�o���j���N�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khmonitoringdatapeps "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"