CREATE VIEW BM_KyhNitigakuBairitu AS SELECT
     syouhncd ,         /* 商品コード */
     syouhnsdno ,         /* 商品世代番号 */
     katakbn ,         /* 型区分 */
     kyhngbairitu ,         /* 給付日額倍率 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_KyhNitigakuBairitu_Z;