CREATE TABLE IT_KhTRAuthoriKekkaHihoji_Z (
     creditkessaiyouno                                  VARCHAR     (26)                                                      NOT NULL  ,  /* クレジットカード決済用番号 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     cardbrandkbn                                       VARCHAR     (2)                                                                 ,  /* カードブランド区分 */
     creditkaiinnosimo4keta                             VARCHAR     (4)                                                                 ,  /* クレジット会員番号（下４桁） */
     authorijkkbn                                       VARCHAR     (1)                                                                 ,  /* オーソリ状況区分 */
     datajyusinymd                                      VARCHAR     (14)                                                                ,  /* データ受信日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KhTRAuthoriKekkaHihoji_Z ADD CONSTRAINT PK_KhTRAuthoriKekkaHihoji PRIMARY KEY (
     creditkessaiyouno                                        , /* クレジットカード決済用番号 */
     syoriYmd                                                   /* 処理年月日 */
) ;
