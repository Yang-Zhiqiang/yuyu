@echo off
echo ==============================================================================
echo  H2DBÇí‚é~ÇµÇ‹Ç∑ÅB
echo ==============================================================================

  setlocal
  pushd %~dp0
  call SetVariables.bat

  for %%j in (%H2JAR%) do (
    start /MIN java -cp %%j org.h2.tools.Server -tcpShutdown tcp://localhost:9092 -tcpShutdownForce
    popd
    goto :eof
  )
