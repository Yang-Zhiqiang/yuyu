CREATE TABLE BM_ChkNenreiHani (
     channelcd                                          VARCHAR     (2)                                                       NOT NULL  ,  /* チャネルコード */
     syusyouhncd                                        VARCHAR     (4)                                                       NOT NULL  ,  /* 主契約商品コード */
     syusyouhnsdnofrom                                  NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                    NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至 */
     hhknseifrom                                        NUMBER      (2)                                                                 ,  /* 被保険者性別自 */
     hhknseito                                          NUMBER      (2)                                                                 ,  /* 被保険者性別至 */
     syukatakbn                                         VARCHAR     (2)                                                       NOT NULL  ,  /* 主契約型区分 */
     syuhknkkn                                          NUMBER      (2)                                                       NOT NULL  ,  /* 主契約保険期間 */
     syuhknkknto                                        NUMBER      (2)                                                       NOT NULL  ,  /* 主契約保険期間至 */
     syuhknkknsmnkbn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* 主契約保険期間歳満期区分 */
     syuhrkkkn                                          NUMBER      (2)                                                       NOT NULL  ,  /* 主契約払込期間 */
     syuhrkkknto                                        NUMBER      (2)                                                       NOT NULL  ,  /* 主契約払込期間至 */
     syuhrkkknsmnkbn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* 主契約払込期間歳満期区分 */
     syufromnen                                         NUMBER      (3)                                                       NOT NULL  ,  /* 主契約年齢自 */
     syutonen                                           NUMBER      (3)                                                       NOT NULL  ,  /* 主契約年齢至 */
     syuyoteiriritufrom                                 NUMBER      (5,4)                                                     NOT NULL  ,  /* 主契約予定利率自 */
     syuyoteirirituto                                   NUMBER      (5,4)                                                     NOT NULL  ,  /* 主契約予定利率至 */
     tokusyuchkno                                       NUMBER      (2)                                                       NOT NULL  ,  /* 特殊チェック番号 */
     tksyouhncd                                         VARCHAR     (4)                                                       NOT NULL  ,  /* 特約商品コード */
     tkhknkkn                                           NUMBER      (2)                                                       NOT NULL  ,  /* 特約保険期間 */
     tkhknkknto                                         NUMBER      (2)                                                       NOT NULL  ,  /* 特約保険期間至 */
     tkhknkknsmnkbn                                     VARCHAR     (1)                                                       NOT NULL  ,  /* 特約保険期間歳満期区分 */
     tkhrkkkn                                           NUMBER      (2)                                                       NOT NULL  ,  /* 特約払込期間 */
     tkhrkkknto                                         NUMBER      (2)                                                       NOT NULL  ,  /* 特約払込期間至 */
     tkhrkkknsmnkbn                                     VARCHAR     (1)                                                       NOT NULL  ,  /* 特約払込期間歳満期区分 */
     tkfromnen                                          NUMBER      (3)                                                       NOT NULL  ,  /* 特約年齢自 */
     tktonen                                            NUMBER      (3)                                                       NOT NULL  ,  /* 特約年齢至 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_ChkNenreiHani ADD CONSTRAINT PK_ChkNenreiHani PRIMARY KEY (
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
