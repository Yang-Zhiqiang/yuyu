CREATE TABLE IW_KhNkShrTokuyakuHenkouWk (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     skssakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 請求書作成日 */
     nkshrtkykhnkkbn                                    VARCHAR     (1)                                                                 ,  /* 年金支払特約変更区分 */
     nkshrtkyknksyukbn                                  VARCHAR     (1)                                                                 ,  /* 年金支払特約年金種類区分 */
     nkshrtkyknksyukkn                                  NUMBER      (2)                                                                 ,  /* 年金支払特約年金期間 */
     honninkakninkekkakbn                               VARCHAR     (1)                                                                 ,  /* 本人確認結果区分 */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     zenkaisyorikekkakbn                                VARCHAR     (3)                                                                 ,  /* 前回処理結果区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IW_KhNkShrTokuyakuHenkouWk ADD CONSTRAINT PK_KhNkShrTokuyakuHenkouWk PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;
