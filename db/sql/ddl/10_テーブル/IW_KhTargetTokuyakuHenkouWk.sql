CREATE TABLE IW_KhTargetTokuyakuHenkouWk (
     kouteikanriid                                      VARCHAR     (20)                                                      NOT NULL  ,  /* 工程管理ＩＤ */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     skssakuseiymd                                      VARCHAR     (8)                                                                 ,  /* 請求書作成日 */
     targettkykkykhenkoymd                              VARCHAR     (8)                                                                 ,  /* ターゲット特約契約変更日 */
     targettkykhnkkbn                                   VARCHAR     (1)                                                                 ,  /* ターゲット特約変更区分 */
     targettkmokuhyouti                                 NUMBER      (3)                                                                 ,  /* ターゲット特約目標値 */
     honninkakninkekkakbn                               VARCHAR     (1)                                                                 ,  /* 本人確認結果区分 */
     hassoukbn                                          VARCHAR     (1)                                                                 ,  /* 発送区分 */
     kanryotuutioutkbn                                  VARCHAR     (1)                                                                 ,  /* 完了通知出力区分 */
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

ALTER TABLE IW_KhTargetTokuyakuHenkouWk ADD CONSTRAINT PK_KhTargetTokuyakuHenkouWk PRIMARY KEY (
     kouteikanriid                                              /* 工程管理ＩＤ */
) ;
