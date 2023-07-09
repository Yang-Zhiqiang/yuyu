CREATE TABLE ST_SuuriyouErrJyouhou_Z (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     kakutyoujobcd                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 拡張ジョブコード */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     gyoumuKousinTime                                   VARCHAR     (17)                                                      NOT NULL  ,  /* 業務用更新時間 */
     suuritoukeiyouerrnaiyou                            VARCHAR     (175)                                                     NOT NULL  ,  /* 数理統計用エラー内容 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ST_SuuriyouErrJyouhou_Z ADD CONSTRAINT PK_SuuriyouErrJyouhou PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     kakutyoujobcd                                            , /* 拡張ジョブコード */
     syono                                                    , /* 証券番号 */
     gyoumuKousinTime                                         , /* 業務用更新時間 */
     suuritoukeiyouerrnaiyou                                    /* 数理統計用エラー内容 */
) ;
