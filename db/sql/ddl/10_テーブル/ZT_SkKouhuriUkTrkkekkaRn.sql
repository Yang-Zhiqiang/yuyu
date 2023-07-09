CREATE TABLE ZT_SkKouhuriUkTrkkekkaRn (
     zrnsyukkncd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）収納機関コード */
     zrnkinyuukikancd8keta                              CHAR        (8)                                                       NOT NULL  ,  /* （連携用）金融機関コード（８桁） */
     zrnrecordkbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）レコード区分 */
     zrnkinyuukkntratkiymd                              CHAR        (8)                                                       NOT NULL  ,  /* （連携用）金融機関取扱年月日 */
     zrnkinyuukkntratkitime                             CHAR        (6)                                                       NOT NULL  ,  /* （連携用）金融機関取扱時刻 */
     zrnkinyuukkntratkino                               CHAR        (15)                                                      NOT NULL  ,  /* （連携用）金融機関取扱番号 */
     zrnkouhuriukchannelkbn                             CHAR        (2)                                                       NOT NULL  ,  /* （連携用）口振受付チャネル区分 */
     zrnkouhuriokyakusamano                             CHAR        (20)                                                      NOT NULL  ,  /* （連携用）口振お客様番号 */
     zrnkouhuribankcd                                   CHAR        (4)                                                       NOT NULL  ,  /* （連携用）口振銀行コード */
     zrnkouhurisitencd5keta                             CHAR        (5)                                                       NOT NULL  ,  /* （連携用）口振支店コード（５桁） */
     zrnkzhurikaeyokinkbn                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口座振替預金種目区分 */
     zrnkzhurikaekouzano8keta                           CHAR        (8)                                                       NOT NULL  ,  /* （連携用）口座振替口座番号（８桁） */
     zrnkzmeiginmei                                     CHAR        (30)                                                      NOT NULL  ,  /* （連携用）口座名義人名 */
     zrnitakusyacd                                      CHAR        (10)                                                      NOT NULL  ,  /* （連携用）委託者コード */
     zrnsyukkntratkiymd                                 CHAR        (8)                                                       NOT NULL  ,  /* （連携用）収納機関取扱年月日 */
     zrnsyukkntratkitime                                CHAR        (6)                                                       NOT NULL  ,  /* （連携用）収納機関取扱時刻 */
     zrnsyukkntratkino                                  CHAR        (15)                                                      NOT NULL  ,  /* （連携用）収納機関取扱番号 */
     zrnkouhuristatuskbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口振ステータス区分 */
     zrnkouhurikekkacd                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）口振処理結果コード */
     zrnkouhurihonninkakkekka                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）口振本人確認結果 */
     zrnyobiv207                                        CHAR        (207)                                                     NOT NULL     /* （連携用）予備項目Ｖ２０７ */
)
;

ALTER TABLE ZT_SkKouhuriUkTrkkekkaRn ADD CONSTRAINT PK_SkKouhuriUkTrkkekkaRn PRIMARY KEY (
     zrnsyukkncd                                              , /* （連携用）収納機関コード */
     zrnkinyuukikancd8keta                                    , /* （連携用）金融機関コード（８桁） */
     zrnkinyuukkntratkiymd                                    , /* （連携用）金融機関取扱年月日 */
     zrnkinyuukkntratkitime                                   , /* （連携用）金融機関取扱時刻 */
     zrnkouhuriokyakusamano                                     /* （連携用）口振お客様番号 */
) ;
