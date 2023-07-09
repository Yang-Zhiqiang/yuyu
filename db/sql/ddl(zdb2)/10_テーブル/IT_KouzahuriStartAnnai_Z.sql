CREATE TABLE IT_KouzahuriStartAnnai_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                                 ,  /* 帳票作成日 */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (62)                                                                ,  /* 通信先住所３（漢字） */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     syouhnnm                                           VARCHAR     (82)                                                                ,  /* 商品名 */
     tuutinm                                            VARCHAR     (28)                                                                ,  /* 通知名称 */
     aisatumongon1                                      VARCHAR     (56)                                                                ,  /* 挨拶文言１ */
     aisatumongon2                                      VARCHAR     (56)                                                                ,  /* 挨拶文言２ */
     aisatumongon3                                      VARCHAR     (56)                                                                ,  /* 挨拶文言３ */
     aisatumongon4                                      VARCHAR     (56)                                                                ,  /* 挨拶文言４ */
     aisatumongon5                                      VARCHAR     (56)                                                                ,  /* 挨拶文言５ */
     kzhurikaeonegai1                                   VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い１ */
     kzhurikaeonegai2                                   VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い２ */
     kzhurikaeonegai3                                   VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い３ */
     kzhurikaeonegai4                                   VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い４ */
     kzhurikaeonegai5                                   VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い５ */
     kzhurikaeonegai6                                   VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い６ */
     kzhurikaeonegai7                                   VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い７ */
     kzhurikaeonegai8                                   VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い８ */
     kzhurikaeonegai9                                   VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い９ */
     kzhurikaeonegai10                                  VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い１０ */
     kzhurikaeonegai11                                  VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い１１ */
     kzhurikaeonegai12                                  VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い１２ */
     kzhurikaeonegai13                                  VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い１３ */
     kzhurikaeonegai14                                  VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い１４ */
     kzhurikaeonegai15                                  VARCHAR     (72)                                                                ,  /* 口座振替についてのお願い１５ */
     tkbriphurikaeyoteigk                               VARCHAR     (13)                                                                ,  /* 月払保険料（振替予定金額） */
     hurikaekzhosokumongon                              VARCHAR     (62)                                                                ,  /* 振替口座補足文言 */
     hurikaekz1                                         VARCHAR     (78)                                                                ,  /* 振替口座１ */
     hurikaekz2                                         VARCHAR     (78)                                                                ,  /* 振替口座２ */
     hurikaekz3                                         VARCHAR     (78)                                                                ,  /* 振替口座３ */
     hurikaekz4                                         VARCHAR     (78)                                                                ,  /* 振替口座４ */
     hurikaekz5                                         VARCHAR     (78)                                                                ,  /* 振替口座５ */
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
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     kzhuristartanfreearea1                             VARCHAR     (72)                                                                ,  /* 口座振替開始案内フリーエリア１ */
     kzhuristartanfreearea2                             VARCHAR     (72)                                                                ,  /* 口座振替開始案内フリーエリア２ */
     kzhuristartanfreearea3                             VARCHAR     (72)                                                                ,  /* 口座振替開始案内フリーエリア３ */
     kzhuristartanfreearea4                             VARCHAR     (72)                                                                ,  /* 口座振替開始案内フリーエリア４ */
     kzhuristartanfreearea5                             VARCHAR     (72)                                                                ,  /* 口座振替開始案内フリーエリア５ */
     kzhuristartanfreearea6                             VARCHAR     (72)                                                                ,  /* 口座振替開始案内フリーエリア６ */
     kzhuristartanfreearea7                             VARCHAR     (72)                                                                ,  /* 口座振替開始案内フリーエリア７ */
     kzhuristartanfreearea8                             VARCHAR     (72)                                                                ,  /* 口座振替開始案内フリーエリア８ */
     kzhuristartanfreearea9                             VARCHAR     (72)                                                                ,  /* 口座振替開始案内フリーエリア９ */
     kzhuristartanfreearea10                            VARCHAR     (72)                                                                ,  /* 口座振替開始案内フリーエリア１０ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KouzahuriStartAnnai_Z ADD CONSTRAINT PK_KouzahuriStartAnnai PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_KouzahuriStartAnnai ON IT_KouzahuriStartAnnai_Z (
     syono                                                      /* 証券番号 */
) ;
