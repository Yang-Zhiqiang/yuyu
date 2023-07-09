CREATE TABLE IT_ZennouTtdkKanryouTuuti (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     zennoustartym                                      VARCHAR     (6)                                                                 ,  /* 前納開始年月 */
     zennousyorikbn                                     VARCHAR     (1)                                                                 ,  /* 前納処理区分 */
     zennounyuukinsyoriymd                              VARCHAR     (8)                                                                 ,  /* 前納入金処理日 */
     zennounyuukindenymd                                VARCHAR     (8)                                                                 ,  /* 前納入金伝票日付 */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     zennoukikan                                        VARCHAR     (2)                                                                 ,  /* 前納期間 */
     zennounyuukinkgk                                   NUMBER      (13)                                                                ,  /* 前納入金額 */
     zennounyuukinkgk$                                  VARCHAR     (10)                                                                ,  /* 前納入金額(通貨型) */
     annaisaikaiym                                      VARCHAR     (6)                                                                 ,  /* 案内再開年月 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字） */
     kykseiymd                                          VARCHAR     (8)                                                                 ,  /* 契約者生年月日 */
     tsinyno                                            VARCHAR     (7)                                                                 ,  /* 通信先郵便番号 */
     tsinadr1kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所１（漢字） */
     tsinadr2kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所２（漢字） */
     tsinadr3kj                                         VARCHAR     (30)                                                                ,  /* 通信先住所３（漢字） */
     hhknnmkj                                           VARCHAR     (15)                                                                ,  /* 被保険者名（漢字） */
     hhknseiymd                                         VARCHAR     (8)                                                                 ,  /* 被保険者生年月日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_ZennouTtdkKanryouTuuti ADD CONSTRAINT PK_ZennouTtdkKanryouTuuti PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                                /* 帳票作成日 */
) ;
