CREATE TABLE MT_DsTtdkRireki_Z (
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     dssyorikbn                                         VARCHAR     (2)                                                                 ,  /* ＤＳ処理区分 */
     henkourrkumu                                       VARCHAR     (1)                                                                 ,  /* 変更履歴有無 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE MT_DsTtdkRireki_Z ADD CONSTRAINT PK_DsTtdkRireki PRIMARY KEY (
     dskokno                                                  , /* ＤＳ顧客番号 */
     henkousikibetukey                                          /* 変更識別キー */
) ;
