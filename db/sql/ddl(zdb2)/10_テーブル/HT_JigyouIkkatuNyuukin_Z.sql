CREATE TABLE HT_JigyouIkkatuNyuukin_Z (
     daimosno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 代表申込番号 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     soukinymd                                          VARCHAR     (8)                                                                 ,  /* 送金日 */
     soukincd                                           VARCHAR     (10)                                                                ,  /* 送金コード */
     rsgaku                                             DECIMAL     (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     rssyouno                                           VARCHAR     (20)                                                                ,  /* 領収証番号 */
     zenhnknkbn                                         VARCHAR     (1)                                                                 ,  /* 全額返金区分 */
     srgonyknumu                                        VARCHAR     (1)                                                                 ,  /* 成立後入金有無 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     krkno                                              DECIMAL     (5)                                                                 ,  /* 仮受番号 */
     dntcd                                              VARCHAR     (8)                                                                 ,  /* 団体コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE HT_JigyouIkkatuNyuukin_Z ADD CONSTRAINT PK_JigyouIkkatuNyuukin PRIMARY KEY (
     daimosno                                                 , /* 代表申込番号 */
     renno                                                      /* 連番 */
) ;
