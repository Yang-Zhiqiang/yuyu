#!/bin/bash

#
# ペーパーレス連動２ センター系ジョブネット起動のための空ファイル作成
# ペーパーレスコードデータの着信起動
# 

##############################################################################
# メイン処理
##############################################################################

TARGET_DIR=/usr/dbif/batch_in
NAME="RAP01"

touch $TARGET_DIR/$NAME

