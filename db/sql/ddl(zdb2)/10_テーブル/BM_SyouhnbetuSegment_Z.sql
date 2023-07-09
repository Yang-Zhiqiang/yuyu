CREATE TABLE BM_SyouhnbetuSegment_Z (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     kyktuukasyu                                        VARCHAR     (3)                                                       NOT NULL  ,  /* 契約通貨種類 */
     segbunrui1                                         VARCHAR     (3)                                                       NOT NULL  ,  /* セグメント分類１ */
     segbunrui2                                         VARCHAR     (3)                                                       NOT NULL  ,  /* セグメント分類２ */
     segcd                                              VARCHAR     (20)                                                                ,  /* セグメントコード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_SyouhnbetuSegment_Z ADD CONSTRAINT PK_SyouhnbetuSegment PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     kyktuukasyu                                              , /* 契約通貨種類 */
     segbunrui1                                               , /* セグメント分類１ */
     segbunrui2                                                 /* セグメント分類２ */
) ;
