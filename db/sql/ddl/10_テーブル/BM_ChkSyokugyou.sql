CREATE TABLE BM_ChkSyokugyou (
     syokugyoucd                                        VARCHAR     (3)                                                       NOT NULL  ,  /* 職業コード */
     gndntgk                                            NUMBER      (13)                                                                ,  /* 限度日額 */
     gndntgk$                                           VARCHAR     (10)                                                                ,  /* 限度日額(通貨型) */
     gnds                                               NUMBER      (13)                                                                ,  /* 限度Ｓ */
     gnds$                                              VARCHAR     (10)                                                                ,  /* 限度Ｓ(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_ChkSyokugyou ADD CONSTRAINT PK_ChkSyokugyou PRIMARY KEY (
     syokugyoucd                                                /* 職業コード */
) ;
