@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P kouzaSyuruiKbn="kouzaSyuruiKbn="
  echo �U�������f�[�^�U�����ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     kouzaSyuruiKbn   : %kouzaSyuruiKbn%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch skhurikomihuriwake "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,kouzaSyuruiKbn=%kouzaSyuruiKbn%"
