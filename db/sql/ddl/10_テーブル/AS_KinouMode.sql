CREATE TABLE AS_KinouMode (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     kinouModeId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* 機能モードＩＤ                                       */
     kinouModeNm                                        VARCHAR     (50)                                                                ,  /* 機能モード名                                        */
     sortNo                                             NUMBER      (3)                                                                 ,  /* ソート番号                                         */
     yuukouKbn                                          VARCHAR     (1)                                                                 ,  /* 有効区分                                          */
     yuukouKaisiYmd                                     VARCHAR     (8)                                                                 ,  /* 有効開始年月日                                       */
     kadouTimeGroupCd                                   VARCHAR     (20)                                                                ,  /* 稼働時間グループコード                                   */
     batchHeisouKahiKbn                                 VARCHAR     (1)                                                                 ,  /* バッチ並走可否区分                                     */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AS_KinouMode ADD CONSTRAINT AS_KinouModePK PRIMARY KEY (
     kinouId                                                  , /* 機能ＩＤ                                           */
     kinouModeId                                                /* 機能モードＩＤ                                        */
) ;
