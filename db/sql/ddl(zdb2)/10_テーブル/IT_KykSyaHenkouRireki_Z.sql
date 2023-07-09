CREATE TABLE IT_KykSyaHenkouRireki_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     meighnksyoriymd                                    VARCHAR     (8)                                                                 ,  /* 名義変更処理年月日 */
     meigihnkjiyuu                                      VARCHAR     (1)                                                                 ,  /* 名義変更事由 */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日 */
     oldkyksibouymd                                     VARCHAR     (8)                                                                 ,  /* （旧）契約者死亡日 */
     oldkyknmkn                                         VARCHAR     (38)                                                                ,  /* （旧）契約者名（カナ） */
     oldkyknmkj                                         VARCHAR     (32)                                                                ,  /* （旧）契約者名（漢字） */
     oldkyknmkjkhukakbn                                 VARCHAR     (1)                                                                 ,  /* （旧）契約者名漢字化不可区分 */
     oldkykseiymd                                       VARCHAR     (8)                                                                 ,  /* （旧）契約者生年月日 */
     oldkyksei                                          VARCHAR     (1)                                                                 ,  /* （旧）契約者性別 */
     oldkkkyktdk                                        VARCHAR     (2)                                                                 ,  /* （旧）契約管理契約者続柄 */
     oldtsinyno                                         VARCHAR     (7)                                                                 ,  /* （旧）通信先郵便番号 */
     oldtsinadr1kj                                      VARCHAR     (62)                                                                ,  /* （旧）通信先住所１（漢字） */
     oldtsinadr2kj                                      VARCHAR     (62)                                                                ,  /* （旧）通信先住所２（漢字） */
     oldtsinadr3kj                                      VARCHAR     (62)                                                                ,  /* （旧）通信先住所３（漢字） */
     oldtsintelno                                       VARCHAR     (14)                                                                ,  /* （旧）通信先電話番号 */
     olddai2tsintelno                                   VARCHAR     (14)                                                                ,  /* （旧）第２通信先電話番号 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所３（漢字） */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     dai2tsintelno                                      VARCHAR     (14)                                                                ,  /* 第２通信先電話番号 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     kaiyakuhrstgk                                      VARCHAR     (13)                                                                ,  /* 解約返戻金相当額 */
     kaiyakuhrstgk$                                     VARCHAR     (10)                                                                ,  /* 解約返戻金相当額(通貨型) */
     yenkaiyakuhrstgk                                   VARCHAR     (13)                                                                ,  /* 円換算解約返戻金相当額 */
     yenkaiyakuhrstgk$                                  VARCHAR     (10)                                                                ,  /* 円換算解約返戻金相当額(通貨型) */
     yenkansantkykwsrate                                DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート */
     yenkansantkykwsrateymd                             VARCHAR     (8)                                                                 ,  /* 円換算適用為替レート基準日 */
     kihrkmpsgk                                         VARCHAR     (13)                                                                ,  /* 既払込保険料総額 */
     kihrkmpsgk$                                        VARCHAR     (10)                                                                ,  /* 既払込保険料総額(通貨型) */
     oldkykkihrkmp                                      VARCHAR     (13)                                                                ,  /* （旧）契約者既払込保険料 */
     oldkykkihrkmp$                                     VARCHAR     (10)                                                                ,  /* （旧）契約者既払込保険料(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     sonotashrkngkyen                                   DECIMAL     (13)                                                                ,  /* その他支払金額（円貨） */
     sonotashrkngkyen$                                  VARCHAR     (10)                                                                   /* その他支払金額（円貨）(通貨型) */
)
;

ALTER TABLE IT_KykSyaHenkouRireki_Z ADD CONSTRAINT PK_KykSyaHenkouRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                          /* 変更識別キー */
) ;
