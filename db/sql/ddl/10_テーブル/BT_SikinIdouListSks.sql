CREATE TABLE BT_SikinIdouListSks (
     densyskbn                                          VARCHAR     (2)                                                       NOT NULL  ,  /* 伝票用システム区分 */
     denrenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 伝票データ連番 */
     edano                                              NUMBER      (2)                                                       NOT NULL  ,  /* 枝番号 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     tyakkinymd                                         VARCHAR     (8)                                                                 ,  /* 着金日 */
     seg1cd                                             VARCHAR     (20)                                                                ,  /* セグメント１コード */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     keiyakutuukagk                                     NUMBER      (13)                                                                ,  /* 契約通貨金額 */
     keiyakutuukagk$                                    VARCHAR     (10)                                                                ,  /* 契約通貨金額(通貨型) */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     siharaituukagk                                     NUMBER      (13)                                                                ,  /* 支払通貨金額 */
     siharaituukagk$                                    VARCHAR     (10)                                                                ,  /* 支払通貨金額(通貨型) */
     sikinidoukbn                                       VARCHAR     (1)                                                                 ,  /* 資金移動区分 */
     sikinidougroupkbn                                  VARCHAR     (2)                                                                 ,  /* 資金移動グループ区分 */
     sikinidoumeisaikbn                                 VARCHAR     (3)                                                                 ,  /* 資金移動明細区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BT_SikinIdouListSks ADD CONSTRAINT PK_SikinIdouListSks PRIMARY KEY (
     densyskbn                                                , /* 伝票用システム区分 */
     denrenno                                                 , /* 伝票データ連番 */
     edano                                                      /* 枝番号 */
) ;

CREATE INDEX IX1_SikinIdouListSks ON BT_SikinIdouListSks (
     syoriYmd                                                 , /* 処理年月日 */
     kyktuukasyu                                                /* 契約通貨種類 */
) ;
