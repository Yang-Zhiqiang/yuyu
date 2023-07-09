CREATE TABLE HT_JidouSyuunouMeisai_Z (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     kessankbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 決算区分 */
     rstuukasyu                                         VARCHAR     (3)                                                       NOT NULL  ,  /* 領収通貨種類 */
     sgittikensuu                                       DECIMAL     (7)                                                                 ,  /* 照合一致件数 */
     sgittigk                                           DECIMAL     (13)                                                                ,  /* 照合一致金額 */
     sgittigk$                                          VARCHAR     (10)                                                                ,  /* 照合一致金額(通貨型) */
     sgittigkyen                                        DECIMAL     (13)                                                                ,  /* 照合一致金額（円） */
     sgittigkyen$                                       VARCHAR     (10)                                                                ,  /* 照合一致金額（円）(通貨型) */
     sghuittikensuu                                     DECIMAL     (7)                                                                 ,  /* 照合不一致件数 */
     sghuittigk                                         DECIMAL     (13)                                                                ,  /* 照合不一致金額 */
     sghuittigk$                                        VARCHAR     (10)                                                                ,  /* 照合不一致金額(通貨型) */
     mostrkskensuu                                      DECIMAL     (7)                                                                 ,  /* 申込取消件数 */
     mostrksgk                                          DECIMAL     (13)                                                                ,  /* 申込取消金額 */
     mostrksgk$                                         VARCHAR     (10)                                                                ,  /* 申込取消金額(通貨型) */
     yuukoukknkeikakensuu                               DECIMAL     (7)                                                                 ,  /* 有効期間経過件数 */
     yuukoukknkeikagk                                   DECIMAL     (13)                                                                ,  /* 有効期間経過金額 */
     yuukoukknkeikagk$                                  VARCHAR     (10)                                                                ,  /* 有効期間経過金額(通貨型) */
     yokukurikosikensuu                                 DECIMAL     (7)                                                                 ,  /* 翌日繰越件数 */
     yokukurikosigk                                     DECIMAL     (13)                                                                ,  /* 翌日繰越金額 */
     yokukurikosigk$                                    VARCHAR     (10)                                                                ,  /* 翌日繰越金額(通貨型) */
     yokukurikosigkyen                                  DECIMAL     (13)                                                                ,  /* 翌日繰越金額（円） */
     yokukurikosigkyen$                                 VARCHAR     (10)                                                                ,  /* 翌日繰越金額（円）(通貨型) */
     jnykntsgkensuu                                     DECIMAL     (7)                                                                 ,  /* 自動入金対象外件数 */
     jnykntsggk                                         DECIMAL     (13)                                                                ,  /* 自動入金対象外金額 */
     jnykntsggk$                                        VARCHAR     (10)                                                                ,  /* 自動入金対象外金額(通貨型) */
     tjkensuu                                           DECIMAL     (7)                                                                 ,  /* 当日件数 */
     tjgk                                               DECIMAL     (13)                                                                ,  /* 当日金額 */
     tjgk$                                              VARCHAR     (10)                                                                ,  /* 当日金額(通貨型) */
     tjgkyen                                            DECIMAL     (13)                                                                ,  /* 当日金額（円） */
     tjgkyen$                                           VARCHAR     (10)                                                                ,  /* 当日金額（円）(通貨型) */
     zenjitukurikosikensuu                              DECIMAL     (7)                                                                 ,  /* 前日繰越件数 */
     zenjitukurikosigk                                  DECIMAL     (13)                                                                ,  /* 前日繰越金額 */
     zenjitukurikosigk$                                 VARCHAR     (10)                                                                ,  /* 前日繰越金額(通貨型) */
     hrkmtsrykensuu                                     DECIMAL     (7)                                                                 ,  /* 振込手数料件数 */
     hrkmtsrykingk                                      DECIMAL     (13)                                                                ,  /* 振込手数料金額 */
     hrkmtsrykingk$                                     VARCHAR     (10)                                                                ,  /* 振込手数料金額(通貨型) */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_JidouSyuunouMeisai_Z ADD CONSTRAINT PK_JidouSyuunouMeisai PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     kessankbn                                                , /* 決算区分 */
     rstuukasyu                                                 /* 領収通貨種類 */
) ;
