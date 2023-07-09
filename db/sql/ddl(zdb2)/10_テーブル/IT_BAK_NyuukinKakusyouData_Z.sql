CREATE TABLE IT_BAK_NyuukinKakusyouData_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     nyuukinkakusyouno                                  VARCHAR     (20)                                                      NOT NULL  ,  /* 入金確証番号 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     trkssikibetukey                                    VARCHAR     (18)                                                      NOT NULL  ,  /* 取消識別キー */
     nyksyoriymd                                        VARCHAR     (8)                                                                 ,  /* 入金処理日 */
     nyuukinkakusyounrkymd                              VARCHAR     (8)                                                                 ,  /* 入金確証入力年月日 */
     nykkeiro                                           VARCHAR     (2)                                                                 ,  /* 入金経路 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     nyknaiyoukbn                                       VARCHAR     (2)                                                                 ,  /* 入金内容区分 */
     iktnyuukinnumu                                     VARCHAR     (1)                                                                 ,  /* 一括入金有無 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuuy                                      DECIMAL     (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      DECIMAL     (2)                                                                 ,  /* 充当回数（月） */
     rsgaku                                             DECIMAL     (13)                                                                ,  /* 領収金額 */
     rsgaku$                                            VARCHAR     (10)                                                                ,  /* 領収金額(通貨型) */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     denrenno                                           VARCHAR     (20)                                                                ,  /* 伝票データ連番 */
     edano                                              DECIMAL     (2)                                                                 ,  /* 枝番号 */
     suitoubumoncd                                      VARCHAR     (3)                                                                 ,  /* 出納部門コード */
     henkousikibetukey                                  VARCHAR     (18)                                                                ,  /* 変更識別キー */
     nykhouhoukbn                                       VARCHAR     (1)                                                                 ,  /* 入金方法区分 */
     tikiktbrisyuruikbn                                 VARCHAR     (2)                                                                 ,  /* 定期一括払種類区分 */
     nykdenymd                                          VARCHAR     (8)                                                                 ,  /* 入金伝票日付 */
     tabakarikanjyono                                   VARCHAR     (2)                                                                 ,  /* 束仮勘定番号 */
     nyuukinkakusyounrkno                               VARCHAR     (8)                                                                 ,  /* 入金確証入力番号 */
     nyuuryokukbn                                       VARCHAR     (1)                                                                 ,  /* 入力区分 */
     suitono                                            VARCHAR     (2)                                                                 ,  /* 出納番号 */
     hrkmyousinkkbn                                     VARCHAR     (1)                                                                 ,  /* 振込用紙入金区分 */
     suitososhikicd                                     VARCHAR     (7)                                                                 ,  /* 出納組織コード */
     kzhurikaebankcd                                    VARCHAR     (4)                                                                 ,  /* 口座振替銀行コード */
     kzhurikaesitencd                                   VARCHAR     (3)                                                                 ,  /* 口座振替支店コード */
     uketuketencd                                       VARCHAR     (7)                                                                 ,  /* 受付店コード */
     cvscd                                              VARCHAR     (6)                                                                 ,  /* ＣＶＳコード */
     ryousyuuhm                                         VARCHAR     (4)                                                                 ,  /* 領収時分 */
     hurikomiyousiokyksmno                              VARCHAR     (12)                                                                ,  /* 振込用紙お客さま番号 */
     hurikomiyousikakuninno                             VARCHAR     (5)                                                                 ,  /* 振込用紙確認番号 */
     kinyuukikankbn                                     VARCHAR     (1)                                                                 ,  /* 金融機関区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     creditkessaiyouno                                  VARCHAR     (26)                                                                ,  /* クレジットカード決済用番号 */
     syuudaikocd                                        VARCHAR     (2)                                                                 ,  /* 収納代行社コード */
     credituriageseikyuukbn                             VARCHAR     (1)                                                                    /* クレジットカード売上請求区分 */
)
;

ALTER TABLE IT_BAK_NyuukinKakusyouData_Z ADD CONSTRAINT PK_BAK_NyuukinKakusyouData PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     nyuukinkakusyouno                                        , /* 入金確証番号 */
     syono                                                    , /* 証券番号 */
     trkssikibetukey                                            /* 取消識別キー */
) ;
