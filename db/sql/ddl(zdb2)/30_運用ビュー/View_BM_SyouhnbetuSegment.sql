CREATE VIEW BM_SyouhnbetuSegment AS SELECT
     syouhncd ,         /* 商品コード */
     kyktuukasyu ,         /* 契約通貨種類 */
     segbunrui1 ,         /* セグメント分類１ */
     segbunrui2 ,         /* セグメント分類２ */
     segcd ,         /* セグメントコード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BM_SyouhnbetuSegment_Z;