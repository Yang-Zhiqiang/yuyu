CREATE TABLE HT_MostenkenRireki (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     sateiketsyorinmkbn                                 VARCHAR     (5)                                                                 ,  /* 査定・決定処理名区分 */
     mostenkenkekkakbn                                  VARCHAR     (3)                                                                 ,  /* 申込点検結果区分 */
     tnsketsyacd                                        VARCHAR     (15)                                                                ,  /* 転送先決定者コード */
     ketsyacd                                           VARCHAR     (15)                                                                ,  /* 決定者コード */
     palketsyacd                                        VARCHAR     (2)                                                                 ,  /* ＰＡＬ決定者コード */
     mostenkencomment                                   VARCHAR     (768)                                                               ,  /* 申込点検コメント */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_MostenkenRireki ADD CONSTRAINT PK_MostenkenRireki PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     renno                                                      /* 連番 */
) ;
