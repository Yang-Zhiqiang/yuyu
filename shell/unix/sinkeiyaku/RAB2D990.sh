#!/bin/bash

#
# ペーパーレス申込入力1の完了後に実施するファイル削除処理。
# 申込情報取込済の告知書イメージを削除する。
# 
# 削除ファイル名：RAZP7001Z*

PRE="RAZP7001Z"
#SYS_DATE=`date "+%Y%m%d"`
AST="*"

TARGET_DIR=/usr/dbif/batch_in
#TARGET_DIR=./target_dir

REMOVE_FILE=$TARGET_DIR/$PRE$AST

# REMOVE_FILEが存在する場合のみrmを実行
ls $REMOVE_FILE >&/dev/null
if [ $? = 0 ]; then
 rm -f -v $REMOVE_FILE
fi

