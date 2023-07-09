CREATE TABLE MT_DsMailAddressSpiralYyk (
     dsdatasakuseiymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* ＤＳデータ作成日 */
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     dsmailaddressrenban                                NUMBER      (9)                                                       NOT NULL  ,  /* ＤＳメールアドレス連番 */
     dsmailaddress                                      VARCHAR     (100)                                                               ,  /* ＤＳメールアドレス */
     dsrendoutaisyoukbn                                 VARCHAR     (1)                                                                 ,  /* ＤＳ連動対象区分 */
     dsmaildbsyorikbn                                   VARCHAR     (1)                                                                 ,  /* ＤＳメールＤＢ処理区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE MT_DsMailAddressSpiralYyk ADD CONSTRAINT PK_DsMailAddressSpiralYyk PRIMARY KEY (
     dsdatasakuseiymd                                         , /* ＤＳデータ作成日 */
     dskokno                                                  , /* ＤＳ顧客番号 */
     dsmailaddressrenban                                        /* ＤＳメールアドレス連番 */
) ;
