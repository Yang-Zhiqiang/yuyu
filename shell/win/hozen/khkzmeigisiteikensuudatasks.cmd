@echo off

  set /P syoriYmd="syoriYmd="
  echo 契約保全保険料払込口座名義指定件数データ作成を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khkzmeigisiteikensuudatasks "syoriYmd=%syoriYmd%"
