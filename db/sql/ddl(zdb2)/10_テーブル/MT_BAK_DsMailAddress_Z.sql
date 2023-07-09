CREATE TABLE MT_BAK_DsMailAddress_Z (
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     dsmailaddressrenban                                DECIMAL     (9)                                                       NOT NULL  ,  /* ＤＳメールアドレス連番 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     dsmailtourokujyoutaikbn                            VARCHAR     (1)                                                                 ,  /* ＤＳメール登録状態区分 */
     dsmailaddress                                      VARCHAR     (100)                                                               ,  /* ＤＳメールアドレス */
     dsmailsousinjyoutaikbn                             VARCHAR     (1)                                                                 ,  /* ＤＳメール送信状態区分 */
     dsmailsousintisrykbn                               VARCHAR     (1)                                                                 ,  /* ＤＳメール送信停止理由区分 */
     dstourokuymdtime                                   VARCHAR     (17)                                                                ,  /* ＤＳ登録日時 */
     dskousinymdtime                                    VARCHAR     (17)                                                                ,  /* ＤＳ更新日時 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE MT_BAK_DsMailAddress_Z ADD CONSTRAINT PK_BAK_DsMailAddress PRIMARY KEY (
     dskokno                                                  , /* ＤＳ顧客番号 */
     dsmailaddressrenban                                      , /* ＤＳメールアドレス連番 */
     trkssikibetukey                                            /* 取消識別キー */
) ;
