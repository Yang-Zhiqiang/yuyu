@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P kzsyuruikbn="kzsyuruikbn="
  echo �U�������f�[�^�������ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     kouzaSyuruiKbn   : %kzsyuruikbn%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch skhurikomiteisei "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,kzsyuruikbn=%kzsyuruikbn%"
