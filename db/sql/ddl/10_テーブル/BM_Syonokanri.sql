CREATE TABLE BM_Syonokanri (
     seirekinen2keta                                    VARCHAR     (2)                                                       NOT NULL  ,  /* 西暦年（２桁） */
     bosyuusosikicd                                     VARCHAR     (3)                                                       NOT NULL  ,  /* 募集組織コード */
     syonorenno                                         NUMBER      (5)                                                       NOT NULL  ,  /* 証券番号連番 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     saibanymd                                          VARCHAR     (8)                                                                 ,  /* 採番日 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_Syonokanri ADD CONSTRAINT PK_Syonokanri PRIMARY KEY (
     seirekinen2keta                                          , /* 西暦年（２桁） */
     bosyuusosikicd                                           , /* 募集組織コード */
     syonorenno                                                 /* 証券番号連番 */
) ;

CREATE INDEX IX1_Syonokanri ON BM_Syonokanri (
     syono                                                      /* 証券番号 */
) ;
