CREATE TABLE BM_TuukabetuKyuusibi (
     tuukatoriatukaiymd                                 VARCHAR     (8)                                                       NOT NULL  ,  /* 通貨取扱年月日                                       */
     kyuusijpykbn                                       VARCHAR     (1)                                                                 ,  /* 円休止区分                                         */
     kyuusiusdkbn                                       VARCHAR     (1)                                                                 ,  /* 米ドル休止区分                                       */
     kyuusieurkbn                                       VARCHAR     (1)                                                                 ,  /* ユーロ休止区分                                       */
     kyuusiaudkbn                                       VARCHAR     (1)                                                                 ,  /* 豪ドル休止区分                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_TuukabetuKyuusibi ADD CONSTRAINT PK_TuukabetuKyuusibi PRIMARY KEY (
     tuukatoriatukaiymd                                         /* 通貨取扱年月日                                        */
) ;
