CREATE TABLE HW_MosMatiKknKeikaWk (
     nyksyoriymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 入金処理日 */
     itirenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 一連番号 */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     knjyymd                                            VARCHAR     (8)                                                                 ,  /* 勘定日 */
     mosno                                              VARCHAR     (20)                                                                ,  /* 申込番号 */
     hrkmirninnm                                        VARCHAR     (96)                                                                ,  /* 振込依頼人名 */
     trhkkgk                                            NUMBER      (13)                                                                ,  /* 取引金額 */
     trhkkgk$                                           VARCHAR     (10)                                                                ,  /* 取引金額(通貨型) */
     rstuukasyu                                         VARCHAR     (3)                                                                 ,  /* 領収通貨種類 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     nyuukinoyadrtennm                                  VARCHAR     (30)                                                                ,  /* 入金用親代理店名 */
     hrkmnykndatarenmotoKbn                             VARCHAR     (1)                                                                 ,  /* 振込入金データ連携元区分 */
     nyktyhyoutkbn                                      VARCHAR     (1)                                                                 ,  /* 入金帳票出力先区分 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HW_MosMatiKknKeikaWk ADD CONSTRAINT PK_MosMatiKknKeikaWk PRIMARY KEY (
     nyksyoriymd                                              , /* 入金処理日 */
     itirenno                                                   /* 一連番号 */
) ;
