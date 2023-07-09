CREATE VIEW IT_BAK_CreditCardInfo AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     credityuukoukakym ,         /* クレジットカード有効確認年月 */
     credityuukoukakkekka ,         /* クレジットカード有効確認結果 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_BAK_CreditCardInfo_Z;