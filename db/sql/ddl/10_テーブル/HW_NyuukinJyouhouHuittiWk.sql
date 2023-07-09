CREATE TABLE HW_NyuukinJyouhouHuittiWk (
     nyksyoriymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 入金処理日 */
     itirenno                                           VARCHAR     (20)                                                      NOT NULL  ,  /* 一連番号 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     hrkmirnincd                                        VARCHAR     (10)                                                                ,  /* 振込依頼人コード */
     hrkmirninnm                                        VARCHAR     (96)                                                                ,  /* 振込依頼人名 */
     hrkmirninnm140                                     VARCHAR     (140)                                                               ,  /* 振込依頼人名（１４０桁） */
     trhkkgk                                            NUMBER      (13)                                                                ,  /* 取引金額 */
     trhkkgk$                                           VARCHAR     (10)                                                                ,  /* 取引金額(通貨型) */
     rstuukasyu                                         VARCHAR     (3)                                                                 ,  /* 領収通貨種類 */
     banknmkn                                           VARCHAR     (25)                                                                ,  /* 銀行名（カナ） */
     sitennmkn                                          VARCHAR     (25)                                                                ,  /* 支店名（カナ） */
     simukebanknm                                       VARCHAR     (70)                                                                ,  /* 仕向銀行名 */
     simuketennm                                        VARCHAR     (35)                                                                ,  /* 仕向店名 */
     seikeijizenkizennouumu                             VARCHAR     (1)                                                                 ,  /* 成契時全期前納有無 */
     nyuukinhuittiriyuukbn                              VARCHAR     (2)                                                                 ,  /* 入金不一致理由区分 */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     knjyymd                                            VARCHAR     (8)                                                                 ,  /* 勘定日 */
     nykmosno                                           VARCHAR     (20)                                                                ,  /* 入金用申込番号 */
     syoriYmd                                           VARCHAR     (8)                                                                 ,  /* 処理年月日 */
     hrkmnykndatarenmotoKbn                             VARCHAR     (1)                                                                 ,  /* 振込入金データ連携元区分 */
     oyadrtensyoritarget                                VARCHAR     (1)                                                                 ,  /* 親代理店処理対象 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE HW_NyuukinJyouhouHuittiWk ADD CONSTRAINT PK_NyuukinJyouhouHuittiWk PRIMARY KEY (
     nyksyoriymd                                              , /* 入金処理日 */
     itirenno                                                   /* 一連番号 */
) ;
