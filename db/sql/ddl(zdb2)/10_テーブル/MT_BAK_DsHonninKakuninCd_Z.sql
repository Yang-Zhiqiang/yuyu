CREATE TABLE MT_BAK_DsHonninKakuninCd_Z (
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     dskrhnnkakcd                                       VARCHAR     (20)                                                                ,  /* ＤＳ仮本人確認コード */
     dskrhnnkakcdsetkbn                                 VARCHAR     (1)                                                                 ,  /* ＤＳ仮本人確認コード設定区分 */
     dskrhnnkakcdsetymd                                 VARCHAR     (8)                                                                 ,  /* ＤＳ仮本人確認コード設定年月日 */
     dskrhnnkakcdyuukouymd                              VARCHAR     (8)                                                                 ,  /* ＤＳ仮本人確認コード有効年月日 */
     dshnnkakcd                                         VARCHAR     (128)                                                               ,  /* ＤＳ本人確認コード */
     dshnnkakcdsetymd                                   VARCHAR     (8)                                                                 ,  /* ＤＳ本人確認コード設定年月日 */
     zenkaidskrhnnkakcd                                 VARCHAR     (20)                                                                ,  /* 前回ＤＳ仮本人確認コード */
     dskrhnnkakcdttshjyhsymd                            VARCHAR     (8)                                                                 ,  /* ＤＳ仮本人確認コード通知送付事由発生日 */
     dskrhnnkakcdttyhkbn                                VARCHAR     (1)                                                                 ,  /* ＤＳ仮本人確認コード通知要否区分 */
     dskrhnnkakcdtttydnjykbn                            VARCHAR     (2)                                                                 ,  /* ＤＳ仮本人確認コード通知中断事由区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE MT_BAK_DsHonninKakuninCd_Z ADD CONSTRAINT PK_BAK_DsHonninKakuninCd PRIMARY KEY (
     dskokno                                                  , /* ＤＳ顧客番号 */
     trkssikibetukey                                            /* 取消識別キー */
) ;
