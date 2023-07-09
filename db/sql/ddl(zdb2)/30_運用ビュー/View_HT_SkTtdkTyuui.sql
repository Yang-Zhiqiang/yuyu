CREATE VIEW HT_SkTtdkTyuui AS SELECT
     mosno ,         /* 申込番号 */
     skeittdkrenrakukbn ,         /* 新契約手続連絡区分 */
     datarenno ,         /* データ連番 */
     skeittdktyuuinaiyou ,         /* 新契約手続注意内容 */
     trkymd ,         /* 登録日 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_SkTtdkTyuui_Z;