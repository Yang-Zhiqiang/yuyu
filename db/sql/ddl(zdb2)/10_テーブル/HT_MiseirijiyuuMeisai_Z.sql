CREATE TABLE HT_MiseirijiyuuMeisai_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     kyknmkn                                            VARCHAR     (38)                                                                ,  /* 契約者名（カナ） */
     sknnkaisiymd                                       VARCHAR     (8)                                                                 ,  /* 責任開始日 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     miseirijiyuukbn                                    VARCHAR     (2)                                                                 ,  /* 未整理事由区分 */
     miseirijiyuudetailkbn                              VARCHAR     (2)                                                                 ,  /* 未整理事由詳細区分 */
     nyuukinjoutaikbn                                   VARCHAR     (1)                                                                 ,  /* 入金状態区分 */
     syoruikbn1                                         VARCHAR     (2)                                                                 ,  /* 書類区分１ */
     syoruikbn2                                         VARCHAR     (2)                                                                 ,  /* 書類区分２ */
     syoruikbn3                                         VARCHAR     (2)                                                                 ,  /* 書類区分３ */
     syoruikbn4                                         VARCHAR     (2)                                                                 ,  /* 書類区分４ */
     syoruikbn5                                         VARCHAR     (2)                                                                 ,  /* 書類区分５ */
     syoruikbn6                                         VARCHAR     (2)                                                                 ,  /* 書類区分６ */
     syoruikbn7                                         VARCHAR     (2)                                                                 ,  /* 書類区分７ */
     syoruikbn8                                         VARCHAR     (2)                                                                 ,  /* 書類区分８ */
     syoruikbn9                                         VARCHAR     (2)                                                                 ,  /* 書類区分９ */
     syoruikbn10                                        VARCHAR     (2)                                                                 ,  /* 書類区分１０ */
     syoruihubikensuu                                   DECIMAL     (2)                                                                 ,  /* 書類不備件数 */
     syokaidenymd                                       VARCHAR     (8)                                                                 ,  /* 初回伝票日付 */
     syokairsymd                                        VARCHAR     (8)                                                                 ,  /* 初回領収日 */
     rsgakuen                                           DECIMAL     (13)                                                                ,  /* 領収金額（円） */
     rsgakuen$                                          VARCHAR     (10)                                                                ,  /* 領収金額（円）(通貨型) */
     rsgakugaika                                        DECIMAL     (13)                                                                ,  /* 領収金額（外貨） */
     rsgakugaika$                                       VARCHAR     (10)                                                                ,  /* 領収金額（外貨）(通貨型) */
     rstuukasyu                                         VARCHAR     (3)                                                                 ,  /* 領収通貨種類 */
     krkhuho2syoukai                                    DECIMAL     (13)                                                                ,  /* 仮受金（普保Ⅱ初回） */
     krkhuho2syoukai$                                   VARCHAR     (10)                                                                ,  /* 仮受金（普保Ⅱ初回）(通貨型) */
     krkhuho2kobetu                                     DECIMAL     (13)                                                                ,  /* 仮受金（普保Ⅱ個別） */
     krkhuho2kobetu$                                    VARCHAR     (10)                                                                ,  /* 仮受金（普保Ⅱ個別）(通貨型) */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     krkdai1kaikeijyougkyen                             DECIMAL     (13)                                                                ,  /* 仮受金（第１回）計上額（円） */
     krkdai1kaikeijyougkyen$                            VARCHAR     (10)                                                                ,  /* 仮受金（第１回）計上額（円）(通貨型) */
     krkdai1kaikeijyougkgaika                           DECIMAL     (13)                                                                ,  /* 仮受金（第１回）計上額（外貨） */
     krkdai1kaikeijyougkgaika$                          VARCHAR     (10)                                                                ,  /* 仮受金（第１回）計上額（外貨）(通貨型) */
     krkdai1kaituukasyu                                 VARCHAR     (3)                                                                    /* 仮受金（第１回）通貨種類 */
)
;

ALTER TABLE HT_MiseirijiyuuMeisai_Z ADD CONSTRAINT PK_MiseirijiyuuMeisai PRIMARY KEY (
     mosno                                                      /* 申込番号 */
) ;
