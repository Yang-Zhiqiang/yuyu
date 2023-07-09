CREATE TABLE IT_Zennou_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     zennoukaisiymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* 前納開始年月日 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     zennounyuukinsyoriymd                              VARCHAR     (8)                                                                 ,  /* 前納入金処理日 */
     zennounyuukindenno                                 VARCHAR     (20)                                                                ,  /* 前納入金伝票番号 */
     zennounyuukindenymd                                VARCHAR     (8)                                                                 ,  /* 前納入金伝票日付 */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     zennoukikan                                        VARCHAR     (2)                                                                 ,  /* 前納期間 */
     zennounyuukinkgk                                   DECIMAL     (13)                                                                ,  /* 前納入金額 */
     zennounyuukinkgk$                                  VARCHAR     (10)                                                                ,  /* 前納入金額(通貨型) */
     zennoujihrkp                                       DECIMAL     (13)                                                                ,  /* 前納時払込保険料 */
     zennoujihrkp$                                      VARCHAR     (10)                                                                ,  /* 前納時払込保険料(通貨型) */
     zennouseisankbn                                    VARCHAR     (1)                                                                 ,  /* 前納精算区分 */
     zennouseisansyoriymd                               VARCHAR     (8)                                                                 ,  /* 前納精算処理日 */
     zennouseisankgk                                    DECIMAL     (13)                                                                ,  /* 前納精算金額 */
     zennouseisankgk$                                   VARCHAR     (10)                                                                ,  /* 前納精算金額(通貨型) */
     zennouseisankijyunymd                              VARCHAR     (8)                                                                 ,  /* 前納精算基準日 */
     zennouseisandenymd                                 VARCHAR     (8)                                                                 ,  /* 前納精算伝票日付 */
     annaisaikaiym                                      VARCHAR     (6)                                                                 ,  /* 案内再開年月 */
     kjsmyouzennoukaisiymd                              VARCHAR     (8)                                                                 ,  /* 控除証明用前納開始年月日 */
     kjsmyouzennoukikanm                                VARCHAR     (4)                                                                 ,  /* 控除証明用前納期間（月） */
     kjsmyouzennounyuukinkgk                            DECIMAL     (13)                                                                ,  /* 控除証明用前納入金額 */
     kjsmyouzennounyuukinkgk$                           VARCHAR     (10)                                                                ,  /* 控除証明用前納入金額(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_Zennou_Z ADD CONSTRAINT PK_Zennou PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     zennoukaisiymd                                           , /* 前納開始年月日 */
     renno                                                      /* 連番 */
) ;
