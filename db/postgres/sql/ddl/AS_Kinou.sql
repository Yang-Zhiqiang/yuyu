CREATE TABLE AS_Kinou (
     kinouId                                            varchar     (50)                                                      NOT NULL  ,  /* 機能ＩＤ                                          */
     subSystemId                                        varchar     (50)                                                                ,  /* サブシステムＩＤ                                      */
     categoryId                                         varchar     (50)                                                                ,  /* カテゴリＩＤ                                        */
     kinouNm                                            varchar     (30)                                                                ,  /* 機能名                                           */
     sortNo                                             decimal     (3)                                                                 ,  /* ソート番号                                         */
     kinouKbn                                           varchar     (3)                                                                 ,  /* 機能区分                                          */
     jikkouPath                                         varchar     (150)                                                               ,  /* 実行パス                                          */
     kinouSetumei                                       varchar     (200)                                                               ,  /* 機能説明                                          */
     batchKyouseiSyuuryouFlag                           varchar     (1)                                                                 ,  /* バッチ強制終了フラグ                                    */
     menuHyoujiKahi                                     decimal     (1)                                                                 ,  /* メニュー表示可否                                      */
     batchLogHyoujiKbn                                  varchar     (1)                                                                 ,  /* バッチログ表示区分                                     */
     kidouKengenHanteiYouhiKbn                          varchar     (1)                                                                 ,  /* 起動権限判定要否区分                                    */
     kinouTeigiTaisyouKbn                               varchar     (1)                                                                 ,  /* 機能定義対象区分                                      */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AS_Kinou ADD CONSTRAINT AS_KinouPk PRIMARY KEY (
     kinouId                                                    /* 機能ＩＤ                                           */
) ;
