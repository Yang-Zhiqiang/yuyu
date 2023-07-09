CREATE TABLE WT_Page (
     iwfImageId                                         VARCHAR     (20)                                                      NOT NULL  ,  /* IWFイメージＩＤ                                     */
     syoruittykymdtime                                  VARCHAR     (17)                                                      NOT NULL  ,  /* 書類到着日時                                        */
     pageno                                             NUMBER      (5)                                                       NOT NULL  ,  /* ページ番号                                         */
     pageId                                             VARCHAR     (20)                                                      NOT NULL  ,  /* ページＩＤ                                         */
     torikomiSousasyaId                                 VARCHAR     (30)                                                                ,  /* 取込操作者ＩＤ                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE WT_Page ADD CONSTRAINT PK_Page PRIMARY KEY (
     iwfImageId                                               , /* IWFイメージＩＤ                                      */
     syoruittykymdtime                                        , /* 書類到着日時                                         */
     pageno                                                     /* ページ番号                                          */
) ;
