#!/bin/sh
### ■シェル名　　　　　　：PDF-TIFF変換
###
### ■製作日　　　　　　　：2016年5月31日
###
### ■製作者／改変者　　　：SLC
###
### ■使用目的　　　　　　：PDFからTIFFファイルへ変換する
###
### ■引数
###  inputファイル(PDFファイル)
###    INPUT_DIR=/usr/dbif/batch_in/${JOB_CODE}
###    INPUT_DIR=$1/${JOB_CODE}
###
###  outputファイル(TIFFファイル、TAR.GZファイル)
###    OUTPUT_DIR=/usr/dbif/batch_out/${JOB_CODE}
###    OUTPUT_DIR=$2/${JOB_CODE}
###  
###  Logファイル
###    LOG_DIR=/usr/yuyulogs/${JOB_CODE}
###    LOG_DIR=$3/${JOB_CODE}
###  
###  SysDate.datファイル ※任意設定※
###    SYSDATE_DIR=/usr/SLCS/batch.ear/batch.war/WEB-INF/classes/conf
###    SYSDATE_DIR=$4
###
###  実行例
###    RCB1D000.sh /usr/dbif/batch_in /usr/dbif/batch_out /usr/yuyulogs
###    RCB1D000.sh /usr/dbif/batch_in /usr/dbif/batch_out /usr/yuyulogs /usr/SLCS/batch.ear/batch.war/WEB-INF/classes/conf
###
###############################################################################


################################################################################
# MSG一覧
################################################################################
# 正常
MSG0001N="--NOR-- PDFTIFF変換処理を開始しました。"
MSG0002N="--NOR-- PDFファイルが存在しません。"
MSG0003N="--NOR-- 空ファイルを作成しました。"
MSG0004N="--NOR-- PDFファイル一覧を表示します。"
MSG0005N="--NOR-- TIFF変換を開始します。"
MSG0006N="--NOR-- TIFF変換に成功しました。"
MSG0007N="--NOR-- TIFFファイルの数量が3桁以上存在するか確認します。"
MSG0008N="--NOR-- 数量が3桁を超えるため、削除します。"
MSG0009N="--NOR-- TIFFファイル一覧を表示します。"
MSG0010N="--NOR-- TIFFファイルをtar.gz形式への圧縮処理を開始します。"
MSG0011N="--NOR-- TIFFファイルをtar.gz形式への圧縮処理に成功しました。"
MSG0012N="--NOR-- 圧縮したファイルの拡張子を除く処理を開始します。"
MSG0013N="--NOR-- 圧縮したファイルの拡張子を除く処理に成功しました。"
MSG0014N="--NOR-- PDFファイル削除処理を開始します。"
MSG0015N="--NOR-- PDFファイル削除処理に成功しました。"
MSG0016N="--NOR-- 処理開始前、アウトプットファイルが存在するため削除します。"
MSG0017N="--NOR-- 処理開始前、アウトプットファイルを削除しました。"


# 異常
MSG0001E="--ERR-- 指定された引数に誤りがあります。正しい引数は3つまたは4つです。"
MSG0002E="--ERR-- 空ファイル作成処理に失敗しました。"
MSG0003E="--ERR-- PDFTIFF変換処理に失敗しました。"
MSG0004E="--ERR-- TIFFファイル 数量が3桁以上のファイル削除処理に失敗しました。"
MSG0005E="--ERR-- TIFFファイルをtar.gz形式に圧縮失敗しました。"
MSG0006E="--ERR-- PDFファイル削除処理に失敗しました。"
MSG0007E="--ERR-- 処理開始前、アウトプットファイルが削除出来ませんでした。"

# 警告
MSG0001W=""

###############################################################################
# 変数設定(初期化)
###############################################################################
# 環境設定(JobCenterパス)
export PATH=$PATH:/usr/sbin

