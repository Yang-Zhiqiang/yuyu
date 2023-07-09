CREATE TABLE HT_BosKoumokuCheckError_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     renno3keta                                         DECIMAL     (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     errorkm                                            VARCHAR     (30)                                                                ,  /* エラー項目 */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_BosKoumokuCheckError_Z ADD CONSTRAINT PK_BosKoumokuCheckError PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     renno3keta                                                 /* 連番（３桁） */
) ;
