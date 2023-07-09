CREATE TABLE BM_SosikiMadoguti (
     sskmdsosikicd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* 組織窓口用組織コード                                    */
     sskmdhassoukbn                                     VARCHAR     (1)                                                                 ,  /* 組織窓口用発送区分                                     */
     sskmdkanjisosikinm                                 VARCHAR     (40)                                                                ,  /* 組織窓口用漢字組織名                                    */
     sskmdkanjisosikiadr1                               VARCHAR     (30)                                                                ,  /* 組織窓口用漢字組織住所１                                  */
     sskmdkanjisosikiadr2                               VARCHAR     (30)                                                                ,  /* 組織窓口用漢字組織住所２                                  */
     sskmdkanjisosikiadr3                               VARCHAR     (30)                                                                ,  /* 組織窓口用漢字組織住所３                                  */
     sskmdpostalcd                                      VARCHAR     (8)                                                                 ,  /* 組織窓口用郵便番号                                     */
     sskmdtelno                                         VARCHAR     (15)                                                                ,  /* 組織窓口用電話番号                                     */
     sskmdfaxno                                         VARCHAR     (15)                                                                ,  /* 組織窓口用ＦＡＸ番号                                    */
     sskmdsisyaharaidasikznm                            VARCHAR     (5)                                                                 ,  /* 組織窓口用支社払出口座名                                  */
     sskmdkouzanocd                                     VARCHAR     (1)                                                                 ,  /* 組織窓口用口座番号ＣＤ                                   */
     sskmdsisyaharaidasikouzano                         VARCHAR     (7)                                                                 ,  /* 組織窓口用支社払出口座番号                                 */
     sskmdsosikikbnnm                                   VARCHAR     (12)                                                                ,  /* 組織窓口用組織区分名                                    */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE BM_SosikiMadoguti ADD CONSTRAINT PK_SosikiMadoguti PRIMARY KEY (
     sskmdsosikicd                                              /* 組織窓口用組織コード                                     */
) ;
