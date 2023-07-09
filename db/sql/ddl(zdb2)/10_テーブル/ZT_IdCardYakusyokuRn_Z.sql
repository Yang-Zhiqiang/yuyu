CREATE TABLE ZT_IdCardYakusyokuRn_Z (
     zrnidkbn                                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）ＩＤ区分 */
     zrnidcd                                            CHAR        (6)                                                       NOT NULL  ,  /* （連携用）ＩＤコード */
     zrnyakusyokuhatureiymd                             CHAR        (8)                                                       NOT NULL  ,  /* （連携用）役職発令年月日 */
     zrnyakusyokuhatureino                              CHAR        (2)                                                       NOT NULL  ,  /* （連携用）役職発令番号 */
     zrnyakusyokuhatureisosikicd                        CHAR        (7)                                                       NOT NULL  ,  /* （連携用）役職発令組織コード */
     zrnyakusyokucd                                     CHAR        (3)                                                       NOT NULL     /* （連携用）役職コード */
)
;

ALTER TABLE ZT_IdCardYakusyokuRn_Z ADD CONSTRAINT PK_IdCardYakusyokuRn PRIMARY KEY (
     zrnidkbn                                                 , /* （連携用）ＩＤ区分 */
     zrnidcd                                                  , /* （連携用）ＩＤコード */
     zrnyakusyokuhatureiymd                                   , /* （連携用）役職発令年月日 */
     zrnyakusyokuhatureino                                      /* （連携用）役職発令番号 */
) ;
