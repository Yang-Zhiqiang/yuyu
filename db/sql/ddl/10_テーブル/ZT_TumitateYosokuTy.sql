CREATE TABLE ZT_TumitateYosokuTy (
     ztyhknsyukigou                                     VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）保険種類記号 */
     ztykeiyakuymd                                      VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）契約日 */
     ztytysytymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）抽出日 */
     ztykyktuukasyu                                     VARCHAR     (3)                                                       NOT NULL  ,  /* （中継用）契約通貨種類 */
     ztyhknkkn                                          VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）保険期間 */
     ztytmttknsyuruikbn                                 VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）積立金種類区分 */
     ztysisuukbn                                        VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）指数区分 */
     ztytmttknysktaisyoukensuu                          NUMBER      (7)                                                                 ,  /* （中継用）積立金予測対象件数 */
     ztykyktuukakyktmttkngk                             NUMBER      (13,2)                                                              ,  /* （中継用）契約通貨建契約時積立金額 */
     ztykyktuukakisitmttkngk                            NUMBER      (13,2)                                                              ,  /* （中継用）契約通貨建期始積立金額 */
     ztykyktuukaysktmttkngk                             NUMBER      (13,2)                                                              ,  /* （中継用）契約通貨建予測積立金額 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_TumitateYosokuTy ADD CONSTRAINT PK_TumitateYosokuTy PRIMARY KEY (
     ztyhknsyukigou                                           , /* （中継用）保険種類記号 */
     ztykeiyakuymd                                            , /* （中継用）契約日 */
     ztytysytymd                                              , /* （中継用）抽出日 */
     ztykyktuukasyu                                           , /* （中継用）契約通貨種類 */
     ztyhknkkn                                                , /* （中継用）保険期間 */
     ztytmttknsyuruikbn                                       , /* （中継用）積立金種類区分 */
     ztysisuukbn                                                /* （中継用）指数区分 */
) ;
