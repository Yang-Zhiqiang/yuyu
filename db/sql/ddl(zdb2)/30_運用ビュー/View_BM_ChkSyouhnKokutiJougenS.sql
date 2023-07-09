CREATE VIEW BM_ChkSyouhnKokutiJougenS AS SELECT
     syouhncd ,         /* 商品コード */
     syusyouhnsdnofrom ,         /* （主契約）商品世代番号自 */
     syusyouhnsdnoto ,         /* （主契約）商品世代番号至 */
     hhknfromnen ,         /* 被保険者年齢自 */
     hhkntonen ,         /* 被保険者年齢至 */
     moskbnfrom ,         /* 申込区分自 */
     moskbnto ,         /* 申込区分至 */
     saikous ,         /* 最高Ｓ */
     saikous$ ,         /* 最高Ｓ(通貨型) */
     bairitu ,         /* 倍率 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkSyouhnKokutiJougenS_Z;