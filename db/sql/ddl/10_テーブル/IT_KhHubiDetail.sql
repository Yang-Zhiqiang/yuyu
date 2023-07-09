CREATE TABLE IT_KhHubiDetail (
     hubisikibetukey                                    VARCHAR     (20)                                                      NOT NULL  ,  /* 不備識別キー */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     hubisyoruicd                                       VARCHAR     (5)                                                                 ,  /* 不備書類コード */
     hubisyoruinm                                       VARCHAR     (30)                                                                ,  /* 不備書類名 */
     hubinaiyoucd                                       VARCHAR     (5)                                                                 ,  /* 不備内容コード */
     hubinaiyoumsg                                      VARCHAR     (158)                                                               ,  /* 不備内容メッセージ */
     genponhnkykumu                                     VARCHAR     (1)                                                                 ,  /* 原本返却有無 */
     trkymd                                             VARCHAR     (8)                                                                 ,  /* 登録日 */
     hasinymd                                           VARCHAR     (8)                                                                 ,  /* 発信日 */
     kaisyouymd                                         VARCHAR     (8)                                                                 ,  /* 解消日 */
     hassinsakikbn                                      VARCHAR     (1)                                                                 ,  /* 発信先区分 */
     hasinkyokakbn                                      VARCHAR     (1)                                                                 ,  /* 発信許可区分 */
     hubitourokuktntid                                  VARCHAR     (15)                                                                ,  /* 不備登録担当者ＩＤ */
     hubisyouninktntid                                  VARCHAR     (15)                                                                ,  /* 不備承認担当者ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KhHubiDetail ADD CONSTRAINT PK_KhHubiDetail PRIMARY KEY (
     hubisikibetukey                                          , /* 不備識別キー */
     renno3keta                                                 /* 連番（３桁） */
) ;
