CREATE TABLE JT_SkKihon_Z (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     seikyuusyubetu                                     VARCHAR     (2)                                                                 ,  /* 請求種別 */
     saisateikbn                                        VARCHAR     (1)                                                                 ,  /* 再査定区分 */
     siboukaritrkymd                                    VARCHAR     (8)                                                                 ,  /* 死亡仮受付登録日 */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     kyknmkn                                            VARCHAR     (38)                                                                ,  /* 契約者名（カナ） */
     kykseiymd                                          VARCHAR     (8)                                                                 ,  /* 契約者生年月日 */
     kyksei                                             VARCHAR     (1)                                                                 ,  /* 契約者性別 */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     hhknnmkn                                           VARCHAR     (38)                                                                ,  /* 被保険者名（カナ） */
     hhknseiymd                                         VARCHAR     (8)                                                                 ,  /* 被保険者生年月日 */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     syorijyoutaikbn                                    VARCHAR     (1)                                                                 ,  /* 処理状態区分 */
     sateiyhkbn                                         VARCHAR     (1)                                                                 ,  /* 査定要否区分 */
     kakninumukbn                                       VARCHAR     (1)                                                                 ,  /* 確認有無区分 */
     hubijyoukyoukbn                                    VARCHAR     (1)                                                                 ,  /* 不備状況区分 */
     tyousajyoukyoukbn                                  VARCHAR     (1)                                                                 ,  /* 調査状況区分 */
     shrkekkakbn                                        VARCHAR     (1)                                                                 ,  /* 支払結果区分 */
     sbjishrumukbn                                      VARCHAR     (1)                                                                 ,  /* 死亡時支払有無区分 */
     saigaihigaitoukbn                                  VARCHAR     (1)                                                                 ,  /* 災害非該当区分 */
     gaibuinsatuoutymd                                  VARCHAR     (8)                                                                 ,  /* 外部印刷出力日 */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JT_SkKihon_Z ADD CONSTRAINT PK_SkKihon PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_SkKihon ON JT_SkKihon_Z (
     seikyuusyubetu                                             /* 請求種別 */
) ;

CREATE INDEX IX2_SkKihon ON JT_SkKihon_Z (
     gaibuinsatuoutymd                                          /* 外部印刷出力日 */
) ;

CREATE INDEX IX3_SkKihon ON JT_SkKihon_Z (
     siboukaritrkymd                                            /* 死亡仮受付登録日 */
) ;
