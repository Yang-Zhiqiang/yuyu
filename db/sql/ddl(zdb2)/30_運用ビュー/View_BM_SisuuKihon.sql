CREATE VIEW BM_SisuuKihon AS SELECT
     sisuukbn ,         /* 指数区分 */
     sisuunm ,         /* 指数名 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_SisuuKihon_Z;