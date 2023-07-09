CREATE TABLE BM_HaitouRiritu_Z (
     kijyunfromymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* 基準日自 */
     kijyuntoymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 基準日至 */
     haitouriritu                                       DECIMAL     (5,4)                                                     NOT NULL  ,  /* 配当利率 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_HaitouRiritu_Z ADD CONSTRAINT PK_HaitouRiritu PRIMARY KEY (
     kijyunfromymd                                            , /* 基準日自 */
     kijyuntoymd                                                /* 基準日至 */
) ;
