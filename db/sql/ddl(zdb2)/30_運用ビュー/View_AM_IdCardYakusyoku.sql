CREATE VIEW AM_IdCardYakusyoku AS SELECT
     idkbn ,         /* ＩＤ区分 */
     idcd ,         /* ＩＤコード */
     yakusyokuhatureiymd ,         /* 役職発令年月日 */
     yakusyokuhatureino ,         /* 役職発令番号 */
     yakusyokuhatureisosikicd ,         /* 役職発令組織コード */
     yakusyokucd ,         /* 役職コード */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM AM_IdCardYakusyoku_Z;