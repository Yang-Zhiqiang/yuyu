CREATE TABLE IT_MinusUriageKykDtlList (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     creditkessaiyouno                                  VARCHAR     (26)                                                      NOT NULL  ,  /* クレジットカード決済用番号 */
     uriagenengappi                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 売上年月日 */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     credituriagegk                                     NUMBER      (13)                                                                ,  /* クレジットカード売上金額 */
     credituriagegk$                                    VARCHAR     (10)                                                                ,  /* クレジットカード売上金額(通貨型) */
     kinouId                                            VARCHAR     (50)                                                                ,  /* 機能ＩＤ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_MinusUriageKykDtlList ADD CONSTRAINT PK_MinusUriageKykDtlList PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     creditkessaiyouno                                        , /* クレジットカード決済用番号 */
     uriagenengappi                                           , /* 売上年月日 */
     renno3keta                                                 /* 連番（３桁） */
) ;
