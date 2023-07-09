@echo off
echo ==============================================================================
echo  H2DBÇãNìÆÇµÇ‹Ç∑ÅB
echo ==============================================================================

  setlocal
  pushd %~dp0
  call SetVariables.bat

  for %%j in (%H2JAR%) do (
    start /MIN java -Dfile.encoding=UTF-8 -Dh2.sortNullsHigh=true -cp %%j org.h2.tools.Server -tcpAllowOthers -pgAllowOthers -baseDir "." -ifExists -trace
    popd
    goto :eof
  )
