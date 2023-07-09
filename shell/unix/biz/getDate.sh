#!/bin/sh
##############################################################################
###
###  ■使用目的		:バッチ処理日付を取得・返却する
###
###  ■引数		:なし
###  ■戻り値		:YYYYMMDD
###
###  ■処理概要		:1)SysDate.datを変数に読み込む
###			 2)現在時刻をシステム日付から取得
###			 3)0時～8時未満は、前日扱いとなるよう補正変数に値を入力
###			 4)1),3)を使って、
###			   日付補正する値をYEAR、MONTH、DAY変数に入力する
###			 5)システム日付を変数に代入し、4)の補正を加える
###			 6)5)の結果を返却する
##############################################################################

# 変数設定
SYSDATE_FILE_NAME=/usr/SLCS/batch.ear/batch.war/WEB-INF/classes/conf/SysDate.dat


# 時間取得
TIME=`date '+%H'`

# AM（00～08）の場合
if test ${TIME} -ge 00 && test ${TIME} -lt 08 ; then
   DAYHOSEI=-1
else
   DAYHOSEI=0   
fi

# 日付取得処理
# SysDate.dat読み込み
while read line;
do

   # 読み込んだ行を「=」で分割te '+%H'`
   array=( `echo ${line}|tr -d '\r'|tr -s '=' ' '` )

   # 読み込んだ値を代入
   case ${array[0]} in

      UseSetting)     # 利用フラグ
         FLAG=${array[1]}
         ## 利用フラグがfalse（利用しない）だったら抜ける
         if [ ${FLAG} = "false" ] ; then
            break
         fi
         ;;

      Year)           # 年
         YEAR=${array[1]}
         ;;

      Month)          # 月
         MONTH=${array[1]}
         ;;

      Day)            # 日
         DAY=` expr ${array[1]} + ${DAYHOSEI} `
         ;;
   esac
done<${SYSDATE_FILE_NAME}

# 日付取得
if [ ${FLAG} = "false" ] ; then
   DATE=`date -d "${DAYHOSEI} day" '+%Y%m%d'`
else
   DATE=` date -d "${YEAR} year ${MONTH} month ${DAY} day" '+%Y%m%d' `
fi

echo ${DATE}
