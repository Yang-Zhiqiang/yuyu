CREATE TABLE JT_SiKekka (
     shiharaikekkadatakbn                               VARCHAR     (1)                                                       NOT NULL  ,  /* 支払結果データ区分 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         NUMBER      (2)                                                       NOT NULL  ,  /* 商品世代番号 */
     kyksyouhnrenno                                     NUMBER      (2)                                                       NOT NULL  ,  /* 契約商品連番 */
     syutkkbn                                           VARCHAR     (1)                                                       NOT NULL  ,  /* 主契約特約区分 */
     nexthrkym                                          VARCHAR     (6)                                                                 ,  /* 次回払込年月 */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日 */
     syoumetujiyuu                                      VARCHAR     (2)                                                                 ,  /* 消滅事由 */
     gansindankakuteiymd                                VARCHAR     (32)                                                                ,  /* がん診断確定日 */
     krkgk                                              NUMBER      (13)                                                                ,  /* 仮受金額 */
     krkgk$                                             VARCHAR     (10)                                                                ,  /* 仮受金額(通貨型) */
     denymd                                             VARCHAR     (8)                                                                 ,  /* 伝票日付 */
     misyuumikeikakbn                                   VARCHAR     (1)                                                                 ,  /* 未収未経過区分 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuuy                                      NUMBER      (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      NUMBER      (2)                                                                 ,  /* 充当回数（月） */
     seisanpgoukei                                      NUMBER      (13)                                                                ,  /* 精算保険料合計 */
     seisanpgoukei$                                     VARCHAR     (10)                                                                ,  /* 精算保険料合計(通貨型) */
     hushrgeninkbn                                      VARCHAR     (2)                                                                 ,  /* 不支払原因区分 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     zennouseisankgk                                    NUMBER      (13)                                                                ,  /* 前納精算金額 */
     zennouseisankgk$                                   VARCHAR     (10)                                                                ,  /* 前納精算金額(通貨型) */
     zitkazukarikingksiteituuka                         NUMBER      (13)                                                                ,  /* 税適預り金額（指定通貨） */
     zitkazukarikingksiteituuka$                        VARCHAR     (10)                                                                ,  /* 税適預り金額（指定通貨）(通貨型) */
     zitkazukarikingkyen                                NUMBER      (13)                                                                ,  /* 税適預り金額（円貨） */
     zitkazukarikingkyen$                               VARCHAR     (10)                                                                ,  /* 税適預り金額（円貨）(通貨型) */
     kossyoricd                                         VARCHAR     (50)                                                                ,  /* 更新処理コード */
     kossyorisscd                                       VARCHAR     (50)                                                                ,  /* 更新処理詳細コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE JT_SiKekka ADD CONSTRAINT PK_SiKekka PRIMARY KEY (
     shiharaikekkadatakbn                                     , /* 支払結果データ区分 */
     syono                                                    , /* 証券番号 */
     syouhncd                                                 , /* 商品コード */
     syouhnsdno                                               , /* 商品世代番号 */
     kyksyouhnrenno                                           , /* 契約商品連番 */
     syutkkbn                                                   /* 主契約特約区分 */
) ;

CREATE INDEX IX1_SiKekka ON JT_SiKekka (
     syoriYmd                                                   /* 処理年月日 */
) ;
