CREATE VIEW IW_KhSiharaiKouzaHenkouWk AS SELECT
     kouteikanriid ,         /* 工程管理ＩＤ */
     syono ,         /* 証券番号 */
     skssakuseiymd ,         /* 請求書作成日 */
     kzsyuruikbn ,         /* 口座種類区分 */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzdoukbn ,         /* 口座名義人同一区分 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     honninkakninkekkakbn ,         /* 本人確認結果区分 */
     hassoukbn ,         /* 発送区分 */
     zenkaisyorikekkakbn ,         /* 前回処理結果区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IW_KhSiharaiKouzaHenkouWk_Z;