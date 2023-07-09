CREATE TABLE IT_BAK_KhHasseijiKazeiRireki (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     hasseijikazeisyorikbn                              VARCHAR     (2)                                                                 ,  /* 発生時課税処理区分 */
     torikesiflg                                        VARCHAR     (1)                                                                 ,  /* 取消フラグ */
     torikesiymd                                        VARCHAR     (8)                                                                 ,  /* 取消日 */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日 */
     zeitratkikbn                                       VARCHAR     (1)                                                                 ,  /* 税取扱区分 */
     gsbunritaisyou                                     VARCHAR     (1)                                                                 ,  /* 源泉分離課税対象 */
     hasseijikngksyuruikbn                              VARCHAR     (1)                                                                 ,  /* 発生時金額種類区分 */
     hasseijikngk                                       NUMBER      (13)                                                                ,  /* 発生時金額 */
     hasseijikngk$                                      VARCHAR     (10)                                                                ,  /* 発生時金額(通貨型) */
     hasseijigstszeigk                                  NUMBER      (13)                                                                ,  /* 発生時源泉徴収税額 */
     hasseijigstszeigk$                                 VARCHAR     (10)                                                                ,  /* 発生時源泉徴収税額(通貨型) */
     yenkansangkgoukei                                  NUMBER      (13)                                                                ,  /* 円換算額合計 */
     yenkansangkgoukei$                                 VARCHAR     (10)                                                                ,  /* 円換算額合計(通貨型) */
     yenkansansyukngkgoukei                             NUMBER      (13)                                                                ,  /* 円換算主たる金額小計 */
     yenkansansyukngkgoukei$                            VARCHAR     (10)                                                                ,  /* 円換算主たる金額小計(通貨型) */
     yengstszeigk                                       NUMBER      (13)                                                                ,  /* 円換算源泉徴収税額 */
     yengstszeigk$                                      VARCHAR     (10)                                                                ,  /* 円換算源泉徴収税額(通貨型) */
     yengstszeigknationaltax                            NUMBER      (13)                                                                ,  /* 円換算源泉徴収税額（国税） */
     yengstszeigknationaltax$                           VARCHAR     (10)                                                                ,  /* 円換算源泉徴収税額（国税）(通貨型) */
     yengstszeigklocaltax                               NUMBER      (13)                                                                ,  /* 円換算源泉徴収税額（地方税） */
     yengstszeigklocaltax$                              VARCHAR     (10)                                                                ,  /* 円換算源泉徴収税額（地方税）(通貨型) */
     nztodouhukencd                                     VARCHAR     (2)                                                                 ,  /* 納税先都道府県コード */
     htykeihi                                           NUMBER      (13)                                                                ,  /* 必要経費 */
     htykeihi$                                          VARCHAR     (10)                                                                ,  /* 必要経費(通貨型) */
     kztgk                                              NUMBER      (13)                                                                ,  /* 課税対象額 */
     kztgk$                                             VARCHAR     (10)                                                                ,  /* 課税対象額(通貨型) */
     yenhtykeihi                                        NUMBER      (13)                                                                ,  /* 円換算必要経費 */
     yenhtykeihi$                                       VARCHAR     (10)                                                                ,  /* 円換算必要経費(通貨型) */
     yenkztgk                                           NUMBER      (13)                                                                ,  /* 円換算課税対象額 */
     yenkztgk$                                          VARCHAR     (10)                                                                ,  /* 円換算課税対象額(通貨型) */
     zeimukwsratekjnymd                                 VARCHAR     (8)                                                                 ,  /* 税務用為替レート基準日 */
     zeimukwsrate                                       NUMBER      (7,4)                                                               ,  /* 税務用為替レート */
     kyknmkn                                            VARCHAR     (18)                                                                ,  /* 契約者名（カナ） */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字） */
     kykyno                                             VARCHAR     (7)                                                                 ,  /* 契約者郵便番号 */
     kykadr1kj                                          VARCHAR     (30)                                                                ,  /* 契約者住所１（漢字） */
     kykadr2kj                                          VARCHAR     (30)                                                                ,  /* 契約者住所２（漢字） */
     kykadr3kj                                          VARCHAR     (30)                                                                ,  /* 契約者住所３（漢字） */
     kykmnmeigibangou                                   VARCHAR     (3)                                                                 ,  /* 契約者ＭＮ名義番号 */
     uktmnmeigibangou                                   VARCHAR     (3)                                                                 ,  /* 受取人ＭＮ名義番号 */
     shrtysysyuruikbn                                   VARCHAR     (3)                                                                 ,  /* 支払調書種類区分 */
     yenshrkykhtykeihi                                  NUMBER      (13)                                                                ,  /* 円換算支払時契約者必要経費 */
     yenshrkykhtykeihi$                                 VARCHAR     (10)                                                                ,  /* 円換算支払時契約者必要経費(通貨型) */
     kykhnkkaisuu                                       NUMBER      (2)                                                                 ,  /* 契約者変更回数 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_BAK_KhHasseijiKazeiRireki ADD CONSTRAINT PK_BAK_KhHasseijiKazeiRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     henkousikibetukey                                          /* 変更識別キー */
) ;
