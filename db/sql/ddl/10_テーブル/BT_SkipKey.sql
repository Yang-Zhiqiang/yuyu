CREATE TABLE BT_SkipKey (
     recoverysikibetukey                                VARCHAR     (332)                                                     NOT NULL  ,  /* リカバリ識別キー                                      */
     kakutyoujobcd                                      VARCHAR     (20)                                                                ,  /* 拡張ジョブコード                                      */
     tableid                                            VARCHAR     (100)                                                               ,  /* テーブルＩＤ                                        */
     recoveryfilterid                                   VARCHAR     (5)                                                                 ,  /* リカバリフィルタＩＤ                                    */
     recoveryfilterkey1                                 VARCHAR     (40)                                                                ,  /* リカバリフィルタキー１                                   */
     recoveryfilterkey2                                 VARCHAR     (40)                                                                ,  /* リカバリフィルタキー２                                   */
     recoveryfilterkey3                                 VARCHAR     (40)                                                                ,  /* リカバリフィルタキー３                                   */
     recoveryfilterkey4                                 VARCHAR     (40)                                                                ,  /* リカバリフィルタキー４                                   */
     recoveryfilterkey5                                 VARCHAR     (40)                                                                ,  /* リカバリフィルタキー５                                   */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BT_SkipKey ADD CONSTRAINT PK_SkipKey PRIMARY KEY (
     recoverysikibetukey                                        /* リカバリ識別キー                                       */
) ;
