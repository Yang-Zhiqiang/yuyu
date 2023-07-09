CREATE TABLE HT_JidouSyuunouMeisai (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     kessankbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 決算区分 */
     rstuukasyu                                         VARCHAR     (3)                                                       NOT NULL  ,  /* 領収通貨種類 */
     sgittikensuu                                       NUMBER      (7)                                                                 ,  /* 照合一致件数 */
     sgittigk                                           NUMBER      (13)                                                                ,  /* 照合一致金額 */
     sgittigk$                                          VARCHAR     (10)                                                                ,  /* 照合一致金額(通貨型) */
     sgittigkyen                                        NUMBER      (13)                                                                ,  /* 照合一致金額（円） */
     sgittigkyen$                                       VARCHAR     (10)                                                                ,  /* 照合一致金額（円）(通貨型) */
     sghuittikensuu                                     NUMBER      (7)                                                                 ,  /* 照合不一致件数 */
     sghuittigk                                         NUMBER      (13)                                                                ,  /* 照合不一致金額 */
     sghuittigk$                                        VARCHAR     (10)                                                                ,  /* 照合不一致金額(通貨型) */
     mostrkskensuu                                      NUMBER      (7)                                                                 ,  /* 申込取消件数 */
     mostrksgk                                          NUMBER      (13)                                                                ,  /* 申込取消金額 */
     mostrksgk$                                         VARCHAR     (10)                                                                ,  /* 申込取消金額(通貨型) */
     yuukoukknkeikakensuu                               NUMBER      (7)                                                                 ,  /* 有効期間経過件数 */
     yuukoukknkeikagk                                   NUMBER      (13)                                                                ,  /* 有効期間経過金額 */
     yuukoukknkeikagk$                                  VARCHAR     (10)                                                                ,  /* 有効期間経過金額(通貨型) */
     yokukurikosikensuu                                 NUMBER      (7)                                                                 ,  /* 翌日繰越件数 */
     yokukurikosigk                                     NUMBER      (13)                                                                ,  /* 翌日繰越金額 */
     yokukurikosigk$                                    VARCHAR     (10)                                                                ,  /* 翌日繰越金額(通貨型) */
     yokukurikosigkyen                                  NUMBER      (13)                                                                ,  /* 翌日繰越金額（円） */
     yokukurikosigkyen$                                 VARCHAR     (10)                                                                ,  /* 翌日繰越金額（円）(通貨型) */
     jnykntsgkensuu                                     NUMBER      (7)                                                                 ,  /* 自動入金対象外件数 */
     jnykntsggk                                         NUMBER      (13)                                                                ,  /* 自動入金対象外金額 */
     jnykntsggk$                                        VARCHAR     (10)                                                                ,  /* 自動入金対象外金額(通貨型) */
     tjkensuu                                           NUMBER      (7)                                                                 ,  /* 当日件数 */
     tjgk                                               NUMBER      (13)                                                                ,  /* 当日金額 */
     tjgk$                                              VARCHAR     (10)                                                                ,  /* 当日金額(通貨型) */
     tjgkyen                                            NUMBER      (13)                                                                ,  /* 当日金額（円） */
     tjgkyen$                                           VARCHAR     (10)                                                                ,  /* 当日金額（円）(通貨型) */
     zenjitukurikosikensuu                              NUMBER      (7)                                                                 ,  /* 前日繰越件数 */
     zenjitukurikosigk                                  NUMBER      (13)                                                                ,  /* 前日繰越金額 */
     zenjitukurikosigk$                                 VARCHAR     (10)                                                                ,  /* 前日繰越金額(通貨型) */
     hrkmtsrykensuu                                     NUMBER      (7)                                                                 ,  /* 振込手数料件数 */
     hrkmtsrykingk                                      NUMBER      (13)                                                                ,  /* 振込手数料金額 */
     hrkmtsrykingk$                                     VARCHAR     (10)                                                                ,  /* 振込手数料金額(通貨型) */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_JidouSyuunouMeisai ADD CONSTRAINT PK_JidouSyuunouMeisai PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     kessankbn                                                , /* 決算区分 */
     rstuukasyu                                                 /* 領収通貨種類 */
) ;
