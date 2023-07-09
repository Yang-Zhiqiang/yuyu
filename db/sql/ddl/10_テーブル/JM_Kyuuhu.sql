CREATE TABLE JM_Kyuuhu (
     kyuuhucd                                           VARCHAR     (4)                                                       NOT NULL  ,  /* 給付コード */
     seikyuusyubetu                                     VARCHAR     (2)                                                                 ,  /* 請求種別 */
     kyuuhuname                                         VARCHAR     (30)                                                                ,  /* 給付名 */
     kyuuhunamegamen                                    VARCHAR     (30)                                                                ,  /* 給付名（画面用） */
     kyuuhunamereport                                   VARCHAR     (30)                                                                ,  /* 給付名（帳票用） */
     hyoujijyun                                         NUMBER      (2)                                                                 ,  /* 表示順 */
     geninkbn                                           VARCHAR     (2)                                                                 ,  /* 原因区分 */
     saigaisippeinyuinumukbn                            VARCHAR     (1)                                                                 ,  /* 災害疾病入院有無区分 */
     kyuuhukbn                                          VARCHAR     (2)                                                                 ,  /* 給付区分 */
     hokenkinsyuruikbn                                  VARCHAR     (1)                                                                 ,  /* 保険金種類区分 */
     kanjyoukmkcd                                       VARCHAR     (5)                                                                 ,  /* 勘定科目コード */
     uktsyukbn                                          VARCHAR     (2)                                                                 ,  /* 受取人種類区分 */
     sateirankcd                                        VARCHAR     (4)                                                                 ,  /* 査定ランクコード */
     seikyuusyainfocheck                                VARCHAR     (1)                                                                 ,  /* 請求者情報チェック */
     sinkensyainfocheck                                 VARCHAR     (1)                                                                 ,  /* 親権者情報チェック */
     souhusakiinfocheck                                 VARCHAR     (1)                                                                 ,  /* 送付先情報チェック */
     soukinsakiinfocheck                                VARCHAR     (1)                                                                 ,  /* 送金先情報チェック */
     uketorihouhoucheck                                 VARCHAR     (1)                                                                 ,  /* 受取方法チェック */
     nkseikyuucheck                                     VARCHAR     (1)                                                                 ,  /* 年金請求チェック */
     hassoukbncheck                                     VARCHAR     (1)                                                                 ,  /* 発送区分チェック */
     honninkaknincheck                                  VARCHAR     (1)                                                                 ,  /* 本人確認チェック */
     saigaigtkanouseicheck                              VARCHAR     (1)                                                                 ,  /* 災害該当可能性チェック */
     saikeninfocheck                                    VARCHAR     (1)                                                                 ,  /* 債権者情報チェック */
     saisateicheck                                      VARCHAR     (1)                                                                 ,  /* 再査定チェック */
     kijyunymdcheck                                     VARCHAR     (1)                                                                 ,  /* 基準日チェック */
     geninkbncheck                                      VARCHAR     (1)                                                                 ,  /* 原因区分チェック */
     syuhiyoucheck                                      VARCHAR     (1)                                                                 ,  /* 守秘要チェック */
     syoumetucheck                                      VARCHAR     (1)                                                                 ,  /* 消滅チェック */
     doujisksyoricheck                                  VARCHAR     (1)                                                                 ,  /* 同時請求処理中チェック */
     khsyoricheck                                       VARCHAR     (1)                                                                 ,  /* 契約保全処理中チェック */
     sknnkaisiymdcheck                                  VARCHAR     (1)                                                                 ,  /* 責任開始日チェック */
     hknkkncheck                                        VARCHAR     (1)                                                                 ,  /* 保険期間チェック */
     phrkyuuyokkncheck                                  VARCHAR     (1)                                                                 ,  /* 保険料払込猶予期間チェック */
     fstphrkyuuyokkntyoukacheck                         VARCHAR     (1)                                                                 ,  /* 初回保険料払込猶予期間超過チェック */
     tokkoudosghtnpcheck                                VARCHAR     (1)                                                                 ,  /* 特定高度障害不担保チェック */
     hokenkinshrskgnkkncheck                            VARCHAR     (1)                                                                 ,  /* 保険金支払削減期間チェック */
     nkkiteicheck                                       VARCHAR     (1)                                                                 ,  /* 年金規定チェック */
     ttdktyuuicheck                                     VARCHAR     (1)                                                                 ,  /* 手続注意チェック */
     uktcheck                                           VARCHAR     (1)                                                                 ,  /* 受取人チェック */
     firstpminyuucheck                                  VARCHAR     (1)                                                                 ,  /* 初回保険料未入チェック */
     sinsatyuuicheck                                    VARCHAR     (1)                                                                 ,  /* 審査注意チェック */
     sateijisatumensekicheck                            VARCHAR     (1)                                                                 ,  /* 査定項目＿自殺免責チェック */
     sateisknnkaisiymdcheck                             VARCHAR     (1)                                                                 ,  /* 査定項目＿責任開始日チェック */
     sateigengkcheck                                    VARCHAR     (1)                                                                 ,  /* 査定項目＿減額チェック */
     sateimeigihnkcheck                                 VARCHAR     (1)                                                                 ,  /* 査定項目＿名義変更チェック */
     sateistknsetcheck                                  VARCHAR     (1)                                                                 ,  /* 査定項目＿質権設定チェック */
     sateisaikenkaiyakumcheck                           VARCHAR     (1)                                                                 ,  /* 査定項目＿債権者解約申出チェック */
     sateihasantosancheck                               VARCHAR     (1)                                                                 ,  /* 査定項目＿破産および倒産チェック */
     sateisasiosaecheck                                 VARCHAR     (1)                                                                 ,  /* 査定項目＿差押チェック */
     sateisousasyoukaicheck                             VARCHAR     (1)                                                                 ,  /* 査定項目＿捜査照会チェック */
     sateihusyousicheck                                 VARCHAR     (1)                                                                 ,  /* 査定項目＿不詳の死チェック */
     sateikaigaisbcheck                                 VARCHAR     (1)                                                                 ,  /* 査定項目＿海外死亡チェック */
     sateikaigaicheck                                   VARCHAR     (1)                                                                 ,  /* 査定項目＿海外チェック */
     sateimrinfocheck                                   VARCHAR     (1)                                                                 ,  /* 査定項目＿ＭＲ情報チェック */
     sateihigaitoucheck                                 VARCHAR     (1)                                                                 ,  /* 査定項目＿非該当チェック */
     sateihnsycheck                                     VARCHAR     (1)                                                                 ,  /* 査定項目＿反社チェック */
     sateiseikyuusyoruicheck                            VARCHAR     (1)                                                                 ,  /* 査定項目＿請求書類チェック */
     sateisaigaigtkanouseicheck                         VARCHAR     (1)                                                                 ,  /* 査定項目＿災害該当可能性チェック */
     sateisaisateicheck                                 VARCHAR     (1)                                                                 ,  /* 査定項目＿再査定チェック */
     calcsyoruiukeymdcheck                              VARCHAR     (1)                                                                 ,  /* 支払金額計算後＿書類受付日チェック */
     calchonninkakunincheck                             VARCHAR     (1)                                                                 ,  /* 支払金額計算後＿本人確認チェック */
     calcmnmeigibangoucheck                             VARCHAR     (1)                                                                 ,  /* 支払金額計算後＿ＭＮ名義番号チェック */
     calcsyksbyensitihsyucheck                          VARCHAR     (1)                                                                 ,  /* 支払金額計算後＿初期死亡時円換算最低保証適用チェック */
     hokenkngkhyoujikbn                                 NUMBER      (1)                                                                 ,  /* 保険金額表示区分 */
     hokenkngkhyoujimsg1                                VARCHAR     (10)                                                                ,  /* 保険金額表示メッセージ１ */
     hokenkngkhyoujimsg2                                VARCHAR     (10)                                                                ,  /* 保険金額表示メッセージ２ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                 ,  /* バージョン */
     mrfkouzatratkicheck                                VARCHAR     (1)                                                                 ,  /* ＭＲＦ口座取扱チェック */
     keiyakusyahnkcheck                                 VARCHAR     (1)                                                                 ,  /* 契約者変更チェック */
     dskaiyakusyoricheck                                VARCHAR     (1)                                                                 ,  /* ＤＳ解約処理中チェック */
     kykymdcheck                                        VARCHAR     (1)                                                                 ,  /* 契約日チェック */
     endthnkymdcheck                                    VARCHAR     (1)                                                                 ,  /* 円建変更日チェック */
     hrmbrcheck                                         VARCHAR     (1)                                                                 ,  /* 返戻金未払いチェック */
     haitoukincheck                                     VARCHAR     (1)                                                                 ,  /* 配当金チェック */
     tmttknjyoutaicheck                                 VARCHAR     (1)                                                                 ,  /* 積立金状態チェック */
     sateisgsbjisatumensekicheck                        VARCHAR     (1)                                                                 ,  /* 査定項目＿災害死亡自殺免責チェック */
     bkntyousafsyorikbn                                 VARCHAR     (2)                                                                    /* 備金調査ファイル処理区分 */
)
;

ALTER TABLE JM_Kyuuhu ADD CONSTRAINT PK_Kyuuhu PRIMARY KEY (
     kyuuhucd                                                   /* 給付コード */
) ;
