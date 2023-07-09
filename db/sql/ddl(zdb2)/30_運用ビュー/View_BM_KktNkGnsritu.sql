CREATE VIEW BM_KktNkGnsritu AS SELECT
     ryouritusdno ,         /* 料率世代番号 */
     tuukasyu ,         /* 通貨種類 */
     shrkkn ,         /* 支払期間 */
     nkgnsritu ,         /* 年金原資率 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     nkgnsritu2           /* 年金原資率２ */
FROM BM_KktNkGnsritu_Z;