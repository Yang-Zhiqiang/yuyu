CREATE VIEW HM_KetteiSya AS SELECT
     ketsyacd ,         /* 決定者コード */
     palketsyacd ,         /* ＰＡＬ決定者コード */
     ketsyanm ,         /* 決定者名 */
     mostenkenrankkbn ,         /* 申込点検ランク区分 */
     knksateirankkbn ,         /* 環境査定ランク区分 */
     knksateijygns ,         /* 環境査定上限Ｓ */
     knksateijygns$ ,         /* 環境査定上限Ｓ(通貨型) */
     imusateirankkbn ,         /* 医務査定ランク区分 */
     imusateijygns ,         /* 医務査定上限Ｓ */
     imusateijygns$ ,         /* 医務査定上限Ｓ(通貨型) */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_KetteiSya_Z;