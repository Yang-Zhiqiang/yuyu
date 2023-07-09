CREATE TABLE IT_DrtenMinyuKykTaisyo (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     minyuutrrenno                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 未入TR連番 */
     nykkeiro                                           VARCHAR     (2)                                                                 ,  /* 入金経路 */
     nyknaiyoukbn                                       VARCHAR     (2)                                                                 ,  /* 入金内容区分 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuuy                                      NUMBER      (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      NUMBER      (2)                                                                 ,  /* 充当回数（月） */
     rsgaku                                             NUMBER      (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     hurihunokbn                                        VARCHAR     (1)                                                                 ,  /* 振替不能理由区分 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     dantaikobetukbn                                    VARCHAR     (1)                                                                 ,  /* 団体個別区分 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     kzhurikaetkbtannaihyj                              VARCHAR     (1)                                                                 ,  /* 口座振替特別案内表示 */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     jkiannaikg                                         NUMBER      (13)                                                                ,  /* 次回案内金額 */
     jkiannaikg$                                        VARCHAR     (10)                                                                ,  /* 次回案内金額(通貨型) */
     jkijyutoukaisuuy                                   NUMBER      (2)                                                                 ,  /* 次回案内充当回数（年） */
     jkijyutoukaisuum                                   NUMBER      (2)                                                                 ,  /* 次回案内充当回数（月） */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_DrtenMinyuKykTaisyo ADD CONSTRAINT PK_DrtenMinyuKykTaisyo PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     syoriYmd                                                 , /* 処理年月日 */
     minyuutrrenno                                              /* 未入TR連番 */
) ;
