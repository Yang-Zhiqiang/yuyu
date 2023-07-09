CREATE TABLE HW_MosMatiKknKeikaWk_Z (
     nyksyoriymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 入金処理日 */
     itirenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 一連番号 */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     knjyymd                                            VARCHAR     (8)                                                                 ,  /* 勘定日 */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     hrkmirninnm                                        VARCHAR     (194)                                                               ,  /* 振込依頼人名 */
     trhkkgk                                            DECIMAL     (13)                                                                ,  /* 取引金額 */
     trhkkgk$                                           VARCHAR     (10)                                                                ,  /* 取引金額(通貨型) */
     rstuukasyu                                         VARCHAR     (3)                                                                 ,  /* 領収通貨種類 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     nyuukinoyadrtennm                                  VARCHAR     (62)                                                                ,  /* 入金用親代理店名 */
     hrkmnykndatarenmotoKbn                             VARCHAR     (1)                                                                    /* 振込入金データ連携元区分 */
)
;

ALTER TABLE HW_MosMatiKknKeikaWk_Z ADD CONSTRAINT PK_MosMatiKknKeikaWk PRIMARY KEY (
     nyksyoriymd                                              , /* 入金処理日 */
     itirenno                                                   /* 一連番号 */
) ;
