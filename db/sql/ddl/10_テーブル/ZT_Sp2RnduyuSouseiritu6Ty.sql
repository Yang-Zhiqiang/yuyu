CREATE TABLE ZT_Sp2RnduyuSouseiritu6Ty (
     ztyktgysyrymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）結合用処理日 */
     ztyktgysyono                                       VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）結合用証券番号 */
     ztyktgyfilerenno                                   VARCHAR     (1)                                                                 ,  /* （中継用）結合用ファイル連番 */
     ztyraysystemhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）ＲＡＹシステム表示 */
     ztygaikakbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）外貨区分 */
     ztykawaserate                                      NUMBER      (9,6)                                                               ,  /* （中継用）為替レート */
     ztykawaseratetekiyouymd                            VARCHAR     (8)                                                                 ,  /* （中継用）為替レート適用年月日 */
     ztykykjikawaserate                                 NUMBER      (9,6)                                                               ,  /* （中継用）契約時為替レート */
     ztykykjikawaseratetkyuymd                          VARCHAR     (8)                                                                 ,  /* （中継用）契約時為替レート適用年月日 */
     ztykeiyakujiyoteiriritu                            NUMBER      (5,4)                                                               ,  /* （中継用）契約時予定利率 */
     ztytumitateriritu                                  NUMBER      (5,4)                                                               ,  /* （中継用）積立利率 */
     ztysrkyksjkkktyouseiriritu                         NUMBER      (5,4)                                                               ,  /* （中継用）数理用契約時市場価格調整用利率 */
     ztyenkdtsbujsitihsyukngk                           NUMBER      (11)                                                                ,  /* （中継用）円貨建死亡時最低保証金額 */
     ztykaigomaebaraitkykarihyj                         VARCHAR     (1)                                                                 ,  /* （中継用）介護前払特約あり表示 */
     ztysuuriyouyobin1                                  VARCHAR     (1)                                                                 ,  /* （中継用）数理用予備項目Ｎ１ */
     ztysibouhyoukbn                                    VARCHAR     (2)                                                                 ,  /* （中継用）死亡表区分 */
     ztymvatyouseikou                                   NUMBER      (5,4)                                                               ,  /* （中継用）ＭＶＡ調整項 */
     ztynyuukintuukakbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）入金通貨区分 */
     ztyhtnknkykliveonearhyj                            VARCHAR     (1)                                                                 ,  /* （中継用）被転換契約ライブワン有表示 */
     ztyliveonepackagesyouhinkbn                        VARCHAR     (1)                                                                 ,  /* （中継用）ライブワンパッケージ商品区分 */
     ztyhtnkngukisisttkknsnp                            NUMBER      (11)                                                                ,  /* （中継用）被転換合計災疾月換算Ｐ */
     ztywyendttargetmokuhyouritu                        VARCHAR     (3)                                                                 ,  /* （中継用）円建Ｗターゲット目標率 */
     ztysisuurendourate                                 VARCHAR     (3)                                                                 ,  /* （中継用）指数連動部分割合 */
     ztysisuukbn                                        VARCHAR     (2)                                                                 ,  /* （中継用）指数区分 */
     ztysuuriyouyobin2                                  VARCHAR     (2)                                                                 ,  /* （中継用）数理用予備項目Ｎ２ */
     ztysuuriyouyobin10x2                               VARCHAR     (10)                                                                ,  /* （中継用）数理用予備項目Ｎ１０＿２ */
     ztysuuriyouyobin10x3                               VARCHAR     (10)                                                                ,  /* （中継用）数理用予備項目Ｎ１０＿３ */
     ztytmttknzoukaritujygn                             NUMBER      (5,4)                                                               ,  /* （中継用）積立金増加率上限 */
     ztysetteibairitu                                   NUMBER      (3,2)                                                               ,  /* （中継用）設定倍率 */
     ztykykymdsisuu                                     NUMBER      (10,5)                                                              ,  /* （中継用）契約日指数 */
     ztyrendouritu                                      NUMBER      (5,4)                                                               ,  /* （中継用）連動率 */
     ztyyobin5                                          NUMBER      (5)                                                                 ,  /* （中継用）予備項目Ｎ５ */
     ztyyobin5x2                                        NUMBER      (5)                                                                 ,  /* （中継用）予備項目Ｎ５＿２ */
     ztyyobiv10x6                                       VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０＿６ */
     ztyyendttargetkijyunkingaku                        NUMBER      (11)                                                                ,  /* （中継用）円建ターゲット基準金額 */
     ztysisuurentumitatekin                             NUMBER      (11)                                                                ,  /* （中継用）指数連動部分積立金 */
     ztytirttmtttumitatekin                             NUMBER      (11)                                                                ,  /* （中継用）定率積立部分積立金 */
     ztynksjitirttmttkn                                 NUMBER      (11)                                                                ,  /* （中継用）年金開始時定率積立金 */
     ztynendomatutirttumitatekin                        NUMBER      (11)                                                                ,  /* （中継用）年度末定率部分積立金 */
     ztysyuptumitatekin                                 NUMBER      (11)                                                                ,  /* （中継用）主契約保険料積立金 */
     ztygaikadatenkgns                                  NUMBER      (11)                                                                ,  /* （中継用）外貨建年金原資 */
     ztytumitatekin                                     NUMBER      (11)                                                                ,  /* （中継用）積立金 */
     ztykiharaikomip                                    NUMBER      (11)                                                                ,  /* （中継用）既払込Ｐ */
     ztygaikadatesyukeiyakup                            NUMBER      (11)                                                                ,  /* （中継用）外貨建主契約Ｐ */
     ztysitivkisnyukykjikwsrate                         NUMBER      (9,6)                                                               ,  /* （中継用）最低Ｖ計算用契約時為替レート */
     ztyyobiv16                                         VARCHAR     (16)                                                                ,  /* （中継用）予備項目Ｖ１６ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_Sp2RnduyuSouseiritu6Ty ADD CONSTRAINT PK_Sp2RnduyuSouseiritu6Ty PRIMARY KEY (
     ztyktgysyono                                               /* （中継用）結合用証券番号 */
) ;
