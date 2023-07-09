CREATE VIEW ZT_SntkInfoHaneiKekkaRn AS SELECT
     zrnsntkinfono ,         /* （連携用）選択情報番号 */
     zrnrenno ,         /* （連携用）連番 */
     zrnsntkinfotourokusyskbn ,         /* （連携用）選択情報登録システム区分 */
     zrnhuho2kyknokbn ,         /* （連携用）普保Ⅱ契約番号区分 */
     zrnhuho2kykno ,         /* （連携用）普保Ⅱ契約番号 */
     zrnsntkinfofsegkbn ,         /* （連携用）選択情報ＦＳＥＧ区分 */
     zrnsntkinfofkojinkbn ,         /* （連携用）選択情報Ｆ個人区分 */
     zrndakuhiketnaiyouarihyj ,         /* （連携用）諾否決定内容有表示 */
     zrnkktnaiyouarihyj ,         /* （連携用）告知内容有表示 */
     zrnkijinaiyouarihyj ,         /* （連携用）記事内容有表示 */
     zrnmrarihyj ,         /* （連携用）ＭＲ有表示 */
     zrnkoudosyougaiarihyj ,         /* （連携用）高度障害有表示 */
     zrntorikaijoarihyj ,         /* （連携用）取消解除有表示 */
     zrnsntkinjotourokuerrkbn ,         /* （連携用）選択情報登録エラー区分 */
     zrnnayosehumeihyj ,         /* （連携用）名寄せ不明表示 */
     zrnsntkinjohaneikekkayobi01           /* （連携用）選択情報反映結果予備０１ */
FROM ZT_SntkInfoHaneiKekkaRn_Z;