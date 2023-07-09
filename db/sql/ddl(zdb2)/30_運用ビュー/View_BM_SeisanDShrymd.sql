CREATE VIEW BM_SeisanDShrymd AS SELECT
     syorinendo ,         /* 処理年度 */
     seisandshrymd ,         /* 精算Ｄ支払年月日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_SeisanDShrymd_Z;