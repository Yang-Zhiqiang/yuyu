CREATE TABLE BM_ChkSaiteiS (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード                                         */
     syusyouhnsdnofrom                                  NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自                                  */
     syusyouhnsdnoto                                    NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至                                  */
     dntsdnumufrom                                      NUMBER      (1)                                                       NOT NULL  ,  /* 団体集団有無自                                       */
     dntsdnumuto                                        NUMBER      (1)                                                       NOT NULL  ,  /* 団体集団有無至                                       */
     hrkkknsmnkbnfrom                                   NUMBER      (1)                                                       NOT NULL  ,  /* 払込期間歳満期区分自                                    */
     hrkkknsmnkbnto                                     NUMBER      (1)                                                       NOT NULL  ,  /* 払込期間歳満期区分至                                    */
     hknkknfrom                                         NUMBER      (2)                                                       NOT NULL  ,  /* 保険期間自                                         */
     hknkknto                                           NUMBER      (2)                                                       NOT NULL  ,  /* 保険期間至                                         */
     saiteisknwtkumufrom                                NUMBER      (1)                                                       NOT NULL  ,  /* 最低Ｓ緩和特約有無自                                    */
     saiteisknwtkumuto                                  NUMBER      (1)                                                       NOT NULL  ,  /* 最低Ｓ緩和特約有無至                                    */
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類                                          */
     saiteis                                            NUMBER      (13)                                                                ,  /* 最低Ｓ                                           */
     saiteis$                                           VARCHAR     (10)                                                                ,  /* 最低Ｓ(通貨型)                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_ChkSaiteiS ADD CONSTRAINT PK_ChkSaiteiS PRIMARY KEY (
     syouhncd                                                 , /* 商品コード                                          */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自                                   */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至                                   */
     dntsdnumufrom                                            , /* 団体集団有無自                                        */
     dntsdnumuto                                              , /* 団体集団有無至                                        */
     hrkkknsmnkbnfrom                                         , /* 払込期間歳満期区分自                                     */
     hrkkknsmnkbnto                                           , /* 払込期間歳満期区分至                                     */
     hknkknfrom                                               , /* 保険期間自                                          */
     hknkknto                                                 , /* 保険期間至                                          */
     saiteisknwtkumufrom                                      , /* 最低Ｓ緩和特約有無自                                     */
     saiteisknwtkumuto                                        , /* 最低Ｓ緩和特約有無至                                     */
     tuukasyu                                                   /* 通貨種類                                           */
) ;
