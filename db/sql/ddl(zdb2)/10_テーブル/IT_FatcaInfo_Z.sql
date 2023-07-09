CREATE TABLE IT_FatcaInfo_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     syorisosikicd                                      VARCHAR     (7)                                                                 ,  /* 処理組織コード */
     fatcasnsikbn                                       VARCHAR     (1)                                                                 ,  /* ＦＡＴＣＡ宣誓区分 */
     bikkjnssinfokbn                                    VARCHAR     (1)                                                                 ,  /* 米国人示唆情報区分 */
     fatcakekkbn                                        VARCHAR     (1)                                                                 ,  /* ＦＡＴＣＡ結果区分 */
     fatcahankeiikbn                                    VARCHAR     (1)                                                                 ,  /* ＦＡＴＣＡ判明経緯区分 */
     bikknzsyno                                         VARCHAR     (9)                                                                 ,  /* 米国納税者番号 */
     syomeiymd                                          VARCHAR     (8)                                                                 ,  /* 署名日 */
     kokno                                              VARCHAR     (10)                                                                ,  /* 顧客番号 */
     fatcatgkbn                                         VARCHAR     (1)                                                                 ,  /* ＦＡＴＣＡ対象者区分 */
     seionnmkn                                          VARCHAR     (62)                                                                ,  /* 清音氏名（カナ） */
     nmkn                                               VARCHAR     (62)                                                                ,  /* 氏名（カナ） */
     nmkj                                               VARCHAR     (62)                                                                ,  /* 氏名（漢字） */
     seiymd                                             VARCHAR     (8)                                                                 ,  /* 生年月日 */
     seibetu                                            VARCHAR     (1)                                                                 ,  /* 性別 */
     kouryokuendymd                                     VARCHAR     (8)                                                                 ,  /* 効力終了日 */
     trkymd                                             VARCHAR     (8)                                                                 ,  /* 登録日 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_FatcaInfo_Z ADD CONSTRAINT PK_FatcaInfo PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     renno                                                      /* 連番 */
) ;

CREATE INDEX IX1_FatcaInfo ON IT_FatcaInfo_Z (
     syono                                                    , /* 証券番号 */
     renno                                                      /* 連番 */
) ;
