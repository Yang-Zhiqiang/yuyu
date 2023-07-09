CREATE TABLE IT_SyoumetuTuuti (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     sksdoufuukbn                                       VARCHAR     (1)                                                                 ,  /* 請求書同封区分 */
     mynosinkokuiraidoufuukbn                           VARCHAR     (1)                                                                 ,  /* マイナンバー申告依頼同封区分 */
     shskyno                                            VARCHAR     (7)                                                                 ,  /* 送付先郵便番号 */
     shsadr1kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所１（漢字）（３０桁） */
     shsadr2kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所２（漢字）（３０桁） */
     shsadr3kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所３（漢字）（３０桁） */
     shsnmkj                                            VARCHAR     (15)                                                                ,  /* 送付先氏名（漢字） */
     toiawaseyno                                        VARCHAR     (8)                                                                 ,  /* 問合せ先郵便番号 */
     toiawaseadr1kj                                     VARCHAR     (15)                                                                ,  /* 問合せ先住所１（漢字） */
     toiawaseadr2kj                                     VARCHAR     (15)                                                                ,  /* 問合せ先住所２（漢字） */
     toiawaseadr3kj                                     VARCHAR     (15)                                                                ,  /* 問合せ先住所３（漢字） */
     toiawasekaisyanmkj                                 VARCHAR     (10)                                                                ,  /* 問合せ先会社名（漢字） */
     toiawasesosikinmkj                                 VARCHAR     (15)                                                                ,  /* 問合せ先組織名（漢字） */
     toiawasetelno                                      VARCHAR     (14)                                                                ,  /* 問合せ先電話番号 */
     toiawaseteluktkkanou1                              VARCHAR     (18)                                                                ,  /* 問合せ先電話受付可能時間１ */
     toiawaseteluktkkanou2                              VARCHAR     (18)                                                                ,  /* 問合せ先電話受付可能時間２ */
     toiawasesosikinmkj2                                VARCHAR     (15)                                                                ,  /* 第２問合せ先組織名（漢字） */
     toiawasetelno2                                     VARCHAR     (14)                                                                ,  /* 第２問合せ先電話番号 */
     syoumetuymd                                        VARCHAR     (8)                                                                 ,  /* 消滅日 */
     shrymd                                             VARCHAR     (8)                                                                 ,  /* 支払日 */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字） */
     hhknnmkj                                           VARCHAR     (15)                                                                ,  /* 被保険者名（漢字） */
     keiyakuymd                                         VARCHAR     (8)                                                                 ,  /* 契約年月日 */
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
     shrgkkei                                           NUMBER      (13)                                                                ,  /* 支払額合計 */
     shrgkkei$                                          VARCHAR     (10)                                                                ,  /* 支払額合計(通貨型) */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     shrkwsrate                                         NUMBER      (7,4)                                                               ,  /* 支払時為替レート */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     banknmkj                                           VARCHAR     (20)                                                                ,  /* 銀行名（漢字） */
     sitennmkj                                          VARCHAR     (20)                                                                ,  /* 支店名（漢字） */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzsyuruikbn                                        VARCHAR     (1)                                                                 ,  /* 口座種類区分 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     htsiryosyukbn                                      VARCHAR     (3)                                                                 ,  /* 法定資料種類区分 */
     synykngk                                           NUMBER      (13)                                                                ,  /* 収入金額 */
     synykngk$                                          VARCHAR     (10)                                                                ,  /* 収入金額(通貨型) */
     htykeihi                                           NUMBER      (13)                                                                ,  /* 必要経費 */
     htykeihi$                                          VARCHAR     (10)                                                                ,  /* 必要経費(通貨型) */
     shrkykhtykeihi                                     NUMBER      (13)                                                                ,  /* 支払時契約者必要経費 */
     shrkykhtykeihi$                                    VARCHAR     (10)                                                                ,  /* 支払時契約者必要経費(通貨型) */
     zeimunaiyouhensyuctrlkbn                           VARCHAR     (1)                                                                 ,  /* 税務内容編集制御区分 */
     kykhnkkaisuu                                       NUMBER      (2)                                                                 ,  /* 契約者変更回数 */
     kykmsnkbn                                          VARCHAR     (1)                                                                 ,  /* 契約者未成年区分 */
     lastsyosaihkymd                                    VARCHAR     (8)                                                                 ,  /* 最終証券再発行日 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     tsinadr1kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所３（漢字） */
     toritugisyasyozokunm                               VARCHAR     (15)                                                                ,  /* 取次者所属名 */
     toritugisyakjncd                                   VARCHAR     (8)                                                                 ,  /* 取次者個人コード */
     toritugisyanm                                      VARCHAR     (15)                                                                ,  /* 取次者氏名 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_SyoumetuTuuti ADD CONSTRAINT PK_SyoumetuTuuti PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;

CREATE INDEX IX1_SyoumetuTuuti ON IT_SyoumetuTuuti (
     tyouhyouymd                                                /* 帳票作成日 */
) ;
