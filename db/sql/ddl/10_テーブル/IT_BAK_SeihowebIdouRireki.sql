CREATE TABLE IT_BAK_SeihowebIdouRireki (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     henkousikibetukey                                  VARCHAR     (18)                                                      NOT NULL  ,  /* 変更識別キー */
     idouhasseiym                                       VARCHAR     (6)                                                                 ,  /* 異動発生年月 */
     idouhasseiymd                                      VARCHAR     (8)                                                                 ,  /* 異動発生年月日 */
     seihowebidoukbnnaiyou1                             VARCHAR     (22)                                                                ,  /* 生保Ｗｅｂ異動区分内容１ */
     seihowebidoukbnnaiyou2                             VARCHAR     (22)                                                                ,  /* 生保Ｗｅｂ異動区分内容２ */
     dairitencd1                                        VARCHAR     (7)                                                                 ,  /* 代理店コード１ */
     bosyuucd1                                          VARCHAR     (6)                                                                 ,  /* 募集人コード１ */
     drtenbunumu                                        VARCHAR     (1)                                                                 ,  /* 代理店分担有無 */
     dairitencd2                                        VARCHAR     (7)                                                                 ,  /* 代理店コード２ */
     bosyuucd2                                          VARCHAR     (6)                                                                 ,  /* 募集人コード２ */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     bosyuuym                                           VARCHAR     (6)                                                                 ,  /* 募集年月 */
     cifcd                                              VARCHAR     (15)                                                                ,  /* ＣＩＦコード */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     jkipjytym                                          VARCHAR     (6)                                                                 ,  /* 次回Ｐ充当年月 */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字） */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     syouhnsdno                                         NUMBER      (2)                                                                 ,  /* 商品世代番号 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     hokenryou                                          NUMBER      (13)                                                                ,  /* 保険料 */
     hokenryou$                                         VARCHAR     (10)                                                                ,  /* 保険料(通貨型) */
     tuukasyu                                           VARCHAR     (3)                                                                 ,  /* 通貨種類 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_BAK_SeihowebIdouRireki ADD CONSTRAINT PK_BAK_SeihowebIdouRireki PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     henkousikibetukey                                          /* 変更識別キー */
) ;
