CREATE TABLE JT_SkHubiMsg_Z (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     seikyuurirekino                                    DECIMAL     (3)                                                       NOT NULL  ,  /* 請求履歴番号 */
     renno3keta                                         DECIMAL     (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     uketukeno                                          DECIMAL     (2)                                                                 ,  /* 受付番号 */
     msgsyubetu                                         VARCHAR     (1)                                                                 ,  /* メッセージ種別 */
     hubimsgid                                          VARCHAR     (10)                                                                ,  /* 不備メッセージＩＤ */
     hubimsg                                            VARCHAR     (302)                                                               ,  /* 不備メッセージ */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JT_SkHubiMsg_Z ADD CONSTRAINT PK_SkHubiMsg PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     seikyuurirekino                                          , /* 請求履歴番号 */
     renno3keta                                                 /* 連番（３桁） */
) ;
