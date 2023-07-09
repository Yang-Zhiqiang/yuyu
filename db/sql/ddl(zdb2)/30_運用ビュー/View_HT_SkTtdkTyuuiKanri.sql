CREATE VIEW HT_SkTtdkTyuuiKanri AS SELECT
     mosno ,         /* 申込番号 */
     skeittdkkinkyuyouhikbn ,         /* 新契約手続緊急要否区分 */
     skeittdktyuuiyouhikbn ,         /* 新契約手続注意要否区分 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_SkTtdkTyuuiKanri_Z;