CREATE TABLE BM_Segment (
     segcd                                              VARCHAR     (20)                                                      NOT NULL  ,  /* セグメントコード                                      */
     segnm                                              VARCHAR     (20)                                                                ,  /* セグメント名                                        */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_Segment ADD CONSTRAINT PK_Segment PRIMARY KEY (
     segcd                                                      /* セグメントコード                                       */
) ;
