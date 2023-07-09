CREATE TABLE MW_DsMailHaisinRirekiWk (
     dsdatasakuseiymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* ＤＳデータ作成日 */
     dskokno                                            VARCHAR     (10)                                                      NOT NULL  ,  /* ＤＳ顧客番号 */
     dsmailhaisinrenban                                 NUMBER      (9)                                                       NOT NULL  ,  /* ＤＳメール配信連番 */
     haisinjidsmailaddress                              VARCHAR     (100)                                                               ,  /* 配信時ＤＳメールアドレス */
     dssousinno                                         VARCHAR     (21)                                                                ,  /* ＤＳ送信番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     dssousinmailsyubetukbn                             VARCHAR     (5)                                                                 ,  /* ＤＳ送信メール種別区分 */
     syono                                              VARCHAR     (20)                                                                   /* 証券番号 */
)
;

ALTER TABLE MW_DsMailHaisinRirekiWk ADD CONSTRAINT PK_DsMailHaisinRirekiWk PRIMARY KEY (
     dsdatasakuseiymd                                         , /* ＤＳデータ作成日 */
     dskokno                                                  , /* ＤＳ顧客番号 */
     dsmailhaisinrenban                                         /* ＤＳメール配信連番 */
) ;
