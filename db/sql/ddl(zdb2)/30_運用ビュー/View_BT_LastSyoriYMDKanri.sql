CREATE VIEW BT_LastSyoriYMDKanri AS SELECT
     lastsyoriymdkanrikbn ,         /* 最終処理日管理区分 */
     lastsyoriymd ,         /* 最終処理日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_LastSyoriYMDKanri_Z;