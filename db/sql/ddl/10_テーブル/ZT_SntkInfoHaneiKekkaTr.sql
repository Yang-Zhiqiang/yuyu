CREATE TABLE ZT_SntkInfoHaneiKekkaTr (
     ztrsntkinfono                                      VARCHAR     (11)                                                      NOT NULL  ,  /* （取込用）選択情報番号 */
     ztrrenno                                           NUMBER      (2)                                                       NOT NULL  ,  /* （取込用）連番 */
     ztrsntkinfotourokusyskbn                           VARCHAR     (1)                                                       NOT NULL  ,  /* （取込用）選択情報登録システム区分 */
     ztrhuho2kyknokbn                                   VARCHAR     (1)                                                                 ,  /* （取込用）普保Ⅱ契約番号区分 */
     ztrhuho2kykno                                      VARCHAR     (11)                                                                ,  /* （取込用）普保Ⅱ契約番号 */
     ztrsntkinfofsegkbn                                 VARCHAR     (2)                                                                 ,  /* （取込用）選択情報ＦＳＥＧ区分 */
     ztrsntkinfofkojinkbn                               VARCHAR     (2)                                                                 ,  /* （取込用）選択情報Ｆ個人区分 */
     ztrdakuhiketnaiyouarihyj                           VARCHAR     (1)                                                                 ,  /* （取込用）諾否決定内容有表示 */
     ztrkktnaiyouarihyj                                 VARCHAR     (1)                                                                 ,  /* （取込用）告知内容有表示 */
     ztrkijinaiyouarihyj                                VARCHAR     (1)                                                                 ,  /* （取込用）記事内容有表示 */
     ztrmrarihyj                                        VARCHAR     (1)                                                                 ,  /* （取込用）ＭＲ有表示 */
     ztrkoudosyougaiarihyj                              VARCHAR     (1)                                                                 ,  /* （取込用）高度障害有表示 */
     ztrtorikaijoarihyj                                 VARCHAR     (1)                                                                 ,  /* （取込用）取消解除有表示 */
     ztrsntkinjotourokuerrkbn                           VARCHAR     (1)                                                                 ,  /* （取込用）選択情報登録エラー区分 */
     ztrnayosehumeihyj                                  VARCHAR     (1)                                                                 ,  /* （取込用）名寄せ不明表示 */
     ztrsntkinjohaneikekkayobi01                        VARCHAR     (22)                                                                ,  /* （取込用）選択情報反映結果予備０１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SntkInfoHaneiKekkaTr ADD CONSTRAINT PK_SntkInfoHaneiKekkaTr PRIMARY KEY (
     ztrsntkinfono                                            , /* （取込用）選択情報番号 */
     ztrrenno                                                 , /* （取込用）連番 */
     ztrsntkinfotourokusyskbn                                   /* （取込用）選択情報登録システム区分 */
) ;
