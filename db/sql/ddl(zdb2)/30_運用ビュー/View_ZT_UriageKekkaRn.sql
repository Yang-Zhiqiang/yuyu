CREATE VIEW ZT_UriageKekkaRn AS SELECT
     zrnrecordkbn ,         /* （連携用）レコード区分 */
     zrnauthorikbn ,         /* （連携用）オーソリ区分 */
     zrnuriageseikyuutorihikicd ,         /* （連携用）売上請求取引コード */
     zrnyobiv14 ,         /* （連携用）予備項目Ｖ１４ */
     zrnuriagetaisyouym ,         /* （連携用）売上対象年月 */
     zrnuriageymd6keta ,         /* （連携用）売上年月日（６桁） */
     zrncreditkigyoucd ,         /* （連携用）クレジット企業コード */
     zrncreditkessaiyouno ,         /* （連携用）クレジットカード決済用番号 */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnrecordno ,         /* （連携用）レコード番号 */
     zrnyobiv3 ,         /* （連携用）予備項目Ｖ３ */
     zrncardyuukoukigen ,         /* （連携用）カード有効期限 */
     zrnseikyuukngk ,         /* （連携用）請求金額 */
     zrnyobiv5 ,         /* （連携用）予備項目Ｖ５ */
     zrncreditkaiinnokami6keta ,         /* （連携用）クレジット会員番号（上６桁） */
     zrnyobiv6 ,         /* （連携用）予備項目Ｖ６ */
     zrncreditkaiinnosimo4keta ,         /* （連携用）クレジット会員番号（下４桁） */
     zrnuriageseikyuuerrorcd ,         /* （連携用）売上請求エラーコード */
     zrnhurikaekekkacd ,         /* （連携用）振替結果コード */
     zrnfukusuukameitennokey ,         /* （連携用）複数加盟店番号設定キー情報 */
     zrnyobiv1           /* （連携用）予備項目Ｖ１ */
FROM ZT_UriageKekkaRn_Z;