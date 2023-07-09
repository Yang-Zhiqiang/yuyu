CREATE VIEW BM_SikinIdouGroup AS SELECT
     segcd ,         /* セグメントコード */
     sikinidougroupkbn ,         /* 資金移動グループ区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_SikinIdouGroup_Z;