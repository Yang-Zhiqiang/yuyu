CREATE TABLE BM_KinyuuKikanHuhoyofuriInfo_Z (
     bankcd                                             VARCHAR     (4)                                                       NOT NULL  ,  /* 銀行コード */
     yofurikyouteikaisiymd                              VARCHAR     (8)                                                                 ,  /* 預振協定開始年月日 */
     yofurikyouteikaijyoymd                             VARCHAR     (8)                                                                 ,  /* 預振協定解除年月日 */
     itakusyakinyuucd                                   VARCHAR     (4)                                                                 ,  /* 委託者金融機関コード */
     itakusyasitencd                                    VARCHAR     (3)                                                                 ,  /* 委託者支店コード */
     itakusyayokinkbn                                   VARCHAR     (1)                                                                 ,  /* 委託者預金種目区分 */
     itakusyakouzano                                    VARCHAR     (7)                                                                 ,  /* 委託者口座番号 */
     tsrkeisanhoukbn                                    VARCHAR     (1)                                                                 ,  /* 手数料計算方法区分 */
     kinyuutesuuryou                                    DECIMAL     (5)                                                                 ,  /* 金融機関手数料 */
     itakusyacd                                         VARCHAR     (10)                                                                ,  /* 委託者コード */
     tapekoukankbn1                                     VARCHAR     (1)                                                                 ,  /* テープ交換区分１ */
     mdsisyacd                                          VARCHAR     (7)                                                                 ,  /* 窓口支社コード */
     zzkkyouteikaisiymd                                 VARCHAR     (8)                                                                 ,  /* 全税共協定開始年月日 */
     zzkkyouteikaijyoymd                                VARCHAR     (8)                                                                 ,  /* 全税共協定解除年月日 */
     csskyouteikaisiymd                                 VARCHAR     (8)                                                                 ,  /* ＣＳＳ協定開始年月日 */
     csskyouteikaijyoymd                                VARCHAR     (8)                                                                 ,  /* ＣＳＳ協定解除年月日 */
     huhoyofuriinfokousinymd                            VARCHAR     (8)                                                                 ,  /* 普保預振情報更新年月日 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_KinyuuKikanHuhoyofuriInfo_Z ADD CONSTRAINT PK_KinyuuKikanHuhoyofuriInfo PRIMARY KEY (
     bankcd                                                     /* 銀行コード */
) ;
