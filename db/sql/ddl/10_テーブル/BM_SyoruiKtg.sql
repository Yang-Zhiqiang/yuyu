CREATE TABLE BM_SyoruiKtg (
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     ktgsyoruicd                                        VARCHAR     (5)                                                       NOT NULL  ,  /* 結合対象書類コード */
     sortNo                                             NUMBER      (3)                                                                 ,  /* ソート番号 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_SyoruiKtg ADD CONSTRAINT PK_SyoruiKtg PRIMARY KEY (
     syoruiCd                                                 , /* 書類コード */
     ktgsyoruicd                                                /* 結合対象書類コード */
) ;
