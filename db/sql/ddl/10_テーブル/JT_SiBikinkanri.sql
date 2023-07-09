CREATE TABLE JT_SiBikinkanri (
     skno                                               VARCHAR     (18)                                                      NOT NULL  ,  /* 請求番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     kessankijyunymd                                    VARCHAR     (8)                                                       NOT NULL  ,  /* 決算基準日 */
     bkncdkbn                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 備金コード区分 */
     bknkktymd                                          VARCHAR     (8)                                                       NOT NULL  ,  /* 備金確定日 */
     kyuuhucd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 給付コード */
     bknrigikbn                                         VARCHAR     (1)                                                                 ,  /* 備金例外区分 */
     seikyuusyubetu                                     VARCHAR     (2)                                                                 ,  /* 請求種別 */
     calckijyunymd                                      VARCHAR     (8)                                                                 ,  /* 計算基準日 */
     syoruiukeymd                                       VARCHAR     (8)                                                                 ,  /* 書類受付日 */
     hubikanryouymd                                     VARCHAR     (8)                                                                 ,  /* 不備完了日 */
     syouhnsyuruikbn                                    VARCHAR     (1)                                                                 ,  /* 商品種類区分 */
     syutkkbn                                           VARCHAR     (1)                                                                 ,  /* 主契約特約区分 */
     sisyacd                                            VARCHAR     (3)                                                                 ,  /* 支社コード */
     kbnkeirisegcd                                      VARCHAR     (20)                                                                ,  /* 区分経理用セグメントコード */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     kyuuhuname                                         VARCHAR     (30)                                                                ,  /* 給付名 */
     bkngk                                              NUMBER      (13)                                                                ,  /* 備金額 */
     bkngk$                                             VARCHAR     (10)                                                                ,  /* 備金額(通貨型) */
     kihons                                             NUMBER      (13)                                                                ,  /* 基本Ｓ */
     kihons$                                            VARCHAR     (10)                                                                ,  /* 基本Ｓ(通貨型) */
     shrumu                                             VARCHAR     (1)                                                                 ,  /* 支払有無区分 */
     sinsaumukbn                                        VARCHAR     (1)                                                                 ,  /* 診査有無区分 */
     soukiumukbn                                        VARCHAR     (1)                                                                 ,  /* 早期有無区分 */
     syoumetuumukbn                                     VARCHAR     (1)                                                                 ,  /* 消滅有無区分 */
     hubijyoukyoukbn                                    VARCHAR     (1)                                                                 ,  /* 不備状況区分 */
     bknjkukbn                                          VARCHAR     (1)                                                                 ,  /* 備金時効区分 */
     shrsyoriymd                                        VARCHAR     (8)                                                                 ,  /* 支払処理日 */
     tyakkinymd                                         VARCHAR     (8)                                                                 ,  /* 着金日 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     shrtuukasyu                                        VARCHAR     (3)                                                                 ,  /* 支払通貨種類 */
     shrgk                                              NUMBER      (13)                                                                ,  /* 支払金額 */
     shrgk$                                             VARCHAR     (10)                                                                ,  /* 支払金額(通貨型) */
     shrkwsratekjnymd                                   VARCHAR     (8)                                                                 ,  /* 支払時為替レート基準日 */
     shrkwsrate                                         NUMBER      (7,4)                                                               ,  /* 支払時為替レート */
     sitihsyutkyumaeyenhknkngk                          NUMBER      (13)                                                                ,  /* 最低保証適用前円換算保険金額 */
     sitihsyutkyumaeyenhknkngk$                         VARCHAR     (10)                                                                ,  /* 最低保証適用前円換算保険金額(通貨型) */
     initsbjiyenkasaiteihsygk                           NUMBER      (13)                                                                ,  /* 初期死亡時円換算最低保証額 */
     initsbjiyenkasaiteihsygk$                          VARCHAR     (10)                                                                ,  /* 初期死亡時円換算最低保証額(通貨型) */
     siboukaritrkymd                                    VARCHAR     (8)                                                                 ,  /* 死亡仮受付登録日 */
     shrkekkakbn                                        VARCHAR     (1)                                                                 ,  /* 支払結果区分 */
     hushrgeninkbn                                      VARCHAR     (2)                                                                 ,  /* 不支払原因区分 */
     siinkbn                                            VARCHAR     (1)                                                                 ,  /* 死因区分 */
     kinoussnm                                          VARCHAR     (25)                                                                ,  /* 機能詳細名 */
     suketorihouhoukbn                                  VARCHAR     (1)                                                                 ,  /* 保険金受取方法区分 */
     tutakngk                                           NUMBER      (13)                                                                ,  /* 積立金額 */
     tutakngk$                                          VARCHAR     (10)                                                                ,  /* 積立金額(通貨型) */
     yentutakngk                                        NUMBER      (13)                                                                ,  /* 円換算積立金額 */
     yentutakngk$                                       VARCHAR     (10)                                                                ,  /* 円換算積立金額(通貨型) */
     kaiyakuhr                                          NUMBER      (13)                                                                ,  /* 解約返戻金 */
     kaiyakuhr$                                         VARCHAR     (10)                                                                ,  /* 解約返戻金(通貨型) */
     yenkaiyakuhr                                       NUMBER      (13)                                                                ,  /* 円換算解約返戻金 */
     yenkaiyakuhr$                                      VARCHAR     (10)                                                                ,  /* 円換算解約返戻金(通貨型) */
     gengkumukbn                                        VARCHAR     (1)                                                                 ,  /* 減額有無区分 */
     gengkymd                                           VARCHAR     (8)                                                                 ,  /* 減額日 */
     jisatumensekiumukbn                                VARCHAR     (1)                                                                 ,  /* 自殺免責有無区分 */
     syuukeiyoubkncdkbn                                 VARCHAR     (4)                                                                 ,  /* 集計用備金コード区分 */
     hokenkinsyuruikbn                                  VARCHAR     (1)                                                                 ,  /* 保険金種類区分 */
     bkntyousafsyorikbn                                 VARCHAR     (2)                                                                 ,  /* 備金調査ファイル処理区分 */
     bknkktinnd                                         VARCHAR     (4)                                                                 ,  /* 備金確定年度 */
     bknkktiym                                          VARCHAR     (6)                                                                 ,  /* 備金確定年月 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     zennouseisankinumukbn                              VARCHAR     (1)                                                                 ,  /* 前納精算金有無区分 */
     zennouseisankgk                                    NUMBER      (13)                                                                ,  /* 前納精算金額 */
     zennouseisankgk$                                   VARCHAR     (10)                                                                ,  /* 前納精算金額(通貨型) */
     yenkazennouseisankgk                               NUMBER      (13)                                                                ,  /* 円貨前納精算金額 */
     yenkazennouseisankgk$                              VARCHAR     (10)                                                                ,  /* 円貨前納精算金額(通貨型) */
     mikeikapumukbn                                     VARCHAR     (1)                                                                 ,  /* 未経過保険料有無区分 */
     mikeikap                                           NUMBER      (13)                                                                ,  /* 未経過保険料 */
     mikeikap$                                          VARCHAR     (10)                                                                ,  /* 未経過保険料(通貨型) */
     yenkamikeikap                                      NUMBER      (13)                                                                ,  /* 円貨未経過保険料 */
     yenkamikeikap$                                     VARCHAR     (10)                                                                ,  /* 円貨未経過保険料(通貨型) */
     misyuupumukbn                                      VARCHAR     (1)                                                                 ,  /* 未収保険料有無区分 */
     misyuupjyuutouym                                   VARCHAR     (6)                                                                 ,  /* 未収保険料充当年月 */
     hrkp                                               NUMBER      (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     misyuup                                            NUMBER      (13)                                                                ,  /* 未収保険料 */
     misyuup$                                           VARCHAR     (10)                                                                ,  /* 未収保険料(通貨型) */
     yenkamisyuup                                       NUMBER      (13)                                                                ,  /* 円貨未収保険料 */
     yenkamisyuup$                                      VARCHAR     (10)                                                                ,  /* 円貨未収保険料(通貨型) */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     syonendojikaiikoup                                 NUMBER      (13)                                                                ,  /* 初年度次回以降Ｐ */
     syonendojikaiikoup$                                VARCHAR     (10)                                                                ,  /* 初年度次回以降Ｐ(通貨型) */
     yenkasyonendojikaiikoup                            NUMBER      (13)                                                                ,  /* 円貨初年度次回以降Ｐ */
     yenkasyonendojikaiikoup$                           VARCHAR     (10)                                                                ,  /* 円貨初年度次回以降Ｐ(通貨型) */
     jinendoikoup                                       NUMBER      (13)                                                                ,  /* 次年度以降Ｐ */
     jinendoikoup$                                      VARCHAR     (10)                                                                ,  /* 次年度以降Ｐ(通貨型) */
     yenkajinendoikoup                                  NUMBER      (13)                                                                ,  /* 円貨次年度以降Ｐ */
     yenkajinendoikoup$                                 VARCHAR     (10)                                                                ,  /* 円貨次年度以降Ｐ(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE JT_SiBikinkanri ADD CONSTRAINT PK_SiBikinkanri PRIMARY KEY (
     skno                                                     , /* 請求番号 */
     syono                                                    , /* 証券番号 */
     kessankijyunymd                                          , /* 決算基準日 */
     bkncdkbn                                                 , /* 備金コード区分 */
     bknkktymd                                                , /* 備金確定日 */
     kyuuhucd                                                   /* 給付コード */
) ;
