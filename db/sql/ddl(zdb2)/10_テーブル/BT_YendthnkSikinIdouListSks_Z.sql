CREATE TABLE BT_YendthnkSikinIdouListSks_Z (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     keiriyendthnkkbn                                   VARCHAR     (1)                                                       NOT NULL  ,  /* 経理用円建変更区分 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     siteituuka                                         VARCHAR     (3)                                                                 ,  /* 指定通貨 */
     siteituukagk                                       DECIMAL     (13)                                                                ,  /* 指定通貨金額 */
     siteituukagk$                                      VARCHAR     (10)                                                                ,  /* 指定通貨金額(通貨型) */
     trhktuuka                                          VARCHAR     (3)                                                                 ,  /* 取引通貨 */
     trhktuukagk                                        DECIMAL     (13)                                                                ,  /* 取引通貨金額 */
     trhktuukagk$                                       VARCHAR     (10)                                                                ,  /* 取引通貨金額(通貨型) */
     kbnkeirisegcd                                      VARCHAR     (20)                                                                ,  /* 区分経理用セグメントコード */
     sikinidougroupkbn                                  VARCHAR     (2)                                                                 ,  /* 資金移動グループ区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_YendthnkSikinIdouListSks_Z ADD CONSTRAINT PK_YendthnkSikinIdouListSks PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     keiriyendthnkkbn                                         , /* 経理用円建変更区分 */
     syoriYmd                                                   /* 処理年月日 */
) ;

CREATE INDEX IX1_YendthnkSikinIdouListSks ON BT_YendthnkSikinIdouListSks_Z (
     syoriYmd                                                   /* 処理年月日 */
) ;
