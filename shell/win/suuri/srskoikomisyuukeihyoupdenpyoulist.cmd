@echo off
  set /P syoriYmd="syoriYmd="
  echo �V�_��Ǎ��W�v�\�i�ی����`�[���X�g�j�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch srskoikomisyuukeihyoupdenpyoulist "syoriYmd=%syoriYmd%"
