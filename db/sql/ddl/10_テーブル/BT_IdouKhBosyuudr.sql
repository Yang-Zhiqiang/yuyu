CREATE TABLE BT_IdouKhBosyuudr (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     renno3keta                                         NUMBER      (3)                                                       NOT NULL  ,  /* 連番（３桁） */
     dairitencd1                                        VARCHAR     (7)                                                                 ,  /* 代理店コード１ */
     bunwari1                                           NUMBER      (3)                                                                 ,  /* 分担割合１ */
     dairitencd2                                        VARCHAR     (7)                                                                 ,  /* 代理店コード２ */
     bunwari2                                           NUMBER      (3)                                                                 ,  /* 分担割合２ */
     kanrisosikicd1                                     VARCHAR     (7)                                                                 ,  /* 管理組織コード１ */
     kanrisosikicd2                                     VARCHAR     (7)                                                                 ,  /* 管理組織コード２ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_IdouKhBosyuudr ADD CONSTRAINT PK_IdouKhBosyuudr PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     renno3keta                                                 /* 連番（３桁） */
) ;
