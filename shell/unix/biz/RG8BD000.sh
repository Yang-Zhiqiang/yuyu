#!/bin/sh
##############################################################################
###
### ■使用目的       ： 400日バックアップ対象ファイル移動
###
### ■使用方法       ： 同フォルダ内にある 400dayBkupFileList.txt に記載されているファイルを
###                     400日バックアップ用フォルダ /sli/data/zm/backup/BACKUP400DAY へ移動します。
###
##############################################################################

# 変数定義
confDir=/usr/SLCS/ray.ear/batch/biz
fileName=400dayBkupFileList.txt
BkupDir=/sli/data/zm/backup/BACKUP400DAY
logDir=/usr/yuyulogs
logFileName=400dayBkup.log
errorFlag=0
hostName=`hostname`

# メイン処理
# 開始ログ出力
echo 400日バックアップ対象ファイル移動を開始します。 > ${logDir}/${logFileName}

# 開始チェック
# ファイル存在チェック
ls ${confDir}/${fileName}

# 対象一覧ファイルが存在しない場合
if [ $? -ne 0 ] ; then
   echo 対象一覧ファイルが存在しません。 >> ${logDir}/${logFileName}
   exit 2
fi

# ディレクトリ存在チェック
ls ${BkupDir}
# 400日バックアップディレクトリが存在しない場合
if [ $? -ne 0 ] ; then
   echo 400日バックアップディレクトリが存在しません。 >> ${logDir}/${logFileName}
   exit 2
fi

# 日付取得
#引数チェック
if [ $# -eq 0 ]; then

  # 1日前の日付を取得する。
  syoriYmd=`date +"%Y%m%d" --date "1 day ago"`
  
else

  # 引数セット
  syoriYmd=$1
  
  #日付妥当性チェック
  date +%Y%m%d --date "${syoriYmd}"
  WK_RES=$?
  
  if [ ${WK_RES} -eq 1 ]; then
    echo "引数を正しい日付形式で指定してください。" >> ${logDir}/${logFileName}
    exit 2
  fi
  
fi

# 日付形式変換
syoriYmd=${syoriYmd:0:4}-${syoriYmd:4:2}-${syoriYmd:6:2}

# 設定ファイル読み込み
cat ${confDir}/${fileName} | while read line
do

   # ファイル名設定
   copyFilename=`echo ${line} | sed -e "s/\[syoriYmd\]/${syoriYmd}_${hostName}/"`
   line=`echo ${line} | sed -e "s/\[syoriYmd\]/${syoriYmd}/"`

   # 移動対象ファイルログ出力
   echo ${logDir}/${line}を移動します。 >> ${logDir}/${logFileName}
   
   # ファイル移動
   mv ${logDir}/${line} ${BkupDir}/${copyFilename}
   
   # エラーの場合
   if [ $? -ne 0 ]; then
   
      # エラーログ出力
      echo ${logDir}/${line}の移動に失敗しました。 >> ${logDir}/${logFileName}
      
      # 終了レベル設定
      errorFlag=2
      
   # エラーでない場合
   else
      
      # ログ出力
      echo ${logDir}/${line}を移動しました。>> ${logDir}/${logFileName}
   
   fi

done

# 終了ログ出力
echo 400日バックアップ対象ファイル移動を終了します。 >> ${logDir}/${logFileName}

# 終了
exit ${errorFlag}
