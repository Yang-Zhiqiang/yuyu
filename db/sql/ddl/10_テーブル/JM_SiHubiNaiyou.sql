CREATE TABLE JM_SiHubiNaiyou (
     jimutetuzukicd                                     VARCHAR     (19)                                                      NOT NULL  ,  /* 事務手続コード */
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     hubinaiyoucd                                       VARCHAR     (5)                                                       NOT NULL  ,  /* 不備内容コード */
     hubinaiyou                                         VARCHAR     (40)                                                                ,  /* 不備内容 */
     hubisyoruimsg                                      VARCHAR     (158)                                                               ,  /* 不備書類用メッセージ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE JM_SiHubiNaiyou ADD CONSTRAINT PK_SiHubiNaiyou PRIMARY KEY (
     jimutetuzukicd                                           , /* 事務手続コード */
     syoruiCd                                                 , /* 書類コード */
     hubinaiyoucd                                               /* 不備内容コード */
) ;
