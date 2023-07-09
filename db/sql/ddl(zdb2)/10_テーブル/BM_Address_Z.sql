CREATE TABLE BM_Address_Z (
     postalCd                                           VARCHAR     (7)                                                       NOT NULL  ,  /* 郵便番号 */
     kihontikucdsimo1                                   VARCHAR     (1)                                                       NOT NULL  ,  /* 基本地区コード下１桁 */
     kihontikucdsyoumetukbn                             VARCHAR     (1)                                                                 ,  /* 基本地区コード消滅理由区分 */
     kjadrkyoutotuusyounmari                            VARCHAR     (102)                                                               ,  /* 漢字住所（京都市内通称町名あり） */
     kjtodouhukennmketasuu                              DECIMAL     (1)                                                                 ,  /* 漢字都道府県名桁数 */
     kjsikugunnmketasuu                                 DECIMAL     (2)                                                                 ,  /* 漢字市区郡名桁数 */
     kjsikutyousonnmketasuu                             DECIMAL     (2)                                                                 ,  /* 漢字市区町村名桁数 */
     kjtyousonnmketasuu                                 DECIMAL     (2)                                                                 ,  /* 漢字町村名桁数 */
     kjkyoutotuusyounmketasuu                           DECIMAL     (2)                                                                 ,  /* 漢字京都市内通称町名桁数 */
     kjadrketasuu                                       DECIMAL     (2)                                                                 ,  /* 漢字住所桁数 */
     knadrkyoutotuusyounmari                            VARCHAR     (202)                                                               ,  /* カナ住所（京都市内通称町名あり） */
     kntodouhukennmketasuu                              DECIMAL     (1)                                                                 ,  /* カナ都道府県名桁数 */
     knsikugunnmketasuu                                 DECIMAL     (2)                                                                 ,  /* カナ市区郡名桁数 */
     knsikutyousonnmketasuu                             DECIMAL     (2)                                                                 ,  /* カナ市区町村名桁数 */
     kntyousonnmketasuu                                 DECIMAL     (2)                                                                 ,  /* カナ町村名桁数 */
     knkyoutotuusyounmketasuu                           DECIMAL     (2)                                                                 ,  /* カナ京都市内通称町名桁数 */
     knadrketasuu                                       DECIMAL     (3)                                                                 ,  /* カナ住所桁数 */
     todouhukencd                                       VARCHAR     (2)                                                                 ,  /* 都道府県コード */
     gyouseikukakucd                                    VARCHAR     (3)                                                                 ,  /* 行政区画コード */
     ikoumaekihontikucd                                 VARCHAR     (8)                                                                 ,  /* 移行前基本地区コード */
     newynohyouji                                       VARCHAR     (1)                                                                 ,  /* 新郵便番号表示 */
     adrkj                                              VARCHAR     (102)                                                               ,  /* 住所（漢字） */
     adrkn                                              VARCHAR     (202)                                                               ,  /* 住所（カナ） */
     adrknblankari                                      VARCHAR     (202)                                                               ,  /* 住所（カナ）（空白あり） */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_Address_Z ADD CONSTRAINT PK_Address PRIMARY KEY (
     postalCd                                                 , /* 郵便番号 */
     kihontikucdsimo1                                           /* 基本地区コード下１桁 */
) ;

CREATE INDEX IX1_Address ON BM_Address_Z (
     postalCd                                                 , /* 郵便番号 */
     kihontikucdsyoumetukbn                                     /* 基本地区コード消滅理由区分 */
) ;
