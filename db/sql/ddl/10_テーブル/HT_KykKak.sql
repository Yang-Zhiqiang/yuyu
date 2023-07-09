CREATE TABLE HT_KykKak (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号                                          */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番                                            */
     kykkaksyrui                                        VARCHAR     (2)                                                                 ,  /* 契約確認種類                                        */
     kykkaktantcd                                       VARCHAR     (12)                                                                ,  /* 契約確認担当者コード                                    */
     kykkakkaisyacd                                     VARCHAR     (12)                                                                ,  /* 契約確認会社コード                                     */
     kykkakiraiymd                                      VARCHAR     (8)                                                                 ,  /* 契約確認依頼日                                       */
     kykkakkanytymd                                     VARCHAR     (8)                                                                 ,  /* 契約確認完了予定日                                     */
     kykkakkekkbn                                       VARCHAR     (2)                                                                 ,  /* 契約確認結果区分                                      */
     kykkakkanymd                                       VARCHAR     (8)                                                                 ,  /* 契約確認完了日                                       */
     kykkakcomment                                      VARCHAR     (154)                                                               ,  /* 契約確認コメント                                      */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE HT_KykKak ADD CONSTRAINT PK_KykKak PRIMARY KEY (
     mosno                                                    , /* 申込番号                                           */
     renno                                                      /* 連番                                             */
) ;
