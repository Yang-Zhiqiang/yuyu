CREATE TABLE BT_WariateHukaInfo_Z (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ */
     jimutetuzukicd                                     VARCHAR     (19)                                                      NOT NULL  ,  /* 事務手続コード */
     wrthukatskid                                       VARCHAR     (50)                                                      NOT NULL  ,  /* 割当不可タスクID */
     userId                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ユーザーＩＤ */
     wrthukakaijyotskid                                 VARCHAR     (50)                                                                ,  /* 割当不可解除用タスクID */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_WariateHukaInfo_Z ADD CONSTRAINT PK_WariateHukaInfo PRIMARY KEY (
     kouteikanriid                                            , /* 工程管理ＩＤ */
     subSystemId                                              , /* サブシステムＩＤ */
     jimutetuzukicd                                           , /* 事務手続コード */
     wrthukatskid                                             , /* 割当不可タスクID */
     userId                                                     /* ユーザーＩＤ */
) ;

CREATE INDEX IX1_WariateHukaInfo ON BT_WariateHukaInfo_Z (
     kouteikanriid                                            , /* 工程管理ＩＤ */
     subSystemId                                              , /* サブシステムＩＤ */
     jimutetuzukicd                                           , /* 事務手続コード */
     wrthukatskid                                               /* 割当不可タスクID */
) ;
