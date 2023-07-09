#!/bin/bash

#
# ペーパーレス申込入力2の完了後に実施するファイル削除処理。
# 申込情報取込済のSMBCコードデータＦ（午後）を削除する。
# 
# 削除ファイル名：RAZP7AA2AYYYYMMDD00002

PRE="RAZP7AA2A"
SYS_DATE="YYYYMMDD"
SUF="00002"
EMP="RAP01"

TARGET_DIR=/usr/dbif/batch_in
#TARGET_DIR=./target_dir

REMOVE_FILE=$TARGET_DIR/$PRE$SYS_DATE$SUF
REMOVE_EMP_FILE=$TARGET_DIR/$EMP

rm -f -v $REMOVE_FILE

# 待合せＦ（コードデータ２）が存在する場合のみrmを実行
ls $REMOVE_EMP_FILE >&/dev/null
if [ $? = 0 ]; then
 rm -f -v $REMOVE_EMP_FILE
fi
