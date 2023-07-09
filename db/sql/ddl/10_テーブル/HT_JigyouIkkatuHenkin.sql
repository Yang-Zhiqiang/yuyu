CREATE TABLE HT_JigyouIkkatuHenkin (
     daimosno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 代表申込番号                                        */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番                                            */
     hnkngk                                             NUMBER      (13)                                                                ,  /* 返金額                                           */
     hnkngk$                                            VARCHAR     (10)                                                                ,  /* 返金額(通貨型)                                      */
     hnknhoukbn                                         VARCHAR     (2)                                                                 ,  /* 返金方法区分                                        */
     hnknymd                                            VARCHAR     (8)                                                                 ,  /* 返金日                                           */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード                                         */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード                                         */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分                                        */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号                                          */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ）                                   */
     srgohnknumu                                        VARCHAR     (1)                                                                 ,  /* 成立後返金有無                                       */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_JigyouIkkatuHenkin ADD CONSTRAINT PK_JigyouIkkatuHenkin PRIMARY KEY (
     daimosno                                                 , /* 代表申込番号                                         */
     renno                                                      /* 連番                                             */
) ;
