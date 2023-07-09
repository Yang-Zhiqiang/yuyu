CREATE TABLE IT_KhUriageSeikyuuKekkaData_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     creditkessaiyouno                                  VARCHAR     (26)                                                      NOT NULL  ,  /* クレジットカード決済用番号 */
     uriagenengappi                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 売上年月日 */
     renno3keta                                         DECIMAL     (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     recordno                                           VARCHAR     (2)                                                                 ,  /* レコード番号 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     authorikbn                                         VARCHAR     (1)                                                                 ,  /* オーソリ区分 */
     uriageseikyuutorihikicd                            VARCHAR     (1)                                                                 ,  /* 売上請求取引コード */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     credityuukoukigen                                  VARCHAR     (4)                                                                 ,  /* クレジット有効期限 */
     credituriagegk                                     DECIMAL     (13)                                                                ,  /* クレジットカード売上金額 */
     credituriagegk$                                    VARCHAR     (10)                                                                ,  /* クレジットカード売上金額(通貨型) */
     creditkaiinnokami6keta                             VARCHAR     (6)                                                                 ,  /* クレジット会員番号（上６桁） */
     creditkaiinnosimo4keta                             VARCHAR     (4)                                                                 ,  /* クレジット会員番号（下４桁） */
     uriageseikyuuerrorcd                               VARCHAR     (3)                                                                 ,  /* 売上請求エラーコード */
     credituriagengjiyuu                                VARCHAR     (2)                                                                 ,  /* クレジットカード売上請求ＮＧ事由 */
     fukusuukameitennokey                               VARCHAR     (7)                                                                 ,  /* 複数加盟店番号設定キー情報 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KhUriageSeikyuuKekkaData_Z ADD CONSTRAINT PK_UriageKekkaData PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     creditkessaiyouno                                        , /* クレジットカード決済用番号 */
     uriagenengappi                                           , /* 売上年月日 */
     renno3keta                                                 /* 連番（３桁） */
) ;
