CREATE TABLE IT_DattaiTuutiKzhuri_Z (
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
     osirasemongon1                                     VARCHAR     (106)                                                               ,  /* お知らせ文言１ */
     osirasemongon2                                     VARCHAR     (106)                                                               ,  /* お知らせ文言２ */
     osirasemongon3                                     VARCHAR     (106)                                                               ,  /* お知らせ文言３ */
     osirasemongon4                                     VARCHAR     (106)                                                               ,  /* お知らせ文言４ */
     osirasemongon5                                     VARCHAR     (106)                                                               ,  /* お知らせ文言５ */
     osirasemongon6                                     VARCHAR     (106)                                                               ,  /* お知らせ文言６ */
     osirasemongon7                                     VARCHAR     (106)                                                               ,  /* お知らせ文言７ */
     osirasemongon8                                     VARCHAR     (106)                                                               ,  /* お知らせ文言８ */
     osirasemongon9                                     VARCHAR     (106)                                                               ,  /* お知らせ文言９ */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     kzinfo30keta1                                      VARCHAR     (62)                                                                ,  /* 口座情報（３０桁）１ */
     kzinfo30keta2                                      VARCHAR     (62)                                                                ,  /* 口座情報（３０桁）２ */
     kzinfo30keta3                                      VARCHAR     (62)                                                                ,  /* 口座情報（３０桁）３ */
     kouzamaskingmsg                                    VARCHAR     (66)                                                                ,  /* 口座マスキングＭＳＧ */
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

ALTER TABLE IT_DattaiTuutiKzhuri_Z ADD CONSTRAINT PK_IT_DattaiTuutiKzhuri PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;
