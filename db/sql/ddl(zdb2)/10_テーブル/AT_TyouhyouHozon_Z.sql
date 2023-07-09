CREATE TABLE AT_TyouhyouHozon_Z (
     reportKey                                          VARCHAR     (20)                                                      NOT NULL  ,  /* 帳票キー */
     pdfData                                            BLOB        (1048576)                                                           ,  /* ＰＤＦデータ */
     tyouhyouJoinKey                                    VARCHAR     (20)                                                                ,  /* 帳票結合キー */
     angoukaKbn                                         VARCHAR     (1)                                                                 ,  /* 暗号化区分 */
     pdfHozonKbn                                        VARCHAR     (1)                                                                 ,  /* ＰＤＦ保存区分 */
     zipHozonKbn                                        VARCHAR     (1)                                                                 ,  /* ＺＩＰ保存区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE AT_TyouhyouHozon_Z ADD CONSTRAINT AT_TyouhyouHozonPK PRIMARY KEY (
     reportKey                                                  /* 帳票キー */
) ;

CREATE INDEX CT_TyouhyouHozon_IX1 ON AT_TyouhyouHozon_Z (
     tyouhyouJoinKey                                            /* 帳票結合キー */
) ;
