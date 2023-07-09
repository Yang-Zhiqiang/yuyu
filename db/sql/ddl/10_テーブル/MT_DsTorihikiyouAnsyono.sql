CREATE TABLE MT_DsTorihikiyouAnsyono (
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tokuteitrhkansyono                                 VARCHAR     (24)                                                                ,  /* 特定取引用暗証番号 */
     tktrhkansyonoerrorkaisuu                           NUMBER      (2)                                                                 ,  /* 特定取引用暗証番号エラー回数 */
     setymd                                             VARCHAR     (8)                                                                 ,  /* 設定年月日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE MT_DsTorihikiyouAnsyono ADD CONSTRAINT PK_DsTorihikiyouAnsyono PRIMARY KEY (
     dskokno                                                  , /* ＤＳ顧客番号 */
     syono                                                      /* 証券番号 */
) ;
