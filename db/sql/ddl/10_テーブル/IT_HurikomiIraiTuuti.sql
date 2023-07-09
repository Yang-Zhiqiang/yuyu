CREATE TABLE IT_HurikomiIraiTuuti (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所３（漢字） */
     tsinadr4kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所４（漢字） */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字） */
     kyknmkn                                            VARCHAR     (18)                                                                ,  /* 契約者名（カナ） */
     hhknnmkj                                           VARCHAR     (15)                                                                ,  /* 被保険者名（漢字） */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuuy                                      NUMBER      (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      NUMBER      (2)                                                                 ,  /* 充当回数（月） */
     yykknmnryymd                                       VARCHAR     (8)                                                                 ,  /* 猶予期間満了日 */
     ryosyugk                                           NUMBER      (10)                                                                ,  /* 領収金額（１０桁） */
     ryosyugk$                                          VARCHAR     (10)                                                                ,  /* 領収金額（１０桁）(通貨型) */
     hrkkigenymd                                        VARCHAR     (8)                                                                 ,  /* 払込期限日 */
     nipyykknmnryymd                                    VARCHAR     (8)                                                                 ,  /* 第２回保険料猶予期間満了日 */
     banknmkj                                           VARCHAR     (20)                                                                ,  /* 銀行名（漢字） */
     sitennmkj                                          VARCHAR     (20)                                                                ,  /* 支店名（漢字） */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     injiptnkbn                                         NUMBER      (2)                                                                 ,  /* 印字パターン区分 */
     tuutikbn                                           VARCHAR     (1)                                                                 ,  /* 通知区分 */
     hurikomisyono                                      VARCHAR     (20)                                                                ,  /* 振込用証券番号 */
     drtencd                                            VARCHAR     (7)                                                                 ,  /* 代理店コード */
     drtennmkj                                          VARCHAR     (30)                                                                ,  /* 代理店名（漢字） */
     rtratkicd                                          NUMBER      (1)                                                                 ,  /* （帳票用）取扱コード */
     rtyouhyoucd                                        VARCHAR     (4)                                                                 ,  /* （帳票用）帳票コード */
     tyhyrenrakusikibetukbn                             VARCHAR     (2)                                                                 ,  /* 帳票連絡先識別区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_HurikomiIraiTuuti ADD CONSTRAINT PK_HurikomiIraiTuuti PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;

CREATE INDEX IX1_HurikomiIraiTuuti ON IT_HurikomiIraiTuuti (
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;
