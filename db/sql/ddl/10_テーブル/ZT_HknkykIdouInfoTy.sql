CREATE TABLE ZT_HknkykIdouInfoTy (
     ztykyktuukasyu                                     VARCHAR     (3)                                                       NOT NULL  ,  /* （中継用）契約通貨種類 */
     ztyidouymd                                         VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）異動日 */
     ztyidoujiyuukbnzfi                                 VARCHAR     (3)                                                       NOT NULL  ,  /* （中継用）異動事由区分（資産運用） */
     ztydatakanrino                                     VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）データ管理番号 */
     ztyrenno                                           VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）連番 */
     ztykeiyakuymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）契約日 */
     ztyhhknnen2                                        VARCHAR     (2)                                                                 ,  /* （中継用）被保険者年齢Ｖ２ */
     ztyhhknsei                                         VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyaisyoumeikbn                                    VARCHAR     (3)                                                                 ,  /* （中継用）愛称名区分 */
     ztyzougenkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）増減区分 */
     ztyhokenkngk13                                     NUMBER      (13,2)                                                              ,  /* （中継用）保険金額Ｎ１３ */
     ztyp13                                             NUMBER      (13,2)                                                              ,  /* （中継用）保険料Ｎ１３ */
     ztyptumitatekin13                                  NUMBER      (13,2)                                                              ,  /* （中継用）保険料積立金Ｎ１３ */
     ztykiykhnrikn13                                    NUMBER      (13,2)                                                              ,  /* （中継用）解約返戻金Ｎ１３ */
     ztyidouhokenkngk                                   NUMBER      (13,2)                                                              ,  /* （中継用）異動保険金額 */
     ztyidoup                                           NUMBER      (13,2)                                                              ,  /* （中継用）異動保険料 */
     ztyidouptumitatekin                                NUMBER      (13,2)                                                              ,  /* （中継用）異動保険料積立金 */
     ztyidoukiykhnrikn                                  NUMBER      (13,2)                                                              ,  /* （中継用）異動解約返戻金 */
     ztyhknkkn                                          VARCHAR     (2)                                                                 ,  /* （中継用）保険期間 */
     ztyyoteiriritun5                                   NUMBER      (5,4)                                                               ,  /* （中継用）予定利率Ｎ５ */
     ztytumitatekinkbn                                  VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）積立金区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_HknkykIdouInfoTy ADD CONSTRAINT PK_HknkykIdouInfoTy PRIMARY KEY (
     ztykyktuukasyu                                           , /* （中継用）契約通貨種類 */
     ztyidouymd                                               , /* （中継用）異動日 */
     ztyidoujiyuukbnzfi                                       , /* （中継用）異動事由区分（資産運用） */
     ztydatakanrino                                           , /* （中継用）データ管理番号 */
     ztyrenno                                                 , /* （中継用）連番 */
     ztytumitatekinkbn                                          /* （中継用）積立金区分 */
) ;
