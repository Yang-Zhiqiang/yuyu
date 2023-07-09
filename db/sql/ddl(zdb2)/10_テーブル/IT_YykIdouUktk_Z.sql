CREATE TABLE IT_YykIdouUktk_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ */
     yykidousyorikbn                                    VARCHAR     (1)                                                                 ,  /* 予約異動処理区分 */
     uktkymd                                            VARCHAR     (8)                                                                 ,  /* 受付日 */
     syoriym                                            VARCHAR     (6)                                                                 ,  /* 処理年月 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_YykIdouUktk_Z ADD CONSTRAINT PK_YykIdouUktk PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                        , /* 変更識別キー */
     kinouId                                                    /* 機能ＩＤ */
) ;

CREATE INDEX IX1_YykIdouUktk ON IT_YykIdouUktk_Z (
     syono                                                    , /* 証券番号 */
     henkousikibetukey                                        , /* 変更識別キー */
     kinouId                                                    /* 機能ＩＤ */
) ;
