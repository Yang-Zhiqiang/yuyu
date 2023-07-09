#!/bin/sh
# バッチ処理を起動します。

# LaunchBatchのあるパスに移動
pushd ./

# 変数設定
MAX_HEAP=12288M
MIN_HEAP=2048M
MAX_PERM=1024M
JAVA_HOME=/usr/IBM/db2/V10.5/java/jdk64/jre

echo ${MAX_HEAP}

CP=/usr/SLCS/batch.ear/batch.war/WEB-INF/lib/ecj-4.5.jar:/usr/IBM/mq/java/lib/com.ibm.mq.jar:/usr/IBM/mq/java/lib/com.ibm.mq.jmqi.jar:/usr/SLCS/batch.ear/batch.war/WEB-INF/classes:/usr/SLCS/batch.ear/batch.war/WEB-INF/lib/*:/usr/IBM/db2/V10.5/java/db2jcc4.jar:/usr/IBM/db2/V10.5/java/db2jcc_license_cisuz.jar:/usr/IBM/db2/V10.5/java/db2jcc_license_cu.jar:/sli/java/lib/slit-ppls.jar:/sli/java/lib/slit-fuho2db.jar:/sli/java/lib/yuyu-bizcommon-1.0.0.jar

# バッチサーバ起動
${JAVA_HOME}/bin/java -Djava.library.path=/usr/IBM/mq/java/lib64 -Xmx${MAX_HEAP} -Xms${MIN_HEAP} -XX:MaxPermSize=${MAX_PERM} -cp "${CP}" jp.co.slcs.swak.batch.Server &

# エラーチェック
if [ $? -ne 0 ]; then
  echo バッチサーバの起動に失敗しました。
fi

# カレントディレクトリに戻る
popd
