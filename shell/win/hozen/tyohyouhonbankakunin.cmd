@echo off

  set /P syoriYmd="syoriYmd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  set /P tyouhyouybdskinou="tyouhyouybdskinou="
  echo ���[�{�Ԋm�F�������ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd          : %syoriYmd%
  echo     ibKakutyoujobcd   : %ibKakutyoujobcd%
  echo     tyouhyouybdskinou : %tyouhyouybdskinou%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch tyohyouhonbankakunin "syoriYmd=%syoriYmd%,ibKakutyoujobcd=%ibKakutyoujobcd%,tyouhyouybdskinou=%tyouhyouybdskinou%"
