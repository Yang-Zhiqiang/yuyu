CREATE TABLE IW_KhHaitouTaisyouWK (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     haitoukinuketorihoukbn                             VARCHAR     (1)                                                       NOT NULL  ,  /* 配当金受取方法区分 */
     haitoumeisaikbn                                    VARCHAR     (2)                                                       NOT NULL  ,  /* 配当明細区分 */
     renno                                              NUMBER      (2)                                                       NOT NULL  ,  /* 連番 */
     haitoujyoutaihanteikbn                             VARCHAR     (2)                                                                 ,  /* 配当状態判定区分 */
     haitoushrkijyunymd                                 VARCHAR     (8)                                                                 ,  /* 配当支払基準日 */
     haitoukbn                                          VARCHAR     (2)                                                                 ,  /* 配当区分 */
     kihons                                             NUMBER      (13)                                                                ,  /* 基本Ｓ */
     kihons$                                            VARCHAR     (10)                                                                ,  /* 基本Ｓ(通貨型) */
     haitoukaisuu                                       NUMBER      (3)                                                                 ,  /* 配当回数 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     ryouritusdno                                       VARCHAR     (3)                                                                 ,  /* 料率世代番号 */
     yoteiriritu                                        NUMBER      (5,4)                                                               ,  /* 予定利率 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hhknsei                                            VARCHAR     (1)                                                                 ,  /* 被保険者性別 */
     hhknnen                                            NUMBER      (3)                                                                 ,  /* 被保険者年齢 */
     hknkknsmnkbn                                       VARCHAR     (1)                                                                 ,  /* 保険期間歳満期区分 */
     hknkkn                                             NUMBER      (2)                                                                 ,  /* 保険期間 */
     hrkkkn                                             NUMBER      (2)                                                                 ,  /* 払込期間 */
     dratenendo                                         VARCHAR     (4)                                                                 ,  /* Ｄレート年度 */
     keisandnendo                                       VARCHAR     (4)                                                                 ,  /* 計算Ｄ年度 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     kykjyoutai                                         VARCHAR     (2)                                                                 ,  /* 契約状態 */
     dai1hknkkn                                         NUMBER      (2)                                                                 ,  /* 第１保険期間 */
     hrkkknsmnkbn                                       VARCHAR     (1)                                                                    /* 払込期間歳満期区分 */
)
;

ALTER TABLE IW_KhHaitouTaisyouWK ADD CONSTRAINT PK_HaitouTaisyouWK PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     syoriYmd                                                 , /* 処理年月日 */
     haitoukinuketorihoukbn                                   , /* 配当金受取方法区分 */
     haitoumeisaikbn                                          , /* 配当明細区分 */
     renno                                                      /* 連番 */
) ;
