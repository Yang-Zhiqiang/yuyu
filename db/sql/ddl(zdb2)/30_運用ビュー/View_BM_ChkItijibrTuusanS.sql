CREATE VIEW BM_ChkItijibrTuusanS AS SELECT
     hhknfromnen ,         /* 被保険者年齢自 */
     hhkntonen ,         /* 被保険者年齢至 */
     gnds ,         /* 限度Ｓ */
     gnds$ ,         /* 限度Ｓ(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkItijibrTuusanS_Z;