#!/bin/sh
##############################################################################
# ＳＰＩＲＡＬ更新予約Ｆ連動
# ＳＰＩＲＡＬ更新予約Ｆをパイプドビッツ（ＳＰＩＲＡＬ環境）へ連動します。
##############################################################################
# ログ出力用のメッセージ定義
# 正常メッセージ
MSG0001N="--NOR-- ＳＰＩＲＡＬ更新予約Ｆ連動を開始します。"
MSG0002N="--NOR-- 連動ファイル名（ＴＳＶ）を取得します。"
MSG0003N="--NOR-- 連動ファイル名（ＴＳＶ）を取得しました。"
MSG0004N="--NOR-- 連動ファイル名（ＦＩＮ）を取得します。"
MSG0005N="--NOR-- 連動ファイル名（ＦＩＮ）を取得しました。"
MSG0006N="--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）へ、ＳＰＩＲＡＬ更新予約Ｆを連動します。"
MSG0007N="--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）へ、ＳＰＩＲＡＬ更新予約Ｆを連動しました。"
MSG0008N="--NOR-- ＳＰＩＲＡＬ更新予約Ｆ連動処理を終了します。"
# 異常メッセージ
MSG0001E="--ERR-- 連動ファイル（ＴＳＶ）が存在しません。"
MSG0002E="--ERR-- 連動ファイル（ＦＩＮ）が存在しません。"
MSG0003E="--ERR-- ＳＣＰ実行時にエラーが発生しました。（ＴＳＶ）"
MSG0004E="--ERR-- ＳＣＰ実行時にエラーが発生しました。（ＦＩＮ）"

# プログラムID
JOB_CODE=RGUND000

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
# メイン処理
#ＳＰＩＲＡＬ更新予約Ｆを連動します。
##############################################################################
# 処理開始のSTARTメッセージを実行ログに出力
FUNC_MSG "${MSG_STR}" ""

# メッセージ出力「--NOR-- ＳＰＩＲＡＬ更新予約Ｆ連動を開始します。」
FUNC_MSG "${MSG_NOR}" ${MSG0001N}

#ローカルディレクトリ
LOCAL_DIR=/usr/dbif/batch_out/

# パイプドビッツ（ＳＰＩＲＡＬ環境）連動先ディレクトリ
REMOTE_DIR=/data/new/

# ファイル名（固定部分）
PRE_FILENAME="SpiralKousinYoyaku_"

# 拡張子（tsv）
EXT_TSV=".tsv"

# 拡張子（fin）
EXT_FIN=".fin"

# 日付（OS日付）
SYS_DATE=`getDate`

# メッセージ出力「--NOR-- 連動ファイル名（ＴＳＶ）を取得します。」
FUNC_MSG "${MSG_NOR}" ${MSG0002N}

# tsvファイル
TSV_FILE=$PRE_FILENAME$SYS_DATE$EXT_TSV

# メッセージ出力「--NOR-- 連動ファイル名（ＴＳＶ）を取得しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0003N}

# 取得TSVファイル名をログ出力
FUNC_MSG "${MSG_NOR}" ${TSV_FILE}

# メッセージ出力「--NOR-- 連動ファイル名（ＦＩＮ）を取得します。」
FUNC_MSG "${MSG_NOR}" ${MSG0004N}

# finファイル
FIN_FILE=$PRE_FILENAME$SYS_DATE$EXT_FIN

# メッセージ出力「--NOR-- 連動ファイル名（ＦＩＮ）を取得しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0005N}

# 取得FINファイル名をログ出力
FUNC_MSG "${MSG_NOR}" ${FIN_FILE}

# ローカルディレクトリへ移動
pushd ${LOCAL_DIR}

# tsvファイルが存在しない場合はエラー
if [ ! -e $TSV_FILE ]; then
  # メッセージ出力「--ERR-- 連動ファイル（ＴＳＶ）が存在しません。」
  FUNC_MSG "${MSG_ERR}" ${MSG0001E}
  exit ${ERR_NO_TSV}
fi

if [ ! -e $FIN_FILE ]; then
  # メッセージ出力「--ERR-- 連動ファイル（ＦＩＮ）が存在しません。」
  FUNC_MSG "${MSG_ERR}" ${MSG0002E}
  exit ${ERR_NO_FIN}
fi

# メッセージ出力「--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）へ、ＳＰＩＲＡＬ更新予約Ｆを連動します。」
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

# メッセージ出力「--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）へ、ＳＰＩＲＡＬ更新予約Ｆを連動しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0007N}

# メッセージ出力「--NOR-- ＳＰＩＲＡＬ更新予約Ｆ連動処理を終了します。」
FUNC_MSG "${MSG_NOR}" ${MSG0008N}

# 処理終了のENDメッセージを実行ログに出力
FUNC_MSG "${MSG_END}" ""

exit ${NOR_END}
