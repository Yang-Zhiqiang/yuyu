CREATE TABLE HT_Nyuukin_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     soukinymd                                          VARCHAR     (8)                                                                 ,  /* 送金日 */
     tyakkinymd                                         VARCHAR     (8)                                                                 ,  /* 着金日 */
     nyksyoriymd                                        VARCHAR     (8)                                                                 ,  /* 入金処理日 */
     nyknsyubetu                                        VARCHAR     (2)                                                                 ,  /* 入金種別 */
     soukincd                                           VARCHAR     (10)                                                                ,  /* 送金コード */
     rsgaku                                             DECIMAL     (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     rstuukasyu                                         VARCHAR     (3)                                                                 ,  /* 領収通貨種類 */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     rssyouno                                           VARCHAR     (20)                                                                ,  /* 領収証番号 */
     zenhnknkbn                                         VARCHAR     (1)                                                                 ,  /* 全額返金区分 */
     srgonyknumu                                        VARCHAR     (1)                                                                 ,  /* 成立後入金有無 */
     denrenno                                           VARCHAR     (20)                                                                ,  /* 伝票データ連番 */
     edano                                              DECIMAL     (2)                                                                 ,  /* 枝番号 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     krkno                                              DECIMAL     (5)                                                                 ,  /* 仮受番号 */
     dntcd                                              VARCHAR     (8)                                                                 ,  /* 団体コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     nyuukinhenkinsyorikbn                              VARCHAR     (2)                                                                 ,  /* 入金返金処理区分 */
     nyuukinsyoritime                                   VARCHAR     (17)                                                                ,  /* 入金処理日時 */
     zenhnknrenno                                       DECIMAL     (2)                                                                 ,  /* 全額返金連番 */
     denrenno2                                          VARCHAR     (20)                                                                   /* 伝票データ連番２ */
)
;

ALTER TABLE HT_Nyuukin_Z ADD CONSTRAINT PK_Nyuukin PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     renno                                                      /* 連番 */
) ;

CREATE INDEX IX1_Nyuukin ON HT_Nyuukin_Z (
     nyksyoriymd                                              , /* 入金処理日 */
     mosno                                                      /* 申込番号 */
) ;

CREATE INDEX IX2_Nyuukin ON HT_Nyuukin_Z (
     nyksyoriymd                                              , /* 入金処理日 */
     rstuukasyu                                               , /* 領収通貨種類 */
     nyuukinhenkinsyorikbn                                      /* 入金返金処理区分 */
) ;
