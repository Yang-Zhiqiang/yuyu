CREATE TABLE IM_KhHenkouUktksyorikahi (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ */
     uktksyorikbn                                       VARCHAR     (2)                                                       NOT NULL  ,  /* 受付処理区分 */
     yuukoujyotaikahikbn                                VARCHAR     (1)                                                                 ,  /* 有効状態処理可否区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IM_KhHenkouUktksyorikahi ADD CONSTRAINT IM_KhHenkouUktksyorikahi PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ */
     uktksyorikbn                                               /* 受付処理区分 */
) ;
