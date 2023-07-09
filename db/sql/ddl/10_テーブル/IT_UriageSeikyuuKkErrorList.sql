CREATE TABLE IT_UriageSeikyuuKkErrorList (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     creditkessaiyouno                                  VARCHAR     (26)                                                      NOT NULL  ,  /* クレジットカード決済用番号 */
     uriagenengappi                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 売上年月日 */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     jyuutouym                                          VARCHAR     (6)                                                       NOT NULL  ,  /* 充当年月 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     credituriagegk                                     NUMBER      (13)                                                      NOT NULL  ,  /* クレジットカード売上金額 */
     credituriagegk$                                    VARCHAR     (10)                                                      NOT NULL  ,  /* クレジットカード売上金額(通貨型) */
     uriageseikyuuerrorcd                               VARCHAR     (3)                                                       NOT NULL  ,  /* 売上請求エラーコード */
     credituriagengjiyuu                                VARCHAR     (2)                                                       NOT NULL  ,  /* クレジットカード売上請求ＮＧ事由 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     authorikbn                                         VARCHAR     (1)                                                                 ,  /* オーソリ区分 */
     kinouId                                            VARCHAR     (50)                                                                ,  /* 機能ＩＤ */
     credituriageseikyuukbn                             VARCHAR     (1)                                                                    /* クレジットカード売上請求区分 */
)
;

ALTER TABLE IT_UriageSeikyuuKkErrorList ADD CONSTRAINT PK_UriageSeikyuuKkErrorList PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     creditkessaiyouno                                        , /* クレジットカード決済用番号 */
     uriagenengappi                                           , /* 売上年月日 */
     renno3keta                                                 /* 連番（３桁） */
) ;
