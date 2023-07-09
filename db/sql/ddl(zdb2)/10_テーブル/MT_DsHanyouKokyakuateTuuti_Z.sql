CREATE TABLE MT_DsHanyouKokyakuateTuuti_Z (
     dsdatasakuseiymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* ＤＳデータ作成日 */
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     dshanyoukokyakuatetuutikbn                         VARCHAR     (3)                                                       NOT NULL  ,  /* ＤＳ汎用顧客宛通知区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE MT_DsHanyouKokyakuateTuuti_Z ADD CONSTRAINT PK_DsHanyouKokyakuateTuuti PRIMARY KEY (
     dsdatasakuseiymd                                         , /* ＤＳデータ作成日 */
     dskokno                                                  , /* ＤＳ顧客番号 */
     dshanyoukokyakuatetuutikbn                                 /* ＤＳ汎用顧客宛通知区分 */
) ;
