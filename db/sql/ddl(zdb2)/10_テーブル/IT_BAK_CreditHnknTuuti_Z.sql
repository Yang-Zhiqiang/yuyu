CREATE TABLE IT_BAK_CreditHnknTuuti_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     denrenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 伝票データ連番 */
     edano                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 枝番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                                 ,  /* 帳票作成日 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
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
     shrriyuukbn                                        VARCHAR     (2)                                                                 ,  /* 支払理由区分 */
     uriageseikyuuymd                                   VARCHAR     (8)                                                                 ,  /* 売上請求日 */
     hnkngk                                             DECIMAL     (13)                                                                ,  /* 返金額 */
     hnkngk$                                            VARCHAR     (10)                                                                ,  /* 返金額(通貨型) */
     krkriyuukbn                                        VARCHAR     (2)                                                                 ,  /* 仮受理由区分 */
     uriageymd                                          VARCHAR     (8)                                                                 ,  /* 売上日 */
     uriagegk                                           DECIMAL     (13)                                                                ,  /* 売上金額 */
     uriagegk$                                          VARCHAR     (10)                                                                ,  /* 売上金額(通貨型) */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuuy                                      DECIMAL     (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      DECIMAL     (2)                                                                 ,  /* 充当回数（月） */
     hnkntaisyouinjiflg                                 VARCHAR     (1)                                                                 ,  /* 返金対象印字フラグ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_BAK_CreditHnknTuuti_Z ADD CONSTRAINT PK_BAK_CreditHnknTuuti PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     denrenno                                                 , /* 伝票データ連番 */
     edano                                                      /* 枝番号 */
) ;
