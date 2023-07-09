CREATE TABLE JM_SiSyouhnZokusei (
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     kyhgndkatakbn                                      VARCHAR     (1)                                                       NOT NULL  ,  /* 給付限度型区分 */
     syouhnsdno                                         NUMBER      (2)                                                       NOT NULL  ,  /* 商品世代番号 */
     kyuuhucd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 給付コード */
     syutkkbn                                           VARCHAR     (1)                                                                 ,  /* 主契約特約区分 */
     syouhnnm                                           VARCHAR     (40)                                                                ,  /* 商品名 */
     syouhnnmgm                                         VARCHAR     (40)                                                                ,  /* 商品名（画面用） */
     syouhnnmtyhy                                       VARCHAR     (40)                                                                ,  /* 商品名（帳票用） */
     hyoujijyun                                         NUMBER      (2)                                                                 ,  /* 表示順 */
     taisyoukkngaishrkahikbn                            NUMBER      (1)                                                                 ,  /* 対象期間外支払可否区分 */
     byoumeisetteikbn                                   VARCHAR     (1)                                                                 ,  /* 病名設定区分 */
     shrjiyuu                                           VARCHAR     (30)                                                                ,  /* 支払事由 */
     syoumetuumukbn                                     VARCHAR     (1)                                                                 ,  /* 消滅有無区分 */
     taisyoukknmae                                      NUMBER      (3)                                                                 ,  /* 対象期間（前） */
     taisyoukknato                                      NUMBER      (3)                                                                 ,  /* 対象期間（後） */
     shrtaisyounissuu                                   NUMBER      (3)                                                                 ,  /* 支払対象日数 */
     shrtaisyounyuuinnissuu                             NUMBER      (4)                                                                 ,  /* 支払対象入院日数 */
     hutanponissuu                                      NUMBER      (2)                                                                 ,  /* 不担保日数 */
     itinyuuingendonissuu                               NUMBER      (3)                                                                 ,  /* １入院限度日数 */
     kyhgendonissuu                                     NUMBER      (3)                                                                 ,  /* 給付限度日数 */
     tuusangendonissuu                                  NUMBER      (4)                                                                 ,  /* 通算限度日数 */
     tuusangendokaisuu                                  NUMBER      (2)                                                                 ,  /* 通算限度回数 */
     tuusangendogaku                                    NUMBER      (11)                                                                ,  /* 通算限度額 */
     tuusangendogaku$                                   VARCHAR     (10)                                                                ,  /* 通算限度額(通貨型) */
     betusippeihanteinissuu                             NUMBER      (3)                                                                 ,  /* 別疾病判定日数 */
     nitigakurate                                       NUMBER      (3)                                                                 ,  /* 日額率 */
     nitigakuhokenkngkkbn                               VARCHAR     (1)                                                                 ,  /* 日額・保険金額区分 */
     kyhkintanikbn                                      VARCHAR     (1)                                                                 ,  /* 給付金単位区分 */
     shrbairitu                                         NUMBER      (4)                                                                 ,  /* 支払倍率 */
     jisatumensekinensuu                                NUMBER      (1)                                                                 ,  /* 自殺免責年数 */
     manryoumaetukisuu                                  NUMBER      (2)                                                                 ,  /* 満了前月数 */
     tyouhyouhyoujikbn                                  NUMBER      (1)                                                                 ,  /* 帳票表示区分 */
     nyuuinitijikinumukbn                               VARCHAR     (1)                                                                 ,  /* 入院一時金有無区分 */
     sensinitijikinumukbn                               VARCHAR     (1)                                                                 ,  /* 先進医療一時金有無区分 */
     itijikngk                                          NUMBER      (11)                                                                ,  /* 一時金額 */
     itijikngk$                                         VARCHAR     (10)                                                                ,  /* 一時金額(通貨型) */
     kyhkintaisyouumukbn                                VARCHAR     (1)                                                                 ,  /* 給付金対象有無区分 */
     kdhokenkintaisyouumukbn                            VARCHAR     (1)                                                                 ,  /* 高度障害保険金対象有無区分 */
     pmtaisyouumukbn                                    VARCHAR     (1)                                                                 ,  /* Ｐ免対象有無区分 */
     sbjishrkbn                                         VARCHAR     (1)                                                                 ,  /* 死亡時支払区分 */
     sbmensekitaisyouumukbn                             VARCHAR     (1)                                                                 ,  /* 死亡免責対象有無区分 */
     kyhntgkkatacalcumukbn                              VARCHAR     (1)                                                                 ,  /* 給付日額型計算有無区分 */
     shrsakugenkknumukbn                                VARCHAR     (1)                                                                 ,  /* 支払削減期間有無区分 */
     misyuumikeikadoujiumukbn                           VARCHAR     (1)                                                                 ,  /* 未収未経過同時発生有無区分 */
     hokenkngknitigakumsg1                              VARCHAR     (10)                                                                ,  /* 保険金額日額文言１ */
     hokenkngknitigakumsg2                              VARCHAR     (10)                                                                ,  /* 保険金額日額文言２ */
     lnmaxkngk                                          NUMBER      (11)                                                                ,  /* ＬＮ上限金額 */
     lnmaxkngk$                                         VARCHAR     (10)                                                                ,  /* ＬＮ上限金額(通貨型) */
     lnminkngk                                          NUMBER      (11)                                                                ,  /* ＬＮ下限金額 */
     lnminkngk$                                         VARCHAR     (10)                                                                ,  /* ＬＮ下限金額(通貨型) */
     lnseikyuutanisenyen                                NUMBER      (4)                                                                 ,  /* ＬＮ請求単位（千円） */
     lnseikyuutanisenyen$                               VARCHAR     (10)                                                                ,  /* ＬＮ請求単位（千円）(通貨型) */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     calckijyunmiraibicheck                             VARCHAR     (1)                                                                 ,  /* 計算基準未来日チェック */
     psoutougkhyoujiumu                                 VARCHAR     (1)                                                                 ,  /* 保険料相当額表示有無 */
     tmttkngkhyoujiumu                                  VARCHAR     (1)                                                                 ,  /* 積立金額表示有無 */
     kaiyakuhrhyoujiumu                                 VARCHAR     (1)                                                                 ,  /* 解約返戻金表示有無 */
     kihonshyoujiumu                                    VARCHAR     (1)                                                                 ,  /* 基本保険金額表示有無 */
     saigaishyoujiumu                                   VARCHAR     (1)                                                                    /* 災害保険金額表示有無 */
)
;

ALTER TABLE JM_SiSyouhnZokusei ADD CONSTRAINT PK_SiSyouhnZokusei PRIMARY KEY (
     syouhncd                                                 , /* 商品コード */
     kyhgndkatakbn                                            , /* 給付限度型区分 */
     syouhnsdno                                               , /* 商品世代番号 */
     kyuuhucd                                                   /* 給付コード */
) ;
