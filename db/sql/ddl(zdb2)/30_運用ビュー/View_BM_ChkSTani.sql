CREATE VIEW BM_ChkSTani AS SELECT
     syouhncd ,         /* 商品コード */
     syusyouhnsdnofrom ,         /* （主契約）商品世代番号自 */
     syusyouhnsdnoto ,         /* （主契約）商品世代番号至 */
     hhknfromnen ,         /* 被保険者年齢自 */
     hhkntonen ,         /* 被保険者年齢至 */
     tuukasyu ,         /* 通貨種類 */
     stani ,         /* Ｓ単位 */
     stani$ ,         /* Ｓ単位(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkSTani_Z;