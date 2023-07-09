CREATE TABLE ZT_SosikiRn (
     zrnsosikicd                                        CHAR        (7)                                                       NOT NULL  ,  /* （連携用）組織コード */
     zrnsosikinmkbn                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）組織名区分 */
     zrnyobiv1                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ１ */
     zrnsosikinm20                                      CHAR        (20)                                                      NOT NULL  ,  /* （連携用）組織名（２０文字） */
     zrnkanjisosikinm20                                 VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）漢字組織名（２０文字） */
     zrnsosikihaisiy                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）組織廃止年月年 */
     zrnsosikihaisim                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）組織廃止年月月 */
     zrnsosikisinsetuy                                  CHAR        (4)                                                       NOT NULL  ,  /* （連携用）組織新設年月年 */
     zrnsosikisinsetum                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）組織新設年月月 */
     zrntougetukeisyousosikicd                          CHAR        (7)                                                       NOT NULL  ,  /* （連携用）当月継承組織コード */
     zrntougetukeisyoueigyoubucd                        CHAR        (3)                                                       NOT NULL  ,  /* （連携用）当月継承営業推進部コード */
     zrnzengetukeisyousosikicd                          CHAR        (7)                                                       NOT NULL  ,  /* （連携用）前月継承組織コード */
     zrnzengetukeisyoueigyoubucd                        CHAR        (3)                                                       NOT NULL  ,  /* （連携用）前月継承営業推進部コード */
     zrnsosikikihontikucd                               CHAR        (8)                                                       NOT NULL  ,  /* （連携用）組織基本地区コード */
     zrnsosikikanjikaiadr30                             VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）組織漢字下位住所（３０文字） */
     zrnkanjibilunm15                                   VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）漢字ビル名称（１５文字） */
     zrnsosikinyuukyokaisuu                             CHAR        (3)                                                       NOT NULL  ,  /* （連携用）組織入居階数 */
     zrnsosikidenwabangousigai                          CHAR        (6)                                                       NOT NULL  ,  /* （連携用）組織電話番号市外局番 */
     zrnsosikitdenwabangousinai                         CHAR        (6)                                                       NOT NULL  ,  /* （連携用）組織電話番号市内局番 */
     zrnsosikidenwabangoubangou                         CHAR        (6)                                                       NOT NULL  ,  /* （連携用）組織電話番号番号 */
     zrnsosikifaxbangousigai                            CHAR        (6)                                                       NOT NULL  ,  /* （連携用）組織ＦＡＸ番号市外局番 */
     zrnsosikifaxbangousinai                            CHAR        (6)                                                       NOT NULL  ,  /* （連携用）組織ＦＡＸ番号市内局番 */
     zrnsosikifaxbangoubangou                           CHAR        (6)                                                       NOT NULL  ,  /* （連携用）組織ＦＡＸ番号番号 */
     zrnkouryokukaisiy                                  CHAR        (4)                                                       NOT NULL  ,  /* （連携用）効力開始年月年 */
     zrnkouryokukaisim                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）効力開始年月月 */
     zrnkouryokukaisid                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）効力開始年月日 */
     zrnnewsosikikihontikucd                            CHAR        (8)                                                       NOT NULL  ,  /* （連携用）(変更後)組織基本地区コード */
     zrnnewkanjisosikikaiadr30                          VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）(変更後)漢字組織下位住所（３０文字） */
     zrnnewkanjibilunm15                                VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）(変更後)漢字ビル名称（１５文字） */
     zrnnewsosikinyuukyokaisuu                          CHAR        (3)                                                       NOT NULL  ,  /* （連携用）(変更後)組織入居階数 */
     zrnnewsosikidenwasigai                             CHAR        (6)                                                       NOT NULL  ,  /* （連携用）(変更後)組織電話番号市外局番 */
     zrnnewsosikidenwasinai                             CHAR        (6)                                                       NOT NULL  ,  /* （連携用）(変更後)組織電話番号市内局番 */
     zrnnewsosikidenwabangou                            CHAR        (6)                                                       NOT NULL  ,  /* （連携用）(変更後)組織電話番号番号 */
     zrnnewsosikifaxsigai                               CHAR        (6)                                                       NOT NULL  ,  /* （連携用）(変更後)組織ＦＡＸ番号市外局番 */
     zrnnewsosikifaxsinai                               CHAR        (6)                                                       NOT NULL  ,  /* （連携用）(変更後)組織ＦＡＸ番号市内局番 */
     zrnnewsosikifaxbangou                              CHAR        (6)                                                       NOT NULL     /* （連携用）(変更後)組織ＦＡＸ番号番号 */
)
;

ALTER TABLE ZT_SosikiRn ADD CONSTRAINT PK_SosikiRn PRIMARY KEY (
     zrnsosikicd                                                /* （連携用）組織コード */
) ;
