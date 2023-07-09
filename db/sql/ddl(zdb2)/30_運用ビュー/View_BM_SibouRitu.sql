CREATE VIEW BM_SibouRitu AS SELECT
     ryouritusdno ,         /* 料率世代番号 */
     seibetu ,         /* 性別 */
     nenrei ,         /* 年齢 */
     sibouritu1 ,         /* 死亡率１ */
     sibouritu2 ,         /* 死亡率２ */
     kaiyakuritu1 ,         /* 解約率１ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_SibouRitu_Z;