CREATE TABLE IT_BAK_KhHenkouUktkYendtHnk_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     hozenhenkouuktkrenno                               DECIMAL     (5)                                                       NOT NULL  ,  /* 保全変更受付連番 */
     yendthnkymd                                        VARCHAR     (8)                                                                 ,  /* 円建変更日 */
     mkhgktttymd                                        VARCHAR     (8)                                                                 ,  /* 目標額到達日 */
     mkhgktttkaiyakuhr                                  DECIMAL     (13)                                                                ,  /* 目標額到達時解約返戻金 */
     mkhgktttkaiyakuhr$                                 VARCHAR     (10)                                                                ,  /* 目標額到達時解約返戻金(通貨型) */
     newkaiyakuhr                                       DECIMAL     (13)                                                                ,  /* 変更後解約返戻金 */
     newkaiyakuhr$                                      VARCHAR     (10)                                                                ,  /* 変更後解約返戻金(通貨型) */
     yendthnkhr                                         DECIMAL     (13)                                                                ,  /* 円建変更時返戻金 */
     yendthnkhr$                                        VARCHAR     (10)                                                                ,  /* 円建変更時返戻金(通貨型) */
     nyuuryokuhassoukbn                                 VARCHAR     (1)                                                                 ,  /* 入力発送区分 */
     hnskariyuu1                                        VARCHAR     (1)                                                                 ,  /* 本社回送理由１ */
     hnskariyuu2                                        VARCHAR     (1)                                                                 ,  /* 本社回送理由２ */
     yendthnkkaiyakuhrgaika                             DECIMAL     (13)                                                                ,  /* 円建変更時解約返戻金（外貨） */
     yendthnkkaiyakuhrgaika$                            VARCHAR     (10)                                                                ,  /* 円建変更時解約返戻金（外貨）(通貨型) */
     yendthnkkaiyakuhryen                               DECIMAL     (13)                                                                ,  /* 円建変更時解約返戻金（円貨） */
     yendthnkkaiyakuhryen$                              VARCHAR     (10)                                                                ,  /* 円建変更時解約返戻金（円貨）(通貨型) */
     yendthnkjikwsrate                                  DECIMAL     (7,4)                                                               ,  /* 円建変更時為替レート */
     newsyouhncd                                        VARCHAR     (4)                                                                 ,  /* 変更後商品コード */
     newsyouhnsdno                                      DECIMAL     (2)                                                                 ,  /* 変更後商品世代番号 */
     yendthnkkihons                                     DECIMAL     (13)                                                                ,  /* 円建変更後基本Ｓ */
     yendthnkkihons$                                    VARCHAR     (10)                                                                ,  /* 円建変更後基本Ｓ(通貨型) */
     newhokenryou                                       DECIMAL     (13)                                                                ,  /* 変更後保険料 */
     newhokenryou$                                      VARCHAR     (10)                                                                ,  /* 変更後保険料(通貨型) */
     newkyktuukasyu                                     VARCHAR     (3)                                                                 ,  /* 変更後契約通貨種類 */
     newryouritusdno                                    VARCHAR     (3)                                                                 ,  /* 変更後料率世代番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     syoruiukeymd                                       VARCHAR     (8)                                                                 ,  /* 書類受付日 */
     newtumitateriritu                                  DECIMAL     (5,4)                                                               ,  /* 変更後積立利率 */
     newyoteiriritu                                     DECIMAL     (5,4)                                                                  /* 変更後予定利率 */
)
;

ALTER TABLE IT_BAK_KhHenkouUktkYendtHnk_Z ADD CONSTRAINT PK_BAK_KhHenkouUktkYendtHnk PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     hozenhenkouuktkrenno                                       /* 保全変更受付連番 */
) ;
