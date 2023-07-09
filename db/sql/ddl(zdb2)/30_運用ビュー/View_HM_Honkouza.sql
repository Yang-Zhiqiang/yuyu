CREATE VIEW HM_Honkouza AS SELECT
     honkouzacd ,         /* 本口座コード */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     kouzano ,         /* 口座番号 */
     sikinidousakibankcd ,         /* 資金移動先銀行コード */
     sikinidousakisitencd ,         /* 資金移動先支店コード */
     sikinidousakikouzano ,         /* 資金移動先口座番号 */
     tuukasyu ,         /* 通貨種類 */
     hyoujijyun ,         /* 表示順 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HM_Honkouza_Z;