CREATE TABLE IT_AsBikinkanri (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kessankijyunymd                                    VARCHAR     (8)                                                       NOT NULL  ,  /* 決算基準日 */
     bkncdkbn                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 備金コード区分 */
     bknkktymd                                          VARCHAR     (8)                                                       NOT NULL  ,  /* 備金確定日 */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番 */
     calckijyunymd                                      VARCHAR     (8)                                                                 ,  /* 計算基準日 */
     sisyacd                                            VARCHAR     (3)                                                                 ,  /* 支社コード */
     kbnkeirisegcd                                      VARCHAR     (20)                                                                ,  /* 区分経理用セグメントコード */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     bkngk                                              NUMBER      (13)                                                                ,  /* 備金額 */
     bkngk$                                             VARCHAR     (10)                                                                ,  /* 備金額(通貨型) */
     syoriumukbn                                        VARCHAR     (1)                                                                 ,  /* 処理有無区分 */
     bknjkukbn                                          VARCHAR     (1)                                                                 ,  /* 備金時効区分 */
     kaiyakuhrgaika                                     NUMBER      (13)                                                                ,  /* 解約返戻金（外貨） */
     kaiyakuhrgaika$                                    VARCHAR     (10)                                                                ,  /* 解約返戻金（外貨）(通貨型) */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     kwsratekjymd                                       VARCHAR     (8)                                                                 ,  /* 為替レート基準日 */
     kawaserate                                         NUMBER      (7,4)                                                               ,  /* 為替レート */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_AsBikinkanri ADD CONSTRAINT PK_AsBikinkanri PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     kessankijyunymd                                          , /* 決算基準日 */
     bkncdkbn                                                 , /* 備金コード区分 */
     bknkktymd                                                , /* 備金確定日 */
     renno                                                      /* 連番 */
) ;
