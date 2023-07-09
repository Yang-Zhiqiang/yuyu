CREATE TABLE IT_BAK_KykSyouhn (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     syutkkbn                                           VARCHAR     (1)                                                       NOT NULL  ,  /* 主契約特約区分 */
     syouhncd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 商品コード */
     syouhnsdno                                         NUMBER      (2)                                                       NOT NULL  ,  /* 商品世代番号 */
     kyksyouhnrenno                                     NUMBER      (2)                                                       NOT NULL  ,  /* 契約商品連番 */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     yuukousyoumetukbn                                  VARCHAR     (1)                                                                 ,  /* 有効消滅区分 */
     kykjyoutai                                         VARCHAR     (2)                                                                 ,  /* 契約状態 */
     syoumetujiyuu                                      VARCHAR     (2)                                                                 ,  /* 消滅事由 */
     syoumetuymd                                        VARCHAR     (8)                                                                 ,  /* 消滅日 */
     kouryokuhasseiymd                                  VARCHAR     (8)                                                                 ,  /* 効力発生日 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     kykymdsiteiumukbn                                  VARCHAR     (1)                                                                 ,  /* 契約日指定有無区分 */
     sknnkaisiymd                                       VARCHAR     (8)                                                                 ,  /* 責任開始日 */
     gansknnkaisiymd                                    VARCHAR     (8)                                                                 ,  /* がん責任開始日 */
     hksknnkaisiymd                                     VARCHAR     (8)                                                                 ,  /* 復活責任開始日 */
     hkgansknnkaisiymd                                  VARCHAR     (8)                                                                 ,  /* 復活がん責任開始日 */
     hknkknsmnkbn                                       VARCHAR     (1)                                                                 ,  /* 保険期間歳満期区分 */
     hknkkn                                             NUMBER      (2)                                                                 ,  /* 保険期間 */
     hrkkknsmnkbn                                       VARCHAR     (1)                                                                 ,  /* 払込期間歳満期区分 */
     hrkkkn                                             NUMBER      (2)                                                                 ,  /* 払込期間 */
     kyknen                                             NUMBER      (3)                                                                 ,  /* 契約者年齢 */
     hhknnen                                            NUMBER      (3)                                                                 ,  /* 被保険者年齢 */
     hhknseiymd                                         VARCHAR     (8)                                                                 ,  /* 被保険者生年月日 */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     haraimanymd                                        VARCHAR     (8)                                                                 ,  /* 払満日 */
     hknkknmanryouymd                                   VARCHAR     (8)                                                                 ,  /* 保険期間満了日 */
     katakbn                                            VARCHAR     (2)                                                                 ,  /* 型区分 */
     kyhgndkatakbn                                      VARCHAR     (1)                                                                 ,  /* 給付限度型区分 */
     syukyhkinkatakbn                                   VARCHAR     (1)                                                                 ,  /* 手術給付金型区分 */
     khnkyhkgbairitukbn                                 VARCHAR     (1)                                                                 ,  /* 基本給付金額倍率区分 */
     rokudaildkbn                                       VARCHAR     (1)                                                                 ,  /* ６大生活習慣病追加給付型区分 */
     pmnjtkkbn                                          VARCHAR     (1)                                                                 ,  /* 保険料免除特約区分 */
     kihons                                             NUMBER      (13)                                                                ,  /* 基本Ｓ */
     kihons$                                            VARCHAR     (10)                                                                ,  /* 基本Ｓ(通貨型) */
     hokenryou                                          NUMBER      (13)                                                                ,  /* 保険料 */
     hokenryou$                                         VARCHAR     (10)                                                                ,  /* 保険料(通貨型) */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     ryouritusdno                                       VARCHAR     (3)                                                                 ,  /* 料率世代番号 */
     yoteiriritu                                        NUMBER      (5,4)                                                               ,  /* 予定利率 */
     yoteirrthendohosyurrt                              NUMBER      (5,4)                                                               ,  /* 予定利率変動時保証利率 */
     ytirrthndmnskaisuu                                 NUMBER      (2)                                                                 ,  /* 予定利率変動見直回数 */
     kyksjkkktyouseiriritu                              NUMBER      (5,4)                                                               ,  /* 契約時市場価格調整用利率 */
     nksyukbn                                           VARCHAR     (1)                                                                 ,  /* 年金種類区分 */
     nenkinkkn                                          NUMBER      (2)                                                                 ,  /* 年金期間 */
     nkgnshosyouritu                                    NUMBER      (3)                                                                 ,  /* 年金原資最低保証率 */
     nkgnshosyougk                                      NUMBER      (13)                                                                ,  /* 年金原資最低保証額 */
     nkgnshosyougk$                                     VARCHAR     (10)                                                                ,  /* 年金原資最低保証額(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     gengakugoyenitijibrpstgk                           NUMBER      (13)                                                                ,  /* 減額後円換算一時払保険料相当額 */
     gengakugoyenitijibrpstgk$                          VARCHAR     (10)                                                                ,  /* 減額後円換算一時払保険料相当額(通貨型) */
     yendthnkymd                                        VARCHAR     (8)                                                                 ,  /* 円建変更日 */
     setteibairitu                                      NUMBER      (3,2)                                                               ,  /* 設定倍率 */
     kykjisisuurendourate                               NUMBER      (3)                                                                 ,  /* 契約時指数連動部分割合 */
     tmttknzoukaritujygn                                NUMBER      (5,4)                                                               ,  /* 積立金増加率上限 */
     tumitateriritu                                     NUMBER      (5,4)                                                               ,  /* 積立利率 */
     tmttknhaibunjyoutai                                VARCHAR     (1)                                                                 ,  /* 積立金配分状態 */
     sisuukbn                                           VARCHAR     (2)                                                                 ,  /* 指数区分 */
     gsbunrikzkakuninumu                                VARCHAR     (1)                                                                 ,  /* 源泉分離課税確認有無 */
     gsbunritaisyou                                     VARCHAR     (1)                                                                 ,  /* 源泉分離課税対象 */
     pharaikomisougaku                                  NUMBER      (13)                                                                ,  /* 保険料払込総額 */
     pharaikomisougaku$                                 VARCHAR     (10)                                                                ,  /* 保険料払込総額(通貨型) */
     tmttknitenymd                                      VARCHAR     (8)                                                                 ,  /* 積立金移転日 */
     loadinghnkgtumitateriritu                          NUMBER      (5,4)                                                               ,  /* ローディング変更後積立利率 */
     rendouritu                                         NUMBER      (5,4)                                                               ,  /* 連動率 */
     teikishrritu                                       NUMBER      (5,4)                                                               ,  /* 定期支払率 */
     dai1hknkkn                                         NUMBER      (2)                                                                    /* 第１保険期間 */
)
;

ALTER TABLE IT_BAK_KykSyouhn ADD CONSTRAINT PK_BAK_KykSyouhn PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                          , /* 取消識別キー */
     syutkkbn                                                 , /* 主契約特約区分 */
     syouhncd                                                 , /* 商品コード */
     syouhnsdno                                               , /* 商品世代番号 */
     kyksyouhnrenno                                             /* 契約商品連番 */
) ;
