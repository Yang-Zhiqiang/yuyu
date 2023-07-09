CREATE TABLE MT_BAK_DsTorihikiServiceKanri_Z (
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     dstrhkserviceriyoujkkbn                            VARCHAR     (1)                                                                 ,  /* ＤＳ取引サービス利用状況区分 */
     dstrhkserviceteisiriyuukbn                         VARCHAR     (1)                                                                 ,  /* ＤＳ取引サービス停止理由区分 */
     dstrhkservicetourokuymd                            VARCHAR     (8)                                                                 ,  /* ＤＳ取引サービス登録年月日 */
     dstrhkservicemukouymd                              VARCHAR     (8)                                                                 ,  /* ＤＳ取引サービス無効年月日 */
     dstrhkservicekanyukeirokbn                         VARCHAR     (1)                                                                 ,  /* ＤＳ取引サービス加入経路区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE MT_BAK_DsTorihikiServiceKanri_Z ADD CONSTRAINT PK_BAK_DsTorihikiServiceKanri PRIMARY KEY (
     dskokno                                                  , /* ＤＳ顧客番号 */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                            /* 取消識別キー */
) ;
