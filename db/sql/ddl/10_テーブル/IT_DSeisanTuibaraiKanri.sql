CREATE TABLE IT_DSeisanTuibaraiKanri (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     haitounendo                                        VARCHAR     (4)                                                       NOT NULL  ,  /* 配当年度 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     syouhnsdno                                         NUMBER      (2)                                                                 ,  /* 商品世代番号 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     shrhousiteikbn                                     VARCHAR     (1)                                                                 ,  /* 支払方法指定区分 */
     inputshrhousiteikbn                                VARCHAR     (1)                                                                 ,  /* 入力用支払方法指定区分 */
     tuibaraiyouhikbn                                   VARCHAR     (1)                                                                 ,  /* 追払要否区分 */
     tuutisakuseiyouhikbn                               VARCHAR     (1)                                                                 ,  /* 通知作成要否区分 */
     dseisansouhusakihnsyukbn                           VARCHAR     (1)                                                                 ,  /* Ｄ精算送付先編集区分 */
     dseisantetudukimeikbn                              VARCHAR     (1)                                                                 ,  /* Ｄ精算手続名区分 */
     shrymd                                             VARCHAR     (8)                                                                 ,  /* 支払日 */
     shrtienrskkisanymd                                 VARCHAR     (8)                                                                 ,  /* 支払遅延利息起算日 */
     tienrsknissuu                                      NUMBER      (5)                                                                 ,  /* 遅延利息日数 */
     syoruiukeymd                                       VARCHAR     (8)                                                                 ,  /* 書類受付日 */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日 */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     gsbunritaisyou                                     VARCHAR     (1)                                                                 ,  /* 源泉分離課税対象 */
     yenshrtkumu                                        VARCHAR     (1)                                                                 ,  /* 円支払特約有無 */
     kzsyuruikbn                                        VARCHAR     (1)                                                                 ,  /* 口座種類区分 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzdoukbn                                           VARCHAR     (1)                                                                 ,  /* 口座名義人同一区分 */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     gaikashrkwsratekjnymd                              VARCHAR     (8)                                                                 ,  /* 外貨支払時為替レート基準日 */
     gaikashrkwsrate                                    NUMBER      (7,4)                                                               ,  /* 外貨支払時為替レート */
     zeimukwsratekjnymd                                 VARCHAR     (8)                                                                 ,  /* 税務用為替レート基準日 */
     zeimukwsrate                                       NUMBER      (7,4)                                                               ,  /* 税務用為替レート */
     nztodouhukencd                                     VARCHAR     (2)                                                                 ,  /* 納税先都道府県コード */
     yensynykngk                                        NUMBER      (13)                                                                ,  /* 円換算収入金額 */
     yensynykngk$                                       VARCHAR     (10)                                                                ,  /* 円換算収入金額(通貨型) */
     yenhtykeihi                                        NUMBER      (13)                                                                ,  /* 円換算必要経費 */
     yenhtykeihi$                                       VARCHAR     (10)                                                                ,  /* 円換算必要経費(通貨型) */
     yenkztgk                                           NUMBER      (13)                                                                ,  /* 円換算課税対象額 */
     yenkztgk$                                          VARCHAR     (10)                                                                ,  /* 円換算課税対象額(通貨型) */
     yenshrkykhtykeihi                                  NUMBER      (13)                                                                ,  /* 円換算支払時契約者必要経費 */
     yenshrkykhtykeihi$                                 VARCHAR     (10)                                                                ,  /* 円換算支払時契約者必要経費(通貨型) */
     kykhnkkaisuu                                       NUMBER      (2)                                                                 ,  /* 契約者変更回数 */
     shrtysykurikosiyouhi                               VARCHAR     (1)                                                                 ,  /* 支払調書繰越要否 */
     soukinsakinmkj                                     VARCHAR     (15)                                                                ,  /* 送金先氏名（漢字） */
     soukinsakiyno                                      VARCHAR     (7)                                                                 ,  /* 送金先郵便番号 */
     soukinsakiadr1kj                                   VARCHAR     (30)                                                                ,  /* 送金先住所１（漢字） */
     soukinsakiadr2kj                                   VARCHAR     (30)                                                                ,  /* 送金先住所２（漢字） */
     soukinsakiadr3kj                                   VARCHAR     (30)                                                                ,  /* 送金先住所３（漢字） */
     kaiyakujiyuu                                       VARCHAR     (1)                                                                 ,  /* 解約事由 */
     shrtuukashrgkgoukei                                NUMBER      (13)                                                                ,  /* 支払通貨支払額合計 */
     shrtuukashrgkgoukei$                               VARCHAR     (10)                                                                ,  /* 支払通貨支払額合計(通貨型) */
     shrtuukagstszeigk                                  NUMBER      (13)                                                                ,  /* 支払通貨源泉徴収税額 */
     shrtuukagstszeigk$                                 VARCHAR     (10)                                                                ,  /* 支払通貨源泉徴収税額(通貨型) */
     shrtuukashrtienrsk                                 NUMBER      (13)                                                                ,  /* 支払通貨支払遅延利息 */
     shrtuukashrtienrsk$                                VARCHAR     (10)                                                                ,  /* 支払通貨支払遅延利息(通貨型) */
     shrtuukasonotashrkngk                              NUMBER      (13)                                                                ,  /* 支払通貨その他支払金額 */
     shrtuukasonotashrkngk$                             VARCHAR     (10)                                                                ,  /* 支払通貨その他支払金額(通貨型) */
     yenkansanhaitoukin                                 NUMBER      (13)                                                                ,  /* 円換算配当金 */
     yenkansanhaitoukin$                                VARCHAR     (10)                                                                ,  /* 円換算配当金(通貨型) */
     yensonotahaitoukin                                 NUMBER      (13)                                                                ,  /* 円換算その他配当金 */
     yensonotahaitoukin$                                VARCHAR     (10)                                                                ,  /* 円換算その他配当金(通貨型) */
     yenshrgkgoukei                                     NUMBER      (13)                                                                ,  /* 円換算支払額合計 */
     yenshrgkgoukei$                                    VARCHAR     (10)                                                                ,  /* 円換算支払額合計(通貨型) */
     yengstszeigk                                       NUMBER      (13)                                                                ,  /* 円換算源泉徴収税額 */
     yengstszeigk$                                      VARCHAR     (10)                                                                ,  /* 円換算源泉徴収税額(通貨型) */
     yengstszeigknationaltax                            NUMBER      (13)                                                                ,  /* 円換算源泉徴収税額（国税） */
     yengstszeigknationaltax$                           VARCHAR     (10)                                                                ,  /* 円換算源泉徴収税額（国税）(通貨型) */
     yengstszeigklocaltax                               NUMBER      (13)                                                                ,  /* 円換算源泉徴収税額（地方税） */
     yengstszeigklocaltax$                              VARCHAR     (10)                                                                ,  /* 円換算源泉徴収税額（地方税）(通貨型) */
     yenshrtienrsk                                      NUMBER      (13)                                                                ,  /* 円換算支払遅延利息 */
     yenshrtienrsk$                                     VARCHAR     (10)                                                                ,  /* 円換算支払遅延利息(通貨型) */
     sonotashrkngkyen                                   NUMBER      (13)                                                                ,  /* その他支払金額（円貨） */
     sonotashrkngkyen$                                  VARCHAR     (10)                                                                ,  /* その他支払金額（円貨）(通貨型) */
     sonotashrkngksiteituuka                            NUMBER      (13)                                                                ,  /* その他支払金額（指定通貨） */
     sonotashrkngksiteituuka$                           VARCHAR     (10)                                                                ,  /* その他支払金額（指定通貨）(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     zeitratkikbn                                       VARCHAR     (1)                                                                    /* 税取扱区分 */
)
;

ALTER TABLE IT_DSeisanTuibaraiKanri ADD CONSTRAINT PK_DSeisanTuibaraiKanri PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     haitounendo                                                /* 配当年度 */
) ;

CREATE INDEX IX1_DSeisanTuibaraiKanri ON IT_DSeisanTuibaraiKanri (
     haitounendo                                                /* 配当年度 */
) ;
