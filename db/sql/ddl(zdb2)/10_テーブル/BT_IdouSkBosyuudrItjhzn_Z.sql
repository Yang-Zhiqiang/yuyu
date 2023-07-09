CREATE TABLE BT_IdouSkBosyuudrItjhzn_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     renno3keta                                         DECIMAL     (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     dairitencd1                                        VARCHAR     (7)                                                                 ,  /* 代理店コード１ */
     bunwari1                                           DECIMAL     (3)                                                                 ,  /* 分担割合１ */
     dairitencd2                                        VARCHAR     (7)                                                                 ,  /* 代理店コード２ */
     bunwari2                                           DECIMAL     (3)                                                                 ,  /* 分担割合２ */
     kanrisosikicd1                                     VARCHAR     (7)                                                                 ,  /* 管理組織コード１ */
     kanrisosikicd2                                     VARCHAR     (7)                                                                 ,  /* 管理組織コード２ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_IdouSkBosyuudrItjhzn_Z ADD CONSTRAINT PK_IdouSkBosyuudrItjhzn PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     renno3keta                                                 /* 連番（３桁） */
) ;
