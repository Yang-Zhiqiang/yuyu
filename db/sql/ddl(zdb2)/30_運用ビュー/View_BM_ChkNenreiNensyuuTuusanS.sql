CREATE VIEW BM_ChkNenreiNensyuuTuusanS AS SELECT
     hhknfromnen ,         /* 被保険者年齢自 */
     hhkntonen ,         /* 被保険者年齢至 */
     hhknfromnensyuu ,         /* 被保険者年収区分自 */
     hhkntonensyuu ,         /* 被保険者年収区分至 */
     gnds1 ,         /* 限度Ｓ１ */
     gnds1$ ,         /* 限度Ｓ１(通貨型) */
     gnds2 ,         /* 限度Ｓ２ */
     gnds2$ ,         /* 限度Ｓ２(通貨型) */
     itijibrgnds1 ,         /* 一時払限度Ｓ１ */
     itijibrgnds1$ ,         /* 一時払限度Ｓ１(通貨型) */
     itijibrgnds2 ,         /* 一時払限度Ｓ２ */
     itijibrgnds2$ ,         /* 一時払限度Ｓ２(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkNenreiNensyuuTuusanS_Z;