CREATE TABLE MT_DsHanyouKokyakuateTuuti2 (
     dsdatasakuseiymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* ＤＳデータ作成日 */
     dskoktuutirenno                                    VARCHAR     (15)                                                      NOT NULL  ,  /* ＤＳ顧客通知連番 */
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     dshanyoukokyakuatetuutikbn                         VARCHAR     (3)                                                       NOT NULL  ,  /* ＤＳ汎用顧客宛通知区分 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     dssousinno                                         VARCHAR     (21)                                                                ,  /* ＤＳ送信番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE MT_DsHanyouKokyakuateTuuti2 ADD CONSTRAINT PK_DsHanyouKokyakuateTuuti2 PRIMARY KEY (
     dsdatasakuseiymd                                         , /* ＤＳデータ作成日 */
     dskoktuutirenno                                          , /* ＤＳ顧客通知連番 */
     dskokno                                                  , /* ＤＳ顧客番号 */
     dshanyoukokyakuatetuutikbn                                 /* ＤＳ汎用顧客宛通知区分 */
) ;
