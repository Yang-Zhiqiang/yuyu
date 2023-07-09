CREATE TABLE BM_ChkKyuuhuKata (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード                                         */
     syusyouhnsdnofrom                                  NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自                                  */
     syusyouhnsdnoto                                    NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至                                  */
     kyhkatakbn                                         VARCHAR     (2)                                                       NOT NULL  ,  /* 給付型区分                                         */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_ChkKyuuhuKata ADD CONSTRAINT PK_ChkKyuuhuKata PRIMARY KEY (
     syouhncd                                                 , /* 商品コード                                          */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自                                   */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至                                   */
     kyhkatakbn                                                 /* 給付型区分                                          */
) ;
