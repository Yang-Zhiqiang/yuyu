CREATE TABLE ZT_Sp2RnduyuSouseiritu6Rn (
     zrnktgysyrymd                                      CHAR        (8)                                                       NOT NULL  ,  /* （連携用）結合用処理日 */
     zrnktgysyono                                       CHAR        (11)                                                      NOT NULL  ,  /* （連携用）結合用証券番号 */
     zrnktgyfilerenno                                   CHAR        (1)                                                       NOT NULL  ,  /* （連携用）結合用ファイル連番 */
     zrnraysystemhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ＲＡＹシステム表示 */
     zrngaikakbn                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）外貨区分 */
     zrnkawaserate                                      NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）為替レート */
     zrnkawaseratetekiyouymd                            CHAR        (8)                                                       NOT NULL  ,  /* （連携用）為替レート適用年月日 */
     zrnkykjikawaserate                                 NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）契約時為替レート */
     zrnkykjikawaseratetkyuymd                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）契約時為替レート適用年月日 */
     zrnkeiyakujiyoteiriritu                            NUMBER      (5,4)                                                     NOT NULL  ,  /* （連携用）契約時予定利率 */
     zrntumitateriritu                                  NUMBER      (5,4)                                                     NOT NULL  ,  /* （連携用）積立利率 */
     zrnsrkyksjkkktyouseiriritu                         NUMBER      (5,4)                                                     NOT NULL  ,  /* （連携用）数理用契約時市場価格調整用利率 */
     zrnenkdtsbujsitihsyukngk                           NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）円貨建死亡時最低保証金額 */
     zrnkaigomaebaraitkykarihyj                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）介護前払特約あり表示 */
     zrnsuuriyouyobin1                                  CHAR        (1)                                                       NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１ */
     zrnsibouhyoukbn                                    CHAR        (2)                                                       NOT NULL  ,  /* （連携用）死亡表区分 */
     zrnmvatyouseikou                                   NUMBER      (5,4)                                                     NOT NULL  ,  /* （連携用）ＭＶＡ調整項 */
     zrnnyuukintuukakbn                                 CHAR        (1)                                                       NOT NULL  ,  /* （連携用）入金通貨区分 */
     zrnhtnknkykliveonearhyj                            CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被転換契約ライブワン有表示 */
     zrnliveonepackagesyouhinkbn                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）ライブワンパッケージ商品区分 */
     zrnhtnkngukisisttkknsnp                            NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）被転換合計災疾月換算Ｐ */
     zrnwyendttargetmokuhyouritu                        CHAR        (3)                                                       NOT NULL  ,  /* （連携用）円建Ｗターゲット目標率 */
     zrnsisuurendourate                                 CHAR        (3)                                                       NOT NULL  ,  /* （連携用）指数連動部分割合 */
     zrnsisuukbn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）指数区分 */
     zrnsuuriyouyobin2                                  CHAR        (2)                                                       NOT NULL  ,  /* （連携用）数理用予備項目Ｎ２ */
     zrnsuuriyouyobin10x2                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１０＿２ */
     zrnsuuriyouyobin10x3                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）数理用予備項目Ｎ１０＿３ */
     zrntmttknzoukaritujygn                             NUMBER      (5,4)                                                     NOT NULL  ,  /* （連携用）積立金増加率上限 */
     zrnsetteibairitu                                   NUMBER      (3,2)                                                     NOT NULL  ,  /* （連携用）設定倍率 */
     zrnkykymdsisuu                                     NUMBER      (10,5)                                                    NOT NULL  ,  /* （連携用）契約日指数 */
     zrnrendouritu                                      NUMBER      (5,4)                                                     NOT NULL  ,  /* （連携用）連動率 */
     zrnyobin5                                          NUMBER      (5)                                                       NOT NULL  ,  /* （連携用）予備項目Ｎ５ */
     zrnyobin5x2                                        NUMBER      (5)                                                       NOT NULL  ,  /* （連携用）予備項目Ｎ５＿２ */
     zrnyobiv10x6                                       CHAR        (10)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１０＿６ */
     zrnyendttargetkijyunkingaku                        NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）円建ターゲット基準金額 */
     zrnsisuurentumitatekin                             NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）指数連動部分積立金 */
     zrntirttmtttumitatekin                             NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）定率積立部分積立金 */
     zrnnksjitirttmttkn                                 NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）年金開始時定率積立金 */
     zrnnendomatutirttumitatekin                        NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）年度末定率部分積立金 */
     zrnsyuptumitatekin                                 NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）主契約保険料積立金 */
     zrngaikadatenkgns                                  NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）外貨建年金原資 */
     zrntumitatekin                                     NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）積立金 */
     zrnkiharaikomip                                    NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）既払込Ｐ */
     zrngaikadatesyukeiyakup                            NUMBER      (11)                                                      NOT NULL  ,  /* （連携用）外貨建主契約Ｐ */
     zrnsitivkisnyukykjikwsrate                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）最低Ｖ計算用契約時為替レート */
     zrnyobiv16                                         CHAR        (16)                                                      NOT NULL     /* （連携用）予備項目Ｖ１６ */
)
;

ALTER TABLE ZT_Sp2RnduyuSouseiritu6Rn ADD CONSTRAINT PK_Sp2RnduyuSouseiritu6Rn PRIMARY KEY (
     zrnktgysyono                                               /* （連携用）結合用証券番号 */
) ;
