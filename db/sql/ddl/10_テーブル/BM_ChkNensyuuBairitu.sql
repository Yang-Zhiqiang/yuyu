CREATE TABLE BM_ChkNensyuuBairitu (
     nensyuukbn                                         VARCHAR     (2)                                                       NOT NULL  ,  /* 年収区分                                          */
     gndntgk                                            NUMBER      (13)                                                                ,  /* 限度日額                                          */
     gndntgk$                                           VARCHAR     (10)                                                                ,  /* 限度日額(通貨型)                                     */
     gnds                                               NUMBER      (13)                                                                ,  /* 限度Ｓ                                           */
     gnds$                                              VARCHAR     (10)                                                                ,  /* 限度Ｓ(通貨型)                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_ChkNensyuuBairitu ADD CONSTRAINT PK_ChkNensyuuBairitu PRIMARY KEY (
     nensyuukbn                                                 /* 年収区分                                           */
) ;
