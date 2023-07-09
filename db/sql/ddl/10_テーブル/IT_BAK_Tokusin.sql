CREATE TABLE IT_BAK_Tokusin (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
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
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_BAK_Tokusin ADD CONSTRAINT PK_BAK_Tokusin PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                            /* 取消識別キー */
) ;
