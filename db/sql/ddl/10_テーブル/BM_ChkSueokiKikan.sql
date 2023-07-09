CREATE TABLE BM_ChkSueokiKikan (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syusyouhnsdnofrom                                  NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                    NUMBER      (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至 */
     channelcd                                          VARCHAR     (2)                                                       NOT NULL  ,  /* チャネルコード */
     sueokikkn                                          NUMBER      (2)                                                       NOT NULL  ,  /* 据置期間 */
     sueokikknsmnkbn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* 据置期間歳満期区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_ChkSueokiKikan ADD CONSTRAINT PK_ChkSueokiKikan PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至 */
     channelcd                                                , /* チャネルコード */
     sueokikkn                                                , /* 据置期間 */
     sueokikknsmnkbn                                            /* 据置期間歳満期区分 */
) ;
