CREATE TABLE BM_KijyungkHanteiKawaseRate (
     kijunnendo                                         VARCHAR     (4)                                                       NOT NULL  ,  /* 基準年度                                          */
     kyktuukasyu                                        VARCHAR     (3)                                                       NOT NULL  ,  /* 契約通貨種類                                        */
     kjngkhntiyukawaserate                              NUMBER      (7,4)                                                               ,  /* 基準額判定用為替レート                                   */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_KijyungkHanteiKawaseRate ADD CONSTRAINT PK_KijyungkHanteiKawaseRate PRIMARY KEY (
     kijunnendo                                               , /* 基準年度                                           */
     kyktuukasyu                                                /* 契約通貨種類                                         */
) ;
