CREATE VIEW ZT_SkKouhuriUkTrkkekkaTr AS SELECT
     ztrsyukkncd ,         /* （取込用）収納機関コード */
     ztrkinyuukikancd8keta ,         /* （取込用）金融機関コード（８桁） */
     ztrrecordkbn ,         /* （取込用）レコード区分 */
     ztrkinyuukkntratkiymd ,         /* （取込用）金融機関取扱年月日 */
     ztrkinyuukkntratkitime ,         /* （取込用）金融機関取扱時刻 */
     ztrkinyuukkntratkino ,         /* （取込用）金融機関取扱番号 */
     ztrkouhuriukchannelkbn ,         /* （取込用）口振受付チャネル区分 */
     ztrkouhuriokyakusamano ,         /* （取込用）口振お客様番号 */
     ztrkouhuribankcd ,         /* （取込用）口振銀行コード */
     ztrkouhurisitencd5keta ,         /* （取込用）口振支店コード（５桁） */
     ztrkzhurikaeyokinkbn ,         /* （取込用）口座振替預金種目区分 */
     ztrkzhurikaekouzano8keta ,         /* （取込用）口座振替口座番号（８桁） */
     ztrkzmeiginmei ,         /* （取込用）口座名義人名 */
     ztritakusyacd ,         /* （取込用）委託者コード */
     ztrsyukkntratkiymd ,         /* （取込用）収納機関取扱年月日 */
     ztrsyukkntratkitime ,         /* （取込用）収納機関取扱時刻 */
     ztrsyukkntratkino ,         /* （取込用）収納機関取扱番号 */
     ztrkouhuristatuskbn ,         /* （取込用）口振ステータス区分 */
     ztrkouhurikekkacd ,         /* （取込用）口振処理結果コード */
     ztrkouhurihonninkakkekka ,         /* （取込用）口振本人確認結果 */
     ztryobiv207 ,         /* （取込用）予備項目Ｖ２０７ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_SkKouhuriUkTrkkekkaTr_Z;