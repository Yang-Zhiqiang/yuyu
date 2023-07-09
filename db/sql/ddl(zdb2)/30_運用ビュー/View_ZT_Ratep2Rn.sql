CREATE VIEW ZT_Ratep2Rn AS SELECT
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
     zrnannaifuyouriyuukbn ,         /* （連携用）案内不要理由区分 */
     zrntuukasyukbn ,         /* （連携用）通貨種類区分 */
     zrndai1hknkkn ,         /* （連携用）第１保険期間 */
     zrnryouritukbn ,         /* （連携用）料率区分 */
     zrnprate ,         /* （連携用）Ｐレート */
     zrnpdatesrate           /* （連携用）Ｐ建Ｓレート */
FROM ZT_Ratep2Rn_Z;