@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P syoriKbn="syoriKbn="
  echo �Í��ʒm�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo     syoriKbn         : %syoriKbn%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khsaikokutuutisks "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,syoriKbn=%syoriKbn%"
