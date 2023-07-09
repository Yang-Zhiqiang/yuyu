CREATE VIEW HT_ImuSonotaTkykJktk AS SELECT
     mosno ,         /* 申込番号 */
     renno ,         /* 連番 */
     pmnjtkkbn ,         /* 保険料免除特約区分 */
     tknzkkbn ,         /* 特約除き区分 */
     seigens ,         /* 制限Ｓ */
     seigens$ ,         /* 制限Ｓ(通貨型) */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_ImuSonotaTkykJktk_Z;