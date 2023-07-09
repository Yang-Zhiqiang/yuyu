CREATE TABLE BM_Address (
     postalCd                                           VARCHAR     (7)                                                       NOT NULL  ,  /* 郵便番号 */
     kihontikucdsimo1                                   VARCHAR     (1)                                                       NOT NULL  ,  /* 基本地区コード下１桁 */
     kihontikucdsyoumetukbn                             VARCHAR     (1)                                                                 ,  /* 基本地区コード消滅理由区分 */
     kjadrkyoutotuusyounmari                            VARCHAR     (50)                                                                ,  /* 漢字住所（京都市内通称町名あり） */
     kjtodouhukennmketasuu                              NUMBER      (1)                                                                 ,  /* 漢字都道府県名桁数 */
     kjsikugunnmketasuu                                 NUMBER      (2)                                                                 ,  /* 漢字市区郡名桁数 */
     kjsikutyousonnmketasuu                             NUMBER      (2)                                                                 ,  /* 漢字市区町村名桁数 */
     kjtyousonnmketasuu                                 NUMBER      (2)                                                                 ,  /* 漢字町村名桁数 */
     kjkyoutotuusyounmketasuu                           NUMBER      (2)                                                                 ,  /* 漢字京都市内通称町名桁数 */
     kjadrketasuu                                       NUMBER      (2)                                                                 ,  /* 漢字住所桁数 */
     knadrkyoutotuusyounmari                            VARCHAR     (100)                                                               ,  /* カナ住所（京都市内通称町名あり） */
     kntodouhukennmketasuu                              NUMBER      (1)                                                                 ,  /* カナ都道府県名桁数 */
     knsikugunnmketasuu                                 NUMBER      (2)                                                                 ,  /* カナ市区郡名桁数 */
     knsikutyousonnmketasuu                             NUMBER      (2)                                                                 ,  /* カナ市区町村名桁数 */
     kntyousonnmketasuu                                 NUMBER      (2)                                                                 ,  /* カナ町村名桁数 */
     knkyoutotuusyounmketasuu                           NUMBER      (2)                                                                 ,  /* カナ京都市内通称町名桁数 */
     knadrketasuu                                       NUMBER      (3)                                                                 ,  /* カナ住所桁数 */
     todouhukencd                                       VARCHAR     (2)                                                                 ,  /* 都道府県コード */
     gyouseikukakucd                                    VARCHAR     (3)                                                                 ,  /* 行政区画コード */
     ikoumaekihontikucd                                 VARCHAR     (8)                                                                 ,  /* 移行前基本地区コード */
     newynohyouji                                       VARCHAR     (1)                                                                 ,  /* 新郵便番号表示 */
     adrkj                                              VARCHAR     (50)                                                                ,  /* 住所（漢字） */
     adrkn                                              VARCHAR     (100)                                                               ,  /* 住所（カナ） */
     adrknblankari                                      VARCHAR     (100)                                                               ,  /* 住所（カナ）（空白あり） */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_Address ADD CONSTRAINT PK_Address PRIMARY KEY (
     postalCd                                                 , /* 郵便番号 */
     kihontikucdsimo1                                           /* 基本地区コード下１桁 */
) ;

CREATE INDEX IX1_Address ON BM_Address (
     postalCd                                                 , /* 郵便番号 */
     kihontikucdsyoumetukbn                                     /* 基本地区コード消滅理由区分 */
) ;
