CREATE TABLE AS_Kinou_Z (
     kinouId                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 機能ＩＤ */
     subSystemId                                        VARCHAR     (50)                                                                ,  /* サブシステムＩＤ */
     categoryId                                         VARCHAR     (50)                                                                ,  /* カテゴリＩＤ */
     kinouNm                                            VARCHAR     (62)                                                                ,  /* 機能名 */
     sortNo                                             DECIMAL     (3)                                                                 ,  /* ソート番号 */
     kinouKbn                                           VARCHAR     (1)                                                                 ,  /* 機能区分 */
     jikkouPath                                         VARCHAR     (200)                                                               ,  /* 実行パス */
     kinouSetumei                                       VARCHAR     (402)                                                               ,  /* 機能説明 */
     batchKyouseiSyuuryouFlag                           VARCHAR     (1)                                                                 ,  /* バッチ強制終了フラグ */
     menuHyoujiKahi                                     VARCHAR     (1)                                                                 ,  /* メニュー表示可否 */
     batchLogHyoujiKbn                                  VARCHAR     (1)                                                                 ,  /* バッチログ表示区分 */
     kidouKengenHanteiYouhiKbn                          VARCHAR     (1)                                                                 ,  /* 起動権限判定要否区分 */
     kinouTeigiTaisyouKbn                               VARCHAR     (1)                                                                 ,  /* 機能定義対象区分 */
     syoricd                                            VARCHAR     (4)                                                                 ,  /* 処理コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AS_Kinou_Z ADD CONSTRAINT AS_KinouPk PRIMARY KEY (
     kinouId                                                    /* 機能ＩＤ */
) ;
