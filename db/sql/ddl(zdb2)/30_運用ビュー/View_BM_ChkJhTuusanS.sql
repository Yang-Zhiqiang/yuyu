CREATE VIEW BM_ChkJhTuusanS AS SELECT
     hhknfromnen ,         /* 被保険者年齢自 */
     hhkntonen ,         /* 被保険者年齢至 */
     gnds1 ,         /* 限度Ｓ１ */
     gnds1$ ,         /* 限度Ｓ１(通貨型) */
     gnds2 ,         /* 限度Ｓ２ */
     gnds2$ ,         /* 限度Ｓ２(通貨型) */
     gnds3 ,         /* 限度Ｓ３ */
     gnds3$ ,         /* 限度Ｓ３(通貨型) */
     gnds4 ,         /* 限度Ｓ４ */
     gnds4$ ,         /* 限度Ｓ４(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkJhTuusanS_Z;