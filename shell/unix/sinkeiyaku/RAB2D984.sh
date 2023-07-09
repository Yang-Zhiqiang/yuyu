#!/bin/sh

##############################################################################
# メイン処理
##############################################################################
#
# 連動ファイル　イメージデータ（午前）のバックアップを実行する。
#
# バックアップ元ディレクトリ  :  /sli*/data/zm/transfer/shuhai/haisin
# バックアップ先ディレクトリ  :  /usr/bkup/sinkeiyaku
# バックアップ対象ファイル    :  RAZP7AK1Z{YYYYMMDD}00001.zip, 00003～00007.zip    
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

COPY_FILE=${COPY_DIR}/${PRE}${DATE}${SUF}1${ZIP}
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


# ファイル名の末尾が3～7のファイルのコピーを実行する
# 該当ファイルが必ず存在するとは限らないので、エラーコードは出力しない
#
for NO in 3 4 5 6 7
do
  COPY_FILE=${COPY_DIR}/${PRE}${DATE}${SUF}${NO}${ZIP}
  ls ${COPY_FILE} >&/dev/null
  if [ $? = 0 ]; then
    cp -v -p ${COPY_FILE} ${TARGET_DIR}
  fi
done
