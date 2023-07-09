CREATE VIEW BM_Sisuu AS SELECT
     sisuukbn ,         /* 指数区分 */
     sisuukouhyouymd ,         /* 指数公表日 */
     sisuu ,         /* 指数 */
     sisuucalckijyunymd ,         /* 指数計算基準日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_Sisuu_Z;