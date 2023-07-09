CREATE TABLE AS_SubSystem (
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ                                      */
     subSystemNm                                        VARCHAR     (50)                                                                ,  /* サブシステム名                                       */
     sortNo                                             NUMBER      (3)                                                                 ,  /* ソート番号                                         */
     linkImage                                          VARCHAR     (100)                                                               ,  /* リンクイメージ                                       */
     hyoudaiImage                                       VARCHAR     (100)                                                               ,  /* 表題イメージ                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AS_SubSystem ADD CONSTRAINT AS_SubSystemPk PRIMARY KEY (
     subSystemId                                                /* サブシステムＩＤ                                       */
) ;
