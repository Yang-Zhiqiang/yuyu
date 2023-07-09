#!/bin/sh
##############################################################################
###
### ■使用目的       ： AKS連動ファイル_HULFT起動
###
### ■使用方法       ： $ <シェル名> 引数（11個）
###                     #1～10 「1710C_統合プラットフォーム運用管理サービス利用ガイド」参照
###                      ※ #11 以下のどちらかを指定すること。
###                               YYYYMMDD               :#4,#5の「hiduke」をバッチ実行日に置換します。（スケジュール実行用）
###                               [日付6桁(YYYYMMDD形式)]:#4,#5の「hiduke」を#11に置換します。（マニュアル実行用）
###
### ■使用前提       ： 管理者権限で実行すること。（ジョブ仕様書作成時に注意）
###
##############################################################################

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
SYSDATE_FILE_NAME=/usr/SLCS/batch.ear/batch.war/WEB-INF/classes/conf/SysDate.dat
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

##############################################################################
# メイン処理
##############################################################################


# 送信先ファイル名編集処理
# 変数設定
IN_FILE_NAME=$4
SEND_FILE_NAME=$5


# 置換用日付取得
# 引数判定
# 11番目の引数が「YYYYMMDD」の場合
if test ${11} = "YYYYMMDD" ; then

   # 日付取得処理実行
   DATE=`getDate`

# 上記以外の場合（11番目の引数に日付が指定されている場合）
else

   # 11番目の引数を取得
   DATE=${11}

fi

# 日付置換処理
IN_FILE_NAME=`echo ${IN_FILE_NAME}|sed "s/hiduke/${DATE}/g"`
SEND_FILE_NAME=`echo ${SEND_FILE_NAME}|sed "s/hiduke/${DATE}/g"`


# HULFT起動
/sli/bin/ZMDSA2.sh $1 $2 $3 ${IN_FILE_NAME} ${SEND_FILE_NAME} $6 $7 $8 $9 ${10}

