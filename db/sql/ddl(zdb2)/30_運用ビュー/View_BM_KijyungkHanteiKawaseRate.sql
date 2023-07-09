CREATE VIEW BM_KijyungkHanteiKawaseRate AS SELECT
     kijunnendo ,         /* 基準年度 */
     kyktuukasyu ,         /* 契約通貨種類 */
     kjngkhntiyukawaserate ,         /* 基準額判定用為替レート */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_KijyungkHanteiKawaseRate_Z;