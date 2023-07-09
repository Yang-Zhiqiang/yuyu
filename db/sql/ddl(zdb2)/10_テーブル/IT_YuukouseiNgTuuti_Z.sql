CREATE TABLE IT_YuukouseiNgTuuti_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     shskyno                                            VARCHAR     (7)                                                                 ,  /* 送付先郵便番号 */
     shsadr1kj                                          VARCHAR     (62)                                                                ,  /* 送付先住所１（漢字）（３０桁） */
     shsadr2kj                                          VARCHAR     (62)                                                                ,  /* 送付先住所２（漢字）（３０桁） */
     shsadr3kj                                          VARCHAR     (62)                                                                ,  /* 送付先住所３（漢字）（３０桁） */
     shsnmkj                                            VARCHAR     (32)                                                                ,  /* 送付先氏名（漢字） */
     toiawasesosikinmkj                                 VARCHAR     (32)                                                                ,  /* 問合せ先組織名（漢字） */
     toiawaseyno                                        VARCHAR     (8)                                                                 ,  /* 問合せ先郵便番号 */
     toiawaseadr1kj                                     VARCHAR     (32)                                                                ,  /* 問合せ先住所１（漢字） */
     toiawaseadr2kj                                     VARCHAR     (32)                                                                ,  /* 問合せ先住所２（漢字） */
     toiawaseadr3kj                                     VARCHAR     (32)                                                                ,  /* 問合せ先住所３（漢字） */
     toiawasetelno                                      VARCHAR     (14)                                                                ,  /* 問合せ先電話番号 */
     toiawaseteluktkkanou1                              VARCHAR     (38)                                                                ,  /* 問合せ先電話受付可能時間１ */
     toiawaseteluktkkanou2                              VARCHAR     (38)                                                                ,  /* 問合せ先電話受付可能時間２ */
     toiawasesosikinmkj2                                VARCHAR     (32)                                                                ,  /* 第２問合せ先組織名（漢字） */
     toiawasetelno2                                     VARCHAR     (14)                                                                ,  /* 第２問合せ先電話番号 */
     osirasemongon46keta1                               VARCHAR     (94)                                                                ,  /* お知らせ文言（４６桁）１ */
     osirasemongon46keta2                               VARCHAR     (94)                                                                ,  /* お知らせ文言（４６桁）２ */
     osirasemongon46keta3                               VARCHAR     (94)                                                                ,  /* お知らせ文言（４６桁）３ */
     osirasemongon46keta4                               VARCHAR     (94)                                                                ,  /* お知らせ文言（４６桁）４ */
     osirasemongon46keta5                               VARCHAR     (94)                                                                ,  /* お知らせ文言（４６桁）５ */
     osirasemongon46keta6                               VARCHAR     (94)                                                                ,  /* お知らせ文言（４６桁）６ */
     osirasemongon46keta7                               VARCHAR     (94)                                                                ,  /* お知らせ文言（４６桁）７ */
     osirasemongon46keta8                               VARCHAR     (94)                                                                ,  /* お知らせ文言（４６桁）８ */
     osirasemongon46keta9                               VARCHAR     (94)                                                                ,  /* お知らせ文言（４６桁）９ */
     osirasemongon46keta10                              VARCHAR     (94)                                                                ,  /* お知らせ文言（４６桁）１０ */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     hokenryou                                          DECIMAL     (13)                                                                ,  /* 保険料 */
     hokenryou$                                         VARCHAR     (10)                                                                ,  /* 保険料(通貨型) */
     creditcardinfo1                                    VARCHAR     (62)                                                                ,  /* クレジットカード情報１ */
     creditcardinfo2                                    VARCHAR     (62)                                                                ,  /* クレジットカード情報２ */
     creditcardinfo3                                    VARCHAR     (62)                                                                ,  /* クレジットカード情報３ */
     creditcardmaskingmsg                               VARCHAR     (80)                                                                ,  /* クレジットカードマスキングＭＳＧ */
     goiraijikoutoumongon1                              VARCHAR     (72)                                                                ,  /* ご依頼事項等文言１ */
     goiraijikoutoumongon2                              VARCHAR     (72)                                                                ,  /* ご依頼事項等文言２ */
     goiraijikoutoumongon3                              VARCHAR     (72)                                                                ,  /* ご依頼事項等文言３ */
     phrkmongon1                                        VARCHAR     (94)                                                                ,  /* 保険料のお払込み文言１ */
     phrkmongon2                                        VARCHAR     (94)                                                                ,  /* 保険料のお払込み文言２ */
     phrkmongon3                                        VARCHAR     (94)                                                                ,  /* 保険料のお払込み文言３ */
     phrkmongon4                                        VARCHAR     (94)                                                                ,  /* 保険料のお払込み文言４ */
     phrkmongon5                                        VARCHAR     (94)                                                                ,  /* 保険料のお払込み文言５ */
     phrkmongon6                                        VARCHAR     (94)                                                                ,  /* 保険料のお払込み文言６ */
     phrkmongon7                                        VARCHAR     (94)                                                                ,  /* 保険料のお払込み文言７ */
     phrkmongon8                                        VARCHAR     (94)                                                                ,  /* 保険料のお払込み文言８ */
     phrkmongon9                                        VARCHAR     (94)                                                                ,  /* 保険料のお払込み文言９ */
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_YuukouseiNgTuuti_Z ADD CONSTRAINT PK_IT_YuukouseiNgTuuti PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;
