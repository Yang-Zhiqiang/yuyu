CREATE TABLE IM_KhHubiNaiyou (
     jimutetuzukicd                                     VARCHAR     (19)                                                      NOT NULL  ,  /* 事務手続コード */
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     hassinsakikbn                                      VARCHAR     (1)                                                       NOT NULL  ,  /* 発信先区分 */
     genponhnkykumu                                     VARCHAR     (1)                                                       NOT NULL  ,  /* 原本返却有無 */
     hubinaiyouhyoujijyun                               NUMBER      (3)                                                       NOT NULL  ,  /* 不備内容表示順 */
     hubinaiyoucd                                       VARCHAR     (5)                                                       NOT NULL  ,  /* 不備内容コード */
     hubinaiyou                                         VARCHAR     (40)                                                                ,  /* 不備内容 */
     hubisyoruimsg                                      VARCHAR     (158)                                                               ,  /* 不備書類用メッセージ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IM_KhHubiNaiyou ADD CONSTRAINT PK_KhHubiNaiyou PRIMARY KEY (
     jimutetuzukicd                                           , /* 事務手続コード */
     syoruiCd                                                 , /* 書類コード */
     hubinaiyoucd                                               /* 不備内容コード */
) ;
