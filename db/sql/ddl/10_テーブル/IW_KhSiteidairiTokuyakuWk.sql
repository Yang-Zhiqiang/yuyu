CREATE TABLE IW_KhSiteidairiTokuyakuWk (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     skssakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 請求書作成日 */
     stdruktkbn                                         VARCHAR     (2)                                                                 ,  /* 指定代理受取人区分 */
     stdrsknmkn                                         VARCHAR     (18)                                                                ,  /* 指定代理請求人名（カナ） */
     stdrsknmkj                                         VARCHAR     (15)                                                                ,  /* 指定代理請求人名（漢字） */
     stdrsknmkjhukakbn                                  VARCHAR     (1)                                                                 ,  /* 指定代理請求人名漢字化不可区分 */
     shsnmkj                                            VARCHAR     (15)                                                                ,  /* 送付先氏名（漢字） */
     shskyno                                            VARCHAR     (7)                                                                 ,  /* 送付先郵便番号 */
     shsadr1kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所１（漢字）（３０桁） */
     shsadr2kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所２（漢字）（３０桁） */
     shsadr3kj                                          VARCHAR     (30)                                                                ,  /* 送付先住所３（漢字）（３０桁） */
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

ALTER TABLE IW_KhSiteidairiTokuyakuWk ADD CONSTRAINT PK_KhSiteidairiTokuyakuWk PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;
