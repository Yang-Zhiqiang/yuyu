CREATE TABLE BM_ChkKeiyakuTaniSaikouS_Z (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syusyouhnsdnofrom                                  DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                    DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至 */
     saikous1                                           DECIMAL     (13)                                                                ,  /* 最高Ｓ１ */
     saikous1$                                          VARCHAR     (10)                                                                ,  /* 最高Ｓ１(通貨型) */
     saikous2                                           DECIMAL     (13)                                                                ,  /* 最高Ｓ２ */
     saikous2$                                          VARCHAR     (10)                                                                ,  /* 最高Ｓ２(通貨型) */
     saikous3                                           DECIMAL     (13)                                                                ,  /* 最高Ｓ３ */
     saikous3$                                          VARCHAR     (10)                                                                ,  /* 最高Ｓ３(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ChkKeiyakuTaniSaikouS_Z ADD CONSTRAINT PK_ChkKeiyakuTaniSaikouS PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                            /* （主契約）商品世代番号至 */
) ;
