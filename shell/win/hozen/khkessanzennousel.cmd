@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P kessanYmd="kessanYmd="
  echo ���Z�p�O�[�f�[�^���o���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd  : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     kessanYmd  : %kessanYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khkessanzennousel "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,kessanYmd=%kessanYmd%"
