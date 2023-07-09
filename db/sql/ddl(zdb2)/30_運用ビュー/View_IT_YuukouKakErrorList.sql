CREATE VIEW IT_YuukouKakErrorList AS SELECT
     syono ,         /* 証券番号 */
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     syoriym ,         /* 処理年月 */
     credityuukoukakym ,         /* クレジットカード有効確認年月 */
     credityuukoukakkekka ,         /* クレジットカード有効確認結果 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_YuukouKakErrorList_Z;