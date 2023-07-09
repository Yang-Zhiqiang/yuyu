CREATE TABLE IM_Syorijtkahi_Z (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ */
     syorijimuttdkcd                                    VARCHAR     (19)                                                      NOT NULL  ,  /* 処理中事務手続コード */
     syoritaskid                                        VARCHAR     (50)                                                      NOT NULL  ,  /* 処理中タスクＩＤ */
     yuukoujyotaikahikbn                                VARCHAR     (1)                                                                 ,  /* 有効状態処理可否区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IM_Syorijtkahi_Z ADD CONSTRAINT PK_Syorijtkahi PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ */
     syorijimuttdkcd                                          , /* 処理中事務手続コード */
     syoritaskid                                                /* 処理中タスクＩＤ */
) ;
