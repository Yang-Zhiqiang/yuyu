CREATE TABLE IT_Tokusin_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tokusinkbn                                         VARCHAR     (1)                                                                 ,  /* 特伸区分 */
     tokusinsyoriymd                                    VARCHAR     (8)                                                                 ,  /* 特伸処理年月日 */
     hsgymd                                             VARCHAR     (8)                                                                 ,  /* 被災害年月日 */
     tokusinendymd                                      VARCHAR     (8)                                                                 ,  /* 特伸終了日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_Tokusin_Z ADD CONSTRAINT PK_Tokusin PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_Tokusin ON IT_Tokusin_Z (
     syono                                                      /* 証券番号 */
) ;
