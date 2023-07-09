CREATE TABLE BM_Syokugyou (
     syokugyoucd                                        VARCHAR     (3)                                                       NOT NULL  ,  /* 職業コード */
     syokugyounm                                        VARCHAR     (20)                                                                ,  /* 職業名 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_Syokugyou ADD CONSTRAINT PK_Syokugyou PRIMARY KEY (
     syokugyoucd                                                /* 職業コード */
) ;
