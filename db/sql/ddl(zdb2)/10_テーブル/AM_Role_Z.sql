CREATE TABLE AM_Role_Z (
     roleCd                                             VARCHAR     (30)                                                      NOT NULL  ,  /* ロールコード */
     roleNm                                             VARCHAR     (32)                                                                ,  /* ロール名 */
     roleSetumei                                        VARCHAR     (202)                                                               ,  /* ロール説明 */
     sysSiyouKbn                                        VARCHAR     (1)                                                                 ,  /* システム使用区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AM_Role_Z ADD CONSTRAINT AM_RolePk PRIMARY KEY (
     roleCd                                                     /* ロールコード */
) ;
