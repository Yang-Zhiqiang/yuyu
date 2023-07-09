CREATE TABLE ZT_SntkInfoTourokuRn (
     zrnsntkinfono                                      CHAR        (11)                                                      NOT NULL  ,  /* （連携用）選択情報番号 */
     zrnrenno                                           CHAR        (2)                                                       NOT NULL  ,  /* （連携用）連番 */
     zrnsntkinfotourokusyskbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）選択情報登録システム区分 */
     zrnsyoriymd                                        CHAR        (8)                                                       NOT NULL  ,  /* （連携用）処理年月日 */
     zrnhuho2kyknokbn                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）普保Ⅱ契約番号区分 */
     zrnhuho2kykno                                      CHAR        (11)                                                      NOT NULL  ,  /* （連携用）普保Ⅱ契約番号 */
     zrnsyouhncd                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）商品コード */
     zrnsntkinfofsegkbn                                 CHAR        (2)                                                       NOT NULL  ,  /* （連携用）選択情報ＦＳＥＧ区分 */
     zrnsntkinfofkojinkbn                               CHAR        (2)                                                       NOT NULL  ,  /* （連携用）選択情報Ｆ個人区分 */
     zrntaisyounm                                       CHAR        (18)                                                      NOT NULL  ,  /* （連携用）対象者姓名 */
     zrnkjtaisyounm                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）対象者漢字姓名 */
     zrntaisyouseiymd                                   CHAR        (8)                                                       NOT NULL  ,  /* （連携用）対象者生年月日 */
     zrntaisyouseibetu                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）対象者性別区分 */
     zrndakuhiketnaiyouarihyj                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）諾否決定内容有表示 */
     zrnkktnaiyouarihyj                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）告知内容有表示 */
     zrnkijinaiyouarihyj                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）記事内容有表示 */
     zrnmrarihyj                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＭＲ有表示 */
     zrnkoudosyougaiarihyj                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）高度障害有表示 */
     zrntorikaijoarihyj                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）取消解除有表示 */
     zrnskhuseirituhyouji                               CHAR        (1)                                                       NOT NULL  ,  /* （連携用）新契約不成立表示 */
     zrnsntkinfotourokuyobi01                           CHAR        (36)                                                      NOT NULL  ,  /* （連携用）選択情報登録予備０１ */
     zrndeckbn                                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＤＥＣ区分 */
     zrnketymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）決定年月日 */
     zrnketkekkacd                                      CHAR        (2)                                                       NOT NULL  ,  /* （連携用）決定結果コード */
     zrnketriyuucd1                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）決定理由コード１ */
     zrnketriyuucd2                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）決定理由コード２ */
     zrnketriyuucd3                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）決定理由コード３ */
     zrnketriyuucd4                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）決定理由コード４ */
     zrnketsyacd                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）決定者コード */
     zrnsntkinfotourokuyobi02                           CHAR        (29)                                                      NOT NULL  ,  /* （連携用）選択情報登録予備０２ */
     zrnsntkinfosintyou                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）選択情報身長 */
     zrnsntkinfotaijyuu                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）選択情報体重 */
     zrnkokutiymd                                       CHAR        (8)                                                       NOT NULL  ,  /* （連携用）告知年月日 */
     zrnsntkinfotourokuyobi03                           CHAR        (26)                                                      NOT NULL  ,  /* （連携用）選択情報登録予備０３ */
     zrnsyoubyoucd1                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）傷病コード１ */
     zrnkantiym1                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）完治年月１ */
     zrnsyoubyoucd2                                     CHAR        (6)                                                       NOT NULL  ,  /* （連携用）傷病コード２ */
     zrnkantiym2                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）完治年月２ */
     zrnsntkinfotourokuyobi04                           CHAR        (26)                                                      NOT NULL  ,  /* （連携用）選択情報登録予備０４ */
     zrnmrriyuucdkbn                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）ＭＲ理由コード区分 */
     zrnsntkinfotourokuyobi05                           CHAR        (17)                                                      NOT NULL  ,  /* （連携用）選択情報登録予備０５ */
     zrnsntkinfokyktorikesikbn                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）選択情報用契約取消処理区分 */
     zrnsntkinfotourokuyobi06                           CHAR        (18)                                                      NOT NULL  ,  /* （連携用）選択情報登録予備０６ */
     zrnkdsssiharaijyoutaikbn                           CHAR        (1)                                                       NOT NULL  ,  /* （連携用）高度障害Ｓ支払状態区分 */
     zrnkdsssiharaiymd                                  CHAR        (8)                                                       NOT NULL  ,  /* （連携用）高度障害Ｓ支払年月日 */
     zrnkdsymd                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）高度障害年月日 */
     zrnkdssiharaisosikicd                              CHAR        (7)                                                       NOT NULL  ,  /* （連携用）高度障害支払組織コード */
     zrnsntkinfotourokuyobi07                           CHAR        (26)                                                      NOT NULL     /* （連携用）選択情報登録予備０７ */
)
;

ALTER TABLE ZT_SntkInfoTourokuRn ADD CONSTRAINT PK_SntkInfoTourokuRn PRIMARY KEY (
     zrnsntkinfono                                            , /* （連携用）選択情報番号 */
     zrnrenno                                                 , /* （連携用）連番 */
     zrnsntkinfotourokusyskbn                                   /* （連携用）選択情報登録システム区分 */
) ;
