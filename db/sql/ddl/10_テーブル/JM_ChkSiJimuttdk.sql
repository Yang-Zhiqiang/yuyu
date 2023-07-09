CREATE TABLE JM_ChkSiJimuttdk (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ */
     syorijimuttdkcd                                    VARCHAR     (19)                                                      NOT NULL  ,  /* 処理中事務手続コード */
     sknaiyouchkkbn                                     VARCHAR     (5)                                                                 ,  /* 請求内容チェック区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE JM_ChkSiJimuttdk ADD CONSTRAINT PK_SiJimuttdkChk PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ */
     syorijimuttdkcd                                            /* 処理中事務手続コード */
) ;
