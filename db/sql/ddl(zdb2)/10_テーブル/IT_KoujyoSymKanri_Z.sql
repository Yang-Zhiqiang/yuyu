CREATE TABLE IT_KoujyoSymKanri_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     nendo                                              VARCHAR     (4)                                                       NOT NULL  ,  /* 年度 */
     lastsyoumeiendym                                   VARCHAR     (6)                                                                 ,  /* 最終証明終了年月 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KoujyoSymKanri_Z ADD CONSTRAINT PK_KoujyoSymKanri PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     nendo                                                      /* 年度 */
) ;

CREATE INDEX IX1_KoujyoSymKanri ON IT_KoujyoSymKanri_Z (
     syono                                                    , /* 証券番号 */
     nendo                                                      /* 年度 */
) ;
