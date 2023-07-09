CREATE TABLE IT_HrhnTtdkKan_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     tyouhyouymd                                        VARCHAR     (8)                                                                 ,  /* 帳票作成日 */
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
     toiawasekaisyanmkj                                 VARCHAR     (22)                                                                ,  /* 問合せ先会社名（漢字） */
     toiawasetelno                                      VARCHAR     (14)                                                                ,  /* 問合せ先電話番号 */
     toiawaseteluktkkanou1                              VARCHAR     (38)                                                                ,  /* 問合せ先電話受付可能時間１ */
     toiawaseteluktkkanou2                              VARCHAR     (38)                                                                ,  /* 問合せ先電話受付可能時間２ */
     toiawasesosikinmkj2                                VARCHAR     (32)                                                                ,  /* 第２問合せ先組織名（漢字） */
     toiawasetelno2                                     VARCHAR     (14)                                                                ,  /* 第２問合せ先電話番号 */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     kouzamaskingmsg                                    VARCHAR     (66)                                                                ,  /* 口座マスキングＭＳＧ */
     hrkkaisuutkiktbrisyu                               VARCHAR     (20)                                                                ,  /* 払込回数・定期一括払種類 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     hrkp                                               DECIMAL     (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     kouryokuhasseiym                                   VARCHAR     (6)                                                                 ,  /* 効力発生年月 */
     msgarea34keta1                                     VARCHAR     (70)                                                                ,  /* メッセージエリア（３４桁）１ */
     msgarea34keta2                                     VARCHAR     (70)                                                                ,  /* メッセージエリア（３４桁）２ */
     msgarea34keta3                                     VARCHAR     (70)                                                                ,  /* メッセージエリア（３４桁）３ */
     msgarea34keta4                                     VARCHAR     (70)                                                                ,  /* メッセージエリア（３４桁）４ */
     msgarea34keta5                                     VARCHAR     (70)                                                                ,  /* メッセージエリア（３４桁）５ */
     msgarea34keta6                                     VARCHAR     (70)                                                                ,  /* メッセージエリア（３４桁）６ */
     msgarea34keta7                                     VARCHAR     (70)                                                                ,  /* メッセージエリア（３４桁）７ */
     hrkykkmsg34keta1                                   VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）１ */
     hrkykkmsg34keta2                                   VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）２ */
     hrkykkmsg34keta3                                   VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）３ */
     hrkykkmsg34keta4                                   VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）４ */
     hrkykkmsg34keta5                                   VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）５ */
     hrkykkmsg34keta6                                   VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）６ */
     hrkykkmsg34keta7                                   VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）７ */
     hrkykkmsg34keta8                                   VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）８ */
     hrkykkmsg34keta9                                   VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）９ */
     hrkykkmsg34keta10                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）１０ */
     hrkykkmsg34keta11                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）１１ */
     hrkykkmsg34keta12                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）１２ */
     hrkykkmsg34keta13                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）１３ */
     hrkykkmsg34keta14                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）１４ */
     hrkykkmsg34keta15                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）１５ */
     hrkykkmsg34keta16                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）１６ */
     hrkykkmsg34keta17                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）１７ */
     hrkykkmsg34keta18                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）１８ */
     hrkykkmsg34keta19                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）１９ */
     hrkykkmsg34keta20                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）２０ */
     hrkykkmsg34keta21                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）２１ */
     hrkykkmsg34keta22                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）２２ */
     hrkykkmsg34keta23                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）２３ */
     hrkykkmsg34keta24                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）２４ */
     hrkykkmsg34keta25                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）２５ */
     hrkykkmsg34keta26                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）２６ */
     hrkykkmsg34keta27                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）２７ */
     hrkykkmsg34keta28                                  VARCHAR     (70)                                                                ,  /* 振替予告メッセージ（３４桁）２８ */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     honsyakaisouriyuu                                  VARCHAR     (3)                                                                    /* 本社回送理由 */
)
;

ALTER TABLE IT_HrhnTtdkKan_Z ADD CONSTRAINT PK_HrhnTtdkKan PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                          /* 変更識別キー */
) ;
