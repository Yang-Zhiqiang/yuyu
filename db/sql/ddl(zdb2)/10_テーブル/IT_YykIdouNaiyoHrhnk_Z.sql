CREATE TABLE IT_YykIdouNaiyoHrhnk_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日 */
     newhrkkeiro                                        VARCHAR     (2)                                                                 ,  /* （変更後）払込経路 */
     newhrkkaisuu                                       VARCHAR     (2)                                                                 ,  /* （変更後）払込回数 */
     newtikiktbrisyuruikbn                              VARCHAR     (2)                                                                 ,  /* （変更後）定期一括払種類区分 */
     hrkkeirohnkumu                                     VARCHAR     (1)                                                                 ,  /* 払込経路変更有無区分 */
     hrkkaisuuhnkumu                                    VARCHAR     (1)                                                                 ,  /* 払込回数変更有無区分 */
     tikiktbrisyuruihnkumu                              VARCHAR     (1)                                                                 ,  /* 定期一括払種類変更有無区分 */
     haraikatahnkumu                                    VARCHAR     (1)                                                                 ,  /* 払方変更有無 */
     haraikatahnkuktknaiyoukbn                          VARCHAR     (1)                                                                 ,  /* 払方変更受付内容区分 */
     hrkp                                               DECIMAL     (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     kzmeiginmkn                                        VARCHAR     (62)                                                                ,  /* 口座名義人氏名（カナ） */
     sinkeizkkbn                                        VARCHAR     (1)                                                                 ,  /* 新規継続区分 */
     syuudaikocd                                        VARCHAR     (2)                                                                 ,  /* 収納代行社コード */
     cardkaisyacd                                       VARCHAR     (2)                                                                 ,  /* カード会社コード */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１ */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２ */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３ */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４ */
     creditcardykkigen                                  VARCHAR     (32)                                                                ,  /* クレジットカード有効期限 */
     creditmeiginmkn                                    VARCHAR     (386)                                                               ,  /* クレジットカード名義人氏名（カナ） */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     kzkykdoukbn                                        VARCHAR     (1)                                                                 ,  /* 口座名義契約者同一人区分 */
     creditkessaiyouno                                  VARCHAR     (26)                                                                ,  /* クレジットカード決済用番号 */
     cardbrandkbn                                       VARCHAR     (2)                                                                 ,  /* カードブランド区分 */
     creditkaiinnosimo4keta                             VARCHAR     (4)                                                                    /* クレジット会員番号（下４桁） */
)
;

ALTER TABLE IT_YykIdouNaiyoHrhnk_Z ADD CONSTRAINT PK_YykIdouNaiyoHrhnk PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                          /* 変更識別キー */
) ;

CREATE INDEX IX1_YykIdouNaiyoHrhnk ON IT_YykIdouNaiyoHrhnk_Z (
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                          /* 変更識別キー */
) ;
