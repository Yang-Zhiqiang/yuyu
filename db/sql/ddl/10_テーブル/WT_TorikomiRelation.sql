CREATE TABLE WT_TorikomiRelation (
     iwfImageId                                         VARCHAR     (20)                                                      NOT NULL  ,  /* IWFイメージＩＤ */
     gyoumuKey                                          VARCHAR     (20)                                                      NOT NULL  ,  /* 業務キー */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE WT_TorikomiRelation ADD CONSTRAINT PK_TorikomiRelation PRIMARY KEY (
     gyoumuKey                                                , /* 業務キー */
     iwfImageId                                                 /* IWFイメージＩＤ */
) ;

CREATE INDEX WT_TORIKOMIRELATIONIdx1 ON WT_TorikomiRelation (
     iwfImageId                                                 /* IWFイメージＩＤ */
) ;
