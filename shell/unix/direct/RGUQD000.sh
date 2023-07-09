#!/bin/sh
###############################################################################
# ＳＰＩＲＡＬメール配信Ｆコピー
# ＳＰＩＲＡＬメール配信Ｆを第２メンテナンス環境から通常環境へコピーします。
###############################################################################
# ログ出力用のメッセージ定義
# 正常メッセージ
MSG0001N="--NOR-- ＳＰＩＲＡＬメール配信Ｆコピー（値動き）処理を開始します。"
MSG0002N="--NOR-- コピーファイル名（ＴＳＶ）を取得します。"
MSG0003N="--NOR-- コピーファイル名（ＴＳＶ）を取得しました。"
MSG0004N="--NOR-- コピーファイル名（ＦＩＮ）を取得します。"
MSG0005N="--NOR-- コピーファイル名（ＦＩＮ）を取得しました。"
MSG0006N="--NOR-- 通常環境へ、ＳＰＩＲＡＬメール配信Ｆをコピーします。"
MSG0007N="--NOR-- 通常環境へ、ＳＰＩＲＡＬメール配信Ｆをコピーしました。"
MSG0008N="--NOR-- ＳＰＩＲＡＬメール配信Ｆコピー（値動き）処理を終了します。"
# 異常メッセージ
MSG0001E="--ERR-- コピーファイル（ＴＳＶ）が存在しません。"
MSG0002E="--ERR-- コピーファイル（ＦＩＮ）が存在しません。"
MSG0003E="--ERR-- ＦＴＰ実行時にエラーが発生しました。"

# プログラムID
JOB_CODE=RGUQD000

# プロセスID
LOG_PID=`echo $$`

# ユーザー
LOG_USR=`whoami`

# Logファイル
LOG_DIR=/usr/yuyulogs/${JOB_CODE}/

# ログ出力先
JOBLOG_FILE=${LOG_DIR}${JOB_CODE}_`date "+%Y%m%d"`.log

# MSG関数引数
MSG_STR=1
MSG_NOR=2
MSG_END=3
MSG_ERR=4

# EXITコード設定
NOR_END=0
ERR_NO_TSV=1
ERR_NO_FIN=2
ERR_FTP=3

##############################################################################
# メッセージ出力処理
# パラメタで受け取ったメッセージをログに出力する。
##############################################################################
FUNC_MSG ()
{
  case $1 in
   1 ) echo `date "+%Y/%m/%d %H:%M:%S"`  ${JOB_CODE} ${LOG_PID} ${LOG_USR} "****** START ******" >> ${JOBLOG_FILE};;
   2 ) shift
       echo `date "+%Y/%m/%d %H:%M:%S"`  $* >> ${JOBLOG_FILE};;
   3 ) echo `date "+%Y/%m/%d %H:%M:%S"`  ${JOB_CODE} ${LOG_PID} ${LOG_USR} "******  END  ******" >> ${JOBLOG_FILE};;
   4 ) shift
       echo `date "+%Y/%m/%d %H:%M:%S"`  $* >> ${JOBLOG_FILE}
       echo `date "+%Y/%m/%d %H:%M:%S"`  ${JOB_CODE} ${LOG_PID} ${LOG_USR} "****** ABEND ******" >> ${JOBLOG_FILE};;
  esac
}

##############################################################################
# メイン処理
# ＳＰＩＲＡＬメール配信Ｆをコピーします。
##############################################################################
# 処理開始のSTARTメッセージを実行ログに出力
FUNC_MSG "${MSG_STR}" ""

# メッセージ出力「--NOR-- ＳＰＩＲＡＬメール配信Ｆコピー（値動き）処理を開始します。」
FUNC_MSG "${MSG_NOR}" ${MSG0001N}

# confファイルに定義しているパスワードを取得
. /usr/SLCS/batch.ear/batch/direct/RGUQD000.conf
PASS=$PASSWORD

#ローカルディレクトリ（第２メンテ環境）
LOCAL_DIR=/usr/dbif/batch_out/

# 通常環境コピー先ディレクトリ
REMOTE_DIR=/usr/dbif/batch_out/

# ファイル名（固定部分）
PRE_FILENAME="SpiralMailHaisin_"

# 拡張子（tsv）
EXT_TSV=".tsv"

# 拡張子（fin）
EXT_FIN=".fin"

# ローカルディレクトリへ移動
pushd ${LOCAL_DIR}

# メッセージ出力「--NOR-- コピーファイル名（ＴＳＶ）を取得します。」
FUNC_MSG "${MSG_NOR}" ${MSG0002N}

# tsvファイル
TSV_FILE=${PRE_FILENAME}*${EXT_TSV}

# tsvファイルが存在しない場合はエラー
if [ ! -e $TSV_FILE ]; then
  # メッセージ出力「--ERR-- コピーファイル（ＴＳＶ）が存在しません。」
  FUNC_MSG "${MSG_ERR}" ${MSG0001E}
  exit ${ERR_NO_TSV}
fi

# メッセージ出力「--NOR-- コピーファイル名（ＴＳＶ）を取得しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0003N}

# 取得TSVファイル名をログ出力
FUNC_MSG "${MSG_NOR}" `ls ${TSV_FILE}`

# メッセージ出力「--NOR-- コピーファイル名（ＦＩＮ）を取得します。」
FUNC_MSG "${MSG_NOR}" ${MSG0004N}

# finファイル
FIN_FILE=${PRE_FILENAME}*${EXT_FIN}

if [ ! -e $FIN_FILE ]; then
  # メッセージ出力「--ERR-- コピーファイル（ＦＩＮ）が存在しません。」
  FUNC_MSG "${MSG_ERR}" ${MSG0002E}
  exit ${ERR_NO_FIN}
fi

# メッセージ出力「--NOR-- コピーファイル名（ＦＩＮ）を取得しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0005N}

# 取得FINファイル名をログ出力
FUNC_MSG "${MSG_NOR}" `ls ${FIN_FILE}`

# メッセージ出力「--NOR-- 通常環境へ、ＳＰＩＲＡＬメール配信Ｆをコピーします。」
FUNC_MSG "${MSG_NOR}" ${MSG0006N}

# ローカルディレクトリから通常環境にコピー
ftp -nv >> ${JOBLOG_FILE} 2>&1 <<END
  open 10.200.92.3
  user ftpapl01 ${PASS}
  cd   ${REMOTE_DIR}
  binary
  prompt
  mput  ${TSV_FILE}  ${FIN_FILE}
END

if [ $? -ne 0 ]; then
  # メッセージ出力「--ERR-- ＦＴＰ実行時にエラーが発生しました。」
  FUNC_MSG "${MSG_ERR}" ${MSG0003E}
  exit ${ERR_FTP}
fi

# メッセージ出力「--NOR-- 通常環境へ、ＳＰＩＲＡＬメール配信Ｆをコピーしました。」
FUNC_MSG "${MSG_NOR}" ${MSG0007N}

# メッセージ出力「--NOR-- ＳＰＩＲＡＬメール配信Ｆコピー（値動き）処理を終了します。」
FUNC_MSG "${MSG_NOR}" ${MSG0008N}

# 処理終了のENDメッセージを実行ログに出力
FUNC_MSG "${MSG_END}" ""

exit ${NOR_END}
