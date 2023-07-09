CREATE TABLE HT_KnksateiRireki_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     sateiketsyorinmkbn                                 VARCHAR     (5)                                                                 ,  /* 査定・決定処理名区分 */
     knksateikekkakbn                                   VARCHAR     (3)                                                                 ,  /* 環境査定結果区分 */
     tnsketsyacd                                        VARCHAR     (15)                                                                ,  /* 転送先決定者コード */
     ketsyacd                                           VARCHAR     (15)                                                                ,  /* 決定者コード */
     palketsyacd                                        VARCHAR     (2)                                                                 ,  /* ＰＡＬ決定者コード */
     knksateicomment                                    VARCHAR     (5058)                                                              ,  /* 環境査定コメント */
     ketkekkacd                                         VARCHAR     (2)                                                                 ,  /* 決定結果コード */
     ketriyuucd1                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード１ */
     ketriyuucd2                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード２ */
     ketriyuucd3                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード３ */
     ketriyuucd4                                        VARCHAR     (2)                                                                 ,  /* 決定理由コード４ */
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

ALTER TABLE HT_KnksateiRireki_Z ADD CONSTRAINT PK_KnksateiRireki PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     renno                                                      /* 連番 */
) ;
