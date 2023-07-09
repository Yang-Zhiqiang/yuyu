CREATE TABLE AS_Sakujyotaisyo (
     sakujyoTableId                                     VARCHAR     (100)                                                     NOT NULL  ,  /* 削除対象テーブルＩＤ                                    */
     sakujyoKbn                                         VARCHAR     (1)                                                                 ,  /* 削除区分                                          */
     sakujyoKey                                         VARCHAR     (30)                                                                ,  /* 削除キー                                          */
     sakujyoKeyKbn                                      VARCHAR     (1)                                                                 ,  /* 削除キー区分                                        */
     hozonKikan                                         NUMBER      (2)                                                                 ,  /* 保存期間                                          */
     nengappiKbn                                        VARCHAR     (1)                                                                 ,  /* 年月日区分                                         */
     dataTaihiKbn                                       VARCHAR     (1)                                                                 ,  /* データ退避区分                                       */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE AS_Sakujyotaisyo ADD CONSTRAINT AS_SakujyotaisyoPk PRIMARY KEY (
     sakujyoTableId                                             /* 削除対象テーブルＩＤ                                     */
) ;
