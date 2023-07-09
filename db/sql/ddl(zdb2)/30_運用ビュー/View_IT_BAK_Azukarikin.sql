CREATE VIEW IT_BAK_Azukarikin AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     henkousikibetukey ,         /* 変更識別キー */
     tuukasyu ,         /* 通貨種類 */
     azukarikinsyuruikbn ,         /* 預り金種類区分 */
     shrymd ,         /* 支払日 */
     shrsyoriymd ,         /* 支払処理日 */
     azukarikinhsiymd ,         /* 預り金発生日 */
     azukarikingk ,         /* 預り金額 */
     azukarikingk$ ,         /* 預り金額(通貨型) */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_BAK_Azukarikin_Z;