CREATE TABLE BT_FBSoukinHukaInfo_Z (
     fbsoukindatasikibetukey                            VARCHAR     (20)                                                      NOT NULL  ,  /* ＦＢ送金データ識別キー */
     kokcd1                                             VARCHAR     (10)                                                                ,  /* 顧客コード１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_FBSoukinHukaInfo_Z ADD CONSTRAINT PK_FBSoukinHukaInfo PRIMARY KEY (
     fbsoukindatasikibetukey                                    /* ＦＢ送金データ識別キー */
) ;
