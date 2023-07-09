CREATE TABLE BM_SeisanDShrymd (
     syorinendo                                         VARCHAR     (4)                                                       NOT NULL  ,  /* 処理年度 */
     seisandshrymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* 精算Ｄ支払年月日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_SeisanDShrymd ADD CONSTRAINT PK_BM_SeisanDShrymd PRIMARY KEY (
     syorinendo                                                 /* 処理年度 */
) ;
