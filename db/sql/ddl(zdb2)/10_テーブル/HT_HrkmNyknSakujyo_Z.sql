CREATE TABLE HT_HrkmNyknSakujyo_Z (
     hrkmdeldataskbtkey                                 VARCHAR     (20)                                                      NOT NULL  ,  /* 振込入金削除データ識別キー */
     trkymd                                             VARCHAR     (8)                                                                 ,  /* 登録日 */
     nyksyoriymd                                        VARCHAR     (8)                                                                 ,  /* 入金処理日 */
     itirenno                                           VARCHAR     (20)                                                                ,  /* 一連番号 */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     nykmosno                                           VARCHAR     (20)                                                                ,  /* 入金用申込番号 */
     hrkmirninnm                                        VARCHAR     (194)                                                               ,  /* 振込依頼人名 */
     trhkkgk                                            DECIMAL     (13)                                                                ,  /* 取引金額 */
     trhkkgk$                                           VARCHAR     (10)                                                                ,  /* 取引金額(通貨型) */
     rstuukasyu                                         VARCHAR     (3)                                                                 ,  /* 領収通貨種類 */
     knjyymd                                            VARCHAR     (8)                                                                 ,  /* 勘定日 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     hrkmirnincd                                        VARCHAR     (10)                                                                ,  /* 振込依頼人コード */
     syorizumiflg                                       VARCHAR     (1)                                                                 ,  /* 処理済フラグ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     hrkmnykndatarenmotoKbn                             VARCHAR     (1)                                                                    /* 振込入金データ連携元区分 */
)
;

ALTER TABLE HT_HrkmNyknSakujyo_Z ADD CONSTRAINT PK_HrkmNyknSakujyo PRIMARY KEY (
     hrkmdeldataskbtkey                                         /* 振込入金削除データ識別キー */
) ;

CREATE INDEX IX1_HrkmNyknSakujyo ON HT_HrkmNyknSakujyo_Z (
     syorizumiflg                                               /* 処理済フラグ */
) ;
