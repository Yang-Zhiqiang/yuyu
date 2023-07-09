CREATE TABLE AT_SosikiRole (
     tanmatusettisosikicd                               VARCHAR     (7)                                                       NOT NULL  ,  /* 端末設置組織コード                                     */
     roleCd                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ロールコード                                        */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AT_SosikiRole ADD CONSTRAINT AT_SosikiRolePk PRIMARY KEY (
     tanmatusettisosikicd                                     , /* 端末設置組織コード                                      */
     roleCd                                                     /* ロールコード                                         */
) ;