# 固定（AKS所管部署指定）
AKS_INF1=KQZ
AKS_INF2=RCB1
AKS_INF3=3Z
AKS_INF4=00001

# 完了コードの初期化
EXIT_CODE=0

# EXITコード設定
NOR_END=0
WAR_END=1
ERR_END=9

# ジョブネット名称
JOB_CODE=RCB1D000

# プログラムID
SHELL_NAME=`basename $0 .sh`

# 実行ログファイル
LOG_PID=`echo $$`
LOG_USR=`whoami`

# MSG関数引数
MSG_STR=1
MSG_NOR=2
MSG_END=3
MSG_ERR=4


# 引数チェック
if [ $# -ne 3 ] && [ $# -ne 4 ]; then
    echo `date "+%Y/%m/%d %H:%M:%S"` ${MSG0001E}
    exit ${ERR_END}
fi

# inputファイル(PDFファイル)
# INPUT_DIR=/test/batch_in/${JOB_CODE}
INPUT_DIR=$1/${JOB_CODE}

# outputファイル(TIFFファイル、TAR.GZファイル)
# OUTPUT_DIR=/test/batch_out/${JOB_CODE}
OUTPUT_DIR=$2/${JOB_CODE}

# Logファイル
# LOG_DIR=/test/yuyulogs/${JOB_CODE}
LOG_DIR=$3/${JOB_CODE}

# ログ出力先
JOBLOG_FILE=${LOG_DIR}/${SHELL_NAME}_`date "+%Y%m%d"`.log

# SysDate.datファイル
if [ $# -eq 4 ]; then
   SYSDATE_DIR=$4
else
   SYSDATE_DIR=/usr/SLCS/batch.ear/batch.war/WEB-INF/classes/conf
fi

##############################################################################
# 関数定義（日付取得処理）
#   バッチ実行日付を返却します。
#   SysDate.datを読み込んで、OS日付からの相対日付を返します。
#   日付の取得元がOS日付なので、相対日付が0時を跨いでいたら、
#   1日前の日付を取得し、バッチ実行日付にあうように調整しています。
##############################################################################

getDate()
{
# 変数設定
SYSDATE_FILE_NAME=${SYSDATE_DIR}/SysDate.dat
FLAG=false

# 日付取得処理
# SysDate.datが存在する場合
if [ -e ${SYSDATE_FILE_NAME} ]; then
   # SysDate.dat読み込み
   while read line;
   do
      # 読み込んだ行を「=」で分割
      array=( `echo ${line}|tr -d '\r'|tr -s '=' ' '` )
      
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
            
         Hour)           # 時
            HOUR=${array[1]}
            ;;
            
         Minute)         # 分
            MINUTE=${array[1]}
            ;;
            
         Second)         # 秒
            SECOND=${array[1]}
            ;;
      esac
   done<${SYSDATE_FILE_NAME}
fi

# 利用フラグ≠trueの場合
if [ ${FLAG} != true ]; then
   # SysDate.datによる相対補正なし (補正値を全て0クリア)
   YEAR=0
   MONTH=0
   DAY=0
   HOUR=0
   MINUTE=0
   SECOND=0
fi

# 時間取得
TIME=`date -d "${HOUR} hour ${MINUTE} minute ${SECOND} second" '+%H'`

# AM（00～08）の場合
if test ${TIME} -ge 00 && test ${TIME} -le 08 ; then
   # 1日前の日付を取得
   DAY=`expr ${DAY} - 1`
fi

# 日付取得
DATE=` date -d "${YEAR} year ${MONTH} month ${DAY} day" '+%Y%m%d' `

echo ${DATE}

}


