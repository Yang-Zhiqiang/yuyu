CREATE VIEW ZT_RatepRn AS SELECT
     zrnhknsyukigou ,         /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn ,         /* （連携用）保険種類記号世代区分 */
     zrnyoteiriritu ,         /* （連携用）予定利率 */
     zrnpmenkbn ,         /* （連携用）Ｐ免区分 */
     zrnhrkkaisuukbn ,         /* （連携用）払込回数区分 */
     zrnhhknsei ,         /* （連携用）被保険者性別 */
     zrnkeiyakujihhknnen ,         /* （連携用）契約時被保険者年令 */
     zrnsaimnkkykhyj ,         /* （連携用）才満期契約表示 */
     zrnhknkkn ,         /* （連携用）保険期間 */
     zrnphrkkikn ,         /* （連携用）Ｐ払込期間 */
     zrnprate ,         /* （連携用）Ｐレート */
     zrnpdatesrate           /* （連携用）Ｐ建Ｓレート */
FROM ZT_RatepRn_Z;