CREATE TABLE IT_KhShrRireki (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     shrymd                                             VARCHAR     (8)                                                                 ,  /* 支払日 */
     shrsyoriymd                                        VARCHAR     (8)                                                                 ,  /* 支払処理日 */
     shrsyorikbn                                        VARCHAR     (2)                                                                 ,  /* 支払処理区分 */
     torikesiflg                                        VARCHAR     (1)                                                                 ,  /* 取消フラグ */
     torikesiymd                                        VARCHAR     (8)                                                                 ,  /* 取消日 */
     syoruiukeymd                                       VARCHAR     (8)                                                                 ,  /* 書類受付日 */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日 */
     shrtienrskkisanymd                                 VARCHAR     (8)                                                                 ,  /* 支払遅延利息起算日 */
     tienrsknissuu                                      NUMBER      (5)                                                                 ,  /* 遅延利息日数 */
     sinsagendokknkbn                                   VARCHAR     (3)                                                                 ,  /* 審査限度期間区分 */
     rikoukityuutuudannissuu                            NUMBER      (3)                                                                 ,  /* 履行期中断日数 */
     zeitratkikbn                                       VARCHAR     (1)                                                                 ,  /* 税取扱区分 */
     gsbunritaisyou                                     VARCHAR     (1)                                                                 ,  /* 源泉分離課税対象 */
     yenshrtkumu                                        VARCHAR     (1)                                                                 ,  /* 円支払特約有無 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     shrgkkei                                           NUMBER      (13)                                                                ,  /* 支払額合計 */
     shrgkkei$                                          VARCHAR     (10)                                                                ,  /* 支払額合計(通貨型) */
     syushrgkkeisyukbn                                  VARCHAR     (2)                                                                 ,  /* 主たる支払額小計種類区分 */
     syushrgkkei                                        NUMBER      (13)                                                                ,  /* 主たる支払額小計 */
     syushrgkkei$                                       VARCHAR     (10)                                                                ,  /* 主たる支払額小計(通貨型) */
     mikeikap                                           NUMBER      (13)                                                                ,  /* 未経過保険料 */
     mikeikap$                                          VARCHAR     (10)                                                                ,  /* 未経過保険料(通貨型) */
     haitoukin                                          NUMBER      (13)                                                                ,  /* 配当金 */
     haitoukin$                                         VARCHAR     (10)                                                                ,  /* 配当金(通貨型) */
     sonotaseisangk                                     NUMBER      (13)                                                                ,  /* その他精算額 */
     sonotaseisangk$                                    VARCHAR     (10)                                                                ,  /* その他精算額(通貨型) */
     gstszeigk                                          NUMBER      (13)                                                                ,  /* 源泉徴収税額 */
     gstszeigk$                                         VARCHAR     (10)                                                                ,  /* 源泉徴収税額(通貨型) */
     shrtienrsk                                         NUMBER      (13)                                                                ,  /* 支払遅延利息 */
     shrtienrsk$                                        VARCHAR     (10)                                                                ,  /* 支払遅延利息(通貨型) */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     shrtuukashrgkgoukei                                NUMBER      (13)                                                                ,  /* 支払通貨支払額合計 */
     shrtuukashrgkgoukei$                               VARCHAR     (10)                                                                ,  /* 支払通貨支払額合計(通貨型) */
     shrtuukasyushrgkkei                                NUMBER      (13)                                                                ,  /* 支払通貨主たる支払額小計 */
     shrtuukasyushrgkkei$                               VARCHAR     (10)                                                                ,  /* 支払通貨主たる支払額小計(通貨型) */
     shrtuukahaitoukin                                  NUMBER      (13)                                                                ,  /* 支払通貨配当金 */
     shrtuukahaitoukin$                                 VARCHAR     (10)                                                                ,  /* 支払通貨配当金(通貨型) */
     shrtuukasonotaseisangk                             NUMBER      (13)                                                                ,  /* 支払通貨その他精算額 */
     shrtuukasonotaseisangk$                            VARCHAR     (10)                                                                ,  /* 支払通貨その他精算額(通貨型) */
     shrtuukagstszeigk                                  NUMBER      (13)                                                                ,  /* 支払通貨源泉徴収税額 */
     shrtuukagstszeigk$                                 VARCHAR     (10)                                                                ,  /* 支払通貨源泉徴収税額(通貨型) */
     shrtuukashrtienrsk                                 NUMBER      (13)                                                                ,  /* 支払通貨支払遅延利息 */
     shrtuukashrtienrsk$                                VARCHAR     (10)                                                                ,  /* 支払通貨支払遅延利息(通貨型) */
     yenshrgkgoukei                                     NUMBER      (13)                                                                ,  /* 円換算支払額合計 */
     yenshrgkgoukei$                                    VARCHAR     (10)                                                                ,  /* 円換算支払額合計(通貨型) */
     yensyushrgkkei                                     NUMBER      (13)                                                                ,  /* 円換算主たる支払額小計 */
     yensyushrgkkei$                                    VARCHAR     (10)                                                                ,  /* 円換算主たる支払額小計(通貨型) */
     yenkansanhaitoukin                                 NUMBER      (13)                                                                ,  /* 円換算配当金 */
     yenkansanhaitoukin$                                VARCHAR     (10)                                                                ,  /* 円換算配当金(通貨型) */
     yenkansansonotaseisangk                            NUMBER      (13)                                                                ,  /* 円換算その他精算額 */
     yenkansansonotaseisangk$                           VARCHAR     (10)                                                                ,  /* 円換算その他精算額(通貨型) */
     yenmikeikap                                        NUMBER      (10)                                                                ,  /* 円換算未経過保険料 */
     yenmikeikap$                                       VARCHAR     (10)                                                                ,  /* 円換算未経過保険料(通貨型) */
     yengstszeigk                                       NUMBER      (13)                                                                ,  /* 円換算源泉徴収税額 */
     yengstszeigk$                                      VARCHAR     (10)                                                                ,  /* 円換算源泉徴収税額(通貨型) */
     yengstszeigknationaltax                            NUMBER      (13)                                                                ,  /* 円換算源泉徴収税額（国税） */
     yengstszeigknationaltax$                           VARCHAR     (10)                                                                ,  /* 円換算源泉徴収税額（国税）(通貨型) */
     yengstszeigklocaltax                               NUMBER      (13)                                                                ,  /* 円換算源泉徴収税額（地方税） */
     yengstszeigklocaltax$                              VARCHAR     (10)                                                                ,  /* 円換算源泉徴収税額（地方税）(通貨型) */
     nztodouhukencd                                     VARCHAR     (2)                                                                 ,  /* 納税先都道府県コード */
     yenshrtienrsk                                      NUMBER      (13)                                                                ,  /* 円換算支払遅延利息 */
     yenshrtienrsk$                                     VARCHAR     (10)                                                                ,  /* 円換算支払遅延利息(通貨型) */
     htykeihi                                           NUMBER      (13)                                                                ,  /* 必要経費 */
     htykeihi$                                          VARCHAR     (10)                                                                ,  /* 必要経費(通貨型) */
     kztgk                                              NUMBER      (13)                                                                ,  /* 課税対象額 */
     kztgk$                                             VARCHAR     (10)                                                                ,  /* 課税対象額(通貨型) */
     yenhtykeihi                                        NUMBER      (13)                                                                ,  /* 円換算必要経費 */
     yenhtykeihi$                                       VARCHAR     (10)                                                                ,  /* 円換算必要経費(通貨型) */
     yenkztgk                                           NUMBER      (13)                                                                ,  /* 円換算課税対象額 */
     yenkztgk$                                          VARCHAR     (10)                                                                ,  /* 円換算課税対象額(通貨型) */
     shrkwsratekjnymd                                   VARCHAR     (8)                                                                 ,  /* 支払時為替レート基準日 */
     shrkwsrate                                         NUMBER      (7,4)                                                               ,  /* 支払時為替レート */
     zeimukwsratekjnymd                                 VARCHAR     (8)                                                                 ,  /* 税務用為替レート基準日 */
     zeimukwsrate                                       NUMBER      (7,4)                                                               ,  /* 税務用為替レート */
     soukinsakisiteikbn                                 VARCHAR     (1)                                                                 ,  /* 送金先指定区分 */
     soukinsakinmkn                                     VARCHAR     (18)                                                                ,  /* 送金先氏名（カナ） */
     soukinsakinmkj                                     VARCHAR     (15)                                                                ,  /* 送金先氏名（漢字） */
     soukinsakiyno                                      VARCHAR     (7)                                                                 ,  /* 送金先郵便番号 */
     soukinsakiadr1kj                                   VARCHAR     (30)                                                                ,  /* 送金先住所１（漢字） */
     soukinsakiadr2kj                                   VARCHAR     (30)                                                                ,  /* 送金先住所２（漢字） */
     soukinsakiadr3kj                                   VARCHAR     (30)                                                                ,  /* 送金先住所３（漢字） */
     kyksyaszknmkn                                      VARCHAR     (18)                                                                ,  /* 契約者相続人氏名（カナ） */
     kyksyaszknmkj                                      VARCHAR     (15)                                                                ,  /* 契約者相続人氏名（漢字） */
     kyksyaszkyno                                       VARCHAR     (7)                                                                 ,  /* 契約者相続人郵便番号 */
     kyksyaszkadr1kj                                    VARCHAR     (30)                                                                ,  /* 契約者相続人住所１（漢字） */
     kyksyaszkadr2kj                                    VARCHAR     (30)                                                                ,  /* 契約者相続人住所２（漢字） */
     kyksyaszkadr3kj                                    VARCHAR     (30)                                                                ,  /* 契約者相続人住所３（漢字） */
     saikennmkj                                         VARCHAR     (30)                                                                ,  /* 債権者氏名（漢字） */
     saikennyno                                         VARCHAR     (7)                                                                 ,  /* 債権者郵便番号 */
     saikenadr1kj                                       VARCHAR     (30)                                                                ,  /* 債権者住所１（漢字） */
     saikenadr2kj                                       VARCHAR     (30)                                                                ,  /* 債権者住所２（漢字） */
     saikenadr3kj                                       VARCHAR     (30)                                                                ,  /* 債権者住所３（漢字） */
     inputshrhousiteikbn                                VARCHAR     (1)                                                                 ,  /* 入力用支払方法指定区分 */
     shrhousiteikbn                                     VARCHAR     (1)                                                                 ,  /* 支払方法指定区分 */
     kzsyuruikbn                                        VARCHAR     (1)                                                                 ,  /* 口座種類区分 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzdoukbn                                           VARCHAR     (1)                                                                 ,  /* 口座名義人同一区分 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     kykmnmeigibangou                                   VARCHAR     (3)                                                                 ,  /* 契約者ＭＮ名義番号 */
     uktmnmeigibangou                                   VARCHAR     (3)                                                                 ,  /* 受取人ＭＮ名義番号 */
     shrtysysyuruikbn                                   VARCHAR     (3)                                                                 ,  /* 支払調書種類区分 */
     denrenno                                           VARCHAR     (20)                                                                ,  /* 伝票データ連番 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     yenshrkykhtykeihi                                  NUMBER      (13)                                                                ,  /* 円換算支払時契約者必要経費 */
     yenshrkykhtykeihi$                                 VARCHAR     (10)                                                                ,  /* 円換算支払時契約者必要経費(通貨型) */
     kykhnkkaisuu                                       NUMBER      (2)                                                                 ,  /* 契約者変更回数 */
     shrmikeikap                                        NUMBER      (13)                                                                ,  /* 支払通貨未経過保険料 */
     shrmikeikap$                                       VARCHAR     (10)                                                                ,  /* 支払通貨未経過保険料(通貨型) */
     zennomikeikap                                      NUMBER      (13)                                                                ,  /* 前納未経過保険料 */
     zennomikeikap$                                     VARCHAR     (10)                                                                ,  /* 前納未経過保険料(通貨型) */
     shrzennomikeikap                                   NUMBER      (13)                                                                ,  /* 支払通貨前納未経過保険料 */
     shrzennomikeikap$                                  VARCHAR     (10)                                                                ,  /* 支払通貨前納未経過保険料(通貨型) */
     yenzennomikeikap                                   NUMBER      (13)                                                                ,  /* 円換算前納未経過保険料 */
     yenzennomikeikap$                                  VARCHAR     (10)                                                                ,  /* 円換算前納未経過保険料(通貨型) */
     zitkazukarikingksiteituuka                         NUMBER      (13)                                                                ,  /* 税適預り金額（指定通貨） */
     zitkazukarikingksiteituuka$                        VARCHAR     (10)                                                                ,  /* 税適預り金額（指定通貨）(通貨型) */
     zitkazukarikingkyen                                NUMBER      (13)                                                                ,  /* 税適預り金額（円貨） */
     zitkazukarikingkyen$                               VARCHAR     (10)                                                                ,  /* 税適預り金額（円貨）(通貨型) */
     shrazukarikingk                                    NUMBER      (13)                                                                ,  /* 支払通貨預り金額 */
     shrazukarikingk$                                   VARCHAR     (10)                                                                ,  /* 支払通貨預り金額(通貨型) */
     yenazukarikingk                                    NUMBER      (13)                                                                ,  /* 円換算預り金額 */
     yenazukarikingk$                                   VARCHAR     (10)                                                                ,  /* 円換算預り金額(通貨型) */
     sonotahaitoukin                                    NUMBER      (13)                                                                ,  /* その他配当金 */
     sonotahaitoukin$                                   VARCHAR     (10)                                                                ,  /* その他配当金(通貨型) */
     shrtuukasonotahaitoukin                            NUMBER      (13)                                                                ,  /* 支払通貨その他配当金 */
     shrtuukasonotahaitoukin$                           VARCHAR     (10)                                                                ,  /* 支払通貨その他配当金(通貨型) */
     yensonotahaitoukin                                 NUMBER      (13)                                                                ,  /* 円換算その他配当金 */
     yensonotahaitoukin$                                VARCHAR     (10)                                                                ,  /* 円換算その他配当金(通貨型) */
     krkgk                                              NUMBER      (13)                                                                ,  /* 仮受金額 */
     krkgk$                                             VARCHAR     (10)                                                                ,  /* 仮受金額(通貨型) */
     shrkrkgk                                           NUMBER      (13)                                                                ,  /* 支払通貨仮受金額 */
     shrkrkgk$                                          VARCHAR     (10)                                                                ,  /* 支払通貨仮受金額(通貨型) */
     yenkrkgk                                           NUMBER      (13)                                                                ,  /* 円換算仮受金額 */
     yenkrkgk$                                          VARCHAR     (10)                                                                ,  /* 円換算仮受金額(通貨型) */
     zeitekiazukarikinkjumu                             VARCHAR     (1)                                                                 ,  /* 税適預り金計上有無 */
     gaikashrkwsratekjnymd                              VARCHAR     (8)                                                                 ,  /* 外貨支払時為替レート基準日 */
     gaikashrkwsrate                                    NUMBER      (7,4)                                                               ,  /* 外貨支払時為替レート */
     kaiyakuhrkngkkeisiteituuka                         NUMBER      (13)                                                                ,  /* 解約返戻金額合計（指定通貨） */
     kaiyakuhrkngkkeisiteituuka$                        VARCHAR     (10)                                                                ,  /* 解約返戻金額合計（指定通貨）(通貨型) */
     shrtuukakaiyakuhrkngkkei                           NUMBER      (13)                                                                ,  /* 支払通貨解約返戻金額合計 */
     shrtuukakaiyakuhrkngkkei$                          VARCHAR     (10)                                                                ,  /* 支払通貨解約返戻金額合計(通貨型) */
     kaiyakuhrkngkkeiyen                                NUMBER      (13)                                                                ,  /* 解約返戻金額合計（円貨） */
     kaiyakuhrkngkkeiyen$                               VARCHAR     (10)                                                                ,  /* 解約返戻金額合計（円貨）(通貨型) */
     sonotashrkngksiteituuka                            NUMBER      (13)                                                                ,  /* その他支払金額（指定通貨） */
     sonotashrkngksiteituuka$                           VARCHAR     (10)                                                                ,  /* その他支払金額（指定通貨）(通貨型) */
     shrtuukasonotashrkngk                              NUMBER      (13)                                                                ,  /* 支払通貨その他支払金額 */
     shrtuukasonotashrkngk$                             VARCHAR     (10)                                                                ,  /* 支払通貨その他支払金額(通貨型) */
     sonotashrkngkyen                                   NUMBER      (13)                                                                ,  /* その他支払金額（円貨） */
     sonotashrkngkyen$                                  VARCHAR     (10)                                                                ,  /* その他支払金額（円貨）(通貨型) */
     yensynykngk                                        NUMBER      (13)                                                                ,  /* 円換算収入金額 */
     yensynykngk$                                       VARCHAR     (10)                                                                ,  /* 円換算収入金額(通貨型) */
     shrtysykurikosiyouhi                               VARCHAR     (1)                                                                    /* 支払調書繰越要否 */
)
;

ALTER TABLE IT_KhShrRireki ADD CONSTRAINT PK_KhShrRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                          /* 変更識別キー */
) ;

CREATE INDEX IX1_KhShrRireki ON IT_KhShrRireki (
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                          /* 変更識別キー */
) ;

CREATE INDEX IX2_KhShrRireki ON IT_KhShrRireki (
     shrsyorikbn                                              , /* 支払処理区分 */
     kouryokuhasseiymd                                          /* 効力発生日 */
) ;

CREATE INDEX IX3_KhShrRireki ON IT_KhShrRireki (
     shrsyorikbn                                              , /* 支払処理区分 */
     shrsyoriymd                                                /* 支払処理日 */
) ;
