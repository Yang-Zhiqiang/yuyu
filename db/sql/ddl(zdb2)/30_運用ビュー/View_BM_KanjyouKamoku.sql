CREATE VIEW BM_KanjyouKamoku AS SELECT
     kanjyoukmkcd ,         /* 勘定科目コード */
     denkanjokamokucd ,         /* 伝票用勘定科目コード */
     kanjyoukmknm ,         /* 勘定科目名 */
     jigyouhiutiwakecd ,         /* 事業費内訳コード */
     jigyouhiutiwakenm ,         /* 事業費内訳名 */
     hjybyouhyj ,         /* 補助簿要表示 */
     hjybtantositucd ,         /* 補助簿統括担当室コード */
     hjybruigkteiseiumukbn ,         /* 補助簿累計額訂正有無区分 */
     kanjyoukmkgroupkbn ,         /* 勘定科目グループ区分 */
     kbnkeiriyouhi ,         /* 区分経理要否 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_KanjyouKamoku_Z;