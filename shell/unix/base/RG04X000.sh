#/bin/sh
##########################################################################
###
### ■使用目的       ： フロー定義をデプロイする
###
### ■使用方法       ： $  <シェル名>
###
### ■使用前提       ： JAVA_HOMEが定義されていること
###
##########################################################################

# 完了コードの初期化
EXIT_CODE=0

# 関数定義(終了処理)
END()
{
case ${EXIT_CODE} in
  0)        # 正常終了
    echo "フロー定義デプロイシェル処理が正常終了しました。" >> ${JOBLOG_FILE}
    echo `date "+%Y/%m/%d %X"` ${SHELL_NAME} ${LOG_PID} ${LOG_USR} "*****  END  *****" >> ${JOBLOG_FILE}
    exit 0  ;;
  *)        # 異常終了
    echo "フロー定義デプロイシェル処理が異常終了しました。" >> ${JOBLOG_FILE}
    echo `date "+%Y/%m/%d %X"` ${SHELL_NAME} ${LOG_PID} ${LOG_USR} "***** ABEND *****" >> ${JOBLOG_FILE}
    exit ${EXIT_CODE}  ;;
esac
}

# 関数定義(エラーチェック)
ERR_CHK()
{
  ERR_MSG_DEF=("エラー情報" \
               "ファイルの拡張子が" \
               "ファイルが存在しません" \
               "ファイルを指定ください" \
               "プロセス定義ファイル名の取得に失敗しました" \
               "プロセス定義ファイル名が未指定です" \
               "引数の設定数が誤っています" \
               "DB設定名が不正です" \
               "実行モード指定が不正です" \
               "ERROR" \
              )

  #エラーMSG定義でループ
  for i in "${ERR_MSG_DEF[@]}"
  do
    #ログファイル内をエラーMSGで検索
    if grep ${i} ${JOBLOG_FILE} > /dev/null; then
      #エラーMSGがヒットした場合
      #終了コード1を返却
      return 1
    fi
  done

  #終了コード0を返却
  return 0
}

# 共通変数定義
#プログラムID
SHELL_NAME=`basename $0`

#シェル保存先
SHELL_DIR=/usr/SLCS/batch.ear/batch/base

#デプロイ対象フォルダ
DEPLOY_DIR=/usr/SLCS/batch.ear/flowdeploy

#デプロイ対象設定ファイル
DEPLOY_CONF_FILE=deploy.conf

#ログ出力フォルダ
JOBLOG_DIR=/usr/yuyulogs

# ジョブ監査ログファイル
LOG_PID=`echo $$`
LOG_USR=`whoami`
JOBLOG_FILE=${JOBLOG_DIR}/`echo ${SHELL_NAME}|sed -e "s/^\(.*\).sh/\1/"`_`date '+%Y%m%d%H%M%S'`.log

#JAVA設定
JAVA_HOME=/usr/IBM/db2/V10.5/java/jdk64/jre

#処理開始のSTARTメッセージをジョブ監査ログに出力
echo `date "+%Y/%m/%d %X"` ${SHELL_NAME} ${LOG_PID} ${LOG_USR} "***** START *****" >> ${JOBLOG_FILE}

#定義取得
#  コマンド「hostname」を実行し、ホスト名を取得。
#  ホスト名の先頭6文字を抽出し、ワーク変数に格納。
HOST_NAME=`hostname | cut -c 1-6`

#  設定ファイル存在チェック
if [ -e ${SHELL_DIR}/${HOST_NAME}.sh ]; then
  #  存在する場合
  #  設定ファイル(ワーク変数.sh)を実行。
  source ${SHELL_DIR}/${HOST_NAME}.sh
else
  #  上記以外の場合
  #  処理を異常終了する。
  echo "設定ファイル(${HOST_NAME}.sh)が存在しない為、処理を終了します。" >> ${JOBLOG_FILE}
  EXIT_CODE=1
  END
fi

#処理開始の正常域メッセージを障害通知メッセージログに出力
echo "フロー定義デプロイシェル処理を開始しました。" >> ${JOBLOG_FILE}

#デプロイ対象フォルダ存在チェック
if [ ! -e ${DEPLOY_DIR} ]; then
  #  存在しない場合
  #  処理を異常終了する。
  echo "デプロイ対象フォルダ(${DEPLOY_DIR})が存在しない為、処理を終了します。" >> ${JOBLOG_FILE}
  EXIT_CODE=1
  END
fi

#デプロイ実施
# デプロイ対象フォルダからデプロイに使用する設定ファイルを生成する。
su - buser -c "find ${DEPLOY_DIR} -name "processdefinition.xml" > ${DEPLOY_DIR}/${DEPLOY_CONF_FILE}"  >> ${JOBLOG_FILE} 2>&1

# コマンド実行結果異常検知
if [ $? -ne "0" ]; then
  echo "コマンド実行時にエラー： find /usr/SLCS/batch.ear/flowdeploy -name processdefinition.xml" >> ${JOBLOG_FILE}
  EXIT_CODE=1
  END
fi

#  フロー定義デプロイツール実行。
su - buser -c "cd ${DEPLOY_DIR};echo -e \"\n\" | ${JAVA_HOME}/bin/java -jar ${DEPLOY_DIR}/iwfdeploy-s.jar ${DEPLOY_DIR}/${DEPLOY_CONF_FILE} ${DB_USER} ${DB_PASS} jdbc:db2://${IP}:${PORT}/${DB} zdb update" >> ${JOBLOG_FILE} 2>&1

# コマンド実行結果異常検知
if [ $? -ne "0" ]; then
  echo "コマンド実行時にエラー： su - buser -c 'cd /usr/SLCS/batch.ear/flowdeploy;echo -e "\n" | /usr/IBM/db2/V10.5/java/jdk64/jre/bin/java -jar /usr/SLCS/batch.ear/flowdeploy/iwfdeploy-s.jar /usr/SLCS/batch.ear/flowdeploy/deploy.conf （db情報） zdb update'" >> ${JOBLOG_FILE}
  EXIT_CODE=1
  END
fi

#実行結果確認
#  ログファイル内の「エラー」文言を検索。
ERR_CHK
RTN=$?
if [ ${RTN} -eq 1 ]; then
  #  「エラー」文言がヒットした場合
  #  処理を異常終了する。
  echo "デプロイ中にエラーが発生しました。" >> ${JOBLOG_FILE}
  EXIT_CODE=1
  END
else
  #  上記以外の場合
  #    処理を正常終了する。
  EXIT_CODE=0
  END
fi
