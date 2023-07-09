CREATE TABLE AS_KinouMode (
     kinouId                                            varchar     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     kinouModeId                                        varchar     (50)                                                      NOT NULL  ,  /* 機能モードＩＤ                                       */
     kinouModeNm                                        varchar     (50)                                                                ,  /* 機能モード名                                        */
     sortNo                                             decimal     (3)                                                                 ,  /* ソート番号                                         */
     yuukouKbn                                          varchar     (1)                                                                 ,  /* 有効区分                                          */
     yuukouKaisiYmd                                     varchar     (8)                                                                 ,  /* 有効開始年月日                                       */
     kadouTimeGroupCd                                   varchar     (20)                                                                ,  /* 稼働時間グループコード                                   */
     batchHeisouKahiKbn                                 varchar     (1)                                                                 ,  /* バッチ並走可否区分                                     */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AS_KinouMode ADD CONSTRAINT AS_KinouModePK PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ                                           */
     kinouModeId                                                /* 機能モードＩＤ                                        */
) ;
