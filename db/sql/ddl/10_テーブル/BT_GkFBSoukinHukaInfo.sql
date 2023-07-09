CREATE TABLE BT_GkFBSoukinHukaInfo (
     fbsoukindatasikibetukey                            VARCHAR     (20)                                                      NOT NULL  ,  /* ＦＢ送金データ識別キー                                   */
     fbtrhksyoukaino                                    VARCHAR     (16)                                                                ,  /* ＦＢ取引先照会番号                                     */
     dengk                                              NUMBER      (13)                                                                ,  /* 伝票金額                                          */
     dengk$                                             VARCHAR     (10)                                                                ,  /* 伝票金額(通貨型)                                     */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BT_GkFBSoukinHukaInfo ADD CONSTRAINT PK_GkFBSoukinHukaInfo PRIMARY KEY (
     fbsoukindatasikibetukey                                    /* ＦＢ送金データ識別キー                                    */
) ;
