CREATE VIEW IT_KhTyouhyouHonbanKakunin AS SELECT
     tyouhyoubunrui ,         /* 帳票分類 */
     syoruiCd ,         /* 書類コード */
     jyoukenbunrui1 ,         /* 条件分類１ */
     jyoukenbunrui2 ,         /* 条件分類２ */
     jyoukenbunrui3 ,         /* 条件分類３ */
     kakuninjyoutaikbn ,         /* 確認状態区分 */
     honbankakuninstartymd ,         /* 本番確認開始日 */
     firstkaisouymd ,         /* 初回回送日 */
     honbankakuninymd ,         /* 本番確認日 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_KhTyouhyouHonbanKakunin_Z;