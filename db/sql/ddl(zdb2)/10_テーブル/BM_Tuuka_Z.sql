CREATE TABLE BM_Tuuka_Z (
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類 */
     ssketasuu                                          DECIMAL     (1)                                                                 ,  /* 小数桁数 */
     tuukasyumei                                        VARCHAR     (42)                                                                ,  /* 通貨種類正式名 */
     tuukasyuryk                                        VARCHAR     (42)                                                                ,  /* 通貨種類略称 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_Tuuka_Z ADD CONSTRAINT PK_Tuuka PRIMARY KEY (
     tuukasyu                                                   /* 通貨種類 */
) ;
