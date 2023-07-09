CREATE TABLE HT_GrossNyknMeisai (
     ryosyuymd                                          VARCHAR     (8)                                                       NOT NULL  ,  /* 領収日 */
     oyadrtencd                                         VARCHAR     (7)                                                       NOT NULL  ,  /* 親代理店コード */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番 */
     meisairenno                                        NUMBER      (3)                                                       NOT NULL  ,  /* 明細連番 */
     nykmosno                                           VARCHAR     (20)                                                                ,  /* 入金用申込番号 */
     rsgaku                                             NUMBER      (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     dengk                                              NUMBER      (13)                                                                ,  /* 伝票金額 */
     dengk$                                             VARCHAR     (10)                                                                ,  /* 伝票金額(通貨型) */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_GrossNyknMeisai ADD CONSTRAINT PK_Nyuukin PRIMARY KEY (
     ryosyuymd                                                , /* 領収日 */
     oyadrtencd                                               , /* 親代理店コード */
     renno                                                    , /* 連番 */
     meisairenno                                                /* 明細連番 */
) ;
