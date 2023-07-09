CREATE TABLE IW_KhKzkPYokuJyuutouYoteiWk_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     kykym                                              VARCHAR     (6)                                                                 ,  /* 契約年月 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     hknkkn                                             DECIMAL     (2)                                                                 ,  /* 保険期間 */
     hokenryou                                          DECIMAL     (13)                                                                ,  /* 保険料 */
     hokenryou$                                         VARCHAR     (10)                                                                ,  /* 保険料(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IW_KhKzkPYokuJyuutouYoteiWk_Z ADD CONSTRAINT PK_IW_KhKzkPYokuJyuutouYoteiWk PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX X1_IW_KhKzkPYokuJyuutouYoteiWk ON IW_KhKzkPYokuJyuutouYoteiWk_Z (
     kyktuukasyu                                              , /* 契約通貨種類 */
     kykym                                                    , /* 契約年月 */
     hknkkn                                                     /* 保険期間 */
) ;
