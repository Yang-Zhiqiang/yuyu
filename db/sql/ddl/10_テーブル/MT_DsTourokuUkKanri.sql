CREATE TABLE MT_DsTourokuUkKanri (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     dsttdksyubetukbn                                   VARCHAR     (2)                                                       NOT NULL  ,  /* ＤＳ手続種別区分 */
     datarenno                                          NUMBER      (5)                                                       NOT NULL  ,  /* データ連番 */
     dskokno                                            VARCHAR     (10)                                                                ,  /* ＤＳ顧客番号 */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     tourokustatus                                      VARCHAR     (1)                                                                 ,  /* 登録ステータス */
     dsjimukaisiymd                                     VARCHAR     (8)                                                                 ,  /* ＤＳ事務開始日 */
     dsjimukanryouymd                                   VARCHAR     (8)                                                                 ,  /* ＤＳ事務完了日 */
     dstourokukanryouymd                                VARCHAR     (8)                                                                 ,  /* ＤＳ登録完了日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE MT_DsTourokuUkKanri ADD CONSTRAINT PK_DsTourokuUkKanri PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     dsttdksyubetukbn                                         , /* ＤＳ手続種別区分 */
     datarenno                                                  /* データ連番 */
) ;

CREATE INDEX IX1_DsTourokuUkKanri ON MT_DsTourokuUkKanri (
     tourokustatus                                            , /* 登録ステータス */
     dsjimukaisiymd                                             /* ＤＳ事務開始日 */
) ;

CREATE INDEX IX2_DsTourokuUkKanri ON MT_DsTourokuUkKanri (
     dsjimukaisiymd                                             /* ＤＳ事務開始日 */
) ;
