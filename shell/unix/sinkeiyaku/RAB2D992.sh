#!/bin/bash

#
# ペーパーレス告知書イメージＦの移動ジョブ。
# 該当のファイルを読込み、移動する。
# 
# 移動対象ファイル名：RAZP7001Z*

#SYS_DATE=`date "+%Y%m%d"`
PRE="RAZP7001Z"
AST="*"

# 【追加要件】
# ホスト名に対応したディレクトリを指定
# HOSTNAME="NSRABF01"(ST)
HOSTNAME=`hostname`
if [ ${HOSTNAME:1:1} = "S" ]; then
  COPY_DIR=/sli/data/zm/transfer/shuhai/haisin   # ST環境
else
  COPY_DIR=/sli1/data/zm/transfer/shuhai/haisin  # ST環境以外
fi

TARGET_DIR=/usr/dbif/batch_in
#COPY_DIR=./copy_dir 
#TARGET_DIR=./target_dir


COPY_FILE=$COPY_DIR/$PRE$AST

# COPY_FILEが存在する場合のみmvを実行
ls $COPY_FILE >&/dev/null
if [ $? = 0 ]; then
 mv -v $COPY_FILE $TARGET_DIR
fi

