CREATE VIEW ZT_SntkInfoHaneiKekkaTr AS SELECT
     ztrsntkinfono ,         /* （取込用）選択情報番号 */
     ztrrenno ,         /* （取込用）連番 */
     ztrsntkinfotourokusyskbn ,         /* （取込用）選択情報登録システム区分 */
     ztrhuho2kyknokbn ,         /* （取込用）普保Ⅱ契約番号区分 */
     ztrhuho2kykno ,         /* （取込用）普保Ⅱ契約番号 */
     ztrsntkinfofsegkbn ,         /* （取込用）選択情報ＦＳＥＧ区分 */
     ztrsntkinfofkojinkbn ,         /* （取込用）選択情報Ｆ個人区分 */
     ztrdakuhiketnaiyouarihyj ,         /* （取込用）諾否決定内容有表示 */
     ztrkktnaiyouarihyj ,         /* （取込用）告知内容有表示 */
     ztrkijinaiyouarihyj ,         /* （取込用）記事内容有表示 */
     ztrmrarihyj ,         /* （取込用）ＭＲ有表示 */
     ztrkoudosyougaiarihyj ,         /* （取込用）高度障害有表示 */
     ztrtorikaijoarihyj ,         /* （取込用）取消解除有表示 */
     ztrsntkinjotourokuerrkbn ,         /* （取込用）選択情報登録エラー区分 */
     ztrnayosehumeihyj ,         /* （取込用）名寄せ不明表示 */
     ztrsntkinjohaneikekkayobi01 ,         /* （取込用）選択情報反映結果予備０１ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_SntkInfoHaneiKekkaTr_Z;