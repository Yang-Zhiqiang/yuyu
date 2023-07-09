CREATE VIEW BM_DairitenSyougou AS SELECT
     drtencd ,         /* 代理店コード */
     kanjihoujinsyougou ,         /* 漢字法人商号 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_DairitenSyougou_Z;