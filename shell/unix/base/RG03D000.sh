#!/bin/sh

################################################################################################################
# 設定ファイルの内容を読み込み、実行日付から指定日数以上古いファイルを削除する
# 
# シェルパラメータ
# 第1引数：設定ファイル（.conf）へのフルパス
# 第2引数：対象サーバ（不要ファイルがアプリサーバ、バッチサーバ、第2メンテサーバの内どこに存在するかを指定）
#          アプリサーバ：ap
#          バッチサーバ：bt
#          第2メンテサーバ：maint
################################################################################################################ 

# ログファイル出力パス
readonly LOG_FILE="/usr/yuyulogs/RG03D000_`date '+%Y%m%d'`.log"

# ログ出力先にシンボリックリンクが張られている場合、警告終了
function check_simlink() {
  if [ -L "${LOG_FILE}" ]; then
    echo "${LOG_FILE}: already exists same name symbolic link!" 1>&2
    exit 2
  fi
}

check_simlink

# ログ出力関数
function log() {
  check_simlink

  echo -e "`date '+%Y-%m-%dT%H:%M:%S'` $@" | tee -a ${LOG_FILE}
  return 0
}


# 引数チェック
if [ $# -ne 2 ]; then
    log "指定された引数に誤りがあります（正しい引数：2）"
    exit 5
fi

# 設定ファイルパス
CONF_FILE=$1

# 設定ファイルが存在しない場合、警告終了
if [ ! -f "${CONF_FILE}" ]; then
  log "設定ファイルが見つかりません：${CONF_FILE}"
  exit 3
fi

# 対象となるサーバの指定
TARGET_SERVER=$2

# 対象サーバ未定義の場合、警告終了
if [ -z "${TARGET_SERVER}" ]; then
  log "対象サーバが未設定です"
  exit 4
fi

log "不要ファイル削除処理を開始します"

# 設定ファイルの行数ループ
while read LINE
do

  # 設定ファイルの空行、及びコメント行を無視する
  if echo ${LINE} | grep -e '^#' -e '^$' >/dev/null; then
    continue
  fi

  # 対象サーバが一致しない場合、無視する
  if [ "`echo ${LINE} | awk -F, '{print $2}'`" != "${TARGET_SERVER}" ]; then
    continue
  fi

  # 行番号
  LINE_NO=`echo ${LINE} | awk -F, '{print $1}'`

  # 対象ディレクトリ
  TARGET_DIR=`echo ${LINE} | awk -F, '{print $3}'`

  # ファイル名の命名パターン
  NAME_PATTERN=`echo ${LINE} | awk -F, '{print $4}'`

  # 残存期間
  LEAVE_TERM=`echo ${LINE} | awk -F, '{print $5}'`

  # 行番号、対象ファイル、残存期間の出力
  log "No:${LINE_NO} 対象ディレクトリ：${TARGET_DIR},ファイル名：${NAME_PATTERN} を直近${LEAVE_TERM}日分残して削除します"

  # ファイル削除実行
  EXEC_RESULT=`find "${TARGET_DIR}" -maxdepth 1 -name "${NAME_PATTERN}" -type f -daystart -mtime +"${LEAVE_TERM}" | xargs rm -fv 2>&1`

  # 実行結果が空値の場合：削除対象なしを出力
  # 上記以外：実行結果を出力
  if [ -n "${EXEC_RESULT}" ]; then
    log "${EXEC_RESULT}"
  else
    log "削除対象ファイルはありませんでした"
  fi


done < ${CONF_FILE}


log "不要ファイル削除処理を終了します"
