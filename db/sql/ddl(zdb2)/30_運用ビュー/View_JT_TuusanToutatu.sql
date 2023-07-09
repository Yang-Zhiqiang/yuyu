CREATE VIEW JT_TuusanToutatu AS SELECT
     skno ,         /* 請求番号 */
     syono ,         /* 証券番号 */
     seikyuurirekino ,         /* 請求履歴番号 */
     syouhncd ,         /* 商品コード */
     kyhgndkatakbn ,         /* 給付限度型区分 */
     syouhnsdno ,         /* 商品世代番号 */
     kyksyouhnrenno ,         /* 契約商品連番 */
     kyuuhucd ,         /* 給付コード */
     kouryokuhasseiymd ,         /* 効力発生日 */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_TuusanToutatu_Z;