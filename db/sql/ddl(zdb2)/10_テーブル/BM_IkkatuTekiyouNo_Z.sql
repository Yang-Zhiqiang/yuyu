CREATE TABLE BM_IkkatuTekiyouNo_Z (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     ryouritusdno                                       VARCHAR     (3)                                                       NOT NULL  ,  /* 料率世代番号 */
     ikttekiyouno                                       DECIMAL     (9)                                                                 ,  /* 一括払適用番号 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_IkkatuTekiyouNo_Z ADD CONSTRAINT PK_IkkatuTekiyouNo PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     ryouritusdno                                               /* 料率世代番号 */
) ;
