#!/bin/sh
##############################################################################
#メールエラーリストＦ取込
#パイプドビッツ（ＳＰＩＲＡＬ環境）から、エラーリストＦ、メール配信エラーリストＦの取込を行う
##############################################################################
# ログ出力用のメッセージ定義
# 正常メッセージ
MSG0001N="--NOR-- メールエラーリストＦ取込処理を開始します。"
MSG0002N="--NOR-- 取込ファイル名を取得します。"
MSG0003N="--NOR-- 取込ファイル名を取得しました。"
MSG0004N="--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、エラーリストＦの取込を行います。"
MSG0005N="--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、エラーリストＦの取込を行いました。"
MSG0006N="--NOR-- メールエラーリストＦの取込に成功しました。"
MSG0007N="--NOR-- メールエラーリストＦ取込処理を終了します。"
MSG0008N="--NOR-- メール配信エラーリストＦ取込処理を開始します。"
MSG0009N="--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、メール配信エラーリストＦの取込を行います。"
MSG0010N="--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、メール配信エラーリストＦの取込を行いました。"
MSG0011N="--NOR-- メール配信エラーリストＦの取込に成功しました。"
MSG0012N="--NOR-- メール配信エラーリストＦ取込処理を終了します。"
MSG0013N="--NOR-- リアルタイムメールエラーリストＦ取込処理を開始します。"
MSG0014N="--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、リアルタイムメールエラーリストＦの取込を行います。"
MSG0015N="--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、リアルタイムメールエラーリストＦの取込を行いました。"
MSG0016N="--NOR-- リアルタイムメールエラーリストＦの取込に成功しました。"
MSG0017N="--NOR-- リアルタイムメールエラーリストＦ取込処理を終了します。"
MSG0018N="--NOR-- リアルタイムメールエラーリストＦとメール配信エラーリストＦの連結を行います。"
MSG0019N="--NOR-- リアルタイムメールエラーリストＦとメール配信エラーリストＦの連結に成功しました。"
MSG0020N="--NOR-- リアルタイムメールエラーリストＦの削除を行います。"
MSG0021N="--NOR-- リアルタイムメールエラーリストＦの削除に成功しました。"
# 異常メッセージ
MSG0001E="--ERR-- ＳＣＰ実行時にエラーが発生しました。"
MSG0002E="--ERR-- メールエラーリストＦの取込に失敗しました。"
MSG0003E="--ERR-- メール配信エラーリストＦの取込に失敗しました。"
MSG0004E="--ERR-- リアルタイムメールエラーリストＦの取込に失敗しました。"
MSG0005E="--ERR-- リアルタイムメールエラーリストＦとメール配信エラーリストＦの連結に失敗しました。"

# プログラムID
JOB_CODE=RGUKD000

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
ERR_SCP=1
ERR_END=9

##############################################################################
# 関数定義（日付取得処理）
#   バッチ実行日付を返却します。
#   SysDate.datを読み込んで、OS日付からの相対日付を返します。
#   日付の取得元がOS日付なので、相対日付が0時（24時）を跨いでいたら、
#   1日前の日付を取得し、バッチ実行日付にあうように調整しています。
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

# 時間取得
TIME=`date '+%H'`

# AM（00～08）の場合
if test ${TIME} -ge 00 && test ${TIME} -le 08 ; then
   # 1日前の日付を取得
   DAY=${DAY}-1
fi

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
# メールエラーリストＦ、メール配信エラーリストＦ、リアルタイムメールエラーリストＦを取込みます。
##############################################################################
# 処理開始のSTARTメッセージを実行ログに出力
FUNC_MSG "${MSG_STR}" ""

#メールエラーリストＦ取込みます。
# メッセージ出力「--NOR-- メールエラーリストＦ取込処理を開始します。」
FUNC_MSG "${MSG_NOR}" ${MSG0001N}

# ローカルディレクトリ
LOCAL_DIR=/usr/dbif/batch_in/

# パイプドビッツ（ＳＰＩＲＡＬ環境）連携元ディレクトリ
REMOTE_DIR=/data/new/

# ファイル名（固定部分）
PRE_FILENAME="SpiralMailErrorList_"

# 拡張子（tsv）
EXT_TSV=".tsv"

# バッチ日付
BATCH_DATE=`getDate`

# メッセージ出力「--NOR-- 取込ファイル名を取得します。」
FUNC_MSG "${MSG_NOR}" ${MSG0002N}

