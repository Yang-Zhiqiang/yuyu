CREATE TABLE BM_SyoruiZokuseiHukaInfo (
     syoruiCd                                           VARCHAR     (5)                                                       NOT NULL  ,  /* 書類コード */
     subSystemId                                        VARCHAR     (50)                                                                ,  /* サブシステムＩＤ */
     tyouhyououtkinousiyouumu                           VARCHAR     (1)                                                                 ,  /* 帳票出力機能使用有無 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_SyoruiZokuseiHukaInfo ADD CONSTRAINT PK_SyoruiZokuseiHukaInfo PRIMARY KEY (
     syoruiCd                                                   /* 書類コード */
) ;
