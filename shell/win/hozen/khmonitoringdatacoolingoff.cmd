@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo �_��ۑS���j�^�����O�f�[�^���o�i�N�[�����O�I�t�j���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khmonitoringdatacoolingoff "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%"