# ターゲットファイル
TARGET_FILE=$PRE_FILENAME$BATCH_DATE$EXT_TSV

# メッセージ出力「--NOR-- 取込ファイル名を取得しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0003N}

# 取得ターゲットファイル名をログ出力
FUNC_MSG "${MSG_NOR}" ${TARGET_FILE}

# メッセージ出力「--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、エラーリストＦの取込を行います。」
FUNC_MSG "${MSG_NOR}" ${MSG0004N}

# パイプドビッツ（ＳＰＩＲＡＬ環境）からローカルディレクトリにコピー
su buser -c "scp -P 8122 -i /home/buser/.ssh/id_rsa yuyudsmail@10.4.252.135:${REMOTE_DIR}${TARGET_FILE} ${LOCAL_DIR}" >> ${JOBLOG_FILE} 2>&1

# SCPコマンドの実行結果が0以外の場合エラーとする
if [ $? -ne 0 ]; then
  # メッセージ出力「--ERR-- ＳＣＰ実行時にエラーが発生しました。」
  FUNC_MSG "${MSG_ERR}" ${MSG0001E}
  exit ${ERR_SCP}
fi

# メッセージ出力「--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、エラーリストＦの取込を行いました。」
FUNC_MSG "${MSG_NOR}" ${MSG0005N}

# ファイルを取得したディレクトリへ移動
pushd ${LOCAL_DIR}

# ローカルディレクトリにファイルがない場合はエラーとする
if [ -e $TARGET_FILE ]; then
  # メッセージ出力「--NOR-- メールエラーリストＦの取込に成功しました。」
  FUNC_MSG "${MSG_NOR}" ${MSG0006N}
else
  # メッセージ出力「--ERR-- メールエラーリストＦの取込に失敗しました。」
  FUNC_MSG "${MSG_ERR}" ${MSG0002E}
  exit ${ERR_END}
fi

# メッセージ出力「--NOR-- メールエラーリストＦ取込処理を終了します。」
FUNC_MSG "${MSG_NOR}" ${MSG0007N}

#メール配信エラーリストＦ取込みます。
# メッセージ出力「--NOR-- メール配信エラーリストＦ取込処理を開始します。」
FUNC_MSG "${MSG_NOR}" ${MSG0008N}

# ファイル名（固定部分）
PRE_FILENAME="SpiralMailHaisinErrorList_"

# メッセージ出力「--NOR-- 取込ファイル名を取得します。」
FUNC_MSG "${MSG_NOR}" ${MSG0002N}

# ターゲットファイル
TARGET_FILE=$PRE_FILENAME$BATCH_DATE$EXT_TSV

# メッセージ出力「--NOR-- 取込ファイル名を取得しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0003N}

# 取得ターゲットファイル名をログ出力
FUNC_MSG "${MSG_NOR}" ${TARGET_FILE}

# メッセージ出力「--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、メール配信エラーリストＦの取込を行います。」
FUNC_MSG "${MSG_NOR}" ${MSG0009N}

# パイプドビッツ（ＳＰＩＲＡＬ環境）からローカルディレクトリにコピー
su buser -c "scp -P 8122 -i /home/buser/.ssh/id_rsa yuyudsmail@10.4.252.135:${REMOTE_DIR}${TARGET_FILE} ${LOCAL_DIR}" >> ${JOBLOG_FILE} 2>&1

# SCPコマンドの実行結果が0以外の場合エラーとする
if [ $? -ne 0 ]; then
  # メッセージ出力「--ERR-- ＳＣＰ実行時にエラーが発生しました。」
  FUNC_MSG "${MSG_ERR}" ${MSG0001E}
  exit ${ERR_SCP}
fi

# メッセージ出力「--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、メール配信エラーリストＦの取込を行いました。」
FUNC_MSG "${MSG_NOR}" ${MSG0010N}

# ファイルを取得したディレクトリへ移動
pushd ${LOCAL_DIR}

# ローカルディレクトリにファイルがない場合はエラーとする
if [ -e $TARGET_FILE ]; then
  # メッセージ出力「--NOR-- メール配信エラーリストＦの取込に成功しました。」
  FUNC_MSG "${MSG_NOR}" ${MSG0011N}
else
  # メッセージ出力「--ERR-- メール配信エラーリストＦの取込に失敗しました。」
  FUNC_MSG "${MSG_ERR}" ${MSG0003E}
  exit ${ERR_END}
fi

