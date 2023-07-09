CREATE TABLE IT_KhUriageKekkaData_Z (
     ansyuusyskbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* 案内収納用システム区分 */
     uriagekekkadatarenno                               VARCHAR     (20)                                                      NOT NULL  ,  /* 売上結果データ連番 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuuy                                      DECIMAL     (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      DECIMAL     (2)                                                                 ,  /* 充当回数（月） */
     syuukeilvkbn                                       VARCHAR     (1)                                                                 ,  /* 集計レベル区分 */
     uriagetorihikikbn                                  VARCHAR     (1)                                                                 ,  /* 売上取引区分 */
     uriageymd                                          VARCHAR     (8)                                                                 ,  /* 売上日 */
     uriagegk                                           DECIMAL     (13)                                                                ,  /* 売上金額 */
     uriagegk$                                          VARCHAR     (10)                                                                ,  /* 売上金額(通貨型) */
     zeisoukin                                          DECIMAL     (13)                                                                ,  /* 税・送金 */
     zeisoukin$                                         VARCHAR     (10)                                                                ,  /* 税・送金(通貨型) */
     uriagegoukei                                       DECIMAL     (13)                                                                ,  /* 売上合計 */
     uriagegoukei$                                      VARCHAR     (10)                                                                ,  /* 売上合計(通貨型) */
     syouninno                                          VARCHAR     (6)                                                                 ,  /* 承認番号 */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１ */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２ */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３ */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４ */
     creditcardykkigen                                  VARCHAR     (32)                                                                ,  /* クレジットカード有効期限 */
     cardkaisyacd                                       VARCHAR     (2)                                                                 ,  /* カード会社コード */
     uriagekekkakbn                                     VARCHAR     (1)                                                                 ,  /* 売上結果区分 */
     creditbrerrorcd                                    VARCHAR     (3)                                                                 ,  /* クレジット払エラーコード */
     authorikaisuu                                      DECIMAL     (2)                                                                 ,  /* オーソリ回数 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KhUriageKekkaData_Z ADD CONSTRAINT PK_KhUriageKekkaData PRIMARY KEY (
     ansyuusyskbn                                             , /* 案内収納用システム区分 */
     uriagekekkadatarenno                                       /* 売上結果データ連番 */
) ;

CREATE INDEX IX1_KhUriageKekkaData ON IT_KhUriageKekkaData_Z (
     syoriYmd                                                   /* 処理年月日 */
) ;
