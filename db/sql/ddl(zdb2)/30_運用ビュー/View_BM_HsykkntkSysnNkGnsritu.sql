CREATE VIEW BM_HsykkntkSysnNkGnsritu AS SELECT
     ryouritusdno ,         /* 料率世代番号 */
     tuukasyu ,         /* 通貨種類 */
     seibetu ,         /* 性別 */
     nkshrstartnen ,         /* 年金支払開始年齢 */
     hsykkn ,         /* 保証期間 */
     nkgnsritu ,         /* 年金原資率 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_HsykkntkSysnNkGnsritu_Z;