# メッセージ出力「--NOR-- メール配信エラーリストＦ取込処理を終了します。」
FUNC_MSG "${MSG_NOR}" ${MSG0012N}

#リアルタイムメールエラーリストＦ取込みます。
# メッセージ出力「--NOR-- リアルタイムメールエラーリストＦ取込処理を開始します。」
FUNC_MSG "${MSG_NOR}" ${MSG0013N}

# ファイル名（固定部分）
PRE_FILENAME="SpiralRealTimeMailErrorList_"

# メッセージ出力「--NOR-- 取込ファイル名を取得します。」
FUNC_MSG "${MSG_NOR}" ${MSG0002N}

# ターゲットファイル
TARGET_FILE_2=$PRE_FILENAME$BATCH_DATE$EXT_TSV

# メッセージ出力「--NOR-- 取込ファイル名を取得しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0003N}

# 取得ターゲットファイル名をログ出力
FUNC_MSG "${MSG_NOR}" ${TARGET_FILE_2}

# メッセージ出力「--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、リアルタイムメールエラーリストＦの取込を行います。」
FUNC_MSG "${MSG_NOR}" ${MSG0014N}

# パイプドビッツ（ＳＰＩＲＡＬ環境）からローカルディレクトリにコピー
su buser -c "scp -P 8122 -i /home/buser/.ssh/id_rsa yuyudsmail@10.4.252.135:${REMOTE_DIR}${TARGET_FILE_2} ${LOCAL_DIR}" >> ${JOBLOG_FILE} 2>&1

# SCPコマンドの実行結果が0以外の場合エラーとする
if [ $? -ne 0 ]; then
  # メッセージ出力「--ERR-- ＳＣＰ実行時にエラーが発生しました。」
  FUNC_MSG "${MSG_ERR}" ${MSG0001E}
  exit ${ERR_SCP}
fi

# メッセージ出力「--NOR-- パイプドビッツ（ＳＰＩＲＡＬ環境）から、リアルタイムメールエラーリストＦの取込を行いました。」
FUNC_MSG "${MSG_NOR}" ${MSG0015N}

# ファイルを取得したディレクトリへ移動
pushd ${LOCAL_DIR}

# ローカルディレクトリにファイルがない場合はエラーとする
if [ -e $TARGET_FILE_2 ]; then
  # メッセージ出力「--NOR-- リアルタイムメールエラーリストＦの取込に成功しました。」
  FUNC_MSG "${MSG_NOR}" ${MSG0016N}
else
  # メッセージ出力「--ERR-- リアルタイムメールエラーリストＦの取込に失敗しました。」
  FUNC_MSG "${MSG_ERR}" ${MSG0004E}
  exit ${ERR_END}
fi

# メッセージ出力「--NOR-- リアルタイムメールエラーリストＦ取込処理を終了します。」
FUNC_MSG "${MSG_NOR}" ${MSG0017N}

# メッセージ出力「--NOR-- リアルタイムメールエラーリストＦとメール配信エラーリストＦの連結を行います。」
FUNC_MSG "${MSG_NOR}" ${MSG0018N}

# メール配信エラーリストＦの末尾にリアルタイムメールエラーリストＦの内容を連結
cat ${TARGET_FILE_2} >> ${TARGET_FILE}

# ファイル結合実行結果が0以外の場合エラーとする
if [ $? -ne 0 ]; then
  # メッセージ出力「--ERR-- リアルタイムメールエラーリストＦとメール配信エラーリストＦの連結に失敗しました。」
  FUNC_MSG "${MSG_ERR}" ${MSG0005E}
  exit ${ERR_SCP}
fi

# メッセージ出力「--NOR-- リアルタイムメールエラーリストＦとメール配信エラーリストＦの連結に成功しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0019N}

# メッセージ出力「--NOR-- リアルタイムメールエラーリストＦの削除を行います。」
FUNC_MSG "${MSG_NOR}" ${MSG0020N}

# リアルタイムメールエラーリストＦを削除する。
rm -f ${TARGET_FILE_2}

# メッセージ出力「--NOR-- リアルタイムメールエラーリストＦの削除に成功しました。」
FUNC_MSG "${MSG_NOR}" ${MSG0021N}

# 削除ターゲットファイル名をログ出力
FUNC_MSG "${MSG_NOR}" ${TARGET_FILE_2}

# 処理終了のENDメッセージを実行ログに出力
FUNC_MSG "${MSG_END}" ""

exit ${NOR_END}
