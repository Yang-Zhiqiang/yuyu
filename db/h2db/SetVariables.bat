rem H2 Database �̃����^�C�����C�u�����uh2-(version).jar�v�ւ̃p�X��
rem ���̃f�B���N�g������̑��΃p�X�Ŏw�肷��B
rem (version) �̕����̓��C���h�J�[�h * �ł��ǂ��B
set H2JAR=..\..\src\main\webapp\WEB-INF\lib\h2-*.jar

rem �����f�[�^�x�[�X�t�@�C�������w�肷��B
rem �u.h2.db�v�Ƃ����g���q�͎w�肵�Ȃ��B
set DB_FILE_NAME=.\yuyu

rem Deffer �ō쐬�����ucreate table�vSQL�X�N���v�g�t�@�C�����i�[���ꂽ�f�B���N�g�����A
rem ���̃f�B���N�g������̑��΃p�X�Ŏw�肷��B
set DDL_DIR=..\sql\ddl\10_�e�[�u��

rem Deffer �ō쐬�����ucreate view�vSQL�X�N���v�g�t�@�C�����i�[���ꂽ�f�B���N�g�����A
rem ���̃f�B���N�g������̑��΃p�X�Ŏw�肷��B
set DDL_VIEW_DIR=..\sql\ddl\40_�Ɩ��r���[

rem INSERT���쐬�c�[��.xls �ō쐬�����u�����f�[�^ insert�v
rem SQL�X�N���v�g�t�@�C�����i�[���ꂽ�f�B���N�g�����A
rem ���̃f�B���N�g������̑��΃p�X�Ŏw�肷��B
rem �X�y�[�X��؂�ŕ����f�B���N�g�����w��\�B
rem �����f�B���N�g�����w�肵���ꍇ�AAllInsert.bat ��
rem �����f�B���N�g���̒��̑SSQL�X�N���v�g�t�@�C�������s����B
set INSERT_DIRS=..\sql\insert\1_product
