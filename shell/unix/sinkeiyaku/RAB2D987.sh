#!/bin/bash

#
# ペーパーレス申込入力２の完了後に実施するファイル削除処理。
# 申込情報取込済の申込書類イメージを削除する。
# 申込入力用申込書類イメージダミーＦ２を削除する。
# 待合せＦ（イメージ２）を削除する。
# 
# 削除ファイル名：RAZP7AK1Z${BATCH_DATE}00002
# 削除ファイル名：RAZP7AK1Z${BATCH_DATE}99992
# 削除ファイル名：RAP11

##############################################################################
# メイン処理
##############################################################################

PRE="RAZP7AK1Z"
# 日付取得処理実行
BATCH_DATE=`/usr/SLCS/batch.ear/batch/biz/getDate.sh`
SUF="0000"
ZIP=".zip"
EMP1="RAP11"
EMP2="*99992.dat"

TARGET_DIR=/usr/dbif/batch_in
#TARGET_DIR=./target_dir

# ホスト名に対応したディレクトリを指定
# HOSTNAME="NSRABF01"(ST)
HOSTNAME=`hostname`
if [ ${HOSTNAME:1:1} = "S" ]; then
  TARGET_DIR2=/sli/data/zm/transfer/shuhai/haisin   # ST環境
else
  TARGET_DIR2=/sli1/data/zm/transfer/shuhai/haisin  # ST環境以外
fi

REMOVE_FILE=${TARGET_DIR}/${PRE}${BATCH_DATE}${SUF}2${ZIP}
REMOVE_EMP_FILE1=${TARGET_DIR}/${EMP1}
REMOVE_EMP_FILE2=${TARGET_DIR2}/${EMP2}

# 申込入力用申込書類イメージＦ２が存在する場合のみrmを実行
ls ${REMOVE_FILE} >&/dev/null
if [ $? = 0 ]; then
 rm -f -v ${REMOVE_FILE}
fi

# 待合せＦ（イメージ２）が存在する場合のみrmを実行
ls ${REMOVE_EMP_FILE1} >&/dev/null
if [ $? = 0 ]; then
 rm -f -v ${REMOVE_EMP_FILE1}
fi

# 申込入力用申込書類イメージダミーＦ２が存在する場合のみrmを実行
ls ${REMOVE_EMP_FILE2} >&/dev/null
if [ $? = 0 ]; then
 rm -f -v ${REMOVE_EMP_FILE2}
fi

