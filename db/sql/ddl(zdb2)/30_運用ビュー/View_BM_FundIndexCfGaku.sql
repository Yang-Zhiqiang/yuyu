CREATE VIEW BM_FundIndexCfGaku AS SELECT
     unitfundkbn ,         /* ユニットファンド区分 */
     fundhyoukaymd ,         /* ファンド評価年月日　　　　 */
     segkey ,         /* ＳＥＧＫＥＹ　　　　　　　　 */
     cfgaku ,         /* ＣＦ額 */
     cfgaku$ ,         /* ＣＦ額(通貨型) */
     gkcfgaku ,         /* （外貨）ＣＦ額 */
     gkcfgaku$ ,         /* （外貨）ＣＦ額(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_FundIndexCfGaku_Z;