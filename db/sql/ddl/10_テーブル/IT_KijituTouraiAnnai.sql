CREATE TABLE IT_KijituTouraiAnnai (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     shskyno                                            VARCHAR     (7)                                                                 ,  /* 送付先郵便番号 */
     shsadr1kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所１（漢字）（３０桁） */
     shsadr2kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所２（漢字）（３０桁） */
     shsadr3kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所３（漢字）（３０桁） */
     shsnmkj                                            VARCHAR     (15)                                                                ,  /* 送付先氏名（漢字） */
     toiawasesosikinmkj                                 VARCHAR     (15)                                                                ,  /* 問合せ先組織名（漢字） */
     toiawaseyno                                        VARCHAR     (8)                                                                 ,  /* 問合せ先郵便番号 */
     toiawaseadr1kj                                     VARCHAR     (15)                                                                ,  /* 問合せ先住所１（漢字） */
     toiawaseadr2kj                                     VARCHAR     (15)                                                                ,  /* 問合せ先住所２（漢字） */
     toiawaseadr3kj                                     VARCHAR     (15)                                                                ,  /* 問合せ先住所３（漢字） */
     toiawasetelno                                      VARCHAR     (14)                                                                ,  /* 問合せ先電話番号 */
     toiawaseteluktkkanou1                              VARCHAR     (18)                                                                ,  /* 問合せ先電話受付可能時間１ */
     toiawaseteluktkkanou2                              VARCHAR     (18)                                                                ,  /* 問合せ先電話受付可能時間２ */
     toiawasesosikinmkj2                                VARCHAR     (15)                                                                ,  /* 第２問合せ先組織名（漢字） */
     toiawasetelno2                                     VARCHAR     (14)                                                                ,  /* 第２問合せ先電話番号 */
     tuutinm20keta                                      VARCHAR     (20)                                                                ,  /* 通知名称（２０桁） */
     hrkykkmsg32keta1                                   VARCHAR     (32)                                                                ,  /* 振替予告メッセージ（３２桁）１ */
     hrkykkmsg32keta2                                   VARCHAR     (32)                                                                ,  /* 振替予告メッセージ（３２桁）２ */
     hrkykkmsg32keta3                                   VARCHAR     (32)                                                                ,  /* 振替予告メッセージ（３２桁）３ */
     hrkykkmsg32keta4                                   VARCHAR     (32)                                                                ,  /* 振替予告メッセージ（３２桁）４ */
     hrkykkmsg32keta5                                   VARCHAR     (32)                                                                ,  /* 振替予告メッセージ（３２桁）５ */
     hrkykkmsg32keta6                                   VARCHAR     (32)                                                                ,  /* 振替予告メッセージ（３２桁）６ */
     hrkykkmsg32keta7                                   VARCHAR     (32)                                                                ,  /* 振替予告メッセージ（３２桁）７ */
     hrkykkmsg32keta8                                   VARCHAR     (32)                                                                ,  /* 振替予告メッセージ（３２桁）８ */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     syouhnnm                                           VARCHAR     (40)                                                                ,  /* 商品名 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     hhknnmkj                                           VARCHAR     (15)                                                                ,  /* 被保険者名（漢字） */
     kjttrnnfreearea1                                   VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア１ */
     kjttrnnfreearea2                                   VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア２ */
     kjttrnnfreearea3                                   VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア３ */
     kjttrnnfreearea4                                   VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア４ */
     kjttrnnfreearea5                                   VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア５ */
     kjttrnnfreearea6                                   VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア６ */
     kjttrnnfreearea7                                   VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア７ */
     hurikaeymd                                         VARCHAR     (8)                                                                 ,  /* 振替日 */
     kzinfo1                                            VARCHAR     (27)                                                                ,  /* 口座情報１ */
     kzinfo2                                            VARCHAR     (27)                                                                ,  /* 口座情報２ */
     kzinfo3                                            VARCHAR     (27)                                                                ,  /* 口座情報３ */
     kzinfo4                                            VARCHAR     (27)                                                                ,  /* 口座情報４ */
     kzinfo5                                            VARCHAR     (27)                                                                ,  /* 口座情報５ */
     kzinfo6                                            VARCHAR     (27)                                                                ,  /* 口座情報６ */
     kzinfo7                                            VARCHAR     (27)                                                                ,  /* 口座情報７ */
     kzinfo8                                            VARCHAR     (27)                                                                ,  /* 口座情報８ */
     hknjytukikan                                       VARCHAR     (18)                                                                ,  /* 保険充当期間 */
     hrkgk1                                             VARCHAR     (27)                                                                ,  /* 払込金額１ */
     hrkgk2                                             VARCHAR     (27)                                                                ,  /* 払込金額２ */
     hrkgk3                                             VARCHAR     (27)                                                                ,  /* 払込金額３ */
     hrkgk4                                             VARCHAR     (27)                                                                ,  /* 払込金額４ */
     kjttrnnfreearea8                                   VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア８ */
     kjttrnnfreearea9                                   VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア９ */
     kjttrnnfreearea10                                  VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア１０ */
     kjttrnnfreearea11                                  VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア１１ */
     kjttrnnfreearea12                                  VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア１２ */
     kjttrnnfreearea13                                  VARCHAR     (35)                                                                ,  /* 期日到来案内フリーエリア１３ */
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KijituTouraiAnnai ADD CONSTRAINT PK_KijituTouraiAnnai PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;

CREATE INDEX IX1_KijituTouraiAnnai ON IT_KijituTouraiAnnai (
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;
