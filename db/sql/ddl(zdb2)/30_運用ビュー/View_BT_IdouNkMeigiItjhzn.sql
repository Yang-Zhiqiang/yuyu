CREATE VIEW BT_IdouNkMeigiItjhzn AS SELECT
     nksysyno ,         /* 年金証書番号 */
     renno3keta ,         /* 連番（３桁） */
     hhknnmkn ,         /* 被保険者名（カナ） */
     hhknnmkj ,         /* 被保険者名（漢字） */
     hhknseiymd ,         /* 被保険者生年月日 */
     hhknsei ,         /* 被保険者性別 */
     hhknyno ,         /* 被保険者郵便番号 */
     hhknadr1kj ,         /* 被保険者住所１（漢字） */
     hhknadr2kj ,         /* 被保険者住所２（漢字） */
     hhknadr3kj ,         /* 被保険者住所３（漢字） */
     hhkntelno ,         /* 被保険者電話番号 */
     hhknsykgycd ,         /* 被保険者職業コード */
     nenkinuktnmkana ,         /* 年金受取人名（カナ） */
     nenkinuktnmkanji ,         /* 年金受取人名（漢字） */
     nenkinuktseiymd ,         /* 年金受取人生年月日 */
     tsinyno ,         /* 通信先郵便番号 */
     tsinadr1kj ,         /* 通信先住所１（漢字） */
     tsinadr2kj ,         /* 通信先住所２（漢字） */
     tsinadr3kj ,         /* 通信先住所３（漢字） */
     tsintelno ,         /* 通信先電話番号 */
     stdrsknmkn ,         /* 指定代理請求人名（カナ） */
     stdrsknmkj ,         /* 指定代理請求人名（漢字） */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_IdouNkMeigiItjhzn_Z;