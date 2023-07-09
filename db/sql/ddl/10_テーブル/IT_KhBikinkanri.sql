CREATE TABLE IT_KhBikinkanri (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kessankijyunymd                                    VARCHAR     (8)                                                       NOT NULL  ,  /* 決算基準日 */
     bkncdkbn                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 備金コード区分 */
     bknkktymd                                          VARCHAR     (8)                                                       NOT NULL  ,  /* 備金確定日 */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番 */
     bknrigikbn                                         VARCHAR     (1)                                                                 ,  /* 備金例外区分 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     calckijyunymd                                      VARCHAR     (8)                                                                 ,  /* 計算基準日 */
     sisyacd                                            VARCHAR     (3)                                                                 ,  /* 支社コード */
     kbnkeirisegcd                                      VARCHAR     (20)                                                                ,  /* 区分経理用セグメントコード */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     bknsyutkkbn                                        VARCHAR     (2)                                                                 ,  /* 備金主契約特約区分 */
     bkngk                                              NUMBER      (13)                                                                ,  /* 備金額 */
     bkngk$                                             VARCHAR     (10)                                                                ,  /* 備金額(通貨型) */
     kihons                                             NUMBER      (13)                                                                ,  /* 基本Ｓ */
     kihons$                                            VARCHAR     (10)                                                                ,  /* 基本Ｓ(通貨型) */
     gngkkiykumukbn                                     VARCHAR     (1)                                                                 ,  /* 減額特約解約有無区分 */
     shrumu                                             VARCHAR     (1)                                                                 ,  /* 支払有無区分 */
     sinsaumukbn                                        VARCHAR     (1)                                                                 ,  /* 診査有無区分 */
     bknjkukbn                                          VARCHAR     (1)                                                                 ,  /* 備金時効区分 */
     shrsyoriymd                                        VARCHAR     (8)                                                                 ,  /* 支払処理日 */
     tyakkinymd                                         VARCHAR     (8)                                                                 ,  /* 着金日 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     shrgk                                              NUMBER      (13)                                                                ,  /* 支払金額 */
     shrgk$                                             VARCHAR     (10)                                                                ,  /* 支払金額(通貨型) */
     shrkwsratekjnymd                                   VARCHAR     (8)                                                                 ,  /* 支払時為替レート基準日 */
     shrkwsrate                                         NUMBER      (7,4)                                                               ,  /* 支払時為替レート */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     gaikashrkwsratekjnymd                              VARCHAR     (8)                                                                 ,  /* 外貨支払時為替レート基準日 */
     gaikashrkwsrate                                    NUMBER      (7,4)                                                               ,  /* 外貨支払時為替レート */
     yenkazennouseisankgk                               NUMBER      (13)                                                                ,  /* 円貨前納精算金額 */
     yenkazennouseisankgk$                              VARCHAR     (10)                                                                ,  /* 円貨前納精算金額(通貨型) */
     gaikazennouseisankgk                               NUMBER      (13)                                                                ,  /* 外貨前納精算金額 */
     gaikazennouseisankgk$                              VARCHAR     (10)                                                                ,  /* 外貨前納精算金額(通貨型) */
     zennouseisankgk                                    NUMBER      (13)                                                                ,  /* 前納精算金額 */
     zennouseisankgk$                                   VARCHAR     (10)                                                                ,  /* 前納精算金額(通貨型) */
     yenkamikeikap                                      NUMBER      (13)                                                                ,  /* 円貨未経過保険料 */
     yenkamikeikap$                                     VARCHAR     (10)                                                                ,  /* 円貨未経過保険料(通貨型) */
     gaikamikeikap                                      NUMBER      (13)                                                                ,  /* 外貨未経過保険料 */
     gaikamikeikap$                                     VARCHAR     (10)                                                                ,  /* 外貨未経過保険料(通貨型) */
     mikeikap                                           NUMBER      (13)                                                                ,  /* 未経過保険料 */
     mikeikap$                                          VARCHAR     (10)                                                                   /* 未経過保険料(通貨型) */
)
;

ALTER TABLE IT_KhBikinkanri ADD CONSTRAINT PK_KhBikinkanri PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     kessankijyunymd                                          , /* 決算基準日 */
     bkncdkbn                                                 , /* 備金コード区分 */
     bknkktymd                                                , /* 備金確定日 */
     renno                                                      /* 連番 */
) ;
