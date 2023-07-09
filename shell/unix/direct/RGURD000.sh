#!/bin/sh
###############################################################################
# ＳＰＩＲＡＬメール配信Ｆ連動
# ＳＰＩＲＡＬメール配信Ｆをパイプドビッツ（ＳＰＩＲＡＬ環境）へ連動します。
###############################################################################
# ログ出力用のメッセージ定義
# 正常メッセージ
MSG0001N="--NOR-- ＳＰＩＲＡＬメール配信Ｆ連動処理を開始します。"
MSG0002N="--NOR-- 連動ファイル名（ＴＳＶ）を取得します。"
MSG0003N="--NOR-- 連動ファイル名（ＴＳＶ）を取得しました。"
MSG0004N="--NOR-- 連動ファイル名（ＦＩＮ）を取得します。"
MSG0005N="--NOR-- 連動ファイル名（ＦＩＮ）を取得しました。"
MSG0006N="--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）へ、ＳＰＩＲＡＬメール配信Ｆを連動します。"
MSG0007N="--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）へ、ＳＰＩＲＡＬメール配信Ｆを連動しました。"
MSG0008N="--NOR-- ＳＰＩＲＡＬメール配信Ｆ連動処理を終了します。"
MSG0009N="--NOR-- ファイル名変更処理を開始します。"
MSG0010N="--NOR-- ファイル名を変更しました。"
MSG0011N="--NOR-- ファイル名変更処理を終了します。"

# 異常メッセージ
MSG0001E="--ERR-- 連動ファイル（ＴＳＶ）が存在しません。"
MSG0002E="--ERR-- 連動ファイル（ＦＩＮ）が存在しません。"
MSG0003E="--ERR-- ＳＣＰ実行時にエラーが発生しました。（ＴＳＶ）"
MSG0004E="--ERR-- ＳＣＰ実行時にエラーが発生しました。（ＦＩＮ）"
MSG0005E="--ERR-- ファイル名変更時にエラーが発生しました。"

# プログラムID
JOB_CODE=RGURD000

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
ERR_SCP_TSV=3
ERR_SCP_FIN=4
ERR_RENAME=5

##############################################################################
# 関数定義（日付取得処理）
#   バッチ実行日付を返却します。
#   SysDate.datを読み込んで、OS日付からの相対日付を返します。
#   相対日付が0時（24時）を跨いでいたら、バッチ実行日付と相違します。
##############################################################################
getDate()
{
# 変数設定
SYSDATE_FILE_NAME=/usr/SLCS/batch.ear/batch.war/WEB-INF/classes/conf/SysDate.dat

# 日付取得処理
# SysDate.dat読み込み
while read line;
do
   # 読み込んだ行を「=」で分割
   array=( `echo ${line}|tr -s '=' ' '` )
   
   # 読み込んだ値を代入
   case ${array[0]} in
   
      UseSetting)     # 利用フラグ
         FLAG=${array[1]}
         ;;
         
      Year)           # 年
         YEAR=${array[1]}
         ;;
         
      Month)          # 月
         MONTH=${array[1]}
         ;;
         
      Day)            # 日
         DAY=${array[1]}
         ;;  
   esac
done<${SYSDATE_FILE_NAME}

# 日付取得
DATE=` date -d "${YEAR} year ${MONTH} month ${DAY} day" '+%Y%m%d' `

