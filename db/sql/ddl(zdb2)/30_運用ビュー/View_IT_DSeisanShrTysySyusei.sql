CREATE VIEW IT_DSeisanShrTysySyusei AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     syoriYmd ,         /* 処理年月日 */
     seisandshrymd ,         /* 精算Ｄ支払年月日 */
     seisand ,         /* 精算Ｄ */
     seisand$ ,         /* 精算Ｄ(通貨型) */
     tyouseid ,         /* 調整Ｄ */
     tyouseid$ ,         /* 調整Ｄ(通貨型) */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_DSeisanShrTysySyusei_Z;