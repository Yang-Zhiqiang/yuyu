CREATE VIEW HT_MosMikakuteiSyorui AS SELECT
     documentid ,         /* ドキュメントＩＤ */
     mosno ,         /* 申込番号 */
     syoruiCd ,         /* 書類コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_MosMikakuteiSyorui_Z;