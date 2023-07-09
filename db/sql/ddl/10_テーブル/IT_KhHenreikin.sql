CREATE TABLE IT_KhHenreikin (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     hrsyuruikbn                                        VARCHAR     (1)                                                                 ,  /* 返戻金種類区分 */
     shrymd                                             VARCHAR     (8)                                                                 ,  /* 支払日 */
     shrsyoriymd                                        VARCHAR     (8)                                                                 ,  /* 支払処理日 */
     hrhsisyoriymd                                      VARCHAR     (8)                                                                 ,  /* 返戻金発生処理日 */
     hrhsiymd                                           VARCHAR     (8)                                                                 ,  /* 返戻金発生日 */
     henreikingk                                        NUMBER      (13)                                                                ,  /* 返戻金額 */
     henreikingk$                                       VARCHAR     (10)                                                                ,  /* 返戻金額(通貨型) */
     hrsiharaijyoutaikbn                                VARCHAR     (1)                                                                 ,  /* 返戻金支払状態区分 */
     seg1cd                                             VARCHAR     (20)                                                                ,  /* セグメント１コード */
     seg2cd                                             VARCHAR     (20)                                                                ,  /* セグメント２コード */
     tantocd                                            VARCHAR     (1)                                                                 ,  /* 担当コード */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KhHenreikin ADD CONSTRAINT PK_KhHenreikin PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                          /* 変更識別キー */
) ;
