CREATE TABLE JT_BetukutiSateiInfo (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号                                          */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号                                          */
     seikyuurirekino                                    NUMBER      (3)                                                       NOT NULL  ,  /* 請求履歴番号                                        */
     betusibouumukbn                                    VARCHAR     (1)                                                                 ,  /* 別口死亡有無区分                                      */
     betusiboucomment                                   VARCHAR     (40)                                                                ,  /* 別口死亡コメント                                      */
     betukdsgumukbn                                     VARCHAR     (1)                                                                 ,  /* 別口高度障害有無区分                                    */
     betukdsgcomment                                    VARCHAR     (40)                                                                ,  /* 別口高度障害コメント                                    */
     betusoukiumukbn                                    VARCHAR     (1)                                                                 ,  /* 別口早期有無区分                                      */
     betusoukicomment                                   VARCHAR     (40)                                                                ,  /* 別口早期コメント                                      */
     betusymtkykumukbn                                  VARCHAR     (1)                                                                 ,  /* 別口消滅契約有無区分                                    */
     betusymtkykcomment                                 VARCHAR     (40)                                                                ,  /* 別口消滅契約コメント                                    */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード                                       */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード                                     */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ                                      */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE JT_BetukutiSateiInfo ADD CONSTRAINT PK_BetukutiSateiInfo PRIMARY KEY (
     skno                                                     , /* 請求番号                                           */
     syono                                                    , /* 証券番号                                           */
     seikyuurirekino                                            /* 請求履歴番号                                         */
) ;
