#!/bin/sh
############################################################
# 為替レートデータテーブル作成（米ドル）を起動します。
############################################################
# 関数定義（日付取得処理）	
#   バッチ実行日付を返却します。	
#   SysDate.datを読み込んで、OS日付からの相対日付を返します。
############################################################
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

# 2番目の引数が「YYYYMMDD」の場合（通常実行時）
if test ${2} = "YYYYMMDD" ; then

   # 日付取得処理実行
   DATE=`getDate`

# 上記以外の場合（臨時実施等で、２番目の引数に日付が指定されている場合）
else

   # 2番目の引数を取得
   DATE=${2}

fi

# ジョブ実行パラメータを上書きする。（処理日付）
set ${1},syoriYmd=${DATE}

# 為替レートデータテーブル作成（米ドル）を起動します。
cd `dirname $0`
../AppLaunchBatch.sh bzkawaseratetblsks $@
