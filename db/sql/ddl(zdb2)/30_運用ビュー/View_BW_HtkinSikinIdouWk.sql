CREATE VIEW BW_HtkinSikinIdouWk AS SELECT
     syono ,         /* 証券番号 */
     kijyunymd ,         /* 基準年月日 */
     haitounendo ,         /* 配当年度 */
     kyktuukasyu ,         /* 契約通貨種類 */
     seisikiwariategaku ,         /* 正式割当額 */
     seisikiwariategaku$ ,         /* 正式割当額(通貨型) */
     seg1cd ,         /* セグメント１コード */
     sikinidoukawaserate ,         /* 資金移動用為替レート */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BW_HtkinSikinIdouWk_Z;