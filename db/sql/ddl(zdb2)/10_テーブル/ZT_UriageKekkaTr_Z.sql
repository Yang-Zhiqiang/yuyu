CREATE TABLE ZT_UriageKekkaTr_Z (
     ztrrecordkbn                                       VARCHAR     (1)                                                                 ,  /* （取込用）レコード区分 */
     ztrauthorikbn                                      VARCHAR     (1)                                                                 ,  /* （取込用）オーソリ区分 */
     ztruriageseikyuutorihikicd                         VARCHAR     (1)                                                                 ,  /* （取込用）売上請求取引コード */
     ztryobiv14                                         VARCHAR     (14)                                                                ,  /* （取込用）予備項目Ｖ１４ */
     ztruriagetaisyouym                                 VARCHAR     (6)                                                                 ,  /* （取込用）売上対象年月 */
     ztruriageymd6keta                                  VARCHAR     (6)                                                       NOT NULL  ,  /* （取込用）売上年月日（６桁） */
     ztrcreditkigyoucd                                  VARCHAR     (5)                                                                 ,  /* （取込用）クレジット企業コード */
     ztrcreditkessaiyouno                               VARCHAR     (26)                                                      NOT NULL  ,  /* （取込用）クレジットカード決済用番号 */
     ztrsyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （取込用）証券番号 */
     ztrrecordno                                        VARCHAR     (2)                                                       NOT NULL  ,  /* （取込用）レコード番号 */
     ztryobiv3                                          VARCHAR     (3)                                                                 ,  /* （取込用）予備項目Ｖ３ */
     ztrcardyuukoukigen                                 VARCHAR     (4)                                                                 ,  /* （取込用）カード有効期限 */
     ztrseikyuukngk                                     DECIMAL     (13)                                                      NOT NULL  ,  /* （取込用）請求金額 */
     ztryobiv5                                          VARCHAR     (5)                                                                 ,  /* （取込用）予備項目Ｖ５ */
     ztrcreditkaiinnokami6keta                          VARCHAR     (6)                                                                 ,  /* （取込用）クレジット会員番号（上６桁） */
     ztryobiv6                                          VARCHAR     (6)                                                                 ,  /* （取込用）予備項目Ｖ６ */
     ztrcreditkaiinnosimo4keta                          VARCHAR     (4)                                                                 ,  /* （取込用）クレジット会員番号（下４桁） */
     ztruriageseikyuuerrorcd                            VARCHAR     (3)                                                                 ,  /* （取込用）売上請求エラーコード */
     ztrhurikaekekkacd                                  VARCHAR     (1)                                                                 ,  /* （取込用）振替結果コード */
     ztrfukusuukameitennokey                            VARCHAR     (7)                                                                 ,  /* （取込用）複数加盟店番号設定キー情報 */
     ztryobiv1                                          VARCHAR     (1)                                                                 ,  /* （取込用）予備項目Ｖ１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_UriageKekkaTr_Z ADD CONSTRAINT PK_UriageKekkaTr PRIMARY KEY (
     ztrsyono                                                 , /* （取込用）証券番号 */
     ztrcreditkessaiyouno                                     , /* （取込用）クレジットカード決済用番号 */
     ztruriageymd6keta                                        , /* （取込用）売上年月日（６桁） */
     ztrrecordno                                              , /* （取込用）レコード番号 */
     ztrseikyuukngk                                             /* （取込用）請求金額 */
) ;
