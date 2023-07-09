CREATE TABLE BM_KaiyakuKoujyoRitu (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     ryouritusdno                                       VARCHAR     (3)                                                       NOT NULL  ,  /* 料率世代番号 */
     kaiyakukjtkybr1                                    VARCHAR     (3)                                                       NOT NULL  ,  /* 解約控除適用分類１ */
     kaiyakukjtkybr2                                    VARCHAR     (3)                                                       NOT NULL  ,  /* 解約控除適用分類２ */
     keikanensuu                                        NUMBER      (2)                                                       NOT NULL  ,  /* 経過年数 */
     kaiyakukoujyoritu                                  NUMBER      (5,4)                                                               ,  /* 解約控除率 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE BM_KaiyakuKoujyoRitu ADD CONSTRAINT PK_KaiyakuKoujyoRitu PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     ryouritusdno                                             , /* 料率世代番号 */
     kaiyakukjtkybr1                                          , /* 解約控除適用分類１ */
     kaiyakukjtkybr2                                          , /* 解約控除適用分類２ */
     keikanensuu                                                /* 経過年数 */
) ;
