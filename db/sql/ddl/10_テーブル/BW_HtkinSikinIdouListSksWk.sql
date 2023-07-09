CREATE TABLE BW_HtkinSikinIdouListSksWk (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kijyunymd                                          VARCHAR     (8)                                                       NOT NULL  ,  /* 基準年月日 */
     haitounendo                                        VARCHAR     (4)                                                                 ,  /* 配当年度 */
     siteituuka                                         VARCHAR     (3)                                                                 ,  /* 指定通貨 */
     siteituukagk                                       NUMBER      (13)                                                                ,  /* 指定通貨金額 */
     siteituukagk$                                      VARCHAR     (10)                                                                ,  /* 指定通貨金額(通貨型) */
     trhktuuka                                          VARCHAR     (3)                                                                 ,  /* 取引通貨 */
     trhktuukagk                                        NUMBER      (13)                                                                ,  /* 取引通貨金額 */
     trhktuukagk$                                       VARCHAR     (10)                                                                ,  /* 取引通貨金額(通貨型) */
     seg1cd                                             VARCHAR     (20)                                                                ,  /* セグメント１コード */
     sikinidougroupkbn                                  VARCHAR     (2)                                                                 ,  /* 資金移動グループ区分 */
     sikinidoukawaserate                                NUMBER      (7,4)                                                               ,  /* 資金移動用為替レート */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BW_HtkinSikinIdouListSksWk ADD CONSTRAINT PK_HtkinSikinIdouListSksWk PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     kijyunymd                                                  /* 基準年月日 */
) ;
