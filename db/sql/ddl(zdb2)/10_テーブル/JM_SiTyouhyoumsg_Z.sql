CREATE TABLE JM_SiTyouhyoumsg_Z (
     bunrui1                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 分類１ */
     bunrui2                                            VARCHAR     (50)                                                      NOT NULL  ,  /* 分類２ */
     tyouhyoulineno                                     DECIMAL     (3)                                                       NOT NULL  ,  /* 帳票行番号 */
     setteikasyo                                        VARCHAR     (102)                                                               ,  /* 設定箇所 */
     tyouhyoumsg                                        VARCHAR     (122)                                                               ,  /* 帳票メッセージ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JM_SiTyouhyoumsg_Z ADD CONSTRAINT PK_SiTyouhyoumsg PRIMARY KEY (
     bunrui1                                                  , /* 分類１ */
     bunrui2                                                  , /* 分類２ */
     tyouhyoulineno                                             /* 帳票行番号 */
) ;
