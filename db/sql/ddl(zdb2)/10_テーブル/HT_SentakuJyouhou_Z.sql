CREATE TABLE HT_SentakuJyouhou_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     sntkinfotaisyousyakbn                              VARCHAR     (1)                                                       NOT NULL  ,  /* 選択情報対象者区分 */
     edano                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 枝番号 */
     sntkinfono                                         VARCHAR     (11)                                                      NOT NULL  ,  /* 選択情報番号 */
     syscdkbn                                           VARCHAR     (4)                                                                 ,  /* システムコード区分 */
     sntkinfokankeisyakbn                               VARCHAR     (2)                                                                 ,  /* 選択情報関係者区分 */
     sntkinfofkojinkbn                                  VARCHAR     (2)                                                                 ,  /* 選択情報Ｆ個人区分 */
     sntkinfokbn                                        VARCHAR     (2)                                                                 ,  /* 選択情報区分 */
     sntkinfosakuseiymd                                 VARCHAR     (8)                                                                 ,  /* 選択情報作成日 */
     mrumukbn                                           VARCHAR     (1)                                                                 ,  /* ＭＲ有無区分 */
     decumukbn                                          VARCHAR     (1)                                                                 ,  /* ＤＥＣ有無区分 */
     infokoukanumukbn                                   VARCHAR     (1)                                                                 ,  /* 情報交換有無区分 */
     nyuuinkyhkshrumukbn                                VARCHAR     (1)                                                                 ,  /* 入院給付金支払有無区分 */
     syujyutukyhkshrumukbn                              VARCHAR     (1)                                                                 ,  /* 手術給付金支払有無区分 */
     syougaikyhkshrumukbn                               VARCHAR     (1)                                                                 ,  /* 障害給付金支払有無区分 */
     koudosyougaiumukbn                                 VARCHAR     (1)                                                                 ,  /* 高度障害有無区分 */
     pmenumukbn                                         VARCHAR     (1)                                                                 ,  /* Ｐ免有無区分 */
     torikaijoumukbn                                    VARCHAR     (1)                                                                 ,  /* 取消解除有無区分 */
     soukikeakyhkshrumukbn                              VARCHAR     (1)                                                                 ,  /* 早期ケア給付金支払有無区分 */
     sonotakyhkshrumukbn                                VARCHAR     (1)                                                                 ,  /* その他給付金支払有無区分 */
     kghsjjtkyhkshrumukbn                               VARCHAR     (1)                                                                 ,  /* 介護保障充実給付金支払有無区分 */
     huho2mrumukbn                                      VARCHAR     (1)                                                                 ,  /* 普保ⅡＭＲ有無区分 */
     huho2decumukbn                                     VARCHAR     (1)                                                                 ,  /* 普保ⅡＤＥＣ有無区分 */
     huho2kdumukbn                                      VARCHAR     (1)                                                                 ,  /* 普保Ⅱ高度障害有無区分 */
     huho2torikaijoumukbn                               VARCHAR     (1)                                                                 ,  /* 普保Ⅱ取消解除有無区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_SentakuJyouhou_Z ADD CONSTRAINT PK_SentakuJyouhou PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     sntkinfotaisyousyakbn                                    , /* 選択情報対象者区分 */
     edano                                                    , /* 枝番号 */
     sntkinfono                                                 /* 選択情報番号 */
) ;
