CREATE TABLE AS_TyouhyouSakujyotaisyo_Z (
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     hozonKikan                                         DECIMAL     (2)                                                                 ,  /* 保存期間 */
     nengetukbn                                         VARCHAR     (1)                                                                 ,  /* 年月区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AS_TyouhyouSakujyotaisyo_Z ADD CONSTRAINT AS_TyouhyouSakujyotaisyoPk PRIMARY KEY (
     syoruiCd                                                   /* 書類コード */
) ;
