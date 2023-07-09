CREATE TABLE IT_BAK_AeoiInfo_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     aeoisyoriymd                                       VARCHAR     (8)                                                                 ,  /* ＡＥＯＩ処理年月日 */
     aeoisyorikbn                                       VARCHAR     (2)                                                                 ,  /* ＡＥＯＩ処理区分 */
     aeoikouryokusttymd                                 VARCHAR     (8)                                                                 ,  /* ＡＥＯＩ効力開始年月日 */
     aeoisyorisosikicd                                  VARCHAR     (7)                                                                 ,  /* ＡＥＯＩ処理組織コード */
     aeoitaisyousyakbn                                  VARCHAR     (1)                                                                 ,  /* ＡＥＯＩ対象者区分 */
     aeoikekkakbn                                       VARCHAR     (1)                                                                 ,  /* ＡＥＯＩ結果区分 */
     aeoihoujinsyuruikbn                                VARCHAR     (1)                                                                 ,  /* ＡＥＯＩ法人種類区分 */
     aeoikouryokuendymd                                 VARCHAR     (8)                                                                 ,  /* ＡＥＯＩ効力終了年月日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_BAK_AeoiInfo_Z ADD CONSTRAINT PK_BAK_AeoiInfo PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     renno                                                      /* 連番 */
) ;
