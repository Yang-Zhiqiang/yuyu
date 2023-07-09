CREATE TABLE JW_HubiDetailWk_Z (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     renno3keta                                         DECIMAL     (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     hubisyoruicd                                       VARCHAR     (5)                                                                 ,  /* 不備書類コード */
     hubisyoruinm                                       VARCHAR     (62)                                                                ,  /* 不備書類名 */
     hubinaiyoucd                                       VARCHAR     (5)                                                                 ,  /* 不備内容コード */
     hubinaiyoumsg                                      VARCHAR     (318)                                                               ,  /* 不備内容メッセージ */
     trkymd                                             VARCHAR     (8)                                                                 ,  /* 登録日 */
     genponhnkykumu                                     VARCHAR     (1)                                                                 ,  /* 原本返却有無 */
     hassinsakikbn                                      VARCHAR     (1)                                                                 ,  /* 発信先区分 */
     hubitourokuktntid                                  VARCHAR     (15)                                                                ,  /* 不備登録担当者ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JW_HubiDetailWk_Z ADD CONSTRAINT PK_HubiDetailWk PRIMARY KEY (
     kouteikanriid                                            , /* 工程管理ＩＤ */
     renno3keta                                                 /* 連番（３桁） */
) ;
