CREATE TABLE IT_AzukarikinKessankanri_Z (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kessankijyunymd                                    VARCHAR     (8)                                                       NOT NULL  ,  /* 決算基準日 */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     tuukasyu                                           VARCHAR     (3)                                                       NOT NULL  ,  /* 通貨種類 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     yuukousyoumetukbn                                  VARCHAR     (1)                                                                 ,  /* 有効消滅区分 */
     syoumetujiyuu                                      VARCHAR     (2)                                                                 ,  /* 消滅事由 */
     syoumetuymd                                        VARCHAR     (8)                                                                 ,  /* 消滅日 */
     kbnkeirisegcd                                      VARCHAR     (20)                                                                ,  /* 区分経理用セグメントコード */
     calckijyunymd                                      VARCHAR     (8)                                                                 ,  /* 計算基準日 */
     azukarikinhsiymd                                   VARCHAR     (8)                                                                 ,  /* 預り金発生日 */
     azukarigankin                                      DECIMAL     (13)                                                                ,  /* 預り元金 */
     azukarigankin$                                     VARCHAR     (10)                                                                ,  /* 預り元金(通貨型) */
     azukarijikikbn                                     VARCHAR     (1)                                                                 ,  /* 預り時期区分 */
     azukariganrikin                                    DECIMAL     (13)                                                                ,  /* 預り元利金 */
     azukariganrikin$                                   VARCHAR     (10)                                                                ,  /* 預り元利金(通貨型) */
     tounendgankin                                      DECIMAL     (13)                                                                ,  /* 当年度元金 */
     tounendgankin$                                     VARCHAR     (10)                                                                ,  /* 当年度元金(通貨型) */
     tounendrsk                                         DECIMAL     (13)                                                                ,  /* 当年度利息 */
     tounendrsk$                                        VARCHAR     (10)                                                                ,  /* 当年度利息(通貨型) */
     kwsratekjymd                                       VARCHAR     (8)                                                                 ,  /* 為替レート基準日 */
     kawaserate                                         DECIMAL     (7,4)                                                               ,  /* 為替レート */
     gaikaazukariganrikin                               DECIMAL     (13)                                                                ,  /* 外貨預り元利金 */
     gaikaazukariganrikin$                              VARCHAR     (10)                                                                ,  /* 外貨預り元利金(通貨型) */
     gaikatounendgankin                                 DECIMAL     (13)                                                                ,  /* 外貨当年度元金 */
     gaikatounendgankin$                                VARCHAR     (10)                                                                ,  /* 外貨当年度元金(通貨型) */
     gaikatounendrsk                                    DECIMAL     (13)                                                                ,  /* 外貨当年度利息 */
     gaikatounendrsk$                                   VARCHAR     (10)                                                                ,  /* 外貨当年度利息(通貨型) */
     gaikashrkwsratekjnymd                              VARCHAR     (8)                                                                 ,  /* 外貨支払時為替レート基準日 */
     gaikashrkwsrate                                    DECIMAL     (7,4)                                                               ,  /* 外貨支払時為替レート */
     gaikaknsnmaeazukariganrikin                        DECIMAL     (13)                                                                ,  /* 外貨換算前預り元利金 */
     gaikaknsnmaeazukariganrikin$                       VARCHAR     (10)                                                                ,  /* 外貨換算前預り元利金(通貨型) */
     gaikaknsnmaetounendgankin                          DECIMAL     (13)                                                                ,  /* 外貨換算前当年度元金 */
     gaikaknsnmaetounendgankin$                         VARCHAR     (10)                                                                ,  /* 外貨換算前当年度元金(通貨型) */
     gaikaknsnmaetounendrsk                             DECIMAL     (13)                                                                ,  /* 外貨換算前当年度利息 */
     gaikaknsnmaetounendrsk$                            VARCHAR     (10)                                                                ,  /* 外貨換算前当年度利息(通貨型) */
     azukarikinshrgk                                    DECIMAL     (13)                                                                ,  /* 預り金支払額 */
     azukarikinshrgk$                                   VARCHAR     (10)                                                                ,  /* 預り金支払額(通貨型) */
     azukarikinshrrskgk                                 DECIMAL     (13)                                                                ,  /* 預り金支払利息額 */
     azukarikinshrrskgk$                                VARCHAR     (10)                                                                ,  /* 預り金支払利息額(通貨型) */
     tounendsyoumetuukemishrgk                          DECIMAL     (13)                                                                ,  /* 当年度消滅受付未支払額 */
     tounendsyoumetuukemishrgk$                         VARCHAR     (10)                                                                ,  /* 当年度消滅受付未支払額(通貨型) */
     sinbikinkeirskgk                                   DECIMAL     (13)                                                                ,  /* 新備金計上利息額 */
     sinbikinkeirskgk$                                  VARCHAR     (10)                                                                ,  /* 新備金計上利息額(通貨型) */
     bknjkukbn                                          VARCHAR     (1)                                                                 ,  /* 備金時効区分 */
     bikinkeiymd                                        VARCHAR     (8)                                                                 ,  /* 備金計上日 */
     bkncdkbn                                           VARCHAR     (4)                                                                 ,  /* 備金コード区分 */
     tounendrsksyukeisitu                               DECIMAL     (13)                                                                ,  /* 当年度利息（主計室用） */
     tounendrsksyukeisitu$                              VARCHAR     (10)                                                                ,  /* 当年度利息（主計室用）(通貨型) */
     zennendrsksyukeisitu                               DECIMAL     (13)                                                                ,  /* 前年度利息（主計室用） */
     zennendrsksyukeisitu$                              VARCHAR     (10)                                                                ,  /* 前年度利息（主計室用）(通貨型) */
     kwsratekjymd1q                                     VARCHAR     (8)                                                                 ,  /* （１Ｑ）為替レート基準日 */
     kawaserate1q                                       DECIMAL     (7,4)                                                               ,  /* （１Ｑ）為替レート */
     azukarikinrsk1q                                    DECIMAL     (13)                                                                ,  /* （１Ｑ）預り金利息 */
     azukarikinrsk1q$                                   VARCHAR     (10)                                                                ,  /* （１Ｑ）預り金利息(通貨型) */
     kwsratekjymd2q                                     VARCHAR     (8)                                                                 ,  /* （２Ｑ）為替レート基準日 */
     kawaserate2q                                       DECIMAL     (7,4)                                                               ,  /* （２Ｑ）為替レート */
     azukarikinrsk2q                                    DECIMAL     (13)                                                                ,  /* （２Ｑ）預り金利息 */
     azukarikinrsk2q$                                   VARCHAR     (10)                                                                ,  /* （２Ｑ）預り金利息(通貨型) */
     kwsratekjymd3q                                     VARCHAR     (8)                                                                 ,  /* （３Ｑ）為替レート基準日 */
     kawaserate3q                                       DECIMAL     (7,4)                                                               ,  /* （３Ｑ）為替レート */
     azukarikinrsk3q                                    DECIMAL     (13)                                                                ,  /* （３Ｑ）預り金利息 */
     azukarikinrsk3q$                                   VARCHAR     (10)                                                                ,  /* （３Ｑ）預り金利息(通貨型) */
     kwsratekjymd4q                                     VARCHAR     (8)                                                                 ,  /* （４Ｑ）為替レート基準日 */
     kawaserate4q                                       DECIMAL     (7,4)                                                               ,  /* （４Ｑ）為替レート */
     azukarikinrsk4q                                    DECIMAL     (13)                                                                ,  /* （４Ｑ）預り金利息 */
     azukarikinrsk4q$                                   VARCHAR     (10)                                                                ,  /* （４Ｑ）預り金利息(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_AzukarikinKessankanri_Z ADD CONSTRAINT PK_AzukarikinKessankanri PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     kessankijyunymd                                          , /* 決算基準日 */
     henkousikibetukey                                        , /* 変更識別キー */
     tuukasyu                                                   /* 通貨種類 */
) ;

CREATE INDEX IX1_AzukarikinKessankanri ON IT_AzukarikinKessankanri_Z (
     kessankijyunymd                                          , /* 決算基準日 */
     bknjkukbn                                                , /* 備金時効区分 */
     yuukousyoumetukbn                                          /* 有効消滅区分 */
) ;
