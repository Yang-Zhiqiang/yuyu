CREATE TABLE IT_HengakuCfDenpyo (
     denrenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 伝票データ連番                                       */
     edano                                              NUMBER      (2)                                                       NOT NULL  ,  /* 枝番号                                           */
     unitfundkbn                                        VARCHAR     (3)                                                                 ,  /* ユニットファンド区分                                    */
     tantocd                                            VARCHAR     (1)                                                                 ,  /* 担当コード                                         */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日                                         */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付                                          */
     taisyakukbn                                        VARCHAR     (1)                                                                 ,  /* 貸借区分                                          */
     kanjyoukmkcd                                       VARCHAR     (5)                                                                 ,  /* 勘定科目コード                                       */
     tuukasyu                                           VARCHAR     (3)                                                                 ,  /* 通貨種類                                          */
     dengaikagk                                         NUMBER      (13)                                                                ,  /* 伝票金額（外貨）                                      */
     dengaikagk$                                        VARCHAR     (10)                                                                ,  /* 伝票金額（外貨）(通貨型)                                 */
     denyenkagk                                         NUMBER      (13)                                                                ,  /* 伝票金額（円）                                       */
     denyenkagk$                                        VARCHAR     (10)                                                                ,  /* 伝票金額（円）(通貨型)                                  */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IT_HengakuCfDenpyo ADD CONSTRAINT PK_HengakuCfDenpyo PRIMARY KEY (
     denrenno                                                 , /* 伝票データ連番                                        */
     edano                                                      /* 枝番号                                            */
) ;
