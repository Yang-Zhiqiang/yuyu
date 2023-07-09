CREATE TABLE IT_DairitenMinyuKykMeisai (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syoriYmd                                           VARCHAR     (8)                                                       NOT NULL  ,  /* 処理年月日 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     drtenrenno                                         NUMBER      (2)                                                       NOT NULL  ,  /* 代理店連番 */
     drtencd                                            VARCHAR     (7)                                                                 ,  /* 代理店コード */
     bosyuucd                                           VARCHAR     (6)                                                                 ,  /* 募集人コード */
     pjytym                                             VARCHAR     (6)                                                                 ,  /* 保険料充当年月 */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     cifcd                                              VARCHAR     (15)                                                                ,  /* ＣＩＦコード */
     kanjidairitennm                                    VARCHAR     (30)                                                                ,  /* 漢字代理店名 */
     minyujytymd                                        VARCHAR     (8)                                                                 ,  /* 未入充当年月日 */
     hassinka                                           VARCHAR     (31)                                                                ,  /* 発信課 */
     bosyuuym                                           VARCHAR     (6)                                                                 ,  /* 募集年月 */
     kanjibosyuuninnm                                   VARCHAR     (15)                                                                ,  /* 漢字募集人名 */
     kydatkikbn                                         VARCHAR     (1)                                                                 ,  /* 共同扱区分 */
     kyknmkj                                            VARCHAR     (15)                                                                ,  /* 契約者名（漢字） */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hrkkeiro                                           VARCHAR     (2)                                                                 ,  /* 払込経路 */
     hrkp                                               NUMBER      (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     hurihunokbn                                        VARCHAR     (1)                                                                 ,  /* 振替不能理由区分 */
     bosyuuningyouhaiymd                                VARCHAR     (8)                                                                 ,  /* 募集人業廃年月日 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     dntcd                                              VARCHAR     (8)                                                                 ,  /* 団体コード */
     kjdntnm                                            VARCHAR     (35)                                                                ,  /* 漢字団体名 */
     hknsyuruinm                                        VARCHAR     (40)                                                                ,  /* 保険種類名 */
     drtenkanrisosikicd                                 VARCHAR     (7)                                                                 ,  /* 代理店管理組織コード */
     hjnkykhyj                                          VARCHAR     (1)                                                                 ,  /* 法人契約表示 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE IT_DairitenMinyuKykMeisai ADD CONSTRAINT PK_DairitenMinyuKykMeisai PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syoriYmd                                                 , /* 処理年月日 */
     syono                                                    , /* 証券番号 */
     drtenrenno                                                 /* 代理店連番 */
) ;
