CREATE TABLE MT_SousaRirekiIvrInfo_Z (
     ttdksikibetuid                                     VARCHAR     (10)                                                      NOT NULL  ,  /* 手続識別ＩＤ */
     tyakusinymd                                        VARCHAR     (14)                                                                ,  /* 着信日時 */
     dsgyoumucd                                         VARCHAR     (2)                                                                 ,  /* ＤＳ業務コード */
     syorinaiyoukbn                                     VARCHAR     (3)                                                                 ,  /* 処理内容区分 */
     callid                                             VARCHAR     (18)                                                                ,  /* コールＩＤ */
     dssyorikekkakbn                                    VARCHAR     (1)                                                                 ,  /* ＤＳ処理結果区分 */
     setudankasyokbn                                    VARCHAR     (3)                                                                 ,  /* 切断箇所区分 */
     setudanriyuukbn                                    VARCHAR     (2)                                                                 ,  /* 切断理由区分 */
     tuuwatime                                          VARCHAR     (10)                                                                ,  /* 通話時間 */
     ttdkisihyouzikbn                                   VARCHAR     (1)                                                                 ,  /* 手続意思表示区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE MT_SousaRirekiIvrInfo_Z ADD CONSTRAINT PK_SousaRirekiIvrInfo PRIMARY KEY (
     ttdksikibetuid                                             /* 手続識別ＩＤ */
) ;
