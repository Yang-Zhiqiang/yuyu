CREATE TABLE IW_TmttkinYskWk (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     syouhnbunruitmttkinyskkbn                          VARCHAR     (2)                                                                 ,  /* 商品分類積立金予測区分 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     kyksjkkktyouseiriritu                              NUMBER      (5,4)                                                               ,  /* 契約時市場価格調整用利率 */
     targettkhkumu                                      VARCHAR     (1)                                                                 ,  /* ターゲット特約付加有無 */
     targettkmokuhyouti                                 NUMBER      (3)                                                                 ,  /* ターゲット特約目標値 */
     kyktuukap                                          NUMBER      (13)                                                                ,  /* 契約通貨建保険料 */
     kyktuukap$                                         VARCHAR     (10)                                                                ,  /* 契約通貨建保険料(通貨型) */
     kyktuukatmttkngk                                   NUMBER      (13)                                                                ,  /* 契約通貨建積立金額 */
     kyktuukatmttkngk$                                  VARCHAR     (10)                                                                ,  /* 契約通貨建積立金額(通貨型) */
     kyktuukakaiyakuhrgk                                NUMBER      (13)                                                                ,  /* 契約通貨建解約返戻金額 */
     kyktuukakaiyakuhrgk$                               VARCHAR     (10)                                                                ,  /* 契約通貨建解約返戻金額(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IW_TmttkinYskWk ADD CONSTRAINT PK_KhTmttkinYskWk PRIMARY KEY (
     syono                                                      /* 証券番号 */
) ;
