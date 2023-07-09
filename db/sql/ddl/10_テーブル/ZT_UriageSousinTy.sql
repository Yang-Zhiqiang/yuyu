CREATE TABLE ZT_UriageSousinTy (
     ztycreditkessaiyouno                               VARCHAR     (26)                                                      NOT NULL  ,  /* （中継用）クレジットカード決済用番号 */
     ztyauthorikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）オーソリ区分 */
     ztyuriageseikyuuymd                                VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）売上請求年月日 */
     ztyrsgaku                                          NUMBER      (11)                                                      NOT NULL  ,  /* （中継用）領収金額 */
     ztyfukusuukameitennokey                            VARCHAR     (7)                                                                 ,  /* （中継用）複数加盟店番号設定キー情報 */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyrecordno                                        VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）レコード番号 */
     ztyuriagetaisyouym                                 VARCHAR     (6)                                                                 ,  /* （中継用）売上対象年月 */
     ztyyobiv33                                         VARCHAR     (33)                                                                ,  /* （中継用）予備項目Ｖ３３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_UriageSousinTy ADD CONSTRAINT PK_UriageSousinTy PRIMARY KEY (
     ztycreditkessaiyouno                                     , /* （中継用）クレジットカード決済用番号 */
     ztysyono                                                 , /* （中継用）証券番号 */
     ztyuriageseikyuuymd                                      , /* （中継用）売上請求年月日 */
     ztyrsgaku                                                , /* （中継用）領収金額 */
     ztyrecordno                                                /* （中継用）レコード番号 */
) ;
