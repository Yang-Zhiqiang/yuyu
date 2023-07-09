CREATE TABLE MT_SousaRirekiSyousai (
     ttdksikibetuid                                     VARCHAR     (10)                                                      NOT NULL  ,  /* 手続識別ＩＤ */
     sousarirekirenno                                   NUMBER      (2)                                                       NOT NULL  ,  /* 操作履歴連番 */
     syoriendymd                                        VARCHAR     (8)                                                                 ,  /* 処理終了日付 */
     syoriendtime                                       VARCHAR     (6)                                                                 ,  /* 処理終了時刻 */
     syorinaiyoukbn                                     VARCHAR     (3)                                                                 ,  /* 処理内容区分 */
     syorisyousai                                       VARCHAR     (200)                                                               ,  /* 処理詳細 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE MT_SousaRirekiSyousai ADD CONSTRAINT PK_SousaRirekiSyousai PRIMARY KEY (
     ttdksikibetuid                                           , /* 手続識別ＩＤ */
     sousarirekirenno                                           /* 操作履歴連番 */
) ;
