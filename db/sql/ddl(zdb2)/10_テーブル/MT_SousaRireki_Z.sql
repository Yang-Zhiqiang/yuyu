CREATE TABLE MT_SousaRireki_Z (
     ttdksikibetuid                                     VARCHAR     (10)                                                      NOT NULL  ,  /* 手続識別ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     dskokno                                            VARCHAR     (10)                                                                ,  /* ＤＳ顧客番号 */
     ttdkstartymd                                       VARCHAR     (8)                                                                 ,  /* 手続開始日付 */
     ttdkstarttime                                      VARCHAR     (6)                                                                 ,  /* 手続開始時刻 */
     ttdkendymd                                         VARCHAR     (8)                                                                 ,  /* 手続終了日付 */
     ttdkendtime                                        VARCHAR     (6)                                                                 ,  /* 手続終了時刻 */
     ttdkkinoukbn                                       VARCHAR     (2)                                                                 ,  /* 手続機能区分 */
     sousarirekijkkbn                                   VARCHAR     (1)                                                                 ,  /* 操作履歴状況区分 */
     sousarirekikekkakbn                                VARCHAR     (1)                                                                 ,  /* 操作履歴結果区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE MT_SousaRireki_Z ADD CONSTRAINT PK_SousaRireki PRIMARY KEY (
     ttdksikibetuid                                             /* 手続識別ＩＤ */
) ;

CREATE INDEX IX1_SousaRireki ON MT_SousaRireki_Z (
     syono                                                    , /* 証券番号 */
     ttdkstartymd                                               /* 手続開始日付 */
) ;

CREATE INDEX IX2_SousaRireki ON MT_SousaRireki_Z (
     ttdkstartymd                                               /* 手続開始日付 */
) ;
