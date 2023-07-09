CREATE VIEW HM_SiinBunrui AS SELECT
     siincd ,         /* 死因コード */
     siintyuubunnruicd ,         /* 死因中分類コード */
     tyuusiincd ,         /* 中死因コード */
     daisiincd ,         /* 大死因コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_SiinBunrui_Z;