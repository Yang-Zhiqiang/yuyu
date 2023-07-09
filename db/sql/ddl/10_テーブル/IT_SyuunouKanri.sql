CREATE TABLE IT_SyuunouKanri (
     syuudaikocd                                        VARCHAR     (2)                                                       NOT NULL  ,  /* 収納代行社コード */
     hurikaeymd                                         VARCHAR     (8)                                                       NOT NULL  ,  /* 振替日 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     annaikensuu                                        NUMBER      (8)                                                                 ,  /* 案内件数 */
     annaigk                                            NUMBER      (13)                                                                ,  /* 案内金額 */
     annaigk$                                           VARCHAR     (10)                                                                ,  /* 案内金額(通貨型) */
     hurizumikensuu                                     NUMBER      (8)                                                                 ,  /* 振替済件数 */
     hurizumigk                                         NUMBER      (13)                                                                ,  /* 振替済金額 */
     hurizumigk$                                        VARCHAR     (10)                                                                ,  /* 振替済金額(通貨型) */
     hurihunokensuu                                     NUMBER      (8)                                                                 ,  /* 振替不能件数 */
     hurihunogk                                         NUMBER      (13)                                                                ,  /* 振替不能金額 */
     hurihunogk$                                        VARCHAR     (10)                                                                ,  /* 振替不能金額(通貨型) */
     syuunousyoriymd                                    VARCHAR     (8)                                                                 ,  /* 収納処理日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_SyuunouKanri ADD CONSTRAINT PK_SyuunouKanri PRIMARY KEY (
     syuudaikocd                                              , /* 収納代行社コード */
     hurikaeymd                                                 /* 振替日 */
) ;
