CREATE VIEW HM_SyouhnTaniHonkouza AS SELECT
     syouhncd ,         /* 商品コード */
     honkouzacd ,         /* 本口座コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_SyouhnTaniHonkouza_Z;