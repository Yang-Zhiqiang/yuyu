CREATE TABLE MT_DsHaisinErrorList (
     dsdatasakuseiymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* ＤＳデータ作成日 */
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     dsmailaddressrenban                                NUMBER      (9)                                                       NOT NULL  ,  /* ＤＳメールアドレス連番 */
     haisinjidsmailaddress                              VARCHAR     (100)                                                               ,  /* 配信時ＤＳメールアドレス */
     dssousinno                                         VARCHAR     (21)                                                                ,  /* ＤＳ送信番号 */
     haisinerrorcount                                   VARCHAR     (36)                                                                ,  /* 配信エラーカウント */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE MT_DsHaisinErrorList ADD CONSTRAINT PK_DsHaisinErrorList PRIMARY KEY (
     dsdatasakuseiymd                                         , /* ＤＳデータ作成日 */
     dskokno                                                  , /* ＤＳ顧客番号 */
     dsmailaddressrenban                                        /* ＤＳメールアドレス連番 */
) ;

CREATE INDEX IX1_DsHaisinErrorList ON MT_DsHaisinErrorList (
     dssousinno                                                 /* ＤＳ送信番号 */
) ;
