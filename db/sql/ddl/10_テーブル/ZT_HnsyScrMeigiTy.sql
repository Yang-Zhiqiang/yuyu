CREATE TABLE ZT_HnsyScrMeigiTy (
     ztyhnsyrecordkbn                                   VARCHAR     (3)                                                                 ,  /* （中継用）反社レコ－ド区分                                 */
     ztykijyunym                                        VARCHAR     (6)                                                                 ,  /* （中継用）基準年月                                     */
     ztytaisyounmkn                                     VARCHAR     (18)                                                      NOT NULL  ,  /* （中継用）対象者姓名（カナ）                                */
     ztytaisyounmkj                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （中継用）対象者姓名（漢字）                                */
     ztytaisyouseiymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）対象者生年月日                                  */
     ztytsnsknewyno                                     VARCHAR     (7)                                                                 ,  /* （中継用）通信先新郵便番号                                 */
     ztytsnsknewtikucd                                  VARCHAR     (1)                                                                 ,  /* （中継用）通信先新地区コード                                */
     ztyhhknnewyno                                      VARCHAR     (7)                                                                 ,  /* （中継用）被保険者新郵便番号                                */
     ztyhhknnewtikucd                                   VARCHAR     (1)                                                                 ,  /* （中継用）被保険者新地区コ－ド                               */
     ztykstkannisknewyno                                VARCHAR     (7)                                                                 ,  /* （中継用）貸付案内先新郵便番号                               */
     ztykstkannisknewtikucd                             VARCHAR     (1)                                                                 ,  /* （中継用）貸付案内先新地区コ－ド                              */
     ztydntnewyno                                       VARCHAR     (7)                                                                 ,  /* （中継用）団体新郵便番号                                  */
     ztydntnewtikucd                                    VARCHAR     (1)                                                                 ,  /* （中継用）団体新地区コ－ド                                 */
     ztykanjitsinkaiadr                                 VARCHAR     (62)                                                                ,  /* （中継用）漢字通信先下位住所                                */
     ztytodouhukennm                                    VARCHAR     (10)                                                                ,  /* （中継用）都道府県名                                    */
     ztysigunnm                                         VARCHAR     (30)                                                                ,  /* （中継用）市郡名                                      */
     ztysosikicd1                                       VARCHAR     (7)                                                                 ,  /* （中継用）組織コ－ド１                                   */
     ztysosikicd2                                       VARCHAR     (7)                                                                 ,  /* （中継用）組織コ－ド２                                   */
     ztysosikicd3                                       VARCHAR     (7)                                                                 ,  /* （中継用）組織コ－ド３                                   */
     ztysosikicd4                                       VARCHAR     (7)                                                                 ,  /* （中継用）組織コ－ド４                                   */
     ztysosikicd5                                       VARCHAR     (7)                                                                 ,  /* （中継用）組織コ－ド５                                   */
     ztyhhknhnsktodouhukencd                            VARCHAR     (2)                                                                 ,  /* （中継用）被保険者本籍都道府県コード                            */
     ztykankeinmkn1                                     VARCHAR     (18)                                                                ,  /* （中継用）関係者名（カナ）１                                */
     ztykankeinmkn2                                     VARCHAR     (18)                                                                ,  /* （中継用）関係者名（カナ）２                                */
     ztykankeinmkn3                                     VARCHAR     (18)                                                                ,  /* （中継用）関係者名（カナ）３                                */
     ztykankeinmkn4                                     VARCHAR     (18)                                                                ,  /* （中継用）関係者名（カナ）４                                */
     ztykankeinmkn5                                     VARCHAR     (18)                                                                ,  /* （中継用）関係者名（カナ）５                                */
     ztykankeinmkj1                                     VARCHAR     (15)                                                                ,  /* （中継用）関係者名（漢字）１                                */
     ztykankeinmkj2                                     VARCHAR     (15)                                                                ,  /* （中継用）関係者名（漢字）２                                */
     ztykankeinmkj3                                     VARCHAR     (15)                                                                ,  /* （中継用）関係者名（漢字）３                                */
     ztykankeinmkj4                                     VARCHAR     (15)                                                                ,  /* （中継用）関係者名（漢字）４                                */
     ztykankeinmkj5                                     VARCHAR     (15)                                                                ,  /* （中継用）関係者名（漢字）５                                */
     ztyhrkkeirokbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）払込経路区分                                   */
     ztydntcd                                           VARCHAR     (8)                                                                 ,  /* （中継用）団体コ－ド                                    */
     ztydntnm                                           VARCHAR     (30)                                                                ,  /* （中継用）団体名                                      */
     ztydntsyzkcd                                       VARCHAR     (10)                                                                ,  /* （中継用）団体所属コ－ド                                  */
     ztydntkojincd                                      VARCHAR     (10)                                                                ,  /* （中継用）団体個人コ－ド                                  */
     ztykzhurikaebankcd                                 VARCHAR     (4)                                                                 ,  /* （中継用）口座振替銀行番号                                 */
     ztykzhurikaesitencd                                VARCHAR     (3)                                                                 ,  /* （中継用）口座振替支店番号                                 */
     ztykzhurikaeyokinkbn                               VARCHAR     (1)                                                                 ,  /* （中継用）口座振替預金種目区分                               */
     ztykzhurikaekouzano                                VARCHAR     (7)                                                                 ,  /* （中継用）口座振替口座番号                                 */
     ztytsintelno                                       VARCHAR     (14)                                                                ,  /* （中継用）通信先電話番号                                  */
     ztyhjncd                                           VARCHAR     (9)                                                                 ,  /* （中継用）法人コード                                    */
     ztyhjnjigyosyocd                                   VARCHAR     (3)                                                                 ,  /* （中継用）法人事業所コード                                 */
     ztysymtymd                                         VARCHAR     (8)                                                                 ,  /* （中継用）消滅年月日                                    */
     ztysyokugyoucd                                     VARCHAR     (3)                                                                 ,  /* （中継用）職業コ－ド                                    */
     ztydai2hhknyno                                     VARCHAR     (7)                                                                 ,  /* （中継用）第２被保険者新郵便番号                              */
     ztydai2hhknnewtikucd                               VARCHAR     (1)                                                                 ,  /* （中継用）第２被保険者新地区コ－ド                             */
     ztydai2hhkntodouhukencd                            VARCHAR     (2)                                                                 ,  /* （中継用）第２被保険者本籍府県コ－ド                            */
     ztysyokugyoucd2                                    VARCHAR     (3)                                                                 ,  /* （中継用）第２職業コ－ド                                  */
     ztyyobiv118                                        VARCHAR     (118)                                                               ,  /* （中継用）予備項目Ｖ１１８                                 */
     ztyskinnm                                          VARCHAR     (10)                                                                ,  /* （中継用）索引姓名                                     */
     ztyyobiv40                                         VARCHAR     (40)                                                                ,  /* （中継用）予備項目Ｖ４０                                  */
     ztynayosetaisyousegkbn                             VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）名寄せ対象者ＳＥＧ区分                              */
     ztynayosetaisyoukojinkbn                           VARCHAR     (2)                                                                 ,  /* （中継用）名寄せ対象者個人区分                               */
     ztyyobiv46                                         VARCHAR     (46)                                                                ,  /* （中継用）予備項目Ｖ４６                                  */
     ztytodouhukencd1                                   VARCHAR     (2)                                                                 ,  /* （中継用）都道府県コード１                                 */
     ztytodouhukencd2                                   VARCHAR     (2)                                                                 ,  /* （中継用）都道府県コード２                                 */
     ztytodouhukencd3                                   VARCHAR     (2)                                                                 ,  /* （中継用）都道府県コード３                                 */
     ztyyobiv34                                         VARCHAR     (34)                                                                ,  /* （中継用）予備項目Ｖ３４                                  */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号                                     */
     ztysyoumetucd                                      VARCHAR     (4)                                                                 ,  /* （中継用）消滅コード                                    */
     ztysymtymd2                                        VARCHAR     (8)                                                                 ,  /* （中継用）消滅年月日＿２                                  */
     ztybohaiyakkandisp                                 VARCHAR     (1)                                                                 ,  /* （中継用）暴排条項導入約款適用表示                             */
     ztymeihenymd                                       VARCHAR     (8)                                                                 ,  /* （中継用）名義変更年月日                                  */
     ztyseiymdseitsymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）生年月日性訂正年月日                               */
     ztykzkmrtityuutohukaymd                            VARCHAR     (8)                                                                 ,  /* （中継用）家族マル定中途付加年月日                             */
     ztykykmfkykknnm                                    VARCHAR     (18)                                                                ,  /* （中継用）契約ＭＦ契約者カナ姓名                              */
     ztykykmfkykkjnm                                    VARCHAR     (15)                                                                ,  /* （中継用）契約ＭＦ契約者漢字姓名                              */
     ztykykmfkykseiymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）契約ＭＦ契約者生年月日                              */
     ztykykmfhhkknnm                                    VARCHAR     (18)                                                                ,  /* （中継用）契約ＭＦ被保険者カナ姓名                             */
     ztykykmfhhkkjnm                                    VARCHAR     (15)                                                                ,  /* （中継用）契約ＭＦ被保険者漢字姓名                             */
     ztykykmfhhkseiymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）契約ＭＦ被保険者生年月日                             */
     ztykykmfdai2knnm                                   VARCHAR     (18)                                                                ,  /* （中継用）契約ＭＦ第２被カナ姓名                              */
     ztykykmfdai2kjnm                                   VARCHAR     (15)                                                                ,  /* （中継用）契約ＭＦ第２被漢字姓名                              */
     ztykykmfdai2seiymd                                 VARCHAR     (8)                                                                 ,  /* （中継用）契約ＭＦ第２被生年月日                              */
     ztykykmfsbuktknnm                                  VARCHAR     (18)                                                                ,  /* （中継用）契約ＭＦ死亡受取人カナ姓名                            */
     ztykykmfsbuktkjnm                                  VARCHAR     (15)                                                                ,  /* （中継用）契約ＭＦ死亡受取人漢字姓名                            */
     ztykykmfsbuktseiymd                                VARCHAR     (8)                                                                 ,  /* （中継用）契約ＭＦ死亡受取人生年月日                            */
     ztykykmfdai2ktknnm                                 VARCHAR     (18)                                                                ,  /* （中継用）契約ＭＦ第２受取人カナ姓名                            */
     ztykykmfdai2ktkjnm                                 VARCHAR     (15)                                                                ,  /* （中継用）契約ＭＦ第２受取人漢字姓名                            */
     ztykykmfdai2ktseiymd                               VARCHAR     (8)                                                                 ,  /* （中継用）契約ＭＦ第２受取人生年月日                            */
     ztykykmfmnkktknnm                                  VARCHAR     (18)                                                                ,  /* （中継用）契約ＭＦ満期受取人カナ姓名                            */
     ztykykmfmnkktkjnm                                  VARCHAR     (15)                                                                ,  /* （中継用）契約ＭＦ満期受取人漢字姓名                            */
     ztykykmfmnkktseiymd                                VARCHAR     (8)                                                                 ,  /* （中継用）契約ＭＦ満期受取人生年月日                            */
     ztydntcd2                                          VARCHAR     (8)                                                                 ,  /* （中継用）団体コード２                                   */
     ztykjdntnm                                         VARCHAR     (35)                                                                ,  /* （中継用）漢字団体名                                    */
     ztyrinjikaisouhyouji                               VARCHAR     (1)                                                                 ,  /* （中継用）臨時回送表示                                   */
     ztyyobiv34x2                                       VARCHAR     (34)                                                                ,  /* （中継用）予備項目Ｖ３４＿２                                */
     ztysgtaisyoukbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）照合対象区分                                   */
     ztyyobiv39                                         VARCHAR     (39)                                                                ,  /* （中継用）予備項目Ｖ３９                                  */
     ztysyuuseihjnnm                                    VARCHAR     (25)                                                                ,  /* （中継用）修正法人名                                    */
     ztyyobiv75                                         VARCHAR     (75)                                                                ,  /* （中継用）予備項目Ｖ７５                                  */
     ztysysyno                                          VARCHAR     (11)                                                                ,  /* （中継用）証書番号                                     */
     ztysueokikaisiymd                                  VARCHAR     (8)                                                                 ,  /* （中継用）据置開始年月日                                  */
     ztyhasseiriyuukbnscreen                            VARCHAR     (1)                                                                 ,  /* （中継用）発生理由区分（反社スクリーニング）                        */
     ztysueokijtkbn                                     VARCHAR     (1)                                                                 ,  /* （中継用）据置状態区分                                   */
     ztytaisyoufilekbn                                  VARCHAR     (1)                                                                 ,  /* （中継用）対象ファイル区分                                 */
     ztybohaiyakkandisp2                                VARCHAR     (1)                                                                 ,  /* （中継用）暴排条項導入約款適用表示２                            */
     ztymeihenymd2                                      VARCHAR     (8)                                                                 ,  /* （中継用）名義変更年月日２                                 */
     ztynksyoumetucd                                    VARCHAR     (2)                                                                 ,  /* （中継用）年金消滅コード                                  */
     ztyyobiv7                                          VARCHAR     (7)                                                                 ,  /* （中継用）予備項目Ｖ７                                   */
     ztyyobiv20                                         VARCHAR     (20)                                                                ,  /* （中継用）予備項目Ｖ２０                                  */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ                                        */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間                                          */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能                                          */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン                                        */
)
;

ALTER TABLE ZT_HnsyScrMeigiTy ADD CONSTRAINT PK_HnsyScrMeigiTy PRIMARY KEY (
     ztytaisyounmkn                                           , /* （中継用）対象者姓名（カナ）                                 */
     ztytaisyounmkj                                           , /* （中継用）対象者姓名（漢字）                                 */
     ztytaisyouseiymd                                         , /* （中継用）対象者生年月日                                   */
     ztynayosetaisyousegkbn                                   , /* （中継用）名寄せ対象者ＳＥＧ区分                               */
     ztysyono                                                   /* （中継用）証券番号                                      */
) ;
