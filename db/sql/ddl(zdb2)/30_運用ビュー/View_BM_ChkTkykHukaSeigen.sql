CREATE VIEW BM_ChkTkykHukaSeigen AS SELECT
     syusyouhncd ,         /* 主契約商品コード */
     syusyouhnsdnofrom ,         /* （主契約）商品世代番号自 */
     syusyouhnsdnoto ,         /* （主契約）商品世代番号至 */
     sntkhoukbnfrom ,         /* 選択方法区分自 */
     sntkhoukbnto ,         /* 選択方法区分至 */
     hhknfromnen ,         /* 被保険者年齢自 */
     hhkntonen ,         /* 被保険者年齢至 */
     tksyouhncd ,         /* 特約商品コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkTkykHukaSeigen_Z;