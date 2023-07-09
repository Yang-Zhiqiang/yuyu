CREATE TABLE JT_SiSentakuInfoTouroku_Z (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     renno                                              DECIMAL     (2)                                                       NOT NULL  ,  /* 連番 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     huho2kykno                                         VARCHAR     (20)                                                                ,  /* 普保Ⅱ契約番号 */
     huho2kyknokbn                                      VARCHAR     (1)                                                                 ,  /* 普保Ⅱ契約番号区分 */
     syouhncd                                           VARCHAR     (4)                                                                 ,  /* 商品コード */
     sntkinfokankeisyakbn                               VARCHAR     (2)                                                                 ,  /* 選択情報関係者区分 */
     taisyounmkn                                        VARCHAR     (38)                                                                ,  /* 対象者氏名（カナ） */
     taisyounmkj                                        VARCHAR     (32)                                                                ,  /* 対象者氏名（漢字） */
     taisyouseiymd                                      VARCHAR     (8)                                                                 ,  /* 対象者生年月日 */
     taisyouseibetu                                     VARCHAR     (1)                                                                 ,  /* 対象者性別 */
     dakuhiketnaiyouumukbn                              VARCHAR     (1)                                                                 ,  /* 諾否決定内容有無区分 */
     kktnaiyouumukbn                                    VARCHAR     (1)                                                                 ,  /* 告知内容有無区分 */
     kijinaiyouumukbn                                   VARCHAR     (1)                                                                 ,  /* 記事内容有無区分 */
     mrumukbn                                           VARCHAR     (1)                                                                 ,  /* ＭＲ有無区分 */
     koudosyougaiumukbn                                 VARCHAR     (1)                                                                 ,  /* 高度障害有無区分 */
     torikaijoumukbn                                    VARCHAR     (1)                                                                 ,  /* 取消解除有無区分 */
     kdsssiharaijyoutaikbn                              VARCHAR     (1)                                                                 ,  /* 高度障害Ｓ支払状態区分 */
     kdsssiharaiymd                                     VARCHAR     (8)                                                                 ,  /* 高度障害Ｓ支払年月日 */
     kdsymd                                             VARCHAR     (8)                                                                 ,  /* 高度障害年月日 */
     kdssiharaisosikicd                                 VARCHAR     (7)                                                                 ,  /* 高度障害支払組織コード */
     syorizumiflg                                       VARCHAR     (1)                                                                 ,  /* 処理済フラグ */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE JT_SiSentakuInfoTouroku_Z ADD CONSTRAINT PK_SiSentakuInfoTouroku PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     renno                                                      /* 連番 */
) ;
