CREATE TABLE HT_RuleHanteiMsg_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     rulehanteimsg                                      VARCHAR     (1)                                                       NOT NULL  ,  /* ルール判定結果メッセージ区分 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     rulehanteimsgid                                    VARCHAR     (7)                                                                 ,  /* ルール判定結果メッセージＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_RuleHanteiMsg_Z ADD CONSTRAINT PK_RuleHanteiMsg PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     rulehanteimsg                                            , /* ルール判定結果メッセージ区分 */
     renno                                                      /* 連番 */
) ;
