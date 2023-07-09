CREATE TABLE BM_SisuuKihon (
     sisuukbn                                           VARCHAR     (2)                                                       NOT NULL  ,  /* 指数区分 */
     sisuunm                                            VARCHAR     (50)                                                                ,  /* 指数名 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_SisuuKihon ADD CONSTRAINT PK_SisuuKihon PRIMARY KEY (
     sisuukbn                                                   /* 指数区分 */
) ;
