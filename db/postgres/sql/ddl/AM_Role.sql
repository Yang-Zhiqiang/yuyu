CREATE TABLE AM_Role (
     roleCd                                             varchar     (30)                                                      NOT NULL  ,  /* ロールコード                                        */
     roleNm                                             varchar     (30)                                                                ,  /* ロール名                                          */
     roleSetumei                                        varchar     (200)                                                               ,  /* ロール説明                                         */
     sysSiyouKbn                                        varchar     (1)                                                                 ,  /* システム使用区分                                      */
     kousinsyaId                                        varchar     (30)                                                                ,  /* 更新者ＩＤ                                         */
     kousinTime                                         varchar     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        varchar     (50)                                                                ,  /* 更新機能                                          */
     version                                            bigint                                                                             /* バージョン                                         */
)
;

ALTER TABLE AM_Role ADD CONSTRAINT AM_RolePk PRIMARY KEY (
     roleCd                                                     /* ロールコード                                         */
) ;
