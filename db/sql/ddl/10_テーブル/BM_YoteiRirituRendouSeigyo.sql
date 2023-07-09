CREATE TABLE BM_YoteiRirituRendouSeigyo (
     yoteirirituhanteidfrom                             VARCHAR     (2)                                                       NOT NULL  ,  /* 予定利率作成判定日（自） */
     yoteirirituhanteidto                               VARCHAR     (2)                                                       NOT NULL  ,  /* 予定利率作成判定日（至） */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_YoteiRirituRendouSeigyo ADD CONSTRAINT PK_YoteiRirituRendouSeigyo PRIMARY KEY (
     yoteirirituhanteidfrom                                   , /* 予定利率作成判定日（自） */
     yoteirirituhanteidto                                     , /* 予定利率作成判定日（至） */
     syouhncd                                                   /* 商品コード */
) ;
