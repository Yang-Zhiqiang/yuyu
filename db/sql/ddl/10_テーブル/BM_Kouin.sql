CREATE TABLE BM_Kouin (
     kinyuucd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 金融機関コード */
     kouincd                                            VARCHAR     (20)                                                      NOT NULL  ,  /* 行員コード */
     bosyuucd                                           VARCHAR     (6)                                                                 ,  /* 募集人コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_Kouin ADD CONSTRAINT PK_Kouin PRIMARY KEY (
     kinyuucd                                                 , /* 金融機関コード */
     kouincd                                                    /* 行員コード */
) ;

CREATE INDEX IX1_Kouin ON BM_Kouin (
     bosyuucd                                                   /* 募集人コード */
) ;
