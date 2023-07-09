CREATE TABLE DM_Jimutetuzuki (
     jimutetuzukicd                                     VARCHAR     (19)                                                      NOT NULL  ,  /* 事務手続コード                                       */
     subSystemId                                        VARCHAR     (50)                                                      NOT NULL  ,  /* サブシステムＩＤ                                      */
     jimutetuzukinm                                     VARCHAR     (20)                                                                ,  /* 事務手続名                                         */
     imagerenkeikbn                                     VARCHAR     (1)                                                                 ,  /* イメージ連携区分                                      */
     hyoujijyun                                         NUMBER      (2)                                                                 ,  /* 表示順                                           */
     syukouteijimutetuzukicd                            VARCHAR     (19)                                                                ,  /* 主工程事務手続コード                                    */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE DM_Jimutetuzuki ADD CONSTRAINT DM_JimutetuzukiPk PRIMARY KEY (
     jimutetuzukicd                                           , /* 事務手続コード                                        */
     subSystemId                                                /* サブシステムＩＤ                                       */
) ;
