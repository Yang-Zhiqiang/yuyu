CREATE TABLE HW_CreditTrkHaneierrList (
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     datarenno                                          NUMBER      (5)                                                       NOT NULL  ,  /* データ連番 */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     credittrkhoukbn                                    VARCHAR     (1)                                                                 ,  /* クレジットカード登録方法区分 */
     sosikicd                                           VARCHAR     (7)                                                                 ,  /* 組織コード */
     creditkessaiyouno                                  VARCHAR     (26)                                                                ,  /* クレジットカード決済用番号 */
     credittrkhaneierrriyuu                             VARCHAR     (30)                                                                ,  /* クレジットカード登録反映エラー理由 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HW_CreditTrkHaneierrList ADD CONSTRAINT PK_CreditTrkHaneierrList PRIMARY KEY (
     tyouhyouymd                                              , /* 帳票作成日 */
     datarenno                                                  /* データ連番 */
) ;
