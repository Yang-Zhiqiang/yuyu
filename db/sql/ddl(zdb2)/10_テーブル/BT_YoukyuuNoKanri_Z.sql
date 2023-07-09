CREATE TABLE BT_YoukyuuNoKanri_Z (
     youkyuuno                                          VARCHAR     (18)                                                      NOT NULL  ,  /* 要求通番 */
     huho2kyknokbn                                      VARCHAR     (1)                                                                 ,  /* 普保Ⅱ契約番号区分 */
     huho2kykno                                         VARCHAR     (20)                                                                ,  /* 普保Ⅱ契約番号 */
     mqkousinmqsyorikekkakbn                            VARCHAR     (1)                                                                 ,  /* （ＭＱ更新用）ＭＱ処理結果区分 */
     mqkousinacserrcd                                   VARCHAR     (4)                                                                 ,  /* （ＭＱ更新用）ＡＣＳ基盤エラーコード */
     mqtrksiraimqsyorikekkakbn                          VARCHAR     (1)                                                                 ,  /* （ＭＱ取消依頼用）ＭＱ処理結果区分 */
     mqtrksiraiacserrcd                                 VARCHAR     (4)                                                                 ,  /* （ＭＱ取消依頼用）ＡＣＳ基盤エラーコード */
     kyknaiyouhaneierrkbn                               VARCHAR     (1)                                                                 ,  /* 契約内容反映エラー区分 */
     trkskekkakbn                                       VARCHAR     (1)                                                                 ,  /* 取消結果区分 */
     jdtrkspaltrkszankbn                                VARCHAR     (1)                                                                 ,  /* 自動取消用ＰＡＬ取消残区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_YoukyuuNoKanri_Z ADD CONSTRAINT PK_YoukyuuNoKanri PRIMARY KEY (
     youkyuuno                                                  /* 要求通番 */
) ;
