CREATE TABLE HW_CreditTrkNgList (
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     datarenno                                          NUMBER      (5)                                                       NOT NULL  ,  /* データ連番 */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     creditkessaiyouno                                  VARCHAR     (26)                                                                ,  /* クレジットカード決済用番号 */
     creditqrerrorcd                                    VARCHAR     (14)                                                                ,  /* クレジットカードＱＲエラーコード */
     bluegateerrorcd                                    VARCHAR     (8)                                                                 ,  /* ＢｌｕｅＧａｔｅエラーコード */
     dbhaneikbn                                         VARCHAR     (1)                                                                 ,  /* ＤＢ反映区分 */
     credittrkhaneierrriyuu                             VARCHAR     (30)                                                                ,  /* クレジットカード登録反映エラー理由 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HW_CreditTrkNgList ADD CONSTRAINT PK_CreditTrkNgList PRIMARY KEY (
     tyouhyouymd                                              , /* 帳票作成日 */
     datarenno                                                  /* データ連番 */
) ;
