#!/bin/sh

##############################################################################
# メイン処理
##############################################################################
#
# 連動ファイル　コードデータ（SMBCコードデータＦ（午後））のバックアップを実行する。
#
# バックアップ元ディレクトリ  :  /sli*/data/zm/transfer/shuhai/haisin
# バックアップ先ディレクトリ  :  /usr/bkup/sinkeiyaku
# バックアップ対象ファイル    :  RAZP7AA2A{YYYYMMDD}.*    
# 

# 日付取得処理実行
DATE=`/usr/SLCS/batch.ear/batch/biz/getDate.sh`
PRE="RAZP7AA2A"
AST="*"
TARGET_FILE=$PRE$DATE$AST

# ホスト名に対応したディレクトリを指定
# HOSTNAME="NSRABF01"(ST)
HOSTNAME=`hostname`
if [ ${HOSTNAME:1:1} = "S" ]; then
  TARGET_DIR=/sli/data/zm/transfer/shuhai/haisin   # ST環境
else
  TARGET_DIR=/sli1/data/zm/transfer/shuhai/haisin  # ST環境以外
fi

COPY_BEFORE=$TARGET_DIR/$TARGET_FILE
COPY_AFTER=/usr/bkup/sinkeiyaku

# コピー実行
# ファイルが存在しない場合エラーコードを出力する
#
# （例）コマンド実行結果
# [～sinkeiyaku]$ cp $COPY_BEFORE $COPY_AFTER
# [～sinkeiyaku]cp: cannot stat `/sli/data/zm/transfer/shuhai/haisin/RAZP7AA2A20170417*': そのようなファイルやディレクトリはありません
# [～sinkeiyaku]$ echo $?
# 1
#
ls ${COPY_AFTER} >&/dev/null
if [ $? = 2 ]; then
  mkdir -p ${COPY_AFTER}
fi

cp -p $COPY_BEFORE $COPY_AFTER/. >&/dev/null
if [ $? = 1 ]; then
  exit 1
fi
