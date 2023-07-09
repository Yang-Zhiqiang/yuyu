CREATE VIEW HT_SyouhnTokujyouRireki AS SELECT
     mosno ,         /* 申込番号 */
     dakuhiktrenno ,         /* 諾否決定連番 */
     syouhncd ,         /* 商品コード */
     syouhnsdno ,         /* 商品世代番号 */
     tknzkkbn ,         /* 特約除き区分 */
     tumahtnpkbn ,         /* 妻不担保区分 */
     kohtnpkbn ,         /* 子不担保区分 */
     seigens ,         /* 制限Ｓ */
     seigens$ ,         /* 制限Ｓ(通貨型) */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_SyouhnTokujyouRireki_Z;