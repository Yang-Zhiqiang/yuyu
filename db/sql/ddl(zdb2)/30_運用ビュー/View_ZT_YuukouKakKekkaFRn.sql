CREATE VIEW ZT_YuukouKakKekkaFRn AS SELECT
     zrnrecordkbn ,         /* （連携用）レコード区分 */
     zrnyobiv1 ,         /* （連携用）予備項目Ｖ１ */
     zrncreditkessaiyouno ,         /* （連携用）クレジットカード決済用番号 */
     zrndbkeykugirimoji1 ,         /* （連携用）ＤＢキー区切り文字１ */
     zrndbkeykugirimoji2 ,         /* （連携用）ＤＢキー区切り文字２ */
     zrnyobiv32 ,         /* （連携用）予備項目Ｖ３２ */
     zrncardno ,         /* （連携用）カード番号 */
     zrncardyuukoukigen ,         /* （連携用）カード有効期限 */
     zrnyuukouhanteikekka ,         /* （連携用）有効性判定結果 */
     zrnyobiv59 ,         /* （連携用）予備項目Ｖ５９ */
     zrncreditkigyoucd ,         /* （連携用）クレジット企業コード */
     zrnyobiv53           /* （連携用）予備項目Ｖ５３ */
FROM ZT_YuukouKakKekkaFRn_Z;