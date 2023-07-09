CREATE TABLE IW_KhSyoukenSaihakkouWk_Z (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     skssakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 請求書作成日 */
     syoukensaihkkbn                                    VARCHAR     (1)                                                                 ,  /* 証券再発行区分 */
     insizeishryouhikbn                                 VARCHAR     (1)                                                                 ,  /* 印紙税支払要否区分 */
     honninkakninkekkakbn                               VARCHAR     (1)                                                                 ,  /* 本人確認結果区分 */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     zenkaisyorikekkakbn                                VARCHAR     (3)                                                                 ,  /* 前回処理結果区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IW_KhSyoukenSaihakkouWk_Z ADD CONSTRAINT PK_IW_KhSyoukenSaihakkouWk PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;
