CREATE TABLE BM_ChkSaiteiS_Z (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syusyouhnsdnofrom                                  DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                    DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至 */
     dntsdnumufrom                                      DECIMAL     (1)                                                       NOT NULL  ,  /* 団体集団有無自 */
     dntsdnumuto                                        DECIMAL     (1)                                                       NOT NULL  ,  /* 団体集団有無至 */
     hrkkknsmnkbnfrom                                   DECIMAL     (1)                                                       NOT NULL  ,  /* 払込期間歳満期区分自 */
     hrkkknsmnkbnto                                     DECIMAL     (1)                                                       NOT NULL  ,  /* 払込期間歳満期区分至 */
     hknkknfrom                                         DECIMAL     (2)                                                       NOT NULL  ,  /* 保険期間自 */
     hknkknto                                           DECIMAL     (2)                                                       NOT NULL  ,  /* 保険期間至 */
     saiteisknwtkumufrom                                DECIMAL     (1)                                                       NOT NULL  ,  /* 最低Ｓ緩和特約有無自 */
     saiteisknwtkumuto                                  DECIMAL     (1)                                                       NOT NULL  ,  /* 最低Ｓ緩和特約有無至 */
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類 */
     saiteis                                            DECIMAL     (13)                                                                ,  /* 最低Ｓ */
     saiteis$                                           VARCHAR     (10)                                                                ,  /* 最低Ｓ(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ChkSaiteiS_Z ADD CONSTRAINT PK_ChkSaiteiS PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至 */
     dntsdnumufrom                                            , /* 団体集団有無自 */
     dntsdnumuto                                              , /* 団体集団有無至 */
     hrkkknsmnkbnfrom                                         , /* 払込期間歳満期区分自 */
     hrkkknsmnkbnto                                           , /* 払込期間歳満期区分至 */
     hknkknfrom                                               , /* 保険期間自 */
     hknkknto                                                 , /* 保険期間至 */
     saiteisknwtkumufrom                                      , /* 最低Ｓ緩和特約有無自 */
     saiteisknwtkumuto                                        , /* 最低Ｓ緩和特約有無至 */
     tuukasyu                                                   /* 通貨種類 */
) ;
