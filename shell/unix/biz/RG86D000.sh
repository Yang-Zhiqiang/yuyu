#/bin/sh
##########################################################################
###
### ■使用目的       ： アクセスログファイルより統計情報を抽出する
###
### ■使用方法       ： $ <シェル名> [<実行日(YYYYMMDD)>]
###
### ■使用前提       ： なし
###
##########################################################################

#引数チェック
if [ $# -eq 0 ]; then
  #実行日取得
  WK_JIKKOUBI=`date --date '1 day ago' +%Y%m%d`
else
  WK_JIKKOUBI=$1
  #日付妥当性チェック
  date +%Y%m%d --date "${WK_JIKKOUBI}" > /dev/null 2>&1
  WK_RES=$?
  if [ ${WK_RES} -eq 1 ]; then
    echo "引数を正しい日付形式で指定してください。"
    exit 1
  fi
fi

#変数定義
#検索文言
SEARCH_STR="ActionBegin"

#プログラムID
SHELL_NAME=`basename $0`

#ログ出力フォルダ
LOG_PID=`echo $$`
LOG_USR=`whoami`
LOG_DIR=/usr/yuyulogs

#統計情報出力ログファイル名
TOUKEI_LOG_FILE=${LOG_DIR}/`echo ${SHELL_NAME}|sed -e "s/^\(.*\).sh/\1/"`_`date '+%Y%m' --date "${WK_JIKKOUBI}"`.log

#アウトプットフォルダ
OUT_DIR="/usr/yuyulogs"

#サブシステム配列
SUBSYSTEM_ARR=("ray" "ray_ag" "ray_ds")

# ホスト名
HOST_NAME=`hostname`

#開始ログを出力
echo `date "+%Y/%m/%d %X"` ${SHELL_NAME} ${LOG_PID} ${LOG_USR} "***** START *****" >> ${TOUKEI_LOG_FILE}
echo "アクセスログ作成(日次)処理を開始します。" >> ${TOUKEI_LOG_FILE}

#サブシステム配列数分、処理を繰り返す
for SUBSYSTEM in "${SUBSYSTEM_ARR[@]}"; do

  #アクセスログファイル名(日次)名定義
  #統計情報出力ファイル名
  TOUKEI_FILE=${OUT_DIR}/${HOST_NAME}_${SUBSYSTEM}_ToukeiAccessLogFile_`date '+%Y%m' --date "${WK_JIKKOUBI}"`.txt
  #echo TOUKEI_FILE:${TOUKEI_FILE}

  #アクセスログファイル(日次)名
  ACCESSLOG_FILE=${LOG_DIR}/${SUBSYSTEM}.accesslog.`date '+%Y-%m-%d' --date "${WK_JIKKOUBI}"`.log
  #echo ACCESSLOG_FILE:${ACCESSLOG_FILE}

  #アクセスログファイル(日次)存在チェック
  if [ ! -e ${ACCESSLOG_FILE} ]; then
    echo "アクセスログファイル(日次)が存在しません。(${ACCESSLOG_FILE})}" >> ${TOUKEI_LOG_FILE}
    echo "アクセスログ作成(日次)処理を終了します。" >> ${TOUKEI_LOG_FILE}
    echo `date "+%Y/%m/%d %X"` ${SHELL_NAME} ${LOG_PID} ${LOG_USR} "***** ABEND *****" >> ${TOUKEI_LOG_FILE}
    exit 1
  fi

  #アクセスログファイル(日次)よりアクセスログ部を抽出
  #抽出実施
  grep ${SEARCH_STR} ${ACCESSLOG_FILE} >> ${TOUKEI_FILE}

  #抽出件数取得
  WK_KENSU=`grep ${SEARCH_STR} ${ACCESSLOG_FILE} | wc -l`

  #実行ログ出力
  echo ${SUBSYSTEM} "処理件数 "${WK_KENSU}" 件" >> ${TOUKEI_LOG_FILE}

done

#終了ログ出力
echo "アクセスログ作成(日次)処理を終了します。" >> ${TOUKEI_LOG_FILE}
echo `date "+%Y/%m/%d %X"` ${SHELL_NAME} ${LOG_PID} ${LOG_USR} "*****  END  *****" >> ${TOUKEI_LOG_FILE}

#処理を正常終了
exit 0
