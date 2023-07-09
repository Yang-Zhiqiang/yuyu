CREATE VIEW BM_ChkItijibrTuusanP AS SELECT
     hhknfromnen ,         /* 被保険者年齢自 */
     hhkntonen ,         /* 被保険者年齢至 */
     gnditijibaraip ,         /* 限度一時払Ｐ */
     gnditijibaraip$ ,         /* 限度一時払Ｐ(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkItijibrTuusanP_Z;