CREATE TABLE IT_BAK_PMinyuuSyoumetuInfo (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     syoriym                                            VARCHAR     (6)                                                                 ,  /* 処理年月 */
     syoumetuymd                                        VARCHAR     (8)                                                                 ,  /* 消滅日 */
     jidousoukinhukariyuu                               VARCHAR     (2)                                                                 ,  /* 自動送金不可理由 */
     ttdktyuuihanteikekka                               VARCHAR     (1)                                                                 ,  /* 手続注意判定結果 */
     stknsetkbn                                         VARCHAR     (1)                                                                 ,  /* 質権設定区分 */
     shrgkkei                                           NUMBER      (13)                                                                ,  /* 支払額合計 */
     shrgkkei$                                          VARCHAR     (10)                                                                ,  /* 支払額合計(通貨型) */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     shrkwsrate                                         NUMBER      (7,4)                                                               ,  /* 支払時為替レート */
     shrtuukakaiyakuhrkngkkei                           NUMBER      (13)                                                                ,  /* 支払通貨解約返戻金額合計 */
     shrtuukakaiyakuhrkngkkei$                          VARCHAR     (10)                                                                ,  /* 支払通貨解約返戻金額合計(通貨型) */
     kaiyakuhrkngkkeisiteituuka                         NUMBER      (13)                                                                ,  /* 解約返戻金額合計（指定通貨） */
     kaiyakuhrkngkkeisiteituuka$                        VARCHAR     (10)                                                                ,  /* 解約返戻金額合計（指定通貨）(通貨型) */
     sonotaseisan                                       NUMBER      (13)                                                                ,  /* その他精算金 */
     sonotaseisan$                                      VARCHAR     (10)                                                                ,  /* その他精算金(通貨型) */
     yenkansanhaitoukin                                 NUMBER      (13)                                                                ,  /* 円換算配当金 */
     yenkansanhaitoukin$                                VARCHAR     (10)                                                                ,  /* 円換算配当金(通貨型) */
     yensonotahaitoukin                                 NUMBER      (13)                                                                ,  /* 円換算その他配当金 */
     yensonotahaitoukin$                                VARCHAR     (10)                                                                ,  /* 円換算その他配当金(通貨型) */
     shrtuukagstszeigk                                  NUMBER      (13)                                                                ,  /* 支払通貨源泉徴収税額 */
     shrtuukagstszeigk$                                 VARCHAR     (10)                                                                ,  /* 支払通貨源泉徴収税額(通貨型) */
     zitkazukarikingksiteituuka                         NUMBER      (13)                                                                ,  /* 税適預り金額（指定通貨） */
     zitkazukarikingksiteituuka$                        VARCHAR     (10)                                                                ,  /* 税適預り金額（指定通貨）(通貨型) */
     zitkazukarikingkyen                                NUMBER      (13)                                                                ,  /* 税適預り金額（円貨） */
     zitkazukarikingkyen$                               VARCHAR     (10)                                                                ,  /* 税適預り金額（円貨）(通貨型) */
     kaiyakuhrknsiteituuka                              NUMBER      (13)                                                                ,  /* 解約返戻金（指定通貨） */
     kaiyakuhrknsiteituuka$                             VARCHAR     (10)                                                                ,  /* 解約返戻金（指定通貨）(通貨型) */
     kaiyakuhryen                                       NUMBER      (13)                                                                ,  /* 解約返戻金（円貨） */
     kaiyakuhryen$                                      VARCHAR     (10)                                                                ,  /* 解約返戻金（円貨）(通貨型) */
     yenkrkgk                                           NUMBER      (13)                                                                ,  /* 円換算仮受金額 */
     yenkrkgk$                                          VARCHAR     (10)                                                                ,  /* 円換算仮受金額(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_BAK_PMinyuuSyoumetuInfo ADD CONSTRAINT PK_BAK_PMinyuuSyoumetuInfo PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                            /* 取消識別キー */
) ;
