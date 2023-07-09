CREATE TABLE BM_Sisuu_Z (
     sisuukbn                                           VARCHAR     (2)                                                       NOT NULL  ,  /* 指数区分 */
     sisuukouhyouymd                                    VARCHAR     (8)                                                       NOT NULL  ,  /* 指数公表日 */
     sisuu                                              DECIMAL     (10,5)                                                              ,  /* 指数 */
     sisuucalckijyunymd                                 VARCHAR     (8)                                                                 ,  /* 指数計算基準日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_Sisuu_Z ADD CONSTRAINT PK_Sisuu PRIMARY KEY (
     sisuukbn                                                 , /* 指数区分 */
     sisuukouhyouymd                                            /* 指数公表日 */
) ;