FUNC_MSG ()
{
  case $1 in
   1 ) echo `date "+%Y/%m/%d %H:%M:%S"`  ${SHELL_NAME} ${LOG_PID} ${LOG_USR} "****** START ******" >> ${JOBLOG_FILE};;
   2 ) shift
       echo `date "+%Y/%m/%d %H:%M:%S"`  $* >> ${JOBLOG_FILE};;
   3 ) echo `date "+%Y/%m/%d %H:%M:%S"`  ${SHELL_NAME} ${LOG_PID} ${LOG_USR} "******  END  ******" >> ${JOBLOG_FILE};;
   4 ) shift
       echo `date "+%Y/%m/%d %H:%M:%S"`  $* >> ${JOBLOG_FILE}
       echo `date "+%Y/%m/%d %H:%M:%S"`  ${SHELL_NAME} ${LOG_PID} ${LOG_USR} "****** ABEND ******" >> ${JOBLOG_FILE};;
  esac
}


# 処理開始のSTARTメッセージを実行ログに出力
FUNC_MSG "1" ""


################################################################################
# 開始処理
################################################################################
# PDF-TIFF変換処理開始出力
FUNC_MSG "${MSG_NOR}" ${MSG0001N}

################################################################################
# PDFTIFF化処理
################################################################################
# 送信ファイル名取得

# バッチ日付取得処理実行
DATE=`getDate`

#SEND_FILE=${AKS_INF1}${AKS_INF2}${AKS_INF3}`date "+%Y%m%d"`${AKS_INF4}
SEND_FILE=${AKS_INF1}${AKS_INF2}${AKS_INF3}${DATE}${AKS_INF4}

###############################################
# アウトプットファイルがあれば削除
cd ${OUTPUT_DIR}
if ls ${AKS_INF1}${AKS_INF2}${AKS_INF3}*${AKS_INF4} > /dev/null 2>&1
then

  FUNC_MSG "${MSG_NOR}" ${MSG0016N}
  rm ./${AKS_INF1}${AKS_INF2}${AKS_INF3}*${AKS_INF4}
  RC=$?

  # --失敗-- アウトプットファイルがあれば削除
  if [ ${RC} -ne 0 ]; then
    FUNC_MSG "${MSG_ERR}" ${MSG0007E}
    exit ${ERR_END}
  fi

  # --成功-- アウトプットファイルがあれば削除
  FUNC_MSG "${MSG_NOR}" ${MSG0017N}

fi
###############################################

# PDFファイル存在確認
PDF_CNT=`find ${INPUT_DIR}/ -maxdepth 1 -name "*.pdf" | wc -l`

# PDFファイルが存在しない場合
if [ ${PDF_CNT} -eq "0" ]; then

  FUNC_MSG "${MSG_NOR}" ${MSG0002N}

  # 空ファイル作成
  cd ${OUTPUT_DIR}
  touch ./${SEND_FILE}

  # --失敗--　空ファイル作成
  if [ $? -ne 0 ]; then
    FUNC_MSG "${MSG_ERR}" ${MSG0002E}
    exit ${ERR_END}
  fi

  # --成功--　空ファイル作成
  FUNC_MSG "${MSG_NOR}" ${MSG0003N}
  echo "                           " ${SEND_FILE} >> ${JOBLOG_FILE}

  # 処理終了のENDメッセージを実行ログに出力
  FUNC_MSG "${MSG_END}" ""
  exit ${NOR_END}
fi

# PDFファイル一覧出力
FUNC_MSG "${MSG_NOR}" ${MSG0004N}
for file in `find ${INPUT_DIR}/ -maxdepth 1 -name '*.pdf' | sort ` ; do
  echo "                           " ${file} >> ${JOBLOG_FILE}
done


