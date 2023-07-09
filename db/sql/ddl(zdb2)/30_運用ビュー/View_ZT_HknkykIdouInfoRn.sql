CREATE VIEW ZT_HknkykIdouInfoRn AS SELECT
     zrnkyktuukasyu ,         /* （連携用）契約通貨種類 */
     zrnidouymd ,         /* （連携用）異動日 */
     zrnidoujiyuukbnzfi ,         /* （連携用）異動事由区分（資産運用） */
     zrndatakanrino ,         /* （連携用）データ管理番号 */
     zrnrenno ,         /* （連携用）連番 */
     zrnkeiyakuymd ,         /* （連携用）契約日 */
     zrnhhknnen2 ,         /* （連携用）被保険者年齢Ｃ２ */
     zrnhhknsei ,         /* （連携用）被保険者性別 */
     zrnhknsyukigou ,         /* （連携用）保険種類記号 */
     zrnaisyoumeikbn ,         /* （連携用）愛称名区分 */
     zrnzougenkbn ,         /* （連携用）増減区分 */
     zrnhokenkngk13 ,         /* （連携用）保険金額Ｎ１３ */
     zrnp13 ,         /* （連携用）保険料Ｎ１３ */
     zrnptumitatekin13 ,         /* （連携用）保険料積立金Ｎ１３ */
     zrnkiykhnrikn13 ,         /* （連携用）解約返戻金Ｎ１３ */
     zrnidouhokenkngk ,         /* （連携用）異動保険金額 */
     zrnidoup ,         /* （連携用）異動保険料 */
     zrnidouptumitatekin ,         /* （連携用）異動保険料積立金 */
     zrnidoukiykhnrikn ,         /* （連携用）異動解約返戻金 */
     zrnhknkkn ,         /* （連携用）保険期間 */
     zrnyoteiriritun5 ,         /* （連携用）予定利率Ｎ５ */
     zrntumitatekinkbn           /* （連携用）積立金区分 */
FROM ZT_HknkykIdouInfoRn_Z;