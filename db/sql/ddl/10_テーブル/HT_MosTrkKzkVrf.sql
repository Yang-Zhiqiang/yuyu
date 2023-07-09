CREATE TABLE HT_MosTrkKzkVrf (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     trkkzkkbn                                          VARCHAR     (1)                                                       NOT NULL  ,  /* 登録家族区分 */
     trkkzknmkn                                         VARCHAR     (18)                                                                ,  /* 登録家族名（カナ） */
     trkkzknmkj                                         VARCHAR     (15)                                                                ,  /* 登録家族名（漢字） */
     trkkzknmkjkhukakbn                                 VARCHAR     (1)                                                                 ,  /* 登録家族名漢字化不可区分 */
     trkkzkseiymd                                       VARCHAR     (8)                                                                 ,  /* 登録家族生年月日 */
     trkkzksei                                          VARCHAR     (1)                                                                 ,  /* 登録家族性別 */
     trkkzktdk                                          VARCHAR     (2)                                                                 ,  /* 登録家族続柄 */
     trkkzktsindousiteikbn                              VARCHAR     (1)                                                                 ,  /* 登録家族通信先同一指定区分 */
     trkkzkyno                                          VARCHAR     (7)                                                                 ,  /* 登録家族郵便番号 */
     trkkzkadr1kj                                       VARCHAR     (30)                                                                ,  /* 登録家族住所１（漢字） */
     trkkzkadr2kj                                       VARCHAR     (30)                                                                ,  /* 登録家族住所２（漢字） */
     trkkzkadr3kj                                       VARCHAR     (30)                                                                ,  /* 登録家族住所３（漢字） */
     trkkzktelno                                        VARCHAR     (14)                                                                ,  /* 登録家族電話番号 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_MosTrkKzkVrf ADD CONSTRAINT PK_MosTrkKzkVrf PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     trkkzkkbn                                                  /* 登録家族区分 */
) ;
