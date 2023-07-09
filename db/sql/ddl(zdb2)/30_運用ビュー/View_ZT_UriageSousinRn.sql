CREATE VIEW ZT_UriageSousinRn AS SELECT
     zrncreditkessaiyouno ,         /* （連携用）クレジットカード決済用番号 */
     zrnauthorikbn ,         /* （連携用）オーソリ区分 */
     zrnuriageseikyuuymd ,         /* （連携用）売上請求年月日 */
     zrnrsgaku ,         /* （連携用）領収金額 */
     zrnfukusuukameitennokey ,         /* （連携用）複数加盟店番号設定キー情報 */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnrecordno ,         /* （連携用）レコード番号 */
     zrnuriagetaisyouym ,         /* （連携用）売上対象年月 */
     zrnyobiv33           /* （連携用）予備項目Ｖ３３ */
FROM ZT_UriageSousinRn_Z;