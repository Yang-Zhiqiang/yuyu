#!/bin/bash

#
# ペーパーレス申込書類イメージＦ２の移動ジョブ。
# 該当日付のファイルを読込み、移動する。
# 
# 移動対象ファイル名：RAZP7AK1Z${BATCH_DATE}00002.zip

##############################################################################
# メイン処理
##############################################################################

# 日付取得処理実行
BATCH_DATE=`/usr/SLCS/batch.ear/batch/biz/getDate.sh`
PRE="RAZP7AK1Z"
SUF="0000"
ZIP=".zip"

# ホスト名に対応したディレクトリを指定
# HOSTNAME="NSRABF01"(ST)
HOSTNAME=`hostname`
if [ ${HOSTNAME:1:1} = "S" ]; then
  MOVE_DIR=/sli/data/zm/transfer/shuhai/haisin   # ST環境
else
  MOVE_DIR=/sli1/data/zm/transfer/shuhai/haisin  # ST環境以外
fi

MOVE_FILE=${MOVE_DIR}/${PRE}${BATCH_DATE}${SUF}2${ZIP}
TARGET_DIR=/usr/dbif/batch_in

# MOVE_FILEが存在する場合のみmvを実行
ls ${MOVE_FILE} >&/dev/null
if [ $? = 0 ]; then
 mv -v ${MOVE_FILE} ${TARGET_DIR}
fi












