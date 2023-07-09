CREATE TABLE ZT_SeihoWebIdouListTy (
     ztysakuseiymd7keta                                 VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）作成年月（７桁） */
     ztybsydrtencd                                      VARCHAR     (7)                                                       NOT NULL  ,  /* （中継用）募集代理店コード */
     ztytntusycd                                        VARCHAR     (6)                                                       NOT NULL  ,  /* （中継用）担当者コード */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztyhasseiymd                                       VARCHAR     (22)                                                      NOT NULL  ,  /* （中継用）発生日 */
     ztyidoukbn1                                        VARCHAR     (22)                                                      NOT NULL  ,  /* （中継用）異動区分１ */
     ztykydatkikbnkj                                    VARCHAR     (1)                                                       NOT NULL  ,  /* （中継用）共同扱区分（漢字） */
     ztykykyymm                                         VARCHAR     (4)                                                       NOT NULL  ,  /* （中継用）契約年月（西暦下２桁） */
     ztycifcd                                           VARCHAR     (15)                                                      NOT NULL  ,  /* （中継用）ＣＩＦコード */
     ztymidasikbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）見出し区分 */
     ztyatesakinm                                       VARCHAR     (20)                                                                ,  /* （中継用）宛先名 */
     ztyhassinka                                        VARCHAR     (31)                                                                ,  /* （中継用）発信課 */
     ztybsyyymm                                         VARCHAR     (4)                                                                 ,  /* （中継用）募集年月（西暦下２桁） */
     ztytntusynm                                        VARCHAR     (10)                                                                ,  /* （中継用）担当者名 */
     ztykyknmkjseihoweb                                 VARCHAR     (15)                                                                ,  /* （中継用）契約者名（漢字）（生保ＷＥＢ） */
     ztypjyuutouyymm                                    VARCHAR     (4)                                                                 ,  /* （中継用）保険料充当年月（西暦下２桁） */
     ztyhrkkaisuukj                                     VARCHAR     (3)                                                                 ,  /* （中継用）払込回数（漢字） */
     ztyp11keta                                         NUMBER      (11)                                                                ,  /* （中継用）保険料（１１桁） */
     ztyhrkkeirobtjhmidasi                              VARCHAR     (5)                                                                 ,  /* （中継用）払込経路別情報見出し */
     ztyhrkkeirobtjh                                    VARCHAR     (60)                                                                ,  /* （中継用）払込経路別情報 */
     ztytntusyjk                                        VARCHAR     (8)                                                                 ,  /* （中継用）担当者状況 */
     ztyhrkkeirokj                                      VARCHAR     (3)                                                                 ,  /* （中継用）払込経路（漢字） */
     ztyhknsyuruimei                                    VARCHAR     (30)                                                                ,  /* （中継用）保険種類名 */
     ztyidoukbn2                                        VARCHAR     (22)                                                                ,  /* （中継用）異動区分２ */
     ztydbskyoteiymd7keta                               VARCHAR     (6)                                                                 ,  /* （中継用）ＤＢ削除予定年月（７桁） */
     ztygaikakykhrkp                                    NUMBER      (13,2)                                                              ,  /* （中継用）外貨契約払込保険料 */
     ztykyktuukasyukbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）契約通貨種類区分 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SeihoWebIdouListTy ADD CONSTRAINT PK_SeihoWebIdouListTy PRIMARY KEY (
     ztysakuseiymd7keta                                       , /* （中継用）作成年月（７桁） */
     ztybsydrtencd                                            , /* （中継用）募集代理店コード */
     ztytntusycd                                              , /* （中継用）担当者コード */
     ztysyono                                                 , /* （中継用）証券番号 */
     ztyhasseiymd                                             , /* （中継用）発生日 */
     ztyidoukbn1                                              , /* （中継用）異動区分１ */
     ztykydatkikbnkj                                          , /* （中継用）共同扱区分（漢字） */
     ztykykyymm                                               , /* （中継用）契約年月（西暦下２桁） */
     ztycifcd                                                   /* （中継用）ＣＩＦコード */
) ;
