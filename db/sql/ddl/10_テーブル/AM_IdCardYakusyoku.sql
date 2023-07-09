CREATE TABLE AM_IdCardYakusyoku (
     idkbn                                              VARCHAR     (2)                                                       NOT NULL  ,  /* ＩＤ区分 */
     idcd                                               VARCHAR     (6)                                                       NOT NULL  ,  /* ＩＤコード */
     yakusyokuhatureiymd                                VARCHAR     (8)                                                       NOT NULL  ,  /* 役職発令年月日 */
     yakusyokuhatureino                                 VARCHAR     (2)                                                       NOT NULL  ,  /* 役職発令番号 */
     yakusyokuhatureisosikicd                           VARCHAR     (7)                                                                 ,  /* 役職発令組織コード */
     yakusyokucd                                        VARCHAR     (3)                                                                 ,  /* 役職コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE AM_IdCardYakusyoku ADD CONSTRAINT AM_IdCardYakusyokuPk PRIMARY KEY (
     idkbn                                                    , /* ＩＤ区分 */
     idcd                                                     , /* ＩＤコード */
     yakusyokuhatureiymd                                      , /* 役職発令年月日 */
     yakusyokuhatureino                                         /* 役職発令番号 */
) ;
