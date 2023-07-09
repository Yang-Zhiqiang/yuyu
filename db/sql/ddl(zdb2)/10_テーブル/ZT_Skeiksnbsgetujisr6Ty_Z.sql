CREATE TABLE ZT_Skeiksnbsgetujisr6Ty_Z (
     ztyktgysyrymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）結合用処理日 */
     ztyktgysyono                                       VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）結合用証券番号 */
     ztyktgyfilerenno                                   VARCHAR     (1)                                                                 ,  /* （中継用）結合用ファイル連番 */
     ztyraysystemhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）ＲＡＹシステム表示 */
     ztygaikakbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）外貨区分 */
     ztykawaserate                                      DECIMAL     (9,6)                                                               ,  /* （中継用）為替レート */
     ztykawaseratetekiyouymd                            VARCHAR     (8)                                                                 ,  /* （中継用）為替レート適用年月日 */
     ztykykjikawaserate                                 DECIMAL     (9,6)                                                               ,  /* （中継用）契約時為替レート */
     ztykykjikawaseratetkyuymd                          VARCHAR     (8)                                                                 ,  /* （中継用）契約時為替レート適用年月日 */
     ztykeiyakujiyoteiriritu                            DECIMAL     (5,4)                                                               ,  /* （中継用）契約時予定利率 */
     ztytumitateriritu                                  DECIMAL     (5,4)                                                               ,  /* （中継用）積立利率 */
     ztysrkyksjkkktyouseiriritu                         DECIMAL     (5,4)                                                               ,  /* （中継用）数理用契約時市場価格調整用利率 */
     ztyenkdtsbujsitihsyukngk                           DECIMAL     (11)                                                                ,  /* （中継用）円貨建死亡時最低保証金額 */
     ztykaigomaebaraitkykarihyj                         VARCHAR     (1)                                                                 ,  /* （中継用）介護前払特約あり表示 */
     ztysuuriyouyobin1                                  VARCHAR     (1)                                                                 ,  /* （中継用）数理用予備項目Ｎ１ */
     ztysibouhyoukbn                                    VARCHAR     (2)                                                                 ,  /* （中継用）死亡表区分 */
     ztymvatyouseikou                                   DECIMAL     (5,4)                                                               ,  /* （中継用）ＭＶＡ調整項 */
     ztynyuukintuukakbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）入金通貨区分 */
     ztyhtnknkykliveonearhyj                            VARCHAR     (1)                                                                 ,  /* （中継用）被転換契約ライブワン有表示 */
     ztyliveonepackagesyouhinkbn                        VARCHAR     (1)                                                                 ,  /* （中継用）ライブワンパッケージ商品区分 */
     ztyhtnkngukisisttkknsnp                            DECIMAL     (11)                                                                ,  /* （中継用）被転換合計災疾月換算Ｐ */
     ztywyendttargetmokuhyouritu                        VARCHAR     (3)                                                                 ,  /* （中継用）円建Ｗターゲット目標率 */
     ztysisuurendourate                                 VARCHAR     (3)                                                                 ,  /* （中継用）指数連動部分割合 */
     ztysisuukbn                                        VARCHAR     (2)                                                                 ,  /* （中継用）指数区分 */
     ztysuuriyouyobin2                                  VARCHAR     (2)                                                                 ,  /* （中継用）数理用予備項目Ｎ２ */
     ztysuuriyouyobin10x2                               VARCHAR     (10)                                                                ,  /* （中継用）数理用予備項目Ｎ１０＿２ */
     ztysuuriyouyobin10x3                               VARCHAR     (10)                                                                ,  /* （中継用）数理用予備項目Ｎ１０＿３ */
     ztytmttknzoukaritujygn                             DECIMAL     (5,4)                                                               ,  /* （中継用）積立金増加率上限 */
     ztysetteibairitu                                   DECIMAL     (3,2)                                                               ,  /* （中継用）設定倍率 */
     ztykykymdsisuu                                     DECIMAL     (10,5)                                                              ,  /* （中継用）契約日指数 */
     ztyrendouritu                                      DECIMAL     (5,4)                                                               ,  /* （中継用）連動率 */
     ztyyobin5                                          DECIMAL     (5)                                                                 ,  /* （中継用）予備項目Ｎ５ */
     ztyyobin5x2                                        DECIMAL     (5)                                                                 ,  /* （中継用）予備項目Ｎ５＿２ */
     ztyyobiv10x6                                       VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０＿６ */
     ztyyendttargetkijyunkingaku                        DECIMAL     (11)                                                                ,  /* （中継用）円建ターゲット基準金額 */
     ztysisuurentumitatekin                             DECIMAL     (11)                                                                ,  /* （中継用）指数連動部分積立金 */
     ztytirttmtttumitatekin                             DECIMAL     (11)                                                                ,  /* （中継用）定率積立部分積立金 */
     ztynksjitirttmttkn                                 DECIMAL     (11)                                                                ,  /* （中継用）年金開始時定率積立金 */
     ztynendomatutirttumitatekin                        DECIMAL     (11)                                                                ,  /* （中継用）年度末定率部分積立金 */
     ztysyuptumitatekin                                 DECIMAL     (11)                                                                ,  /* （中継用）主契約保険料積立金 */
     ztygaikadatenkgns                                  DECIMAL     (11)                                                                ,  /* （中継用）外貨建年金原資 */
     ztytumitatekin                                     DECIMAL     (11)                                                                ,  /* （中継用）積立金 */
     ztykiharaikomip                                    DECIMAL     (11)                                                                ,  /* （中継用）既払込Ｐ */
     ztygaikadatesyukeiyakup                            DECIMAL     (11)                                                                ,  /* （中継用）外貨建主契約Ｐ */
     ztysitivkisnyukykjikwsrate                         DECIMAL     (9,6)                                                               ,  /* （中継用）最低Ｖ計算用契約時為替レート */
     ztyyobiv16                                         VARCHAR     (16)                                                                ,  /* （中継用）予備項目Ｖ１６ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_Skeiksnbsgetujisr6Ty_Z ADD CONSTRAINT PK_Skeiksnbsgetujisr6Ty PRIMARY KEY (
     ztyktgysyono                                               /* （中継用）結合用証券番号 */
) ;
