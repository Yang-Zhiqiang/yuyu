CREATE TABLE HM_HurikomiKouza_Z (
     bankcd                                             VARCHAR     (4)                                                       NOT NULL  ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                       NOT NULL  ,  /* 支店コード */
     kouzano                                            VARCHAR     (12)                                                      NOT NULL  ,  /* 口座番号 */
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類 */
     hrkmirnincd                                        VARCHAR     (10)                                                      NOT NULL  ,  /* 振込依頼人コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     nyuukinoyadrtennm                                  VARCHAR     (62)                                                                ,  /* 入金用親代理店名 */
     oyadrtensyoritarget                                VARCHAR     (1)                                                                 ,  /* 親代理店処理対象 */
     jidonykntargethyouji                               VARCHAR     (1)                                                                 ,  /* 自動入金対象表示 */
     hrkmirnineditptnkbn                                VARCHAR     (1)                                                                 ,  /* 振込依頼人編集パターン区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     siteituuka                                         VARCHAR     (3)                                                                 ,  /* 指定通貨 */
     honkouzacd                                         VARCHAR     (3)                                                                    /* 本口座コード */
)
;

ALTER TABLE HM_HurikomiKouza_Z ADD CONSTRAINT PK_HurikomiKouza PRIMARY KEY (
     bankcd                                                   , /* 銀行コード */
     sitencd                                                  , /* 支店コード */
     kouzano                                                  , /* 口座番号 */
     tuukasyu                                                 , /* 通貨種類 */
     hrkmirnincd                                                /* 振込依頼人コード */
) ;

CREATE INDEX IX1_HurikomiKouza ON HM_HurikomiKouza_Z (
     oyadrtencd                                                 /* 親代理店コード */
) ;
