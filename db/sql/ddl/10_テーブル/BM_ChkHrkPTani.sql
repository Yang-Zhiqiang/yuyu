CREATE TABLE BM_ChkHrkPTani (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード                                         */
     hrkkaisuu                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 払込回数                                          */
     syusyouhnsdnofrom                                  NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自                                  */
     syusyouhnsdnoto                                    NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至                                  */
     channelcd                                          VARCHAR     (2)                                                       NOT NULL  ,  /* チャネルコード                                       */
     hrktuukasyu                                        VARCHAR     (3)                                                       NOT NULL  ,  /* 払込通貨種類                                        */
     hrkptani                                           NUMBER      (13)                                                                ,  /* 払込Ｐ単位                                         */
     hrkptani$                                          VARCHAR     (10)                                                                ,  /* 払込Ｐ単位(通貨型)                                    */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_ChkHrkPTani ADD CONSTRAINT PK_ChkHrkPTani PRIMARY KEY (
     syouhncd                                                 , /* 商品コード                                          */
     hrkkaisuu                                                , /* 払込回数                                           */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自                                   */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至                                   */
     channelcd                                                , /* チャネルコード                                        */
     hrktuukasyu                                                /* 払込通貨種類                                         */
) ;
