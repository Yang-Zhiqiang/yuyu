CREATE TABLE IT_KhUriageData (
     ansyuusyskbn                                       VARCHAR     (1)                                                       NOT NULL  ,  /* 案内収納用システム区分 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     authorikaisuu                                      NUMBER      (2)                                                       NOT NULL  ,  /* オーソリ回数 */
     creditcardno1                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号１ */
     creditcardno2                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号２ */
     creditcardno3                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号３ */
     creditcardno4                                      VARCHAR     (32)                                                                ,  /* クレジットカード番号４ */
     creditcardykkigen                                  VARCHAR     (32)                                                                ,  /* クレジットカード有効期限 */
     cardkaisyacd                                       VARCHAR     (2)                                                                 ,  /* カード会社コード */
     syuukeilvkbn                                       VARCHAR     (1)                                                                 ,  /* 集計レベル区分 */
     authorigk                                          NUMBER      (13)                                                                ,  /* オーソリ金額 */
     authorigk$                                         VARCHAR     (10)                                                                ,  /* オーソリ金額(通貨型) */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuum                                      NUMBER      (2)                                                                 ,  /* 充当回数（月） */
     uriagegk                                           NUMBER      (13)                                                                ,  /* 売上金額 */
     uriagegk$                                          VARCHAR     (10)                                                                ,  /* 売上金額(通貨型) */
     uriageymd                                          VARCHAR     (8)                                                                 ,  /* 売上日 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hknsyukigou                                        VARCHAR     (2)                                                                 ,  /* 保険種類記号 */
     hokensyuruikigousdicode                            VARCHAR     (1)                                                                 ,  /* 保険種類記号世代コード */
     hknsyukigoukktkmk1                                 NUMBER      (15)                                                                ,  /* 保険種類記号拡張項目１ */
     hknsyukigoukktkmk2                                 VARCHAR     (10)                                                                ,  /* 保険種類記号拡張項目２ */
     hknsyukigoukktkmk3                                 NUMBER      (10)                                                                ,  /* 保険種類記号拡張項目３ */
     kameitenno                                         VARCHAR     (15)                                                                ,  /* 加盟店番号 */
     kameitennm25                                       VARCHAR     (25)                                                                ,  /* 加盟店名（２５桁） */
     credittsryritu                                     NUMBER      (11)                                                                ,  /* クレジット手数料率 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_KhUriageData ADD CONSTRAINT PK_KhUriageData PRIMARY KEY (
     ansyuusyskbn                                             , /* 案内収納用システム区分 */
     syoriYmd                                                 , /* 処理年月日 */
     syono                                                    , /* 証券番号 */
     authorikaisuu                                              /* オーソリ回数 */
) ;
