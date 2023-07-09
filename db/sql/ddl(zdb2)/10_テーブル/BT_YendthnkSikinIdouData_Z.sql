CREATE TABLE BT_YendthnkSikinIdouData_Z (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     keiriyendthnkkbn                                   VARCHAR     (1)                                                       NOT NULL  ,  /* 経理用円建変更区分 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     syouhnsdno                                         DECIMAL     (2)                                                                 ,  /* 商品世代番号 */
     siteituuka                                         VARCHAR     (3)                                                                 ,  /* 指定通貨 */
     siteituukagk                                       DECIMAL     (13)                                                                ,  /* 指定通貨金額 */
     siteituukagk$                                      VARCHAR     (10)                                                                ,  /* 指定通貨金額(通貨型) */
     trhktuuka                                          VARCHAR     (3)                                                                 ,  /* 取引通貨 */
     trhktuukagk                                        DECIMAL     (13)                                                                ,  /* 取引通貨金額 */
     trhktuukagk$                                       VARCHAR     (10)                                                                ,  /* 取引通貨金額(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_YendthnkSikinIdouData_Z ADD CONSTRAINT PK_YendthnkSikinIdouData PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     keiriyendthnkkbn                                         , /* 経理用円建変更区分 */
     syoriYmd                                                   /* 処理年月日 */
) ;

CREATE INDEX IX1_YendthnkSikinIdouData ON BT_YendthnkSikinIdouData_Z (
     syoriYmd                                                   /* 処理年月日 */
) ;
