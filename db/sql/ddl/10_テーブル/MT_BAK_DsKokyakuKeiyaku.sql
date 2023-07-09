CREATE TABLE MT_BAK_DsKokyakuKeiyaku (
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     dskykkanyuuymd                                     VARCHAR     (8)                                                                 ,  /* ＤＳ契約加入年月日 */
     dskykhenkouymd                                     VARCHAR     (8)                                                                 ,  /* ＤＳ契約変更年月日 */
     dskykmukouhyj                                      VARCHAR     (1)                                                                 ,  /* ＤＳ契約無効表示 */
     dskykmukouymd                                      VARCHAR     (8)                                                                 ,  /* ＤＳ契約無効年月日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     pplessrenjidssymenttdkhyj                          VARCHAR     (1)                                                                    /* ペーパーレス連動時ＤＳ書面手続表示 */
)
;

ALTER TABLE MT_BAK_DsKokyakuKeiyaku ADD CONSTRAINT PK_BAK_DsKokyakuKeiyaku PRIMARY KEY (
     dskokno                                                  , /* ＤＳ顧客番号 */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                            /* 取消識別キー */
) ;
