CREATE VIEW IT_YuukouKakKekkaKikyk AS SELECT
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     creditcardno ,         /* クレジットカード番号 */
     cardyuukoukigen4keta ,         /* クレジットカード有効期限（４桁） */
     credityuukoukakym ,         /* クレジットカード有効確認年月 */
     credityuukoukakkekka ,         /* クレジットカード有効確認結果 */
     creditkigyoucd ,         /* クレジットカード企業コード */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_YuukouKakKekkaKikyk_Z;