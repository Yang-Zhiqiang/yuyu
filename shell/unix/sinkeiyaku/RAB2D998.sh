#!/bin/bash

#
# ペーパーレスコードデータ（SMBCコードデータＦ（午前））の移動ジョブ。
# 該当日付のファイルを読込み、リネームするとともに移動する。
# 
# 移動元ファイル名：RAZP7AA1A${BATCH_DATE1}00001
# 移動先ファイル名：RAZP7AA1AYYYYMMDD00001

##############################################################################
# メイン処理
##############################################################################

# 日付取得処理実行
BATCH_DATE1=`/usr/SLCS/batch.ear/batch/biz/getDate.sh`
BATCH_DATE2="YYYYMMDD"
PRE="RAZP7AA1A"
SUF="00001"
SUF2=".*"

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


COPY_FILE=$COPY_DIR/$PRE$BATCH_DATE1$SUF$SUF2
RENAME_FILE=$COPY_DIR/$PRE$BATCH_DATE2$SUF$SUF2
MOVE_FILE=$TARGET_DIR/$PRE$BATCH_DATE2$SUF

# 一括リネーム後にファイル移動
rename $BATCH_DATE1 $BATCH_DATE2 $COPY_FILE
mv -v $RENAME_FILE $MOVE_FILE

