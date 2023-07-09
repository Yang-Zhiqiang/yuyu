CREATE TABLE IT_HsgbnktAnnaihouhoukanri (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     hsgymd                                             VARCHAR     (8)                                                       NOT NULL  ,  /* 被災害年月日 */
     bnktannaihouhoukbn                                 VARCHAR     (2)                                                                 ,  /* 分割案内方法区分 */
     bnktannaikaisiymd                                  VARCHAR     (8)                                                                 ,  /* 分割案内開始日 */
     bnktannaiendymd                                    VARCHAR     (8)                                                                 ,  /* 分割案内終了日 */
     hsgtkbtymd1                                        VARCHAR     (8)                                                                 ,  /* 被災害特別年月日１ */
     hsgtkbtymd2                                        VARCHAR     (8)                                                                 ,  /* 被災害特別年月日２ */
     hsgtkbtkbn1                                        VARCHAR     (2)                                                                 ,  /* 被災害特別区分１ */
     hsgtkbtkbn2                                        VARCHAR     (2)                                                                 ,  /* 被災害特別区分２ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_HsgbnktAnnaihouhoukanri ADD CONSTRAINT PK_HsgbnktAnnaihouhoukanri PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     hsgymd                                                     /* 被災害年月日 */
) ;

CREATE INDEX IX1_HsgbnktAnnaihouhoukanri ON IT_HsgbnktAnnaihouhoukanri (
     hsgymd                                                     /* 被災害年月日 */
) ;

CREATE INDEX IX2_HsgbnktAnnaihouhoukanri ON IT_HsgbnktAnnaihouhoukanri (
     bnktannaihouhoukbn                                         /* 分割案内方法区分 */
) ;
