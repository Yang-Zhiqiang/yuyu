CREATE TABLE ZT_SntkInfoTourokuTy_Z (
     ztysntkinfono                                      VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）選択情報番号 */
     ztyrenno                                           VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）連番 */
     ztysntkinfotourokusyskbn                           VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）選択情報登録システム区分 */
     ztysyoriymd                                        VARCHAR     (8)                                                                 ,  /* （中継用）処理年月日 */
     ztyhuho2kyknokbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）普保Ⅱ契約番号区分 */
     ztyhuho2kykno                                      VARCHAR     (11)                                                                ,  /* （中継用）普保Ⅱ契約番号 */
     ztysyouhncd                                        VARCHAR     (2)                                                                 ,  /* （中継用）商品コード */
     ztysntkinfofsegkbn                                 VARCHAR     (2)                                                                 ,  /* （中継用）選択情報ＦＳＥＧ区分 */
     ztysntkinfofkojinkbn                               VARCHAR     (2)                                                                 ,  /* （中継用）選択情報Ｆ個人区分 */
     ztytaisyounm                                       VARCHAR     (38)                                                                ,  /* （中継用）対象者名 */
     ztykjtaisyounm                                     VARCHAR     (32)                                                                ,  /* （中継用）漢字対象者名 */
     ztytaisyouseiymd                                   VARCHAR     (8)                                                                 ,  /* （中継用）対象者生年月日 */
     ztytaisyouseibetu                                  VARCHAR     (1)                                                                 ,  /* （中継用）対象者性別区分 */
     ztydakuhiketnaiyouarihyj                           VARCHAR     (1)                                                                 ,  /* （中継用）諾否決定内容有表示 */
     ztykktnaiyouarihyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）告知内容有表示 */
     ztykijinaiyouarihyj                                VARCHAR     (1)                                                                 ,  /* （中継用）記事内容有表示 */
     ztymrarihyj                                        VARCHAR     (1)                                                                 ,  /* （中継用）ＭＲ有表示 */
     ztykoudosyougaiarihyj                              VARCHAR     (1)                                                                 ,  /* （中継用）高度障害有表示 */
     ztytorikaijoarihyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）取消解除有表示 */
     ztyskhuseirituhyouji                               VARCHAR     (1)                                                                 ,  /* （中継用）新契約不成立表示 */
     ztysntkinfotourokuyobi01                           VARCHAR     (36)                                                                ,  /* （中継用）選択情報登録予備０１ */
     ztydeckbn                                          VARCHAR     (1)                                                                 ,  /* （中継用）ＤＥＣ区分 */
     ztyketymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）決定年月日 */
     ztyketkekkacd                                      VARCHAR     (2)                                                                 ,  /* （中継用）決定結果コード */
     ztyketriyuucd1                                     VARCHAR     (2)                                                                 ,  /* （中継用）決定理由コード１ */
     ztyketriyuucd2                                     VARCHAR     (2)                                                                 ,  /* （中継用）決定理由コード２ */
     ztyketriyuucd3                                     VARCHAR     (2)                                                                 ,  /* （中継用）決定理由コード３ */
     ztyketriyuucd4                                     VARCHAR     (2)                                                                 ,  /* （中継用）決定理由コード４ */
     ztyketsyacd                                        VARCHAR     (2)                                                                 ,  /* （中継用）決定者コード */
     ztysntkinfotourokuyobi02                           VARCHAR     (29)                                                                ,  /* （中継用）選択情報登録予備０２ */
     ztysntkinfosintyou                                 VARCHAR     (3)                                                                 ,  /* （中継用）選択情報身長 */
     ztysntkinfotaijyuu                                 VARCHAR     (3)                                                                 ,  /* （中継用）選択情報体重 */
     ztykokutiymd                                       VARCHAR     (8)                                                                 ,  /* （中継用）告知年月日 */
     ztysntkinfotourokuyobi03                           VARCHAR     (26)                                                                ,  /* （中継用）選択情報登録予備０３ */
     ztysyoubyoucd1                                     VARCHAR     (6)                                                                 ,  /* （中継用）傷病コード１ */
     ztykantiym1                                        VARCHAR     (6)                                                                 ,  /* （中継用）完治年月１ */
     ztysyoubyoucd2                                     VARCHAR     (6)                                                                 ,  /* （中継用）傷病コード２ */
     ztykantiym2                                        VARCHAR     (6)                                                                 ,  /* （中継用）完治年月２ */
     ztysntkinfotourokuyobi04                           VARCHAR     (26)                                                                ,  /* （中継用）選択情報登録予備０４ */
     ztymrriyuucdkbn                                    VARCHAR     (3)                                                                 ,  /* （中継用）ＭＲ理由コード区分 */
     ztysntkinfotourokuyobi05                           VARCHAR     (17)                                                                ,  /* （中継用）選択情報登録予備０５ */
     ztysntkinfokyktorikesikbn                          VARCHAR     (2)                                                                 ,  /* （中継用）選択情報用契約取消処理区分 */
     ztysntkinfotourokuyobi06                           VARCHAR     (18)                                                                ,  /* （中継用）選択情報登録予備０６ */
     ztykdsssiharaijyoutaikbn                           VARCHAR     (1)                                                                 ,  /* （中継用）高度障害Ｓ支払状態区分 */
     ztykdsssiharaiymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）高度障害Ｓ支払年月日 */
     ztykdsymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）高度障害年月日 */
     ztykdssiharaisosikicd                              VARCHAR     (7)                                                                 ,  /* （中継用）高度障害支払組織コード */
     ztysntkinfotourokuyobi07                           VARCHAR     (26)                                                                ,  /* （中継用）選択情報登録予備０７ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_SntkInfoTourokuTy_Z ADD CONSTRAINT PK_SntkInfoTourokuTy PRIMARY KEY (
     ztysntkinfono                                            , /* （中継用）選択情報番号 */
     ztyrenno                                                 , /* （中継用）連番 */
     ztysntkinfotourokusyskbn                                   /* （中継用）選択情報登録システム区分 */
) ;
