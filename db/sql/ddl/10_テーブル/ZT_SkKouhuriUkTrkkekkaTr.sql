CREATE TABLE ZT_SkKouhuriUkTrkkekkaTr (
     ztrsyukkncd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* （取込用）収納機関コード */
     ztrkinyuukikancd8keta                              VARCHAR     (8)                                                       NOT NULL  ,  /* （取込用）金融機関コード（８桁） */
     ztrrecordkbn                                       VARCHAR     (1)                                                                 ,  /* （取込用）レコード区分 */
     ztrkinyuukkntratkiymd                              VARCHAR     (8)                                                       NOT NULL  ,  /* （取込用）金融機関取扱年月日 */
     ztrkinyuukkntratkitime                             VARCHAR     (6)                                                       NOT NULL  ,  /* （取込用）金融機関取扱時刻 */
     ztrkinyuukkntratkino                               VARCHAR     (15)                                                                ,  /* （取込用）金融機関取扱番号 */
     ztrkouhuriukchannelkbn                             VARCHAR     (2)                                                                 ,  /* （取込用）口振受付チャネル区分 */
     ztrkouhuriokyakusamano                             VARCHAR     (20)                                                      NOT NULL  ,  /* （取込用）口振お客様番号 */
     ztrkouhuribankcd                                   VARCHAR     (4)                                                                 ,  /* （取込用）口振銀行コード */
     ztrkouhurisitencd5keta                             VARCHAR     (5)                                                                 ,  /* （取込用）口振支店コード（５桁） */
     ztrkzhurikaeyokinkbn                               VARCHAR     (1)                                                                 ,  /* （取込用）口座振替預金種目区分 */
     ztrkzhurikaekouzano8keta                           VARCHAR     (8)                                                                 ,  /* （取込用）口座振替口座番号（８桁） */
     ztrkzmeiginmei                                     VARCHAR     (30)                                                                ,  /* （取込用）口座名義人名 */
     ztritakusyacd                                      VARCHAR     (10)                                                                ,  /* （取込用）委託者コード */
     ztrsyukkntratkiymd                                 VARCHAR     (8)                                                                 ,  /* （取込用）収納機関取扱年月日 */
     ztrsyukkntratkitime                                VARCHAR     (6)                                                                 ,  /* （取込用）収納機関取扱時刻 */
     ztrsyukkntratkino                                  VARCHAR     (15)                                                                ,  /* （取込用）収納機関取扱番号 */
     ztrkouhuristatuskbn                                VARCHAR     (1)                                                                 ,  /* （取込用）口振ステータス区分 */
     ztrkouhurikekkacd                                  VARCHAR     (2)                                                                 ,  /* （取込用）口振処理結果コード */
     ztrkouhurihonninkakkekka                           VARCHAR     (1)                                                                 ,  /* （取込用）口振本人確認結果 */
     ztryobiv207                                        VARCHAR     (207)                                                               ,  /* （取込用）予備項目Ｖ２０７ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SkKouhuriUkTrkkekkaTr ADD CONSTRAINT PK_SkKouhuriUkTrkkekkaTr PRIMARY KEY (
     ztrsyukkncd                                              , /* （取込用）収納機関コード */
     ztrkinyuukikancd8keta                                    , /* （取込用）金融機関コード（８桁） */
     ztrkinyuukkntratkiymd                                    , /* （取込用）金融機関取扱年月日 */
     ztrkinyuukkntratkitime                                   , /* （取込用）金融機関取扱時刻 */
     ztrkouhuriokyakusamano                                     /* （取込用）口振お客様番号 */
) ;
