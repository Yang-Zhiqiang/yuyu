CREATE TABLE HT_MosMikakuteiJyouhouKanri_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     jimutetuzukicd                                     VARCHAR     (19)                                                                ,  /* 事務手続コード */
     skeijimukbn                                        VARCHAR     (2)                                                                 ,  /* 新契約事務区分 */
     mosuketukekbn                                      VARCHAR     (1)                                                                 ,  /* 申込受付区分 */
     hknsyuruino                                        VARCHAR     (3)                                                                 ,  /* 保険種類番号 */
     dairitencd1                                        VARCHAR     (7)                                                                 ,  /* 代理店コード１ */
     dairitencd2                                        VARCHAR     (7)                                                                 ,  /* 代理店コード２ */
     jimuyoucd                                          VARCHAR     (3)                                                                 ,  /* 事務用コード */
     doujimosumu                                        VARCHAR     (1)                                                                 ,  /* 同時申込有無 */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     syorizumiflg                                       VARCHAR     (1)                                                                 ,  /* 処理済フラグ */
     sakujoyoteiymd                                     VARCHAR     (8)                                                                 ,  /* 削除予定日 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     setmosno1                                          VARCHAR     (20)                                                                   /* セット申込番号１ */
)
;

ALTER TABLE HT_MosMikakuteiJyouhouKanri_Z ADD CONSTRAINT PK_MosMikakuteiJyouhouKanri PRIMARY KEY (
     mosno                                                      /* 申込番号 */
) ;
