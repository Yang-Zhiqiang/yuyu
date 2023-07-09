CREATE TABLE BM_ChkTkykHukaSeigen_Z (
     syusyouhncd                                        VARCHAR     (4)                                                       NOT NULL  ,  /* 主契約商品コード */
     syusyouhnsdnofrom                                  DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                    DECIMAL     (2)                                                       NOT NULL  ,  /* （主契約）商品世代番号至 */
     sntkhoukbnfrom                                     DECIMAL     (2)                                                       NOT NULL  ,  /* 選択方法区分自 */
     sntkhoukbnto                                       DECIMAL     (2)                                                       NOT NULL  ,  /* 選択方法区分至 */
     hhknfromnen                                        DECIMAL     (3)                                                       NOT NULL  ,  /* 被保険者年齢自 */
     hhkntonen                                          DECIMAL     (3)                                                       NOT NULL  ,  /* 被保険者年齢至 */
     tksyouhncd                                         VARCHAR     (4)                                                       NOT NULL  ,  /* 特約商品コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_ChkTkykHukaSeigen_Z ADD CONSTRAINT PK_ChkTkykHukaSeigen PRIMARY KEY (
     syusyouhncd                                              , /* 主契約商品コード */
     syusyouhnsdnofrom                                        , /* （主契約）商品世代番号自 */
     syusyouhnsdnoto                                          , /* （主契約）商品世代番号至 */
     sntkhoukbnfrom                                           , /* 選択方法区分自 */
     sntkhoukbnto                                             , /* 選択方法区分至 */
     hhknfromnen                                              , /* 被保険者年齢自 */
     hhkntonen                                                , /* 被保険者年齢至 */
     tksyouhncd                                                 /* 特約商品コード */
) ;
