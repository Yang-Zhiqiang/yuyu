CREATE TABLE HT_NayoseKekka_Z (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     sntkinfotaisyousyakbn                              VARCHAR     (1)                                                       NOT NULL  ,  /* 選択情報対象者区分 */
     edano                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 枝番号 */
     sakuinnmno                                         VARCHAR     (10)                                                                ,  /* 索引名番号 */
     nysjissikekkakbn                                   VARCHAR     (1)                                                                 ,  /* 名寄せ実施結果区分 */
     nysjyoutaikbn                                      VARCHAR     (1)                                                                 ,  /* 名寄せ状態区分 */
     sakuininfosyoukaierrkbn                            VARCHAR     (1)                                                                 ,  /* 索引情報照会エラー区分 */
     mrsyoukaierrkbn                                    VARCHAR     (1)                                                                 ,  /* ＭＲ照会エラー区分 */
     signalsyoukaierrkbn                                VARCHAR     (1)                                                                 ,  /* シグナル照会エラー区分 */
     sinsntkhnsysyoukaierrkbn                           VARCHAR     (1)                                                                 ,  /* 新選択情報反社照会エラー区分 */
     tsngksyoukaierrkbn                                 VARCHAR     (1)                                                                 ,  /* 通算金額照会エラー区分 */
     kykdrtentsnssyoukaierrkbn                          VARCHAR     (1)                                                                 ,  /* 契約者同一代理店通算Ｓ照会エラー区分 */
     mossakuseikahisyoukaierrkbn                        VARCHAR     (1)                                                                 ,  /* 申込書作成可否照会エラー区分 */
     hndketyhsyoukaierrkbn                              VARCHAR     (1)                                                                 ,  /* ハンド決定要否照会エラー区分 */
     sntkinfomrumukbn                                   VARCHAR     (1)                                                                 ,  /* 選択情報ＭＲ有無区分 */
     sntkinfohnsyumukbn                                 VARCHAR     (1)                                                                 ,  /* 選択情報反社有無区分 */
     signalsetteiumukbn                                 VARCHAR     (1)                                                                 ,  /* シグナル設定有無区分 */
     signalinfohnsyumukbn                               VARCHAR     (1)                                                                 ,  /* シグナル情報反社有無区分 */
     sinsntkhnsyumukbn                                  VARCHAR     (1)                                                                 ,  /* 新選択情報反社有無区分 */
     itekisntkhndktyhkbn                                VARCHAR     (1)                                                                 ,  /* 医的選択情報ハンド決定要否区分 */
     ttdktyuuiknkhndktyhkbn                             VARCHAR     (1)                                                                 ,  /* 手続注意環境ハンド決定要否区分 */
     kyhkinuktkariitkhndktyhkbn                         VARCHAR     (1)                                                                 ,  /* 給付金受付有医的ハンド決定要否区分 */
     doujimositekihndktyhkbn                            VARCHAR     (1)                                                                 ,  /* 同時申込医的ハンド決定要否区分 */
     doujimosknkhndktyhkbn                              VARCHAR     (1)                                                                 ,  /* 同時申込環境ハンド決定要否区分 */
     sirajikykkbn                                       VARCHAR     (1)                                                                 ,  /* 白地契約区分 */
     kikykinfoseiymd                                    VARCHAR     (8)                                                                 ,  /* 既契約情報生年月日 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     gaikokupepsumukbn                                  VARCHAR     (1)                                                                    /* 外国ＰＥＰｓ有無区分 */
)
;

ALTER TABLE HT_NayoseKekka_Z ADD CONSTRAINT PK_NayoseKekka PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     sntkinfotaisyousyakbn                                    , /* 選択情報対象者区分 */
     edano                                                      /* 枝番号 */
) ;

CREATE INDEX IX1_NayoseKekka ON HT_NayoseKekka_Z (
     sakuinnmno                                                 /* 索引名番号 */
) ;
