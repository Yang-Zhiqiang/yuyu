CREATE TABLE IM_KhHituyouSyorui (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     hanteikbn1                                         NUMBER      (2)                                                       NOT NULL  ,  /* 判定区分１                                         */
     hanteikbn2                                         NUMBER      (2)                                                       NOT NULL  ,  /* 判定区分２                                         */
     hanteikbn3                                         NUMBER      (2)                                                       NOT NULL  ,  /* 判定区分３                                         */
     htysrirenno                                        NUMBER      (2)                                                       NOT NULL  ,  /* 必要書類連番                                        */
     htysyorui                                          VARCHAR     (50)                                                                ,  /* 必要書類メッセージ                                     */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IM_KhHituyouSyorui ADD CONSTRAINT PK_KhHituyouSyorui PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ                                           */
     hanteikbn1                                               , /* 判定区分１                                          */
     hanteikbn2                                               , /* 判定区分２                                          */
     hanteikbn3                                               , /* 判定区分３                                          */
     htysrirenno                                                /* 必要書類連番                                         */
) ;
