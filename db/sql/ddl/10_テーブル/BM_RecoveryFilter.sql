CREATE TABLE BM_RecoveryFilter (
     recoveryfilterid                                   VARCHAR     (5)                                                       NOT NULL  ,  /* リカバリフィルタＩＤ                                    */
     recoveryfilternm                                   VARCHAR     (40)                                                                ,  /* リカバリフィルタ名                                     */
     recoveryfilterkeykmid1                             VARCHAR     (30)                                                                ,  /* リカバリフィルタキー項目ＩＤ１                               */
     recoveryfilterkeykmid2                             VARCHAR     (30)                                                                ,  /* リカバリフィルタキー項目ＩＤ２                               */
     recoveryfilterkeykmid3                             VARCHAR     (30)                                                                ,  /* リカバリフィルタキー項目ＩＤ３                               */
     recoveryfilterkeykmid4                             VARCHAR     (30)                                                                ,  /* リカバリフィルタキー項目ＩＤ４                               */
     recoveryfilterkeykmid5                             VARCHAR     (30)                                                                ,  /* リカバリフィルタキー項目ＩＤ５                               */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_RecoveryFilter ADD CONSTRAINT PK_RecoveryFilter PRIMARY KEY (
     recoveryfilterid                                           /* リカバリフィルタＩＤ                                     */
) ;
