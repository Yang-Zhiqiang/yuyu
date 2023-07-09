CREATE TABLE BM_Tyouhyourenrakusaki (
     tyhyrenrakusikibetukbn                             VARCHAR     (2)                                                       NOT NULL  ,  /* 帳票連絡先識別区分                                     */
     cctelno                                            VARCHAR     (14)                                                                ,  /* コールセンター電話番号                                   */
     ccimagepath                                        VARCHAR     (120)                                                               ,  /* コールセンター画像パス                                   */
     sapodetelno                                        VARCHAR     (14)                                                                ,  /* サポートデスク電話番号                                   */
     sapodeimagepath                                    VARCHAR     (120)                                                               ,  /* サポートデスク画像パス                                   */
     sapodefaxno                                        VARCHAR     (14)                                                                ,  /* サポートデスクＦＡＸ番号                                  */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_Tyouhyourenrakusaki ADD CONSTRAINT PK_Tyouhyourenrakusaki PRIMARY KEY (
     tyhyrenrakusikibetukbn                                     /* 帳票連絡先識別区分                                      */
) ;
