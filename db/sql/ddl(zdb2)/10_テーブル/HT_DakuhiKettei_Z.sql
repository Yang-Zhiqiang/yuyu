CREATE TABLE HT_DakuhiKettei_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     dakuhiktrenno                                      DECIMAL     (2)                                                       NOT NULL  ,  /* 諾否決定連番 */
     ketymd                                             VARCHAR     (8)                                                                 ,  /* 決定日 */
     dakuhiktbunruikbn                                  VARCHAR     (1)                                                                 ,  /* 諾否決定分類区分 */
     ketkekkacd                                         VARCHAR     (2)                                                                 ,  /* 決定結果コード */
     ketriyuucd1                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード１ */
     ketriyuucd2                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード２ */
     ketriyuucd3                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード３ */
     ketriyuucd4                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード４ */
     syoubyoucd1                                        VARCHAR     (6)                                                                 ,  /* 傷病コード１ */
     syoubyoujyoutaikbn1                                VARCHAR     (1)                                                                 ,  /* 傷病状態区分１ */
     kantiym1                                           VARCHAR     (6)                                                                 ,  /* 完治年月１ */
     syoubyoucd2                                        VARCHAR     (6)                                                                 ,  /* 傷病コード２ */
     syoubyoujyoutaikbn2                                VARCHAR     (1)                                                                 ,  /* 傷病状態区分２ */
     kantiym2                                           VARCHAR     (6)                                                                 ,  /* 完治年月２ */
     ketsyacd                                           VARCHAR     (15)                                                                ,  /* 決定者コード */
     palketsyacd                                        VARCHAR     (2)                                                                 ,  /* ＰＡＬ決定者コード */
     tkjysydkno                                         DECIMAL     (2)                                                                 ,  /* 特条承諾番号 */
     tkjysydkymd                                        VARCHAR     (8)                                                                 ,  /* 特条条件付承諾日 */
     tkjysydksyhykbn                                    VARCHAR     (1)                                                                 ,  /* 特条承諾書不要区分 */
     sntkinfosakuseiyhkbn                               VARCHAR     (1)                                                                 ,  /* 選択情報作成要否区分 */
     mrriyuucdkbn                                       VARCHAR     (3)                                                                 ,  /* ＭＲ理由コード区分 */
     torikesisyousairiyuucd                             VARCHAR     (2)                                                                 ,  /* 取消詳細理由コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_DakuhiKettei_Z ADD CONSTRAINT PK_DakuhiKettei PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     dakuhiktrenno                                              /* 諾否決定連番 */
) ;
