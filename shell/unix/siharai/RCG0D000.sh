#!/bin/bash

#
# （支払）あいキューブ病名マスタ送信ファイルの移動ジョブ。
# 該当日付のファイルを読込み、リネームするとともに移動する。
# 
# 移動元ファイル名：RAZ4IA01Z${BATCH_DATE1}00001
# 移動先ファイル名：RAZ4IA01ZYYYYMMDD00001

##############################################################################
# メイン処理
##############################################################################

# 日付取得処理実行
BATCH_DATE1=`/usr/SLCS/batch.ear/batch/biz/getDate.sh`
BATCH_DATE2="YYYYMMDD"
PRE="RAZ4IA01Z"
SUF="00001"

# ホスト名に対応したディレクトリを指定
# HOSTNAME="NSRABF01"(ST)
HOSTNAME=`hostname`
if [ ${HOSTNAME:1:1} = "S" ]; then
  COPY_DIR=/sli/data/zm/transfer/shuhai/haisin   # ST環境
else
  COPY_DIR=/sli1/data/zm/transfer/shuhai/haisin  # ST環境以外
fi

TARGET_DIR=/usr/dbif/batch_in


COPY_FILE=$COPY_DIR/$PRE$BATCH_DATE1$SUF
RENAME_FILE=$COPY_DIR/$PRE$BATCH_DATE2$SUF
MOVE_FILE=$TARGET_DIR/$PRE$BATCH_DATE2$SUF

# リネーム後にファイル移動
# COPY_FILEが存在する場合のみrenameとmvを実行
if [ -e $COPY_FILE ]; then
  rename $BATCH_DATE1 $BATCH_DATE2 $COPY_FILE
  mv -v $RENAME_FILE $MOVE_FILE
fi

