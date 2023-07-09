CREATE TABLE MT_DsLoginKanri_Z (
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     syokailoginymd                                     VARCHAR     (8)                                                                 ,  /* 初回ログイン年月日 */
     syokailogintime                                    VARCHAR     (6)                                                                 ,  /* 初回ログイン時刻 */
     syokailoginbaitaikbn                               VARCHAR     (1)                                                                 ,  /* 初回ログイン媒体区分 */
     saisinloginymd                                     VARCHAR     (8)                                                                 ,  /* 最新ログイン年月日 */
     saisinlogintime                                    VARCHAR     (6)                                                                 ,  /* 最新ログイン時刻 */
     saisinloginbaitaikbn                               VARCHAR     (1)                                                                 ,  /* 最新ログイン媒体区分 */
     dshnnkakcderrorkaisuu                              DECIMAL     (2)                                                                 ,  /* ＤＳ本人確認コードエラー回数 */
     dskokyakunmerrorkaisuu                             DECIMAL     (2)                                                                 ,  /* ＤＳ顧客名エラー回数 */
     dskokyakuseiymderrorkaisuu                         DECIMAL     (2)                                                                 ,  /* ＤＳ顧客生年月日エラー回数 */
     dskokyakutelnoerrorkaisuu                          DECIMAL     (2)                                                                 ,  /* ＤＳ顧客電話番号エラー回数 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE MT_DsLoginKanri_Z ADD CONSTRAINT PK_DsLoginKanri PRIMARY KEY (
     dskokno                                                    /* ＤＳ顧客番号 */
) ;
