@echo off
pushd
java -Dfile.read.encoding=UTF-8 -jar StarSQL.jar org.postgresql.Driver jdbc:postgresql://devmanage01/yuyuseiho_pkg yuyuseiho yuyuseiho %1 %2 %3 %4 %5 %6 %7 %8 %9
popd
