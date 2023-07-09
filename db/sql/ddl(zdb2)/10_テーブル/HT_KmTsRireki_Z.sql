CREATE TABLE HT_KmTsRireki_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     syoriTime                                          VARCHAR     (17)                                                      NOT NULL  ,  /* 処理時間 */
     renno3keta                                         DECIMAL     (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     kinouId                                            VARCHAR     (50)                                                                ,  /* 機能ＩＤ */
     kinouModeId                                        VARCHAR     (50)                                                                ,  /* 機能モードＩＤ */
     tskmnm                                             VARCHAR     (62)                                                                ,  /* 訂正項目名 */
     tsmaenaiyou                                        VARCHAR     (202)                                                               ,  /* 訂正前内容 */
     tsgonaiyou                                         VARCHAR     (202)                                                               ,  /* 訂正後内容 */
     tantid                                             VARCHAR     (15)                                                                ,  /* 担当者ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_KmTsRireki_Z ADD CONSTRAINT PK_KmTsRireki PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     syoriTime                                                , /* 処理時間 */
     renno3keta                                                 /* 連番（３桁） */
) ;

CREATE INDEX IX1_KmTsRireki ON HT_KmTsRireki_Z (
     syoriTime                                                  /* 処理時間 */
) ;
