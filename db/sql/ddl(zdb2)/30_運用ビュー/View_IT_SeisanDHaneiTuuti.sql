CREATE VIEW IT_SeisanDHaneiTuuti AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     haitounendo ,         /* 配当年度 */
     kakuteitounendod ,         /* 確定当年度Ｄ */
     kakuteitounendod$ ,         /* 確定当年度Ｄ(通貨型) */
     naiteitounendod ,         /* 内定当年度Ｄ */
     naiteitounendod$ ,         /* 内定当年度Ｄ(通貨型) */
     seisandkgk ,         /* 精算Ｄ金額 */
     seisandkgk$ ,         /* 精算Ｄ金額(通貨型) */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_SeisanDHaneiTuuti_Z;