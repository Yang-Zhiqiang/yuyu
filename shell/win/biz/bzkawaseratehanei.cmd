@echo off
  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P kwsrendouKbn="kwsrendouKbn="
  echo �בփ��[�g�}�X�^���f���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     kwsrendouKbn     : %kwsrendouKbn%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch bzkawaseratehanei "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,kwsrendouKbn=%kwsrendouKbn%"
