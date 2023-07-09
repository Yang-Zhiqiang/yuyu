CREATE TABLE HT_TokujyouRireki (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     dakuhiktrenno                                      NUMBER      (2)                                                       NOT NULL  ,  /* 諾否決定連番                                        */
     tkjyhyouten                                        VARCHAR     (3)                                                                 ,  /* 特条標点                                          */
     tkjyskgnkkn                                        VARCHAR     (2)                                                                 ,  /* 特条削減期間                                        */
     htnpbuicd1                                         VARCHAR     (3)                                                                 ,  /* 不担保部位コード１                                     */
     htnpkkn1                                           VARCHAR     (2)                                                                 ,  /* 不担保期間１                                        */
     htnpbuicd2                                         VARCHAR     (3)                                                                 ,  /* 不担保部位コード２                                     */
     htnpkkn2                                           VARCHAR     (2)                                                                 ,  /* 不担保期間２                                        */
     htnpbuicd3                                         VARCHAR     (3)                                                                 ,  /* 不担保部位コード３                                     */
     htnpkkn3                                           VARCHAR     (2)                                                                 ,  /* 不担保期間３                                        */
     htnpbuicd4                                         VARCHAR     (3)                                                                 ,  /* 不担保部位コード４                                     */
     htnpkkn4                                           VARCHAR     (2)                                                                 ,  /* 不担保期間４                                        */
     tokkoudosghtnpkbn                                  VARCHAR     (1)                                                                 ,  /* 特定高度障害不担保区分                                   */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_TokujyouRireki ADD CONSTRAINT PK_TokujyouRireki PRIMARY KEY (
     mosno                                                    , /* 申込番号                                           */
     dakuhiktrenno                                              /* 諾否決定連番                                         */
) ;
