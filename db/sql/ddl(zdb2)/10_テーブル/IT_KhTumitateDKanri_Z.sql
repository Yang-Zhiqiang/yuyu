CREATE TABLE IT_KhTumitateDKanri_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tumitatedtumitateymd                               VARCHAR     (8)                                                       NOT NULL  ,  /* 積立Ｄ積立年月日 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     tumitatedskskbn                                    VARCHAR     (2)                                                       NOT NULL  ,  /* 積立Ｄ作成区分 */
     tumitated                                          DECIMAL     (13)                                                      NOT NULL  ,  /* 積立Ｄ */
     tumitated$                                         VARCHAR     (10)                                                      NOT NULL  ,  /* 積立Ｄ(通貨型) */
     tumitatedshrkrkymd                                 VARCHAR     (8)                                                                 ,  /* 積立Ｄ支払効力日 */
     naiteikakuteikbn                                   VARCHAR     (1)                                                                 ,  /* 内定確定区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KhTumitateDKanri_Z ADD CONSTRAINT PK_TumitateDKanri PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tumitatedtumitateymd                                     , /* 積立Ｄ積立年月日 */
     renno                                                      /* 連番 */
) ;

CREATE INDEX IX1_TumitateDKanri ON IT_KhTumitateDKanri_Z (
     syono                                                      /* 証券番号 */
) ;
