CREATE TABLE IT_KhSntkInfoTouroku (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番                                            */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日                                         */
     huho2kykno                                         VARCHAR     (20)                                                                ,  /* 普保Ⅱ契約番号                                       */
     huho2kyknokbn                                      VARCHAR     (1)                                                                 ,  /* 普保Ⅱ契約番号区分                                     */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード                                         */
     sntkinfokankeisyakbn                               VARCHAR     (2)                                                                 ,  /* 選択情報関係者区分                                     */
     taisyounmkn                                        VARCHAR     (18)                                                                ,  /* 対象者氏名（カナ）                                     */
     taisyounmkj                                        VARCHAR     (15)                                                                ,  /* 対象者氏名（漢字）                                     */
     taisyouseiymd                                      VARCHAR     (8)                                                                 ,  /* 対象者生年月日                                       */
     taisyouseibetu                                     VARCHAR     (1)                                                                 ,  /* 対象者性別                                         */
     dakuhiketnaiyouumukbn                              VARCHAR     (1)                                                                 ,  /* 諾否決定内容有無区分                                    */
     kktnaiyouumukbn                                    VARCHAR     (1)                                                                 ,  /* 告知内容有無区分                                      */
     kijinaiyouumukbn                                   VARCHAR     (1)                                                                 ,  /* 記事内容有無区分                                      */
     mrumukbn                                           VARCHAR     (1)                                                                 ,  /* ＭＲ有無区分                                        */
     koudosyougaiumukbn                                 VARCHAR     (1)                                                                 ,  /* 高度障害有無区分                                      */
     torikaijoumukbn                                    VARCHAR     (1)                                                                 ,  /* 取消解除有無区分                                      */
     seiritukbn                                         VARCHAR     (2)                                                                 ,  /* 成立区分                                          */
     deckbn                                             VARCHAR     (1)                                                                 ,  /* ＤＥＣ区分                                         */
     ketymd                                             VARCHAR     (8)                                                                 ,  /* 決定日                                           */
     ketkekkacd                                         VARCHAR     (2)                                                                 ,  /* 決定結果コード                                       */
     ketriyuucd1                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード１                                      */
     ketriyuucd2                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード２                                      */
     ketriyuucd3                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード３                                      */
     ketriyuucd4                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード４                                      */
     ketsyacd                                           VARCHAR     (15)                                                                ,  /* 決定者コード                                        */
     palketsyacd                                        VARCHAR     (2)                                                                 ,  /* ＰＡＬ決定者コード                                     */
     sintyou                                            NUMBER      (3)                                                                 ,  /* 身長                                            */
     taijyuu                                            NUMBER      (3)                                                                 ,  /* 体重                                            */
     kktymd                                             VARCHAR     (8)                                                                 ,  /* 告知日                                           */
     syoubyoucd1                                        VARCHAR     (6)                                                                 ,  /* 傷病コード１                                        */
     syoubyoujyoutaikbn1                                VARCHAR     (1)                                                                 ,  /* 傷病状態区分１                                       */
     kantiym1                                           VARCHAR     (6)                                                                 ,  /* 完治年月１                                         */
     syoubyoucd2                                        VARCHAR     (6)                                                                 ,  /* 傷病コード２                                        */
     syoubyoujyoutaikbn2                                VARCHAR     (1)                                                                 ,  /* 傷病状態区分２                                       */
     kantiym2                                           VARCHAR     (6)                                                                 ,  /* 完治年月２                                         */
     mrriyuucdkbn                                       VARCHAR     (3)                                                                 ,  /* ＭＲ理由コード区分                                     */
     sntkinfokyktorikesikbn                             VARCHAR     (2)                                                                 ,  /* 選択情報用契約取消処理区分                                 */
     syorizumiflg                                       VARCHAR     (1)                                                                 ,  /* 処理済フラグ                                        */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE IT_KhSntkInfoTouroku ADD CONSTRAINT PK_KhSntkInfoTouroku PRIMARY KEY (
     syono                                                    , /* 証券番号                                           */
     renno                                                      /* 連番                                             */
) ;
