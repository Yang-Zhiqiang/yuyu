CREATE TABLE IT_HhknSya_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kokno                                              VARCHAR     (10)                                                                ,  /* 顧客番号 */
     hhknsakuinmeino                                    VARCHAR     (10)                                                                ,  /* 被保険者索引名番号 */
     hhknnmkn                                           VARCHAR     (38)                                                                ,  /* 被保険者名（カナ） */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     hhknnmkjkhukakbn                                   VARCHAR     (1)                                                                 ,  /* 被保険者名漢字化不可区分 */
     hhknseiymd                                         VARCHAR     (8)                                                                 ,  /* 被保険者生年月日 */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     hhknyno                                            VARCHAR     (7)                                                                 ,  /* 被保険者郵便番号 */
     hhknadr1kn                                         VARCHAR     (62)                                                                ,  /* 被保険者住所１（カナ） */
     hhknadr1kj                                         VARCHAR     (62)                                                                ,  /* 被保険者住所１（漢字） */
     hhknadr2kn                                         VARCHAR     (62)                                                                ,  /* 被保険者住所２（カナ） */
     hhknadr2kj                                         VARCHAR     (62)                                                                ,  /* 被保険者住所２（漢字） */
     hhknadr3kn                                         VARCHAR     (62)                                                                ,  /* 被保険者住所３（カナ） */
     hhknadr3kj                                         VARCHAR     (62)                                                                ,  /* 被保険者住所３（漢字） */
     hhkntelno                                          VARCHAR     (14)                                                                ,  /* 被保険者電話番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_HhknSya_Z ADD CONSTRAINT PK_HhknSya PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_HhknSya ON IT_HhknSya_Z (
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX2_HhknSya ON IT_HhknSya_Z (
     hhknseiymd                                                 /* 被保険者生年月日 */
) ;
