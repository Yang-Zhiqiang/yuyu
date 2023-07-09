#!/bin/sh
##############################################################################
###
### ■使用目的       ： 市場価格調整用利率連動ファイル_HULFT起動
###
### ■使用方法       ： $ <シェル名> 引数（11個）
###                     #1～10 「ED-IF_インターフェース概要書_市場価格調整用利率連動Ｆ.xlsx」参照
###                      ※ [ファイル名][hiduke（固定文字列）][5桁連番]
###                         連番は１つのジョブ内で複数送信する場合に値を増やすこと。
###
###                         例．TestFile01hidule00001
###
###                      ※ #11 以下のどちらかを指定すること。
###                               YYYYMMDD               :#5の「hiduke」をバッチ実行日に置換します。（スケジュール実行用）
###                               [日付6桁(YYYYMMDD形式)]:#5の「hiduke」を#11に置換します。（マニュアル実行用）
###
### ■使用前提       ： 管理者権限で実行すること。（ジョブ仕様書作成時に注意）
###
##############################################################################

##############################################################################
# メイン処理
##############################################################################
# 前回の送信ファイルが存在している場合、削除する
BK_FILE=/usr/dbif/batch_out/A8ZRG261Z*
if [ -e ${BK_FILE} ]; then
   rm -f ${BK_FILE}
fi

# ファイル名編集処理
# 変数設定
IN_FILE_NAME=$4
SEND_FILE_NAME=$5
RENDOU_FILE_NAME="${10}"

# 置換用日付取得
# 引数判定
# 11番目の引数が「YYYYMMDD」の場合
if test ${11} = "YYYYMMDD" ; then

   # 日付取得処理実行
   DATE=`/usr/SLCS/batch.ear/batch/biz/getDate.sh`

# 上記以外の場合（11番目の引数に日付が指定されている場合）
else

   # 11番目の引数を取得
   DATE=${11}

fi

# 日付置換処理
IN_FILE_NAME=`echo ${IN_FILE_NAME}|sed "s/hiduke/${DATE}/g"`
SEND_FILE_NAME=`echo ${SEND_FILE_NAME}|sed "s/hiduke/${DATE}/g"`
RENDOU_FILE_NAME=`echo ${RENDOU_FILE_NAME}|sed "s/hiduke/${DATE}/g"`

# ファイルをコピーする
cp -p /usr/dbif/batch_out/BM_SjkkkTyouseiyouRiritu_rendou.csv ${IN_FILE_NAME}

# HULFT起動
/sli/bin/ZMDSA2.sh $1 $2 $3 ${IN_FILE_NAME} ${SEND_FILE_NAME} $6 $7 $8 $9 "${RENDOU_FILE_NAME}"

