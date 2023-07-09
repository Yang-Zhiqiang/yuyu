CREATE TABLE IT_AnsyuCreditCard_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     yukoukachkymd                                      VARCHAR     (8)                                                                 ,  /* 有効性確認日 */
     yuukoukakujkkbn                                    VARCHAR     (1)                                                                 ,  /* 有効性確認状況区分 */
     authorijkkbn                                       VARCHAR     (1)                                                                 ,  /* オーソリ状況区分 */
     authoritrkkbn                                      VARCHAR     (1)                                                                 ,  /* オーソリ登録区分 */
     authorigk                                          DECIMAL     (13)                                                                ,  /* オーソリ金額 */
     authorigk$                                         VARCHAR     (10)                                                                ,  /* オーソリ金額(通貨型) */
     authorikanryoymd                                   VARCHAR     (8)                                                                 ,  /* オーソリ完了日 */
     syouninno                                          VARCHAR     (6)                                                                 ,  /* 承認番号 */
     tanmatusyorino                                     VARCHAR     (7)                                                                 ,  /* 端末処理通番 */
     uriageymd                                          VARCHAR     (8)                                                                 ,  /* 売上日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_AnsyuCreditCard_Z ADD CONSTRAINT PK_AnsyuCreditCard PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_AnsyuCreditCard ON IT_AnsyuCreditCard_Z (
     syono                                                      /* 証券番号 */
) ;
