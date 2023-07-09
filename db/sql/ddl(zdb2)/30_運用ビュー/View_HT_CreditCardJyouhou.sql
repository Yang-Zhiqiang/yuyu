CREATE VIEW HT_CreditCardJyouhou AS SELECT
     mosno ,         /* 申込番号 */
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     cardbrandkbn ,         /* カードブランド区分 */
     credittrkhoukbn ,         /* クレジットカード登録方法区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_CreditCardJyouhou_Z;