CREATE TABLE HT_SkHubi (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     hubisikibetukey                                    VARCHAR     (20)                                                      NOT NULL  ,  /* 不備識別キー                                        */
     jimutetuzukinm                                     VARCHAR     (20)                                                                ,  /* 事務手続名                                         */
     rnrkskhaneikbn                                     VARCHAR     (1)                                                                 ,  /* 連絡先反映区分                                       */
     utdskknnm1kj                                       VARCHAR     (15)                                                                ,  /* 打出機関名１（漢字）                                    */
     utdskknnm2kj                                       VARCHAR     (15)                                                                ,  /* 打出機関名２（漢字）                                    */
     tuutisakitantounmkj                                VARCHAR     (15)                                                                ,  /* 通知先担当者名（漢字）                                   */
     tuutikyokasyanmkj                                  VARCHAR     (15)                                                                ,  /* 通知許可者名（漢字）                                    */
     commentarea                                        VARCHAR     (3712)                                                              ,  /* コメント欄                                         */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_SkHubi ADD CONSTRAINT PK_SkHubi PRIMARY KEY (
     mosno                                                    , /* 申込番号                                           */
     hubisikibetukey                                            /* 不備識別キー                                         */
) ;
