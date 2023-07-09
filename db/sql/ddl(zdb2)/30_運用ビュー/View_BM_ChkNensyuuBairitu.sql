CREATE VIEW BM_ChkNensyuuBairitu AS SELECT
     nensyuukbn ,         /* 年収区分 */
     gndntgk ,         /* 限度日額 */
     gndntgk$ ,         /* 限度日額(通貨型) */
     gnds ,         /* 限度Ｓ */
     gnds$ ,         /* 限度Ｓ(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkNensyuuBairitu_Z;