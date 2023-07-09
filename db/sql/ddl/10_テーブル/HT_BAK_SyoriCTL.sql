CREATE TABLE HT_BAK_SyoriCTL (
     mosno                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 申込番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     syono                                              VARCHAR     (20)                                                                ,  /* 証券番号 */
     kaisyacd                                           VARCHAR     (5)                                                                 ,  /* 会社コード */
     mosuketukekbn                                      VARCHAR     (1)                                                                 ,  /* 申込受付区分 */
     mosuktkerrkbn                                      VARCHAR     (1)                                                                 ,  /* 申込受付エラー区分 */
     skeijimukbn                                        VARCHAR     (2)                                                                 ,  /* 新契約事務区分 */
     mosnrkumu                                          VARCHAR     (1)                                                                 ,  /* 申込書入力有無 */
     mosnrkvrfjkkbn                                     VARCHAR     (1)                                                                 ,  /* 申込書入力ベリファイ状況区分 */
     mosnrkymd                                          VARCHAR     (8)                                                                 ,  /* 申込書入力日 */
     kznrkumu                                           VARCHAR     (1)                                                                 ,  /* 口座情報入力有無 */
     kznrkhbumu                                         VARCHAR     (1)                                                                 ,  /* 口座情報入力不備有無 */
     kznrkvrfjkkbn                                      VARCHAR     (1)                                                                 ,  /* 口座情報入力ベリファイ状況区分 */
     dntnrkumu                                          VARCHAR     (1)                                                                 ,  /* 団体承認書入力有無 */
     sdnnrkumu                                          VARCHAR     (1)                                                                 ,  /* 集団扱加入申込書入力有無 */
     kktnrkumu                                          VARCHAR     (1)                                                                 ,  /* 告知書入力有無 */
     kktnrkhbumu                                        VARCHAR     (1)                                                                 ,  /* 告知書入力不備有無 */
     kktnrkvrfjkkbn                                     VARCHAR     (1)                                                                 ,  /* 告知書入力ベリファイ状況区分 */
     kktymd                                             VARCHAR     (8)                                                                 ,  /* 告知日 */
     hjynrkumu                                          VARCHAR     (1)                                                                 ,  /* 報状入力有無 */
     hjynrkhbumu                                        VARCHAR     (1)                                                                 ,  /* 報状入力不備有無 */
     nyknnrkumu                                         VARCHAR     (1)                                                                 ,  /* 入金入力有無 */
     nyuukinjoutaikbn                                   VARCHAR     (1)                                                                 ,  /* 入金状態区分 */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     nyknkwsratekijyunymd                               VARCHAR     (8)                                                                 ,  /* 入金用為替レート基準日 */
     nyknkwsrate                                        NUMBER      (7,4)                                                               ,  /* 入金用為替レート */
     authorikakymd                                      VARCHAR     (8)                                                                 ,  /* オーソリ確認日 */
     uriagesousinkbn                                    VARCHAR     (1)                                                                 ,  /* 売上送信区分 */
     credittrkjkkbn                                     VARCHAR     (1)                                                                 ,  /* クレジットカード登録状況区分 */
     credityuukoukakkbn                                 VARCHAR     (1)                                                                 ,  /* クレジットカード有効確認区分 */
     mostenken1jiyhkbn                                  VARCHAR     (1)                                                                 ,  /* 申込点検（１次）要否区分 */
     mostenken2jiyhkbn                                  VARCHAR     (1)                                                                 ,  /* 申込点検（２次）要否区分 */
     mostenken3jiyhkbn                                  VARCHAR     (1)                                                                 ,  /* 申込点検（３次）要否区分 */
     mostenkenrrkumu                                    VARCHAR     (1)                                                                 ,  /* 申込点検履歴有無 */
     mostenkenjoukbn                                    VARCHAR     (1)                                                                 ,  /* 申込点検状態区分 */
     knkysatei1jiyhkbn                                  VARCHAR     (1)                                                                 ,  /* 環境査定（１次）要否区分 */
     knkysatei2jiyhkbn                                  VARCHAR     (1)                                                                 ,  /* 環境査定（２次）要否区分 */
     knkysateirrkumu                                    VARCHAR     (1)                                                                 ,  /* 環境査定履歴有無 */
     knkysateijyoukbn                                   VARCHAR     (1)                                                                 ,  /* 環境査定状態区分 */
     imusateikaniyhkbn                                  VARCHAR     (1)                                                                 ,  /* 医務査定（簡易）要否区分 */
     imusateirrkumu                                     VARCHAR     (1)                                                                 ,  /* 医務査定履歴有無 */
     imusateijyoukbn                                    VARCHAR     (1)                                                                 ,  /* 医務査定状態区分 */
     mihassinhubiumu                                    VARCHAR     (1)                                                                 ,  /* 未発信不備有無 */
     hubikaisyoujoutaikbn                               VARCHAR     (1)                                                                 ,  /* 不備解消状態区分 */
     kthhbkbn                                           VARCHAR     (1)                                                                 ,  /* 決定保留不備区分 */
     srhhbkbn                                           VARCHAR     (1)                                                                 ,  /* 成立保留不備区分 */
     khnhbkbn                                           VARCHAR     (1)                                                                 ,  /* 基本不備区分 */
     kykkakjkkbn                                        VARCHAR     (2)                                                                 ,  /* 契約確認状況区分 */
     ketteikbn                                          VARCHAR     (2)                                                                 ,  /* 決定状態区分 */
     sateijtkbn                                         VARCHAR     (2)                                                                 ,  /* 査定状態区分 */
     sateizumiymd                                       VARCHAR     (8)                                                                 ,  /* 査定済日 */
     doujimosumu                                        VARCHAR     (1)                                                                 ,  /* 同時申込有無 */
     paldoujimosumu                                     VARCHAR     (1)                                                                 ,  /* ＰＡＬ同時申込有無 */
     raydoujimosumu                                     VARCHAR     (1)                                                                 ,  /* ＲＡＹ同時申込有無 */
     lincgthtkekkbn                                     VARCHAR     (1)                                                                 ,  /* ＬＩＮＣ該当判定結果区分 */
     lincjkkbn                                          VARCHAR     (2)                                                                 ,  /* ＬＩＮＣ状況区分 */
     lincsousinflg                                      VARCHAR     (1)                                                                 ,  /* ＬＩＮＣ送信済フラグ */
     linckknnjkkbn                                      VARCHAR     (1)                                                                 ,  /* ＬＩＮＣ確認状況区分 */
     lincdatasousinkbn                                  VARCHAR     (1)                                                                 ,  /* ＬＩＮＣデータ送信区分 */
     uktkakkbn                                          VARCHAR     (1)                                                                 ,  /* 受取人確認区分 */
     tkhjnkbn                                           VARCHAR     (1)                                                                 ,  /* 特定関係法人区分 */
     tktkhjnkakuninyouhikbn                             VARCHAR     (1)                                                                 ,  /* 特定関係法人確認要否区分 */
     kouseiinkykkbn                                     VARCHAR     (1)                                                                 ,  /* 構成員契約区分 */
     koukankykkbn                                       VARCHAR     (1)                                                                 ,  /* 交換契約区分 */
     fatcakakkekkakbn                                   VARCHAR     (1)                                                                 ,  /* ＦＡＴＣＡ確認結果区分 */
     aeoikekkakbn                                       VARCHAR     (1)                                                                 ,  /* ＡＥＯＩ結果区分 */
     tkhsyouryakuumukbn                                 VARCHAR     (1)                                                                 ,  /* 通計保留省略有無区分 */
     kykksktkankbn                                      VARCHAR     (1)                                                                 ,  /* 契約者強制決定判定完了区分 */
     hhknksktkankbn                                     VARCHAR     (1)                                                                 ,  /* 被保険者強制決定判定完了区分 */
     seiritukbn                                         VARCHAR     (2)                                                                 ,  /* 成立区分 */
     srsyoriymd                                         VARCHAR     (8)                                                                 ,  /* 成立処理日 */
     minyknkurikosiumu                                  VARCHAR     (1)                                                                 ,  /* 未入金繰越有無 */
     kettienkurikosiumu                                 VARCHAR     (1)                                                                 ,  /* 決定遅延繰越有無 */
     srhkurikosiumu                                     VARCHAR     (1)                                                                 ,  /* 成立保留繰越有無 */
     daimosno                                           VARCHAR     (20)                                                                ,  /* 代表申込番号 */
     mfrenflg                                           VARCHAR     (1)                                                                 ,  /* ＭＦ連動済フラグ */
     mfrenymd                                           VARCHAR     (8)                                                                 ,  /* ＭＦ連動日 */
     jimusrhkbn                                         VARCHAR     (2)                                                                 ,  /* 事務成立保留区分 */
     syssrhkbn                                          VARCHAR     (2)                                                                 ,  /* システム成立保留区分 */
     annaisakuseikbn                                    VARCHAR     (1)                                                                 ,  /* 送付案内作成状況区分 */
     annaikaisuu                                        NUMBER      (2)                                                                 ,  /* 案内回数 */
     tkbtkktumu                                         VARCHAR     (1)                                                                 ,  /* 特別告知有無 */
     kansyoutuutiyhkbn                                  VARCHAR     (1)                                                                 ,  /* 勧奨通知作成要否区分 */
     lastkossyoricd                                     VARCHAR     (5)                                                                 ,  /* 最終更新処理コード */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     yoteirirituhenkourenrakuymd                        VARCHAR     (8)                                                                    /* 予定利率変更連絡日 */
)
;

ALTER TABLE HT_BAK_SyoriCTL ADD CONSTRAINT PK_BAK_SyoriCTL PRIMARY KEY (
     mosno                                                    , /* 申込番号 */
     trkssikibetukey                                            /* 取消識別キー */
) ;

CREATE INDEX IX1_BAK_SyoriCTL ON HT_BAK_SyoriCTL (
     srsyoriymd                                               , /* 成立処理日 */
     mosno                                                      /* 申込番号 */
) ;

CREATE INDEX IX2_BAK_SyoriCTL ON HT_BAK_SyoriCTL (
     syono                                                      /* 証券番号 */
) ;
