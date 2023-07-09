CREATE TABLE BT_HijynNykSikinIdouListSks_Z (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     sikinidoupjytym                                    VARCHAR     (6)                                                       NOT NULL  ,  /* 資金移動用保険料充当年月 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     siteituuka                                         VARCHAR     (3)                                                                 ,  /* 指定通貨 */
     siteituukagk                                       DECIMAL     (13)                                                                ,  /* 指定通貨金額 */
     siteituukagk$                                      VARCHAR     (10)                                                                ,  /* 指定通貨金額(通貨型) */
     trhktuuka                                          VARCHAR     (3)                                                                 ,  /* 取引通貨 */
     trhktuukagk                                        DECIMAL     (13)                                                                ,  /* 取引通貨金額 */
     trhktuukagk$                                       VARCHAR     (10)                                                                ,  /* 取引通貨金額(通貨型) */
     seg1cd                                             VARCHAR     (20)                                                                ,  /* セグメント１コード */
     sikinidougroupkbn                                  VARCHAR     (2)                                                                 ,  /* 資金移動グループ区分 */
     sikinidoumeisaikbn                                 VARCHAR     (3)                                                                 ,  /* 資金移動明細区分 */
     sikinidoujtkbn                                     VARCHAR     (1)                                                                 ,  /* 資金移動状態区分 */
     sikinidoukawaserate                                DECIMAL     (7,4)                                                               ,  /* 資金移動用為替レート */
     sikinidoupkbn                                      VARCHAR     (1)                                                                 ,  /* 資金移動用保険料区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BT_HijynNykSikinIdouListSks_Z ADD CONSTRAINT PK_HijynNykSikinIdouListSks PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     sikinidoupjytym                                            /* 資金移動用保険料充当年月 */
) ;

CREATE INDEX IX1_HijynNykSikinIdouListSks ON BT_HijynNykSikinIdouListSks_Z (
     sikinidoujtkbn                                           , /* 資金移動状態区分 */
     sikinidoupkbn                                              /* 資金移動用保険料区分 */
) ;
