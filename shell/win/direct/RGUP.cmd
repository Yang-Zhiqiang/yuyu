@echo off

  set /P syoriYmd="syoriYmd="
  set /P dssousinmailsyubetukbn="dssousinmailsyubetukbn="
  set /P syoriymdhoseinissuu="syoriymdhoseinissuu="
  set /P dsBatchKadouknkKbn="dsBatchKadouknkKbn="
  set /P ibKakutyoujobcd="ibKakutyoujobcd="
  echo ‚r‚o‚h‚q‚`‚kƒ[ƒ‹”zM‚eì¬‚ğˆÈ‰º‚Ìƒpƒ‰ƒ[ƒ^‚Å‹N“®‚µ‚Ü‚·B
  echo     syoriYmd               : %syoriYmd%
  echo     dssousinmailsyubetukbn : %dssousinmailsyubetukbn%
  echo     syoriymdhoseinissuu    : %syoriymdhoseinissuu%
  echo     dsBatchKadouknkKbn    : %dsBatchKadouknkKbn%
  echo     ibKakutyoujobcd        : %ibKakutyoujobcd%
  echo.
  echo ‹N“®‚ğ’†~‚·‚éê‡‚Í [Ctrl] + [C] ‚ğ‰Ÿ‚µ‚Ä‚­‚¾‚³‚¢B
  pause

  %~dp0\..\AppLaunchBatch dsspiralmailhaisinsakusei "syoriYmd=%syoriYmd%,dssousinmailsyubetukbn=%dssousinmailsyubetukbn%,syoriymdhoseinissuu=%syoriymdhoseinissuu%,ibKakutyoujobcd=%ibKakutyoujobcd%,dsBatchKadouknkKbn=%dsBatchKadouknkKbn%"
