CREATE TABLE WT_PDFHozon (
     iwfImageId                                         VARCHAR     (20)                                                      NOT NULL  ,  /* IWFイメージＩＤ                                     */
     pageId                                             VARCHAR     (20)                                                      NOT NULL  ,  /* ページＩＤ                                         */
     pdfData                                            BLOB                                                                            ,  /* ＰＤＦデータ                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE WT_PDFHozon ADD CONSTRAINT PK_PDFHozon PRIMARY KEY (
     iwfImageId                                               , /* IWFイメージＩＤ                                      */
     pageId                                                     /* ページＩＤ                                          */
) ;
