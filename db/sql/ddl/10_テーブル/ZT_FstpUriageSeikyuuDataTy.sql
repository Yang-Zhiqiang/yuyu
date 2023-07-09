CREATE TABLE ZT_FstpUriageSeikyuuDataTy (
     ztyrecordkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）レコード区分 */
     ztyauthorikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）オーソリ区分 */
     ztyuriageseikyuutorihikicd                         VARCHAR     (1)                                                                 ,  /* （中継用）売上請求取引コード */
     ztyyobiv14                                         VARCHAR     (14)                                                                ,  /* （中継用）予備項目Ｖ１４ */
     ztyuriagetaisyouym                                 VARCHAR     (6)                                                                 ,  /* （中継用）売上対象年月 */
     ztyuriageymd6keta                                  VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）売上年月日（６桁） */
     ztycreditkigyoucd                                  VARCHAR     (5)                                                                 ,  /* （中継用）クレジット企業コード */
     ztycreditkessaiyouno                               VARCHAR     (26)                                                      NOT NULL  ,  /* （中継用）クレジットカード決済用番号 */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyrecordno                                        VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）レコード番号 */
     ztyyobiv3                                          VARCHAR     (3)                                                                 ,  /* （中継用）予備項目Ｖ３ */
     ztycardyuukoukigen                                 VARCHAR     (4)                                                                 ,  /* （中継用）カード有効期限 */
     ztyseikyuukngk11keta                               NUMBER      (11)                                                      NOT NULL  ,  /* （中継用）請求金額（１１桁） */
     ztyyobiv2                                          VARCHAR     (2)                                                                 ,  /* （中継用）予備項目Ｖ２ */
     ztycreditkaiinnokami6keta                          VARCHAR     (6)                                                                 ,  /* （中継用）クレジット会員番号（上６桁） */
     ztyyobiv6                                          VARCHAR     (6)                                                                 ,  /* （中継用）予備項目Ｖ６ */
     ztycreditkaiinnosimo4keta                          VARCHAR     (4)                                                                 ,  /* （中継用）クレジット会員番号（下４桁） */
     ztyuriageseikyuuerrorcd                            VARCHAR     (3)                                                                 ,  /* （中継用）売上請求エラーコード */
     ztyhurikaekekkacd                                  VARCHAR     (1)                                                                 ,  /* （中継用）振替結果コード */
     ztyfukusuukameitennokey                            VARCHAR     (7)                                                                 ,  /* （中継用）複数加盟店番号設定キー情報 */
     ztyyobiv1                                          VARCHAR     (1)                                                                 ,  /* （中継用）予備項目Ｖ１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_FstpUriageSeikyuuDataTy ADD CONSTRAINT PK_FstpUriageSeikyuuDataTy PRIMARY KEY (
     ztyuriageymd6keta                                        , /* （中継用）売上年月日（６桁） */
     ztycreditkessaiyouno                                     , /* （中継用）クレジットカード決済用番号 */
     ztysyono                                                 , /* （中継用）証券番号 */
     ztyrecordno                                              , /* （中継用）レコード番号 */
     ztyseikyuukngk11keta                                       /* （中継用）請求金額（１１桁） */
) ;
