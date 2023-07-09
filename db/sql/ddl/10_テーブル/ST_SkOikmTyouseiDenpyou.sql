CREATE TABLE ST_SkOikmTyouseiDenpyou (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     kanjyoukmkcd                                       VARCHAR     (5)                                                       NOT NULL  ,  /* 勘定科目コード                                       */
     taisyakukbn                                        VARCHAR     (1)                                                       NOT NULL  ,  /* 貸借区分                                          */
     naibukeiyakukbn                                    VARCHAR     (1)                                                       NOT NULL  ,  /* 内部契約区分                                        */
     tekiyoukbn                                         VARCHAR     (1)                                                       NOT NULL  ,  /* 摘要区分                                          */
     seg1cd                                             VARCHAR     (20)                                                      NOT NULL  ,  /* セグメント１コード                                     */
     huridenatesakicd                                   VARCHAR     (3)                                                                 ,  /* 振替伝票宛先部課コード                                   */
     tantocd                                            VARCHAR     (1)                                                                 ,  /* 担当コード                                         */
     denkanjokamokucd                                   VARCHAR     (5)                                                                 ,  /* 伝票用勘定科目コード                                    */
     tekiyoucd                                          VARCHAR     (20)                                                                ,  /* 摘要コード                                         */
     suitoubumoncd                                      VARCHAR     (3)                                                                 ,  /* 出納部門コード                                       */
     denyenkagk                                         NUMBER      (13)                                                                ,  /* 伝票金額（円）                                       */
     denyenkagk$                                        VARCHAR     (10)                                                                ,  /* 伝票金額（円）(通貨型)                                  */
     huridenpagekbn                                     VARCHAR     (2)                                                                 ,  /* 振替伝票ページ区分                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE ST_SkOikmTyouseiDenpyou ADD CONSTRAINT PK_SkOikmTyouseiDenpyou PRIMARY KEY (
     mosno                                                    , /* 申込番号                                           */
     kanjyoukmkcd                                             , /* 勘定科目コード                                        */
     taisyakukbn                                              , /* 貸借区分                                           */
     naibukeiyakukbn                                          , /* 内部契約区分                                         */
     tekiyoukbn                                               , /* 摘要区分                                           */
     seg1cd                                                     /* セグメント１コード                                      */
) ;
