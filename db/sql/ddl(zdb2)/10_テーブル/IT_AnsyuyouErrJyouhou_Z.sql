CREATE TABLE IT_AnsyuyouErrJyouhou_Z (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     kakutyoujobcd                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 拡張ジョブコード */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     gyoumuKousinTime                                   VARCHAR     (17)                                                      NOT NULL  ,  /* 業務用更新時間 */
     ansyuyouerrnaiyou                                  VARCHAR     (142)                                                     NOT NULL  ,  /* 案内収納用エラー内容 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_AnsyuyouErrJyouhou_Z ADD CONSTRAINT PK_AnsyuyouErrJyouhou PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     kakutyoujobcd                                            , /* 拡張ジョブコード */
     syono                                                    , /* 証券番号 */
     gyoumuKousinTime                                         , /* 業務用更新時間 */
     ansyuyouerrnaiyou                                          /* 案内収納用エラー内容 */
) ;