# 変換処理実施
cd ${INPUT_DIR}
for file in `find ./ -maxdepth 1 -name '*.pdf' | sed "s/\.\///" | sort ` ; do

  FUNC_MSG "${MSG_NOR}" ${MSG0005N}
  echo "                           " ${file} >> ${JOBLOG_FILE}

  # .pdfを除く(後方一致削除)
  PDF_FILE=${file%.*}

  gs -q -dSAFER -dBATCH -dNOPAUSE -r200 -dTextAlphaBits=4 -dGraphicsAlphaBits=4 \
   -dMaxStripSize=8192 -sDEVICE=tiffg4 \
   -sOutputFile=${OUTPUT_DIR}/${PDF_FILE}%02d.tif ./${PDF_FILE}.pdf

  RC=$?

  # --失敗-- PDFTIFF変換
  if [ ${RC} -ne 0 ]; then
    FUNC_MSG "${MSG_ERR}" ${MSG0003E}
    exit ${ERR_END}
  fi

  # --成功-- PDFTTIF変換
  FUNC_MSG "${MSG_NOR}" ${MSG0006N}
done


# TIFFファイル3桁チェック
FUNC_MSG "${MSG_NOR}" ${MSG0007N}


cd ${OUTPUT_DIR}
for file in `find ./ -maxdepth 1 -name '*.tif' | sed "s/\.\///" | sort ` ; do

  # 19桁+4桁(.pdf)=23桁
  if [ ${#file} -ne 23 ]; then

    # --成功-- 3桁以上のファイル削除
    FUNC_MSG "${MSG_NOR}" ${MSG0008N}
    echo "                           " ${file} >> ${JOBLOG_FILE}

    rm -f ${file} 
    RC=$?

    # --失敗-- 3桁以上のファイル削除
    if [ ${RC} -ne 0 ]; then
      FUNC_MSG "${MSG_ERR}" ${MSG0004E}
      exit ${ERR_END}
    fi

  fi
done

# TIFFファイル一覧出力
FUNC_MSG "${MSG_NOR}" ${MSG0009N}
for file in `find ${OUTPUT_DIR}/ -maxdepth 1 -name '*.tif' | sort` ; do
  echo "                           " ${file} >> ${JOBLOG_FILE}
done


# TIFFファイルをtar.gz形式に圧縮
FUNC_MSG "${MSG_NOR}" ${MSG0010N}
cd ${OUTPUT_DIR}
tar czf ${SEND_FILE}.tar.gz ./*.tif --remove-files
RC=$?

# --失敗-- tar.gz圧縮処理
if [ ${RC} -ne 0 ]; then
  FUNC_MSG "${MSG_ERR}" ${MSG0005E}
  exit ${ERR_END}
fi

# --成功-- tar.gz圧縮処理
FUNC_MSG "${MSG_NOR}" ${MSG0011N}
echo "                           " ${OUTPUT_DIR}/${SEND_FILE}.tar.gz >> ${JOBLOG_FILE}

# TIFFファイルのtar.gz拡張子を除く
FUNC_MSG "${MSG_NOR}" ${MSG0012N}
cd ${OUTPUT_DIR}
mv ${SEND_FILE}.tar.gz ${SEND_FILE}
RC=$?

# --失敗-- TIFFファイルのtar.gz拡張子を除く処理
if [ ${RC} -ne 0 ]; then
  FUNC_MSG "${MSG_ERR}" ${MSG0006E}
  exit ${ERR_END}
fi

# --成功-- TIFファイルのtar.gz拡張子を除く処理
FUNC_MSG "${MSG_NOR}" ${MSG0013N}
echo "                           " ${OUTPUT_DIR}/${SEND_FILE} >> ${JOBLOG_FILE}

# PDFファイルを削除する処理
FUNC_MSG "${MSG_NOR}" ${MSG0014N}
cd ${INPUT_DIR}
rm ./*.pdf
RC=$?

# --失敗-- PDFファイルを削除する処理
if [ ${RC} -ne 0 ]; then
  FUNC_MSG "${MSG_ERR}" ${MSG0006E}
  exit ${ERR_END}
fi

# --成功-- PDFファイルを削除する処理
FUNC_MSG "${MSG_NOR}" ${MSG0015N}

# 処理終了のENDメッセージを実行ログに出力
FUNC_MSG "${MSG_END}" ""

