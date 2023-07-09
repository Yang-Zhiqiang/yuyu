CREATE TABLE JT_MisyuupRendo_Z (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     datarenno                                          DECIMAL     (5)                                                       NOT NULL  ,  /* データ連番 */
     nykkeiro                                           VARCHAR     (2)                                                                 ,  /* 入金経路 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     nyknaiyoukbn                                       VARCHAR     (2)                                                                 ,  /* 入金内容区分 */
     iktnyuukinnumu                                     VARCHAR     (1)                                                                 ,  /* 一括入金有無 */
     misyuupjyuutouym                                   VARCHAR     (6)                                                                 ,  /* 未収保険料充当年月 */
     misyuupjyuutoukaisuuy                              DECIMAL     (2)                                                                 ,  /* 未収保険料充当回数（年） */
     misyuupjyuutoukaisuum                              DECIMAL     (2)                                                                 ,  /* 未収保険料充当回数（月） */
     misyuup                                            DECIMAL     (13)                                                                ,  /* 未収保険料 */
     misyuup$                                           VARCHAR     (10)                                                                ,  /* 未収保険料(通貨型) */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付 */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     nyknkwsratekijyunymd                               VARCHAR     (8)                                                                 ,  /* 入金用為替レート基準日 */
     syoriYmd                                           VARCHAR     (8)                                                                    /* 処理年月日 */
)
;

ALTER TABLE JT_MisyuupRendo_Z ADD CONSTRAINT PK_MisyuupRendo PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     datarenno                                                  /* データ連番 */
) ;
