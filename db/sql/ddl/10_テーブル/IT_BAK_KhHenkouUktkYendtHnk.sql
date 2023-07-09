CREATE TABLE IT_BAK_KhHenkouUktkYendtHnk (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     hozenhenkouuktkrenno                               NUMBER      (5)                                                       NOT NULL  ,  /* 保全変更受付連番 */
     yendthnkymd                                        VARCHAR     (8)                                                                 ,  /* 円建変更日 */
     mkhgktttymd                                        VARCHAR     (8)                                                                 ,  /* 目標額到達日 */
     mkhgktttkaiyakuhr                                  NUMBER      (13)                                                                ,  /* 目標額到達時解約返戻金 */
     mkhgktttkaiyakuhr$                                 VARCHAR     (10)                                                                ,  /* 目標額到達時解約返戻金(通貨型) */
     newkaiyakuhr                                       NUMBER      (13)                                                                ,  /* 変更後解約返戻金 */
     newkaiyakuhr$                                      VARCHAR     (10)                                                                ,  /* 変更後解約返戻金(通貨型) */
     yendthnkhr                                         NUMBER      (13)                                                                ,  /* 円建変更時返戻金 */
     yendthnkhr$                                        VARCHAR     (10)                                                                ,  /* 円建変更時返戻金(通貨型) */
     nyuuryokuhassoukbn                                 VARCHAR     (1)                                                                 ,  /* 入力発送区分 */
     hnskariyuu1                                        VARCHAR     (1)                                                                 ,  /* 本社回送理由１ */
     hnskariyuu2                                        VARCHAR     (1)                                                                 ,  /* 本社回送理由２ */
     yendthnkkaiyakuhrgaika                             NUMBER      (13)                                                                ,  /* 円建変更時解約返戻金（外貨） */
     yendthnkkaiyakuhrgaika$                            VARCHAR     (10)                                                                ,  /* 円建変更時解約返戻金（外貨）(通貨型) */
     yendthnkkaiyakuhryen                               NUMBER      (13)                                                                ,  /* 円建変更時解約返戻金（円貨） */
     yendthnkkaiyakuhryen$                              VARCHAR     (10)                                                                ,  /* 円建変更時解約返戻金（円貨）(通貨型) */
     yendthnkjikwsrate                                  NUMBER      (7,4)                                                               ,  /* 円建変更時為替レート */
     newsyouhncd                                        VARCHAR     (4)                                                                 ,  /* 変更後商品コード */
     newsyouhnsdno                                      NUMBER      (2)                                                                 ,  /* 変更後商品世代番号 */
     yendthnkkihons                                     NUMBER      (13)                                                                ,  /* 円建変更後基本Ｓ */
     yendthnkkihons$                                    VARCHAR     (10)                                                                ,  /* 円建変更後基本Ｓ(通貨型) */
     newhokenryou                                       NUMBER      (13)                                                                ,  /* 変更後保険料 */
     newhokenryou$                                      VARCHAR     (10)                                                                ,  /* 変更後保険料(通貨型) */
     newkyktuukasyu                                     VARCHAR     (3)                                                                 ,  /* 変更後契約通貨種類 */
     newryouritusdno                                    VARCHAR     (3)                                                                 ,  /* 変更後料率世代番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     syoruiukeymd                                       VARCHAR     (8)                                                                 ,  /* 書類受付日 */
     newtumitateriritu                                  NUMBER      (5,4)                                                               ,  /* 変更後積立利率 */
     newyoteiriritu                                     NUMBER      (5,4)                                                               ,  /* 変更後予定利率 */
     mkhgk                                              NUMBER      (13)                                                                ,  /* 目標額 */
     mkhgk$                                             VARCHAR     (10)                                                                ,  /* 目標額(通貨型) */
     yendthnkkjnkg                                      NUMBER      (13)                                                                ,  /* 円建変更基準金額 */
     yendthnkkjnkg$                                     VARCHAR     (10)                                                                ,  /* 円建変更基準金額(通貨型) */
     targettkmokuhyouti                                 NUMBER      (3)                                                                 ,  /* ターゲット特約目標値 */
     yendthnkbfrsibousyen                               NUMBER      (13)                                                                ,  /* 円建変更前死亡Ｓ（円貨） */
     yendthnkbfrsibousyen$                              VARCHAR     (10)                                                                ,  /* 円建変更前死亡Ｓ（円貨）(通貨型) */
     yendthnkjiptumitatekin                             NUMBER      (13)                                                                ,  /* 円建変更時保険料積立金 */
     yendthnkjiptumitatekin$                            VARCHAR     (10)                                                                ,  /* 円建変更時保険料積立金(通貨型) */
     yendthnkjisjkkktyouseiritu                         NUMBER      (11,8)                                                              ,  /* 円建変更時市場価格調整率 */
     yendthnkjikaiyakukjgk                              NUMBER      (13)                                                                ,  /* 円建変更時解約控除額 */
     yendthnkjikaiyakukjgk$                             VARCHAR     (10)                                                                ,  /* 円建変更時解約控除額(通貨型) */
     yendthnkjikaiyakukoujyoritu                        NUMBER      (4,3)                                                               ,  /* 円建変更時解約控除率 */
     kaiyakukoujyoritutekiumu                           VARCHAR     (1)                                                                 ,  /* 解約控除率適用有無 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_BAK_KhHenkouUktkYendtHnk ADD CONSTRAINT PK_BAK_KhHenkouUktkYendtHnk PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     hozenhenkouuktkrenno                                       /* 保全変更受付連番 */
) ;
