CREATE TABLE IT_BAK_KouzaHrkmTuuti (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     krkno                                              NUMBER      (5)                                                       NOT NULL  ,  /* 仮受番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     tyouhyouymd                                        VARCHAR     (8)                                                                 ,  /* 帳票作成日 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
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
     syoruiCd                                           VARCHAR     (5)                                                                 ,  /* 書類コード */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     hurikomiymd                                        VARCHAR     (8)                                                                 ,  /* 振込日 */
     shrgk                                              NUMBER      (13)                                                                ,  /* 支払金額 */
     shrgk$                                             VARCHAR     (10)                                                                ,  /* 支払金額(通貨型) */
     shririyuu1                                         VARCHAR     (32)                                                                ,  /* 支払理由１ */
     shririyuu2                                         VARCHAR     (32)                                                                ,  /* 支払理由２ */
     shririyuu3                                         VARCHAR     (32)                                                                ,  /* 支払理由３ */
     siteikouza1                                        VARCHAR     (32)                                                                ,  /* 指定口座１ */
     siteikouza2                                        VARCHAR     (32)                                                                ,  /* 指定口座２ */
     siteikouza3                                        VARCHAR     (32)                                                                ,  /* 指定口座３ */
     siteikouza4                                        VARCHAR     (32)                                                                ,  /* 指定口座４ */
     siteikouza5                                        VARCHAR     (32)                                                                ,  /* 指定口座５ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_BAK_KouzaHrkmTuuti ADD CONSTRAINT PK_BAK_KouzaHrkmTuuti PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     krkno                                                    , /* 仮受番号 */
     trkssikibetukey                                            /* 取消識別キー */
) ;
