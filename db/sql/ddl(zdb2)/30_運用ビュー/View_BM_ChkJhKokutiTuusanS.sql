CREATE VIEW BM_ChkJhKokutiTuusanS AS SELECT
     hhknfromnen ,         /* 被保険者年齢自 */
     hhkntonen ,         /* 被保険者年齢至 */
     kijikbn ,         /* 記事区分 */
     iktkktkbnfrom ,         /* 一括告知区分自 */
     iktkktkbnto ,         /* 一括告知区分至 */
     gnds1 ,         /* 限度Ｓ１ */
     gnds1$ ,         /* 限度Ｓ１(通貨型) */
     gnds2 ,         /* 限度Ｓ２ */
     gnds2$ ,         /* 限度Ｓ２(通貨型) */
     gnds3 ,         /* 限度Ｓ３ */
     gnds3$ ,         /* 限度Ｓ３(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkJhKokutiTuusanS_Z;