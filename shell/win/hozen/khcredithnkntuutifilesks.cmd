@echo off
  set /P kijyunymd="kijyunymd="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo �N���J�ԋ��ʒm�e�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     kijyunymd  : %kijyunymd%
  echo     ibKakutyoujobcd  : %ibKakutyoujobcd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khcredithnkntuutifilesks "kijyunymd=%kijyunymd%,ibKakutyoujobcd=%ibKakutyoujobcd%"
