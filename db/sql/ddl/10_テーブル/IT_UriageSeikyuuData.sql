CREATE TABLE IT_UriageSeikyuuData (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     creditkessaiyouno                                  VARCHAR     (26)                                                      NOT NULL  ,  /* クレジットカード決済用番号 */
     uriagenengappi                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 売上年月日 */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     recordno                                           VARCHAR     (2)                                                                 ,  /* レコード番号 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     credituriageseikyuukbn                             VARCHAR     (1)                                                                 ,  /* クレジットカード売上請求区分 */
     authorikbn                                         VARCHAR     (1)                                                                 ,  /* オーソリ区分 */
     credituriagegk                                     NUMBER      (13)                                                                ,  /* クレジットカード売上金額 */
     credituriagegk$                                    VARCHAR     (10)                                                                ,  /* クレジットカード売上金額(通貨型) */
     fukusuukameitennokey                               VARCHAR     (7)                                                                 ,  /* 複数加盟店番号設定キー情報 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuum                                      NUMBER      (2)                                                                 ,  /* 充当回数（月） */
     jyutoukaisuuy                                      NUMBER      (2)                                                                 ,  /* 充当回数（年） */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     nyknaiyoukbn                                       VARCHAR     (2)                                                                 ,  /* 入金内容区分 */
     annaino                                            NUMBER      (2)                                                                 ,  /* 案内番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_UriageSeikyuuData ADD CONSTRAINT PK_UriageSeikyuuData PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     creditkessaiyouno                                        , /* クレジットカード決済用番号 */
     uriagenengappi                                           , /* 売上年月日 */
     renno3keta                                                 /* 連番（３桁） */
) ;

CREATE INDEX IX1_UriageSeikyuuData ON IT_UriageSeikyuuData (
     syono                                                      /* 証券番号 */
) ;
