CREATE TABLE ST_SkOikmSyukeiPDenpyou_Z (
     densyskbn                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 伝票用システム区分 */
     denrenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 伝票データ連番 */
     edano                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 枝番号 */
     kanjyoukmkcd                                       VARCHAR     (5)                                                                 ,  /* 勘定科目コード */
     taisyakukbn                                        VARCHAR     (1)                                                                 ,  /* 貸借区分 */
     naibukeiyakukbn                                    VARCHAR     (1)                                                                 ,  /* 内部契約区分 */
     tekiyoukbn                                         VARCHAR     (1)                                                                 ,  /* 摘要区分 */
     seg1cd                                             VARCHAR     (20)                                                                ,  /* セグメント１コード */
     huridenatesakicd                                   VARCHAR     (3)                                                                 ,  /* 振替伝票宛先部課コード */
     tantocd                                            VARCHAR     (1)                                                                 ,  /* 担当コード */
     tekiyoucd                                          VARCHAR     (20)                                                                ,  /* 摘要コード */
     suitoubumoncd                                      VARCHAR     (3)                                                                 ,  /* 出納部門コード */
     denyenkagk                                         DECIMAL     (13)                                                                ,  /* 伝票金額（円） */
     denyenkagk$                                        VARCHAR     (10)                                                                ,  /* 伝票金額（円）(通貨型) */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ST_SkOikmSyukeiPDenpyou_Z ADD CONSTRAINT PK_SkOikmSyukeiPDenpyou PRIMARY KEY (
     densyskbn                                                , /* 伝票用システム区分 */
     denrenno                                                 , /* 伝票データ連番 */
     edano                                                      /* 枝番号 */
) ;
