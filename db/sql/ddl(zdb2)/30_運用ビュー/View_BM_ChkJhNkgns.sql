CREATE VIEW BM_ChkJhNkgns AS SELECT
     hhknfromnen ,         /* 被保険者年齢自 */
     hhkntonen ,         /* 被保険者年齢至 */
     nkgnsgndgk ,         /* 年金原資限度額 */
     nkgnsgndgk$ ,         /* 年金原資限度額(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkJhNkgns_Z;