CREATE VIEW IT_KykSyaHenkouRireki AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     henkousikibetukey ,         /* 変更識別キー */
     meighnksyoriymd ,         /* 名義変更処理年月日 */
     meigihnkjiyuu ,         /* 名義変更事由 */
     kouryokuhasseiymd ,         /* 効力発生日 */
     oldkyksibouymd ,         /* （旧）契約者死亡日 */
     oldkyknmkn ,         /* （旧）契約者名（カナ） */
     oldkyknmkj ,         /* （旧）契約者名（漢字） */
     oldkyknmkjkhukakbn ,         /* （旧）契約者名漢字化不可区分 */
     oldkykseiymd ,         /* （旧）契約者生年月日 */
     oldkyksei ,         /* （旧）契約者性別 */
     oldkkkyktdk ,         /* （旧）契約管理契約者続柄 */
     oldtsinyno ,         /* （旧）通信先郵便番号 */
     oldtsinadr1kj ,         /* （旧）通信先住所１（漢字） */
     oldtsinadr2kj ,         /* （旧）通信先住所２（漢字） */
     oldtsinadr3kj ,         /* （旧）通信先住所３（漢字） */
     oldtsintelno ,         /* （旧）通信先電話番号 */
     olddai2tsintelno ,         /* （旧）第２通信先電話番号 */
     tsinyno ,         /* 通信先郵便番号 */
     tsinadr1kj ,         /* 通信先住所１（漢字） */
     tsinadr2kj ,         /* 通信先住所２（漢字） */
     tsinadr3kj ,         /* 通信先住所３（漢字） */
     tsintelno ,         /* 通信先電話番号 */
     dai2tsintelno ,         /* 第２通信先電話番号 */
     kyktuukasyu ,         /* 契約通貨種類 */
     kaiyakuhrstgk ,         /* 解約返戻金相当額 */
     kaiyakuhrstgk$ ,         /* 解約返戻金相当額(通貨型) */
     yenkaiyakuhrstgk ,         /* 円換算解約返戻金相当額 */
     yenkaiyakuhrstgk$ ,         /* 円換算解約返戻金相当額(通貨型) */
     yenkansantkykwsrate ,         /* 円換算適用為替レート */
     yenkansantkykwsrateymd ,         /* 円換算適用為替レート基準日 */
     kihrkmpsgk ,         /* 既払込保険料総額 */
     kihrkmpsgk$ ,         /* 既払込保険料総額(通貨型) */
     oldkykkihrkmp ,         /* （旧）契約者既払込保険料 */
     oldkykkihrkmp$ ,         /* （旧）契約者既払込保険料(通貨型) */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     sonotashrkngkyen ,         /* その他支払金額（円貨） */
     sonotashrkngkyen$           /* その他支払金額（円貨）(通貨型) */
FROM IT_KykSyaHenkouRireki_Z;