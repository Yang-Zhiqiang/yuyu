#!/bin/sh

##############################################################################
# メイン処理
##############################################################################
#
# 連動ファイル　イメージデータ（午後）のバックアップを実行する。
#
# バックアップ元ディレクトリ  :  /sli*/data/zm/transfer/shuhai/haisin
# バックアップ先ディレクトリ  :  /usr/bkup/sinkeiyaku
# バックアップ対象ファイル    :  RAZP7AK1Z{YYYYMMDD}00002.zip
# 

# 日付取得処理実行
DATE=`/usr/SLCS/batch.ear/batch/biz/getDate.sh`
PRE="RAZP7AK1Z"
SUF="0000"
ZIP=".zip"

# ホスト名に対応したディレクトリを指定
# HOSTNAME="NSRABF01"(ST)
HOSTNAME=`hostname`
if [ ${HOSTNAME:1:1} = "S" ]; then
  COPY_DIR=/sli/data/zm/transfer/shuhai/haisin   # ST環境
else
  COPY_DIR=/sli1/data/zm/transfer/shuhai/haisin  # ST環境以外
fi

COPY_FILE=${COPY_DIR}/${PRE}${DATE}${SUF}2${ZIP}
TARGET_DIR=/usr/bkup/sinkeiyaku

# コピー実行
# COPY_FILEが存在する場合のみmvを実行
ls ${TARGET_DIR} >&/dev/null
if [ $? = 2 ]; then
  mkdir -p ${TARGET_DIR}
fi

ls ${COPY_FILE} >&/dev/null
if [ $? = 0 ]; then
  cp -v -p ${COPY_FILE} ${TARGET_DIR}
fi
