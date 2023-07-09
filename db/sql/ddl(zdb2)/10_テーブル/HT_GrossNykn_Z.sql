CREATE TABLE HT_GrossNykn_Z (
     ryosyuymd                                          VARCHAR     (8)                                                       NOT NULL  ,  /* 領収日 */
     oyadrtencd                                         VARCHAR     (7)                                                       NOT NULL  ,  /* 親代理店コード */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     hrktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 払込通貨種類 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     kawaserate                                         DECIMAL     (7,4)                                                               ,  /* 為替レート */
     grossnykngk                                        DECIMAL     (13)                                                                ,  /* グロス入金額 */
     grossnykngk$                                       VARCHAR     (10)                                                                ,  /* グロス入金額(通貨型) */
     grossdengk                                         DECIMAL     (13)                                                                ,  /* グロス入金伝票金額 */
     grossdengk$                                        VARCHAR     (10)                                                                ,  /* グロス入金伝票金額(通貨型) */
     meisaigoukeidengk                                  DECIMAL     (13)                                                                ,  /* 明細合計伝票金額 */
     meisaigoukeidengk$                                 VARCHAR     (10)                                                                ,  /* 明細合計伝票金額(通貨型) */
     kawasesasonekikngk                                 DECIMAL     (13)                                                                ,  /* 為替差損益金額 */
     kawasesasonekikngk$                                VARCHAR     (10)                                                                ,  /* 為替差損益金額(通貨型) */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_GrossNykn_Z ADD CONSTRAINT PK_Nyuukin PRIMARY KEY (
     ryosyuymd                                                , /* 領収日 */
     oyadrtencd                                               , /* 親代理店コード */
     renno                                                      /* 連番 */
) ;
