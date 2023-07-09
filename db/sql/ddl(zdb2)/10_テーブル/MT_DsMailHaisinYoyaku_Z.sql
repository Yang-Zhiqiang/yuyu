CREATE TABLE MT_DsMailHaisinYoyaku_Z (
     dsmailhaisinyoyakuskbtkey                          VARCHAR     (11)                                                      NOT NULL  ,  /* ＤＳメール配信予約識別キー */
     dsmailhaisinyoteiymd                               VARCHAR     (8)                                                                 ,  /* ＤＳメール配信（予定）日 */
     dssousinmailsyubetukbn                             VARCHAR     (5)                                                                 ,  /* ＤＳ送信メール種別区分 */
     dshaisinyoyakustatuskbn                            VARCHAR     (1)                                                                 ,  /* ＤＳ配信予約ステータス区分 */
     dsmailhaisintourokuymd                             VARCHAR     (8)                                                                 ,  /* ＤＳメール配信登録日 */
     dsmailhaisinsyouninymd                             VARCHAR     (8)                                                                 ,  /* ＤＳメール配信承認日 */
     dsmailhaisintourokusyaid                           VARCHAR     (30)                                                                ,  /* ＤＳメール配信登録者ＩＤ */
     dsmailhaisinsyouninsyaid                           VARCHAR     (30)                                                                ,  /* ＤＳメール配信承認者ＩＤ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE MT_DsMailHaisinYoyaku_Z ADD CONSTRAINT PK_DsMailHaisinYoyaku PRIMARY KEY (
     dsmailhaisinyoyakuskbtkey                                  /* ＤＳメール配信予約識別キー */
) ;

CREATE INDEX IX1_DsMailHaisinYoyaku ON MT_DsMailHaisinYoyaku_Z (
     dsmailhaisinyoteiymd                                       /* ＤＳメール配信（予定）日 */
) ;

CREATE INDEX IX2_DsMailHaisinYoyaku ON MT_DsMailHaisinYoyaku_Z (
     dssousinmailsyubetukbn                                     /* ＤＳ送信メール種別区分 */
) ;

CREATE INDEX IX3_DsMailHaisinYoyaku ON MT_DsMailHaisinYoyaku_Z (
     dshaisinyoyakustatuskbn                                    /* ＤＳ配信予約ステータス区分 */
) ;
