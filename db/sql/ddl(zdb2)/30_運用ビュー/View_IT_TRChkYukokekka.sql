CREATE VIEW IT_TRChkYukokekka AS SELECT
     syono ,         /* 証券番号 */
     syoriYmd ,         /* 処理年月日 */
     yuukoutrrenno ,         /* 有効性確認結果TR連番 */
     creditcardno1 ,         /* クレジットカード番号１ */
     creditcardno2 ,         /* クレジットカード番号２ */
     creditcardno3 ,         /* クレジットカード番号３ */
     creditcardno4 ,         /* クレジットカード番号４ */
     cardnokosumu ,         /* カード番号更新有無 */
     cardykkigenkosumu ,         /* カード有効期限更新有無 */
     newcreditcardno1 ,         /* （変更後）クレジットカード番号１ */
     newcreditcardno2 ,         /* （変更後）クレジットカード番号２ */
     newcreditcardno3 ,         /* （変更後）クレジットカード番号３ */
     newcreditcardno4 ,         /* （変更後）クレジットカード番号４ */
     newcreditcardykkigen ,         /* （変更後）クレジットカード有効期限 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_TRChkYukokekka_Z;