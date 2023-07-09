CREATE VIEW BM_ChkTkykSyuNenreiHani AS SELECT
     pmnjtkkbn ,         /* 保険料免除特約区分 */
     hhknfromnen ,         /* 被保険者年齢自 */
     hhkntonen ,         /* 被保険者年齢至 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkTkykSyuNenreiHani_Z;