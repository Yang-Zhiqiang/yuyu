CREATE TABLE BM_IkkatuKeisuu_Z (
     ikttekiyouno                                       DECIMAL     (9)                                                       NOT NULL  ,  /* 一括払適用番号 */
     nen1nen2baraihyouji                                DECIMAL     (1)                                                       NOT NULL  ,  /* 年１回年２回払表示 */
     keikatukisuu                                       DECIMAL     (2)                                                       NOT NULL  ,  /* 経過月数（２桁） */
     iktkeisuu                                          DECIMAL     (5,3)                                                               ,  /* 一括払係数 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_IkkatuKeisuu_Z ADD CONSTRAINT PK_IkkatuKeisuu PRIMARY KEY (
     ikttekiyouno                                             , /* 一括払適用番号 */
     nen1nen2baraihyouji                                      , /* 年１回年２回払表示 */
     keikatukisuu                                               /* 経過月数（２桁） */
) ;
