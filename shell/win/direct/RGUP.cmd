@echo off

  set /P syoriYmd="syoriYmd="
  set /P dssousinmailsyubetukbn="dssousinmailsyubetukbn="
  set /P syoriymdhoseinissuu="syoriymdhoseinissuu="
  set /P dsBatchKadouknkKbn="dsBatchKadouknkKbn="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo ＳＰＩＲＡＬメール配信Ｆ作成を以下のパラメータで起動します。
  echo     syoriYmd               : %syoriYmd%
  echo     dssousinmailsyubetukbn : %dssousinmailsyubetukbn%
  echo     syoriymdhoseinissuu    : %syoriymdhoseinissuu%
  echo     dsBatchKadouknkKbn    : %dsBatchKadouknkKbn%
  echo     ibKakutyoujobcd        : %ibKakutyoujobcd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch dsspiralmailhaisinsakusei "syoriYmd=%syoriYmd%,dssousinmailsyubetukbn=%dssousinmailsyubetukbn%,syoriymdhoseinissuu=%syoriymdhoseinissuu%,ibKakutyoujobcd=%ibKakutyoujobcd%,dsBatchKadouknkKbn=%dsBatchKadouknkKbn%"
