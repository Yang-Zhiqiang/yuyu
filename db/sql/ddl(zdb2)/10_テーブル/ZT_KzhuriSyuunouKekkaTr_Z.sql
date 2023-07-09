CREATE TABLE ZT_KzhuriSyuunouKekkaTr_Z (
     ztrsyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （取込用）証券番号 */
     ztrkzhurikaebankcd                                 VARCHAR     (4)                                                                 ,  /* （取込用）口座振替銀行番号 */
     ztrkzhurikaesitencd                                VARCHAR     (3)                                                                 ,  /* （取込用）口座振替支店番号 */
     ztrkzhurikaeyokinkbn                               VARCHAR     (1)                                                                 ,  /* （取込用）口座振替預金種目区分 */
     ztrkzhurikaekouzano                                VARCHAR     (7)                                                                 ,  /* （取込用）口座振替口座番号 */
     ztrhurikaeymd                                      VARCHAR     (8)                                                                 ,  /* （取込用）振替年月日 */
     ztrrsgaku                                          DECIMAL     (11)                                                                ,  /* （取込用）領収金額 */
     ztrjyuutouym                                       VARCHAR     (6)                                                       NOT NULL  ,  /* （取込用）充当年月 */
     ztrjyuutounensuu                                   VARCHAR     (2)                                                                 ,  /* （取込用）充当年数 */
     ztrjyuutoutukisuu                                  VARCHAR     (2)                                                                 ,  /* （取込用）充当月数 */
     ztrdantaikobetukbn                                 VARCHAR     (1)                                                                 ,  /* （取込用）団体個別区分 */
     ztrnyknaiyoukbn                                    VARCHAR     (2)                                                                 ,  /* （取込用）入金内容区分 */
     ztrhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （取込用）払込回数区分 */
     ztrkzhurikaetkbtannaihyj                           VARCHAR     (1)                                                                 ,  /* （取込用）口座振替特別案内表示 */
     ztrhurikaekekkakbn                                 VARCHAR     (1)                                                                 ,  /* （取込用）振替結果区分 */
     ztrkzhurisyuudaikokbn                              VARCHAR     (1)                                                                 ,  /* （取込用）口座振替収納代行会社区分 */
     ztryobiv13                                         VARCHAR     (13)                                                                ,  /* （取込用）予備項目Ｖ１３ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_KzhuriSyuunouKekkaTr_Z ADD CONSTRAINT PK_KzhuriSyuunouKekkaTr PRIMARY KEY (
     ztrsyono                                                 , /* （取込用）証券番号 */
     ztrjyuutouym                                               /* （取込用）充当年月 */
) ;
