CREATE TABLE HT_SkUriageData_Z (
     ansyuusyskbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* 案内収納用システム区分 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     authorikaisuu                                      DECIMAL     (2)                                                       NOT NULL  ,  /* オーソリ回数 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuum                                      DECIMAL     (2)                                                                 ,  /* 充当回数（月） */
     uriagegk                                           DECIMAL     (13)                                                                ,  /* 売上金額 */
     uriagegk$                                          VARCHAR     (10)                                                                ,  /* 売上金額(通貨型) */
     uriageymd                                          VARCHAR     (8)                                                                 ,  /* 売上日 */
     hknsyuruino                                        VARCHAR     (3)                                                                 ,  /* 保険種類番号 */
     srsyoriymd                                         VARCHAR     (8)                                                                 ,  /* 成立処理日 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     authorikbn                                         VARCHAR     (1)                                                                 ,  /* オーソリ区分 */
     uriageseikyuutorihikicd                            VARCHAR     (1)                                                                 ,  /* 売上請求取引コード */
     creditkessaiyouno                                  VARCHAR     (26)                                                                ,  /* クレジットカード決済用番号 */
     creditkaiinnokami6keta                             VARCHAR     (6)                                                                 ,  /* クレジット会員番号（上６桁） */
     creditkaiinnosimo4keta                             VARCHAR     (4)                                                                 ,  /* クレジット会員番号（下４桁） */
     credituriagengjiyuu                                VARCHAR     (2)                                                                 ,  /* クレジットカード売上請求ＮＧ事由 */
     fukusuukameitennokey                               VARCHAR     (7)                                                                 ,  /* 複数加盟店番号設定キー情報 */
     cardbrandkbn                                       VARCHAR     (2)                                                                 ,  /* カードブランド区分 */
     carddatasousinymd                                  VARCHAR     (8)                                                                 ,  /* カードデータ送信日 */
     uriageseikyuuerrorcd                               VARCHAR     (3)                                                                 ,  /* 売上請求エラーコード */
     uriagekekkakbn                                     VARCHAR     (1)                                                                 ,  /* 売上結果区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_SkUriageData_Z ADD CONSTRAINT PK_SkUriageData PRIMARY KEY (
     ansyuusyskbn                                             , /* 案内収納用システム区分 */
     syoriYmd                                                 , /* 処理年月日 */
     mosno                                                    , /* 申込番号 */
     authorikaisuu                                              /* オーソリ回数 */
) ;

CREATE INDEX IX1_SkUriageData ON HT_SkUriageData_Z (
     syoriYmd                                                   /* 処理年月日 */
) ;

CREATE INDEX IX2_SkUriageData ON HT_SkUriageData_Z (
     creditkessaiyouno                                          /* クレジットカード決済用番号 */
) ;

CREATE INDEX IX3_SkUriageData ON HT_SkUriageData_Z (
     cardbrandkbn                                             , /* カードブランド区分 */
     carddatasousinymd                                        , /* カードデータ送信日 */
     uriagekekkakbn                                             /* 売上結果区分 */
) ;
