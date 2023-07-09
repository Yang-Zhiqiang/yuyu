CREATE TABLE BM_ChkSaiteiP_Z (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     hrkkaisuu                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 払込回数 */
     hrkkknfrom                                         DECIMAL     (2)                                                       NOT NULL  ,  /* 払込期間自 */
     hrkkknto                                           DECIMAL     (2)                                                       NOT NULL  ,  /* 払込期間至 */
     syusyouhnsdnofrom                                  DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                    DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至 */
     channelcd                                          VARCHAR     (2)                                                       NOT NULL  ,  /* チャネルコード */
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類 */
     syouhinbetukey1                                    VARCHAR     (5)                                                       NOT NULL  ,  /* 商品別キー１ */
     saiteip                                            DECIMAL     (13)                                                                ,  /* 最低Ｐ */
     saiteip$                                           VARCHAR     (10)                                                                ,  /* 最低Ｐ(通貨型) */
     ptani                                              DECIMAL     (13)                                                                ,  /* Ｐ単位 */
     ptani$                                             VARCHAR     (10)                                                                ,  /* Ｐ単位(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ChkSaiteiP_Z ADD CONSTRAINT PK_ChkSaiteiP PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     hrkkaisuu                                                , /* 払込回数 */
     hrkkknfrom                                               , /* 払込期間自 */
     hrkkknto                                                 , /* 払込期間至 */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至 */
     channelcd                                                , /* チャネルコード */
     tuukasyu                                                 , /* 通貨種類 */
     syouhinbetukey1                                            /* 商品別キー１ */
) ;
