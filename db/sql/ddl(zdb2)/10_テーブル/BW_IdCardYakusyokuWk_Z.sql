CREATE TABLE BW_IdCardYakusyokuWk_Z (
     idkbn                                              VARCHAR     (2)                                                       NOT NULL  ,  /* ＩＤ区分 */
     idcd                                               VARCHAR     (6)                                                       NOT NULL  ,  /* ＩＤコード */
     yakusyokuhatureiymd                                VARCHAR     (8)                                                       NOT NULL  ,  /* 役職発令年月日 */
     yakusyokuhatureino                                 VARCHAR     (2)                                                       NOT NULL  ,  /* 役職発令番号 */
     yakusyokuhatureisosikicd                           VARCHAR     (7)                                                                 ,  /* 役職発令組織コード */
     yakusyokucd                                        VARCHAR     (3)                                                                 ,  /* 役職コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BW_IdCardYakusyokuWk_Z ADD CONSTRAINT PK_IdCardYakusyokuWk PRIMARY KEY (
     idkbn                                                    , /* ＩＤ区分 */
     idcd                                                     , /* ＩＤコード */
     yakusyokuhatureiymd                                      , /* 役職発令年月日 */
     yakusyokuhatureino                                         /* 役職発令番号 */
) ;