echo ${DATE}

}

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
# ファイル名変更処理
# パラメタで受け取ったファイルのファイル名称を変更する。
##############################################################################
FUNC_RENAME ()
{
# メッセージ出力「--NOR-- ファイル名変更処理を開始します。」
FUNC_MSG "${MSG_NOR}" ${MSG0009N}

# 時分秒を取得する。
DATE_HMS=`date "+_%H%M%S"`

# パラメタからファイル名を取得する。
FAILENAME=`ls $1`

# ファイル名からファイル名称部分を取得する。
PRE_FILENAME=${FAILENAME%_*}

# ファイル名から拡張子部分を取得する。
DATE_EXT=_${FAILENAME##*_}

# 新ファイル名を作成する。
NEW_FILENAME_EXT=${PRE_FILENAME}${DATE_HMS}${DATE_EXT}

# ファイル名を変更する。（旧ファイル名から新ファイル名へ変更する）
mv ${FAILENAME} ${NEW_FILENAME_EXT}

# 新ファイルが存在しない場合はエラー
if [ ! -e $NEW_FILENAME_EXT ]; then
  # メッセージ出力「--ERR-- ファイル名変更時にエラーが発生しました。」
  FUNC_MSG "${MSG_ERR}" ${MSG0005E}
  
  # 旧ファイル名を出力
  FUNC_MSG "${MSG_ERR}" ${FAILENAME}

  exit ${ERR_RENAME}
fi

# メッセージ出力「--NOR-- ファイル名を変更しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0010N}

# 新ファイル名をログに出力する。
FUNC_MSG "${MSG_NOR}" ${NEW_FILENAME_EXT}

# メッセージ出力「--NOR-- ファイル名変更処理を終了します。」
FUNC_MSG "${MSG_NOR}" ${MSG0011N}
}

##############################################################################
# メイン処理
#ＳＰＩＲＡＬメール配信Ｆを連動します。
##############################################################################
# 処理開始のSTARTメッセージを実行ログに出力
FUNC_MSG "${MSG_STR}" ""

# メッセージ出力「--NOR-- ＳＰＩＲＡＬメール配信Ｆ連動処理を開始します。」
FUNC_MSG "${MSG_NOR}" ${MSG0001N}

#ローカルディレクトリ
LOCAL_DIR=/usr/dbif/batch_out/

# パイプドビッツ（ＳＰＩＲＡＬ環境）連動先ディレクトリ
REMOTE_DIR=/data/new/

# ファイル名（固定部分）
PRE_FILENAME="SpiralMailHaisin_"

# 拡張子（tsv）
EXT_TSV=".tsv"

# 拡張子（fin）
EXT_FIN=".fin"

# 日付（OS日付）
SYS_DATE=`getDate`

# ローカルディレクトリへ移動
pushd ${LOCAL_DIR}

# 前日以前のファイルを削除
find -maxdepth 1 -not -name "${PRE_FILENAME}${SYS_DATE}*" -and  -name "${PRE_FILENAME}*" | xargs rm -f -v >> ${JOBLOG_FILE} 2>&1

# メッセージ出力「--NOR-- 連動ファイル名（ＴＳＶ）を取得します。」
FUNC_MSG "${MSG_NOR}" ${MSG0002N}

# tsvファイル
TSV_FILE=${PRE_FILENAME}*${EXT_TSV}

# tsvファイルが存在しない場合はエラー
if [ ! -e $TSV_FILE ]; then
  # メッセージ出力「--ERR-- 連動ファイル（ＴＳＶ）が存在しません。」
  FUNC_MSG "${MSG_ERR}" ${MSG0001E}
  exit ${ERR_NO_TSV}
fi

# メッセージ出力「--NOR-- 連動ファイル名（ＴＳＶ）を取得しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0003N}

# 取得TSVファイル名をログ出力
FUNC_MSG "${MSG_NOR}" `ls ${TSV_FILE}`

# メッセージ出力「--NOR-- 連動ファイル名（ＦＩＮ）を取得します。」
FUNC_MSG "${MSG_NOR}" ${MSG0004N}

# finファイル
FIN_FILE=${PRE_FILENAME}*${EXT_FIN}

# finファイルが存在しない場合はエラー
if [ ! -e $FIN_FILE ]; then
  # メッセージ出力「--ERR-- 連動ファイル（ＦＩＮ）が存在しません。」
  FUNC_MSG "${MSG_ERR}" ${MSG0002E}
  exit ${ERR_NO_FIN}
fi

# メッセージ出力「--NOR-- 連動ファイル名（ＦＩＮ）を取得しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0005N}

# 取得FINファイル名をログ出力
FUNC_MSG "${MSG_NOR}" `ls ${FIN_FILE}`

# メッセージ出力「--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）へ、ＳＰＩＲＡＬメール配信Ｆを連動します。」
FUNC_MSG "${MSG_NOR}" ${MSG0006N}

# ローカルディレクトリからパイプドビッツ（ＳＰＩＲＡＬ環境）にコピー（tsvファイル）
su buser -c "scp -P 8122 -i /home/buser/.ssh/id_rsa ${TSV_FILE} yuyudsmail@10.4.252.135:${REMOTE_DIR}" >> ${JOBLOG_FILE} 2>&1

if [ $? -ne 0 ]; then
  # メッセージ出力「--ERR-- ＳＣＰ実行時にエラーが発生しました。（ＴＳＶ）」
  FUNC_MSG "${MSG_ERR}" ${MSG0003E}
  exit ${ERR_SCP_TSV}
fi

# ローカルディレクトリからパイプドビッツ（ＳＰＩＲＡＬ環境）にコピー（finファイル）
su buser -c "scp -P 8122 -i /home/buser/.ssh/id_rsa ${FIN_FILE} yuyudsmail@10.4.252.135:${REMOTE_DIR}" >> ${JOBLOG_FILE} 2>&1

if [ $? -ne 0 ]; then
  # メッセージ出力「--ERR-- ＳＣＰ実行時にエラーが発生しました。（ＦＩＮ）」
  FUNC_MSG "${MSG_ERR}" ${MSG0004E}
  exit ${ERR_SCP_FIN}
fi

# TSVファイルのファイル名変更処理を実行する。
FUNC_RENAME "${TSV_FILE}"

# FINファイルのファイル名変更処理を実行する。
FUNC_RENAME "${FIN_FILE}"

# メッセージ出力「--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）へ、ＳＰＩＲＡＬメール配信Ｆを連動しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0007N}

# メッセージ出力「--NOR-- ＳＰＩＲＡＬメール配信Ｆ連動処理を終了します。」
FUNC_MSG "${MSG_NOR}" ${MSG0008N}

# 処理終了のENDメッセージを実行ログに出力
FUNC_MSG "${MSG_END}" ""

exit ${NOR_END}
