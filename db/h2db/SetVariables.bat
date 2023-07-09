rem H2 Database のランタイムライブラリ「h2-(version).jar」へのパスを
rem このディレクトリからの相対パスで指定する。
rem (version) の部分はワイルドカード * でも良い。
set H2JAR=..\..\src\main\webapp\WEB-INF\lib\h2-*.jar

rem 物理データベースファイル名を指定する。
rem 「.h2.db」という拡張子は指定しない。
set DB_FILE_NAME=.\yuyu

rem Deffer で作成した「create table」SQLスクリプトファイルが格納されたディレクトリを、
rem このディレクトリからの相対パスで指定する。
set DDL_DIR=..\sql\ddl\10_テーブル

rem Deffer で作成した「create view」SQLスクリプトファイルが格納されたディレクトリを、
rem このディレクトリからの相対パスで指定する。
set DDL_VIEW_DIR=..\sql\ddl\40_業務ビュー

rem INSERT文作成ツール.xls で作成した「初期データ insert」
rem SQLスクリプトファイルが格納されたディレクトリを、
rem このディレクトリからの相対パスで指定する。
rem スペース区切りで複数ディレクトリを指定可能。
rem 複数ディレクトリを指定した場合、AllInsert.bat は
rem それらディレクトリの中の全SQLスクリプトファイルを実行する。
set INSERT_DIRS=..\sql\insert\1_product
