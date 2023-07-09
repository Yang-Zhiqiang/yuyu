CREATE VIEW BM_AzukariRiritu AS SELECT
     tuukasyu ,         /* 通貨種類 */
     tkyfromymd ,         /* 適用日自 */
     tkytoymd ,         /* 適用日至 */
     azukaririritu ,         /* 預り利率 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_AzukariRiritu_Z;