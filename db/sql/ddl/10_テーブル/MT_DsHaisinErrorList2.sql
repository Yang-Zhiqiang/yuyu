CREATE TABLE MT_DsHaisinErrorList2 (
     dsdatasakuseiymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* ＤＳデータ作成日 */
     dsmailhaisinrenban                                 NUMBER      (9)                                                       NOT NULL  ,  /* ＤＳメール配信連番 */
     dskokno                                            VARCHAR     (10)                                                                ,  /* ＤＳ顧客番号 */
     dsmailaddressrenban                                NUMBER      (9)                                                                 ,  /* ＤＳメールアドレス連番 */
     dssousinmailsyubetukbn                             VARCHAR     (5)                                                                 ,  /* ＤＳ送信メール種別区分 */
     dssousinno                                         VARCHAR     (21)                                                                ,  /* ＤＳ送信番号 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     haisinjidsmailaddress                              VARCHAR     (100)                                                               ,  /* 配信時ＤＳメールアドレス */
     dsmailsousinymd                                    VARCHAR     (8)                                                                 ,  /* ＤＳメール送信日 */
     dsmailsakujyoymd                                   VARCHAR     (8)                                                                 ,  /* ＤＳメール削除日 */
     haisinerrorcount                                   VARCHAR     (36)                                                                ,  /* 配信エラーカウント */
     haisinerrorcount2                                  VARCHAR     (36)                                                                ,  /* 配信エラーカウント２ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE MT_DsHaisinErrorList2 ADD CONSTRAINT PK_DsHaisinErrorList2 PRIMARY KEY (
     dsdatasakuseiymd                                         , /* ＤＳデータ作成日 */
     dsmailhaisinrenban                                         /* ＤＳメール配信連番 */
) ;

CREATE INDEX IX1_DsHaisinErrorList2 ON MT_DsHaisinErrorList2 (
     dssousinno                                                 /* ＤＳ送信番号 */
) ;
