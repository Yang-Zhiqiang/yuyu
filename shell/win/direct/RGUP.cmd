@echo off

  set /P syoriYmd="syoriYmd="
  set /P dssousinmailsyubetukbn="dssousinmailsyubetukbn="
  set /P syoriymdhoseinissuu="syoriymdhoseinissuu="
  set /P dsBatchKadouknkKbn="dsBatchKadouknkKbn="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo �r�o�h�q�`�k���[���z�M�e�쐬���ȉ��̃p�����[�^�ŋN�����܂��B
  echo     syoriYmd               : %syoriYmd%
  echo     dssousinmailsyubetukbn : %dssousinmailsyubetukbn%
  echo     syoriymdhoseinissuu    : %syoriymdhoseinissuu%
  echo     dsBatchKadouknkKbn    : %dsBatchKadouknkKbn%
  echo     ibKakutyoujobcd        : %ibKakutyoujobcd%
  echo.
  echo �N���𒆎~����ꍇ�� [Ctrl] + [C] �������Ă��������B
  pause

  %~dp0\..\AppLaunchBatch dsspiralmailhaisinsakusei "syoriYmd=%syoriYmd%,dssousinmailsyubetukbn=%dssousinmailsyubetukbn%,syoriymdhoseinissuu=%syoriymdhoseinissuu%,ibKakutyoujobcd=%ibKakutyoujobcd%,dsBatchKadouknkKbn=%dsBatchKadouknkKbn%"
