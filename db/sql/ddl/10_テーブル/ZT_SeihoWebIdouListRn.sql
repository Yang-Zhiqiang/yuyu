CREATE TABLE ZT_SeihoWebIdouListRn (
     zrnsakuseiymd7keta                                 NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）作成年月（７桁） */
     zrnbsydrtencd                                      CHAR        (7)                                                       NOT NULL  ,  /* （連携用）募集代理店コード */
     zrntntusycd                                        CHAR        (6)                                                       NOT NULL  ,  /* （連携用）担当者コード */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnhasseiymd                                       VARCHAR     (22)                                                      NOT NULL  ,  /* （連携用）発生日 */
     zrnidoukbn1                                        VARCHAR     (22)                                                      NOT NULL  ,  /* （連携用）異動区分１ */
     zrnkydatkikbnkj                                    VARCHAR     (1)                                                       NOT NULL  ,  /* （連携用）共同扱区分（漢字） */
     zrnkykyymm                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）契約年月（西暦下２桁） */
     zrncifcd                                           CHAR        (15)                                                      NOT NULL  ,  /* （連携用）ＣＩＦコード */
     zrnmidasikbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）見出し区分 */
     zrnatesakinm                                       VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）宛先名 */
     zrnhassinka                                        VARCHAR     (31)                                                      NOT NULL  ,  /* （連携用）発信課 */
     zrnbsyyymm                                         CHAR        (4)                                                       NOT NULL  ,  /* （連携用）募集年月（西暦下２桁） */
     zrntntusynm                                        VARCHAR     (10)                                                      NOT NULL  ,  /* （連携用）担当者名 */
     zrnkyknmkjseihoweb                                 VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字）（生保ＷＥＢ） */
     zrnpjyuutouyymm                                    CHAR        (4)                                                       NOT NULL  ,  /* （連携用）保険料充当年月（西暦下２桁） */
     zrnhrkkaisuukj                                     VARCHAR     (3)                                                       NOT NULL  ,  /* （連携用）払込回数（漢字） */
     zrnp11keta                                         NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）保険料（１１桁） */
     zrnhrkkeirobtjhmidasi                              VARCHAR     (5)                                                       NOT NULL  ,  /* （連携用）払込経路別情報見出し */
     zrnhrkkeirobtjh                                    VARCHAR     (60)                                                      NOT NULL  ,  /* （連携用）払込経路別情報 */
     zrntntusyjk                                        VARCHAR     (8)                                                       NOT NULL  ,  /* （連携用）担当者状況 */
     zrnhrkkeirokj                                      VARCHAR     (3)                                                       NOT NULL  ,  /* （連携用）払込経路（漢字） */
     zrnhknsyuruimei                                    VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）保険種類名 */
     zrnidoukbn2                                        VARCHAR     (22)                                                      NOT NULL  ,  /* （連携用）異動区分２ */
     zrndbskyoteiymd7keta                               NUMBER      (7)                                                       NOT NULL  ,  /* （連携用）ＤＢ削除予定年月（７桁） */
     zrngaikakykhrkp                                    NUMBER      (13,2)                                                    NOT NULL  ,  /* （連携用）外貨契約払込保険料 */
     zrnkyktuukasyukbn                                  CHAR        (1)                                                       NOT NULL     /* （連携用）契約通貨種類区分 */
)
;

ALTER TABLE ZT_SeihoWebIdouListRn ADD CONSTRAINT PK_SeihoWebIdouListRn PRIMARY KEY (
     zrnsakuseiymd7keta                                       , /* （連携用）作成年月（７桁） */
     zrnbsydrtencd                                            , /* （連携用）募集代理店コード */
     zrntntusycd                                              , /* （連携用）担当者コード */
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnhasseiymd                                             , /* （連携用）発生日 */
     zrnidoukbn1                                              , /* （連携用）異動区分１ */
     zrnkydatkikbnkj                                          , /* （連携用）共同扱区分（漢字） */
     zrnkykyymm                                               , /* （連携用）契約年月（西暦下２桁） */
     zrncifcd                                                   /* （連携用）ＣＩＦコード */
) ;
