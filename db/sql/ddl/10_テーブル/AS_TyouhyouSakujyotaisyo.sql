CREATE TABLE AS_TyouhyouSakujyotaisyo (
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     hozonKikan                                         NUMBER      (2)                                                                 ,  /* 保存期間 */
     nengetukbn                                         VARCHAR     (1)                                                                 ,  /* 年月区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE AS_TyouhyouSakujyotaisyo ADD CONSTRAINT AS_TyouhyouSakujyotaisyoPk PRIMARY KEY (
     syoruiCd                                                   /* 書類コード */
) ;
