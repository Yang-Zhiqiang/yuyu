CREATE VIEW BM_ChkKyuuhuKata AS SELECT
     syouhncd ,         /* 商品コード */
     syusyouhnsdnofrom ,         /* （主契約）商品世代番号自 */
     syusyouhnsdnoto ,         /* （主契約）商品世代番号至 */
     kyhkatakbn ,         /* 給付型区分 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_ChkKyuuhuKata_Z;