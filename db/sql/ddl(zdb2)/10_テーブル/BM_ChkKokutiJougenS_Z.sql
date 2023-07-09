CREATE TABLE BM_ChkKokutiJougenS_Z (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syusyouhnsdnofrom                                  DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                    DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至 */
     hhknfromnen                                        DECIMAL     (3)                                                       NOT NULL  ,  /* 被保険者年齢自 */
     hhkntonen                                          DECIMAL     (3)                                                       NOT NULL  ,  /* 被保険者年齢至 */
     moskbnfrom                                         DECIMAL     (1)                                                       NOT NULL  ,  /* 申込区分自 */
     moskbnto                                           DECIMAL     (1)                                                       NOT NULL  ,  /* 申込区分至 */
     saikous                                            DECIMAL     (13)                                                                ,  /* 最高Ｓ */
     saikous$                                           VARCHAR     (10)                                                                ,  /* 最高Ｓ(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ChkKokutiJougenS_Z ADD CONSTRAINT PK_ChkKokutiJougenS PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至 */
     hhknfromnen                                              , /* 被保険者年齢自 */
     hhkntonen                                                , /* 被保険者年齢至 */
     moskbnfrom                                               , /* 申込区分自 */
     moskbnto                                                   /* 申込区分至 */
) ;
