CREATE VIEW ZT_IdCardYakusyokuRn AS SELECT
     zrnidkbn ,         /* （連携用）ＩＤ区分 */
     zrnidcd ,         /* （連携用）ＩＤコード */
     zrnyakusyokuhatureiymd ,         /* （連携用）役職発令年月日 */
     zrnyakusyokuhatureino ,         /* （連携用）役職発令番号 */
     zrnyakusyokuhatureisosikicd ,         /* （連携用）役職発令組織コード */
     zrnyakusyokucd           /* （連携用）役職コード */
FROM ZT_IdCardYakusyokuRn_Z;