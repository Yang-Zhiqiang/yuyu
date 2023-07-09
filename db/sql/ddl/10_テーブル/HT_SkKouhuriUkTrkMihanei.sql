CREATE TABLE HT_SkKouhuriUkTrkMihanei (
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     syukkncd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 収納機関コード */
     kinyuucd8keta                                      VARCHAR     (8)                                                       NOT NULL  ,  /* 金融機関コード（８桁） */
     kinyuukkntratkiymd                                 VARCHAR     (8)                                                       NOT NULL  ,  /* 金融機関取扱年月日 */
     kinyuukkntratkitime                                VARCHAR     (6)                                                       NOT NULL  ,  /* 金融機関取扱時刻 */
     kinyuukkntratkino                                  VARCHAR     (15)                                                                ,  /* 金融機関取扱番号 */
     kouhuriukchannelkbn                                VARCHAR     (2)                                                                 ,  /* 口振受付チャネル区分 */
     kouhuriokyakusamano                                VARCHAR     (20)                                                      NOT NULL  ,  /* 口振お客様番号 */
     nykmosno                                           VARCHAR     (20)                                                                ,  /* 入金用申込番号 */
     syorizumiflg                                       VARCHAR     (1)                                                                 ,  /* 処理済フラグ */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd5keta                                       VARCHAR     (5)                                                                 ,  /* 支店コード（５桁） */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano8keta                                       VARCHAR     (8)                                                                 ,  /* 口座番号（８桁） */
     kzmeiginmkn                                        VARCHAR     (30)                                                                ,  /* 口座名義人氏名（カナ） */
     itakusyacd                                         VARCHAR     (10)                                                                ,  /* 委託者コード */
     syukkntratkiymd                                    VARCHAR     (8)                                                                 ,  /* 収納機関取扱年月日 */
     syukkntratkitime                                   VARCHAR     (6)                                                                 ,  /* 収納機関取扱時刻 */
     syukkntratkino                                     VARCHAR     (15)                                                                ,  /* 収納機関取扱番号 */
     kouhuristatuskbn                                   VARCHAR     (1)                                                                 ,  /* 口振ステータス区分 */
     kouhurikekkacd                                     VARCHAR     (2)                                                                 ,  /* 口振処理結果コード */
     kouhurihonninkakkekka                              VARCHAR     (1)                                                                 ,  /* 口振本人確認結果 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HT_SkKouhuriUkTrkMihanei ADD CONSTRAINT PK_SkKouhuriUkTrkMihanei PRIMARY KEY (
     syoriYmd                                                 , /* 処理年月日 */
     syukkncd                                                 , /* 収納機関コード */
     kinyuucd8keta                                            , /* 金融機関コード（８桁） */
     kinyuukkntratkiymd                                       , /* 金融機関取扱年月日 */
     kinyuukkntratkitime                                      , /* 金融機関取扱時刻 */
     kouhuriokyakusamano                                        /* 口振お客様番号 */
) ;

CREATE INDEX IX1_SkKouhuriUkTrkMihanei ON HT_SkKouhuriUkTrkMihanei (
     nykmosno                                                   /* 入金用申込番号 */
) ;
