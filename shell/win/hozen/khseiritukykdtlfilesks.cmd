@echo off

  set /P syoriYmd="syoriYmd="
  set /P kykYmdFrom="kykYmdFrom="
  set /P kykYmdTo="kykYmdTo="
  echo �����_�񖾍׃t�@�C���쐬�������ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd         : %syoriYmd%
  echo     kykYmdFrom       : %kykYmdFrom%
  echo     kykYmdTo         : %kykYmdTo%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch khseiritukykdtlfilesks "syoriYmd=%syoriYmd%,kykYmdFrom=%kykYmdFrom%,kykYmdTo=%kykYmdTo%"
