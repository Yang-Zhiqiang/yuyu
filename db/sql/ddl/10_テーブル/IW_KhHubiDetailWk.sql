CREATE TABLE IW_KhHubiDetailWk (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     hubisyoruicd                                       VARCHAR     (5)                                                                 ,  /* 不備書類コード */
     hubisyoruinm                                       VARCHAR     (30)                                                                ,  /* 不備書類名 */
     hubinaiyoucd                                       VARCHAR     (5)                                                                 ,  /* 不備内容コード */
     hubinaiyoumsg                                      VARCHAR     (158)                                                               ,  /* 不備内容メッセージ */
     genponhnkykumu                                     VARCHAR     (1)                                                                 ,  /* 原本返却有無 */
     hassinsakikbn                                      VARCHAR     (1)                                                                 ,  /* 発信先区分 */
     hubitourokuktntid                                  VARCHAR     (15)                                                                ,  /* 不備登録担当者ＩＤ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     trkymd                                             VARCHAR     (8)                                                                 ,  /* 登録日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IW_KhHubiDetailWk ADD CONSTRAINT PK_KhHubiDetailWk PRIMARY KEY (
     kouteikanriid                                            , /* 工程管理ＩＤ */
     renno3keta                                                 /* 連番（３桁） */
) ;
