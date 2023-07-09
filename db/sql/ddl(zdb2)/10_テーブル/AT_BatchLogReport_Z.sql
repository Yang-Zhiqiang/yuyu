CREATE TABLE AT_BatchLogReport_Z (
     batchJobId                                         VARCHAR     (20)                                                      NOT NULL  ,  /* バッチジョブＩＤ */
     reportKey                                          VARCHAR     (20)                                                      NOT NULL  ,  /* 帳票キー */
     tyouhyouJoinKey                                    VARCHAR     (20)                                                                ,  /* 帳票結合キー */
     batchSyoriYmd                                      VARCHAR     (8)                                                                 ,  /* バッチ処理年月日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_BatchLogReport_Z ADD CONSTRAINT AT_BatchReportLogPK PRIMARY KEY (
     batchJobId                                               , /* バッチジョブＩＤ */
     reportKey                                                  /* 帳票キー */
) ;
