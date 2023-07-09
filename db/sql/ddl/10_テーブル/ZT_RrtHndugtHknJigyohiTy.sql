CREATE TABLE ZT_RrtHndugtHknJigyohiTy (
     ztysequenceno                                      NUMBER      (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztyyuukourecordlength                              NUMBER      (7)                                                                 ,  /* （中継用）有効レコード長 */
     ztyrdwarea                                         VARCHAR     (4)                                                                 ,  /* （中継用）ＲＤＷ領域 */
     ztykeijyouym                                       VARCHAR     (6)                                                                 ,  /* （中継用）計上年月 */
     ztysuuriyoupjytouym                                VARCHAR     (6)                                                                 ,  /* （中継用）数理用Ｐ充当年月 */
     ztysihankibikinkbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）四半期備金区分 */
     ztyhenkousyoriymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）変更処理年月日 */
     ztydenymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）伝票日付 */
     ztysyoricd                                         VARCHAR     (4)                                                                 ,  /* （中継用）処理コード */
     ztykykymdmaekykhyj                                 VARCHAR     (1)                                                                 ,  /* （中継用）契約日前契約表示 */
     ztykarikasikbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）借方貸方区分 */
     ztysuuriyouyobin8                                  VARCHAR     (8)                                                                 ,  /* （中継用）数理用予備項目Ｎ８ */
     ztyyobiv7                                          VARCHAR     (7)                                                                 ,  /* （中継用）予備項目Ｖ７ */
     ztydatakanrino                                     VARCHAR     (11)                                                                ,  /* （中継用）データ管理番号 */
     ztyraysystemhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）ＲＡＹシステム表示 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztyhknsyuruikigousedaikbn                          VARCHAR     (1)                                                                 ,  /* （中継用）保険種類記号世代区分 */
     ztysotodasipmenkbn                                 VARCHAR     (1)                                                                 ,  /* （中継用）外出Ｐ免区分 */
     ztystdssytikbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）外出集定区分 */
     ztystdssnskbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）外出診査区分 */
     ztysotodasimanagehyouji                            VARCHAR     (1)                                                                 ,  /* （中継用）外出満年令表示 */
     ztysotodasiphkbnmnoshyouji                         VARCHAR     (1)                                                                 ,  /* （中継用）外出Ｐ不可分見直表示 */
     ztystdsstkjytkyuhyj                                VARCHAR     (1)                                                                 ,  /* （中継用）外出新特条適用表示 */
     ztysuuriyouyobin5                                  VARCHAR     (5)                                                                 ,  /* （中継用）数理用予備項目Ｎ５ */
     ztyyobiv4                                          VARCHAR     (4)                                                                 ,  /* （中継用）予備項目Ｖ４ */
     ztykbnkeiriyousegmentkbn                           VARCHAR     (2)                                                                 ,  /* （中継用）区分経理用セグメント区分 */
     ztykbnkeiriyourgnbnskkbn                           VARCHAR     (2)                                                                 ,  /* （中継用）区分経理用利源分析区分 */
     ztysuurisyuruicd                                   VARCHAR     (2)                                                                 ,  /* （中継用）数理種類コード */
     ztyhosyoukinoukbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）保障機能区分 */
     ztydaikbn                                          VARCHAR     (2)                                                                 ,  /* （中継用）大区分 */
     ztytyuukbn                                         VARCHAR     (4)                                                                 ,  /* （中継用）中区分 */
     ztysyoukbn                                         VARCHAR     (4)                                                                 ,  /* （中継用）小区分 */
     ztysedaikbn                                        VARCHAR     (4)                                                                 ,  /* （中継用）世代区分 */
     ztyharaikatakbn                                    VARCHAR     (2)                                                                 ,  /* （中継用）払方区分 */
     ztykykymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）契約年月日 */
     ztyhknkkn                                          VARCHAR     (2)                                                                 ,  /* （中継用）保険期間 */
     ztyphrkkikn                                        VARCHAR     (2)                                                                 ,  /* （中継用）Ｐ払込期間 */
     ztysaimnkkykhyj                                    VARCHAR     (1)                                                                 ,  /* （中継用）才満期契約表示 */
     ztyannaifuyouriyuukbn                              VARCHAR     (2)                                                                 ,  /* （中継用）案内不要理由区分 */
     ztyhrkkaisuukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）払込回数区分 */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分 */
     ztysdpdkbn                                         VARCHAR     (1)                                                                 ,  /* （中継用）Ｓ建Ｐ建区分 */
     ztyryouritukbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）料率区分 */
     ztyhhknseikbn                                      VARCHAR     (1)                                                                 ,  /* （中継用）被保険者性別区分 */
     ztyhihokensyaagev2                                 VARCHAR     (2)                                                                 ,  /* （中継用）被保険者年令Ｖ２ */
     ztyhhknnentysihyj                                  VARCHAR     (1)                                                                 ,  /* （中継用）被保険者年令調整表示 */
     ztysyukeiyakupwaribikikbn                          VARCHAR     (2)                                                                 ,  /* （中継用）主契約Ｐ割引区分 */
     ztykuriagekurisagekbn                              VARCHAR     (1)                                                                 ,  /* （中継用）繰上げ繰下げ区分 */
     ztysuuriyouyobin11                                 VARCHAR     (11)                                                                ,  /* （中継用）数理用予備項目Ｎ１１ */
     ztyyobiv10                                         VARCHAR     (10)                                                                ,  /* （中継用）予備項目Ｖ１０ */
     ztyalmyousohutomeisyoukbn                          VARCHAR     (2)                                                                 ,  /* （中継用）ＡＬＭ用ソフト名称区分 */
     ztysnkyksoftmeisyoukbn                             VARCHAR     (2)                                                                 ,  /* （中継用）新契約ソフト名称区分 */
     ztysoftmeisyoukbn                                  VARCHAR     (2)                                                                 ,  /* （中継用）ソフト名称区分 */
     ztynenkinkaisinendo                                VARCHAR     (4)                                                                 ,  /* （中継用）年金開始年度 */
     ztynenkingatakbn                                   VARCHAR     (1)                                                                 ,  /* （中継用）年金型区分 */
     ztynknshry                                         VARCHAR     (2)                                                                 ,  /* （中継用）年金支払期間 */
     ztybosyuukeitaikbn                                 VARCHAR     (2)                                                                 ,  /* （中継用）募集形態区分 */
     ztygaikakbn                                        VARCHAR     (1)                                                                 ,  /* （中継用）外貨区分 */
     ztysuuriyouyobin8x2                                VARCHAR     (8)                                                                 ,  /* （中継用）数理用予備項目Ｎ８＿２ */
     ztyyobiv6                                          VARCHAR     (6)                                                                 ,  /* （中継用）予備項目Ｖ６ */
     ztysyukeiyakup                                     NUMBER      (11)                                                                ,  /* （中継用）主契約Ｐ */
     ztykihons                                          NUMBER      (11)                                                                ,  /* （中継用）基本Ｓ */
     ztypjuutoujikawaserate                             NUMBER      (9,6)                                                               ,  /* （中継用）保険料充当時為替レート */
     ztypjuutoujikawasekijyunymd                        VARCHAR     (8)                                                                 ,  /* （中継用）保険料充当時為替基準年月日 */
     ztygessitumitatekin                                NUMBER      (11)                                                                ,  /* （中継用）月始積立金 */
     ztyyoteiriritun5                                   NUMBER      (5,4)                                                               ,  /* （中継用）予定利率Ｎ５ */
     ztytumitateriritu                                  NUMBER      (5,4)                                                               ,  /* （中継用）積立利率 */
     ztygaikadatetougetujuutoup                         NUMBER      (11)                                                                ,  /* （中継用）外貨建当月充当Ｐ */
     ztykiharaikomip                                    NUMBER      (11)                                                                ,  /* （中継用）既払込Ｐ */
     ztykeisanhanteiyoutmttkn                           NUMBER      (11)                                                                ,  /* （中継用）計算判定用積立金 */
     ztyzettaisibouritu                                 NUMBER      (13,11)                                                             ,  /* （中継用）絶対死亡率 */
     ztysoutaisibouritu                                 NUMBER      (13,11)                                                             ,  /* （中継用）相対死亡率 */
     ztysoutaikaiyakuritu                               NUMBER      (13,11)                                                             ,  /* （中継用）相対解約率 */
     ztyvhireilritu                                     NUMBER      (13,11)                                                             ,  /* （中継用）Ｖ比例Ｌ率 */
     ztyyobin13                                         NUMBER      (13)                                                                ,  /* （中継用）予備項目Ｎ１３ */
     ztyphireilwrbkritu                                 NUMBER      (13,11)                                                             ,  /* （中継用）Ｐ比例Ｌ割引率 */
     ztygetumatutumitatekin                             NUMBER      (11)                                                                ,  /* （中継用）月末積立金 */
     ztyzennoujiikkatubaraijytgk                        NUMBER      (11)                                                                ,  /* （中継用）前納時一括払充当額 */
     ztygaikadatenkgns                                  NUMBER      (11)                                                                ,  /* （中継用）外貨建年金原資 */
     ztyphireialpha                                     NUMBER      (13,11)                                                             ,  /* （中継用）Ｐ比例α */
     ztyphireibeta                                      NUMBER      (13,11)                                                             ,  /* （中継用）Ｐ比例β */
     ztyphireiganma                                     NUMBER      (13,11)                                                             ,  /* （中継用）Ｐ比例γ */
     ztykykjikawaserate                                 NUMBER      (9,6)                                                               ,  /* （中継用）契約時為替レート */
     ztykykjikawaseratetkyuymd                          VARCHAR     (8)                                                                 ,  /* （中継用）契約時為替レート適用年月日 */
     ztyyobiv11                                         VARCHAR     (11)                                                                ,  /* （中継用）予備項目Ｖ１１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_RrtHndugtHknJigyohiTy ADD CONSTRAINT PK_RrtHndugtHknJigyohiTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;
