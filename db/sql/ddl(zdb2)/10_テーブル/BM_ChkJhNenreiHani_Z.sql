CREATE TABLE BM_ChkJhNenreiHani_Z (
     channelcd                                          VARCHAR     (2)                                                       NOT NULL  ,  /* チャネルコード */
     syusyouhncd                                        VARCHAR     (4)                                                       NOT NULL  ,  /* 主契約商品コード */
     syusyouhnsdnofrom                                  DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                    DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至 */
     hhknseifrom                                        DECIMAL     (2)                                                                 ,  /* 被保険者性別自 */
     hhknseito                                          DECIMAL     (2)                                                                 ,  /* 被保険者性別至 */
     syukatakbn                                         VARCHAR     (2)                                                       NOT NULL  ,  /* 主契約型区分 */
     syuhknkkn                                          DECIMAL     (2)                                                       NOT NULL  ,  /* 主契約保険期間 */
     syuhknkknto                                        DECIMAL     (2)                                                       NOT NULL  ,  /* 主契約保険期間至 */
     syuhknkknsmnkbn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* 主契約保険期間歳満期区分 */
     syuhrkkkn                                          DECIMAL     (2)                                                       NOT NULL  ,  /* 主契約払込期間 */
     syuhrkkknto                                        DECIMAL     (2)                                                       NOT NULL  ,  /* 主契約払込期間至 */
     syuhrkkknsmnkbn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* 主契約払込期間歳満期区分 */
     syufromnen                                         DECIMAL     (3)                                                       NOT NULL  ,  /* 主契約年齢自 */
     syutonen                                           DECIMAL     (3)                                                       NOT NULL  ,  /* 主契約年齢至 */
     syuyoteiriritufrom                                 DECIMAL     (5,4)                                                     NOT NULL  ,  /* 主契約予定利率自 */
     syuyoteirirituto                                   DECIMAL     (5,4)                                                     NOT NULL  ,  /* 主契約予定利率至 */
     tokusyuchkno                                       DECIMAL     (2)                                                       NOT NULL  ,  /* 特殊チェック番号 */
     tksyouhncd                                         VARCHAR     (4)                                                       NOT NULL  ,  /* 特約商品コード */
     tkhknkkn                                           DECIMAL     (2)                                                       NOT NULL  ,  /* 特約保険期間 */
     tkhknkknto                                         DECIMAL     (2)                                                       NOT NULL  ,  /* 特約保険期間至 */
     tkhknkknsmnkbn                                     VARCHAR     (1)                                                       NOT NULL  ,  /* 特約保険期間歳満期区分 */
     tkhrkkkn                                           DECIMAL     (2)                                                       NOT NULL  ,  /* 特約払込期間 */
     tkhrkkknto                                         DECIMAL     (2)                                                       NOT NULL  ,  /* 特約払込期間至 */
     tkhrkkknsmnkbn                                     VARCHAR     (1)                                                       NOT NULL  ,  /* 特約払込期間歳満期区分 */
     tkfromnen                                          DECIMAL     (3)                                                       NOT NULL  ,  /* 特約年齢自 */
     tktonen                                            DECIMAL     (3)                                                       NOT NULL  ,  /* 特約年齢至 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ChkJhNenreiHani_Z ADD CONSTRAINT PK_ChkJhNenreiHani PRIMARY KEY (
     channelcd                                                , /* チャネルコード */
     syusyouhncd                                              , /* 主契約商品コード */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至 */
     syukatakbn                                               , /* 主契約型区分 */
     syuhknkkn                                                , /* 主契約保険期間 */
     syuhknkknto                                              , /* 主契約保険期間至 */
     syuhknkknsmnkbn                                          , /* 主契約保険期間歳満期区分 */
     syuhrkkkn                                                , /* 主契約払込期間 */
     syuhrkkknto                                              , /* 主契約払込期間至 */
     syuhrkkknsmnkbn                                          , /* 主契約払込期間歳満期区分 */
     syufromnen                                               , /* 主契約年齢自 */
     syutonen                                                 , /* 主契約年齢至 */
     syuyoteiriritufrom                                       , /* 主契約予定利率自 */
     syuyoteirirituto                                         , /* 主契約予定利率至 */
     tokusyuchkno                                             , /* 特殊チェック番号 */
     tksyouhncd                                               , /* 特約商品コード */
     tkhknkkn                                                 , /* 特約保険期間 */
     tkhknkknto                                               , /* 特約保険期間至 */
     tkhknkknsmnkbn                                           , /* 特約保険期間歳満期区分 */
     tkhrkkkn                                                 , /* 特約払込期間 */
     tkhrkkknto                                               , /* 特約払込期間至 */
     tkhrkkknsmnkbn                                           , /* 特約払込期間歳満期区分 */
     tkfromnen                                                , /* 特約年齢自 */
     tktonen                                                    /* 特約年齢至 */
) ;
