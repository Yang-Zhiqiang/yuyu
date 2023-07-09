@echo off

  set /P syoriYmd="syoriYmd="
  set /P kykYmdFrom="kykYmdFrom="
  set /P kykYmdTo="kykYmdTo="
  echo 成立契約明細ファイル作成処理を以下のパラメータで起動します。
  echo     syoriYmd         : %syoriYmd%
  echo     kykYmdFrom       : %kykYmdFrom%
  echo     kykYmdTo         : %kykYmdTo%
  echo.
  echo 起動を中止する場合は [Ctrl] + [C] を押してください。
  pause

  %~dp0\..\AppLaunchBatch khseiritukykdtlfilesks "syoriYmd=%syoriYmd%,kykYmdFrom=%kykYmdFrom%,kykYmdTo=%kykYmdTo%"
