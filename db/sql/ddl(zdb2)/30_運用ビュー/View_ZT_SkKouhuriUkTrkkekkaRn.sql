CREATE VIEW ZT_SkKouhuriUkTrkkekkaRn AS SELECT
     zrnsyukkncd ,         /* （連携用）収納機関コード */
     zrnkinyuukikancd8keta ,         /* （連携用）金融機関コード（８桁） */
     zrnrecordkbn ,         /* （連携用）レコード区分 */
     zrnkinyuukkntratkiymd ,         /* （連携用）金融機関取扱年月日 */
     zrnkinyuukkntratkitime ,         /* （連携用）金融機関取扱時刻 */
     zrnkinyuukkntratkino ,         /* （連携用）金融機関取扱番号 */
     zrnkouhuriukchannelkbn ,         /* （連携用）口振受付チャネル区分 */
     zrnkouhuriokyakusamano ,         /* （連携用）口振お客様番号 */
     zrnkouhuribankcd ,         /* （連携用）口振銀行コード */
     zrnkouhurisitencd5keta ,         /* （連携用）口振支店コード（５桁） */
     zrnkzhurikaeyokinkbn ,         /* （連携用）口座振替預金種目区分 */
     zrnkzhurikaekouzano8keta ,         /* （連携用）口座振替口座番号（８桁） */
     zrnkzmeiginmei ,         /* （連携用）口座名義人名 */
     zrnitakusyacd ,         /* （連携用）委託者コード */
     zrnsyukkntratkiymd ,         /* （連携用）収納機関取扱年月日 */
     zrnsyukkntratkitime ,         /* （連携用）収納機関取扱時刻 */
     zrnsyukkntratkino ,         /* （連携用）収納機関取扱番号 */
     zrnkouhuristatuskbn ,         /* （連携用）口振ステータス区分 */
     zrnkouhurikekkacd ,         /* （連携用）口振処理結果コード */
     zrnkouhurihonninkakkekka ,         /* （連携用）口振本人確認結果 */
     zrnyobiv207           /* （連携用）予備項目Ｖ２０７ */
FROM ZT_SkKouhuriUkTrkkekkaRn_Z;