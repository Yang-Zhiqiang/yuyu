CREATE TABLE BT_GyoumuKouteiInfo (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     subSystemId                                        VARCHAR     (50)                                                                ,  /* サブシステムＩＤ */
     jimutetuzukicd                                     VARCHAR     (19)                                                                ,  /* 事務手続コード */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     skno                                               VARCHAR     (18)                                                                ,  /* 請求番号 */
     nksysyno                                           VARCHAR     (20)                                                                ,  /* 年金証書番号 */
     syukouteikanriid                                   VARCHAR     (20)                                                                ,  /* 主工程管理ＩＤ */
     syukouteijimutetuzukicd                            VARCHAR     (19)                                                                ,  /* 主工程事務手続コード */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_GyoumuKouteiInfo ADD CONSTRAINT PK_GyoumuKouteiInfo PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;

CREATE INDEX IX1_GyoumuKouteiInfo ON BT_GyoumuKouteiInfo (
     syukouteikanriid                                         , /* 主工程管理ＩＤ */
     jimutetuzukicd                                             /* 事務手続コード */
) ;

CREATE INDEX IX2_GyoumuKouteiInfo ON BT_GyoumuKouteiInfo (
     kouteikanriid                                            , /* 工程管理ＩＤ */
     jimutetuzukicd                                             /* 事務手続コード */
) ;

CREATE INDEX IX3_GyoumuKouteiInfo ON BT_GyoumuKouteiInfo (
     syukouteikanriid                                         , /* 主工程管理ＩＤ */
     syukouteijimutetuzukicd                                    /* 主工程事務手続コード */
) ;

CREATE INDEX IX4_GyoumuKouteiInfo ON BT_GyoumuKouteiInfo (
     mosno                                                    , /* 申込番号 */
     syukouteikanriid                                           /* 主工程管理ＩＤ */
) ;

CREATE INDEX IX5_GyoumuKouteiInfo ON BT_GyoumuKouteiInfo (
     syono                                                    , /* 証券番号 */
     skno                                                     , /* 請求番号 */
     jimutetuzukicd                                             /* 事務手続コード */
) ;
