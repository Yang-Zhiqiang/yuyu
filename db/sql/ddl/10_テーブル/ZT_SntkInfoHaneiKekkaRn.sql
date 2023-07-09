CREATE TABLE ZT_SntkInfoHaneiKekkaRn (
     zrnsntkinfono                                      CHAR        (11)                                                      NOT NULL  ,  /* （連携用）選択情報番号 */
     zrnrenno                                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）連番 */
     zrnsntkinfotourokusyskbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）選択情報登録システム区分 */
     zrnhuho2kyknokbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）普保Ⅱ契約番号区分 */
     zrnhuho2kykno                                      CHAR        (11)                                                      NOT NULL  ,  /* （連携用）普保Ⅱ契約番号 */
     zrnsntkinfofsegkbn                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）選択情報ＦＳＥＧ区分 */
     zrnsntkinfofkojinkbn                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）選択情報Ｆ個人区分 */
     zrndakuhiketnaiyouarihyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）諾否決定内容有表示 */
     zrnkktnaiyouarihyj                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）告知内容有表示 */
     zrnkijinaiyouarihyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）記事内容有表示 */
     zrnmrarihyj                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＭＲ有表示 */
     zrnkoudosyougaiarihyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）高度障害有表示 */
     zrntorikaijoarihyj                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）取消解除有表示 */
     zrnsntkinjotourokuerrkbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）選択情報登録エラー区分 */
     zrnnayosehumeihyj                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）名寄せ不明表示 */
     zrnsntkinjohaneikekkayobi01                        CHAR        (22)                                                      NOT NULL     /* （連携用）選択情報反映結果予備０１ */
)
;

ALTER TABLE ZT_SntkInfoHaneiKekkaRn ADD CONSTRAINT PK_SntkInfoHaneiKekkaRn PRIMARY KEY (
     zrnsntkinfono                                            , /* （連携用）選択情報番号 */
     zrnrenno                                                 , /* （連携用）連番 */
     zrnsntkinfotourokusyskbn                                   /* （連携用）選択情報登録システム区分 */
) ;
