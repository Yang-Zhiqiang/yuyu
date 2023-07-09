CREATE TABLE IT_UriageSkDataSyuKnr (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     creditkessaiyouno                                  VARCHAR     (26)                                                      NOT NULL  ,  /* クレジットカード決済用番号 */
     uriagenengappi                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 売上年月日 */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     credituriagekekkahaneiymd                          VARCHAR     (8)                                                                 ,  /* クレジットカード売上請求結果反映日 */
     credituragskkkmhnkkchkzmflg                        CHAR        (1)                                                                 ,  /* クレジットカード売上請求結果未返却チェック済フラグ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_UriageSkDataSyuKnr ADD CONSTRAINT PK_UriageSkDataSyuKnr PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     creditkessaiyouno                                        , /* クレジットカード決済用番号 */
     uriagenengappi                                           , /* 売上年月日 */
     renno3keta                                                 /* 連番（３桁） */
) ;
