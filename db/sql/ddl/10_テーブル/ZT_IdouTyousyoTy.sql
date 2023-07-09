CREATE TABLE ZT_IdouTyousyoTy (
     ztysubsystemid                                     VARCHAR     (50)                                                                ,  /* （中継用）サブシステムＩＤ */
     ztysequenceno                                      NUMBER      (8)                                                       NOT NULL  ,  /* （中継用）シーケンス番号 */
     ztysyono                                           VARCHAR     (11)                                                                ,  /* （中継用）証券番号 */
     ztyhknsyukigou                                     VARCHAR     (2)                                                                 ,  /* （中継用）保険種類記号 */
     ztykacd                                            VARCHAR     (3)                                                                 ,  /* （中継用）課コード */
     ztytantocd                                         VARCHAR     (1)                                                                 ,  /* （中継用）担当コード */
     ztysyorisosikicd                                   VARCHAR     (7)                                                                 ,  /* （中継用）処理組織コード */
     ztyshrtysysyuruicd                                 VARCHAR     (1)                                                                 ,  /* （中継用）支払調書種類コード */
     ztysyoritaisyoukbn                                 VARCHAR     (2)                                                                 ,  /* （中継用）処理対象区分 */
     ztybaitaiskshunoriyuukbn1                          VARCHAR     (2)                                                                 ,  /* （中継用）媒体作成不能理由区分１ */
     ztybaitaiskshunoriyuukbn2                          VARCHAR     (2)                                                                 ,  /* （中継用）媒体作成不能理由区分２ */
     ztybaitaiskshunoriyuukbn3                          VARCHAR     (2)                                                                 ,  /* （中継用）媒体作成不能理由区分３ */
     ztybaitaiskshunoriyuukbn4                          VARCHAR     (2)                                                                 ,  /* （中継用）媒体作成不能理由区分４ */
     ztybaitaiskshunoriyuukbn5                          VARCHAR     (2)                                                                 ,  /* （中継用）媒体作成不能理由区分５ */
     ztyshrtysyjyuusyocd                                VARCHAR     (7)                                                                 ,  /* （中継用）支払調書住所コード */
     ztyshrtysyjyuusyo                                  VARCHAR     (62)                                                                ,  /* （中継用）支払調書住所 */
     ztykyknmkj35                                       VARCHAR     (35)                                                                ,  /* （中継用）契約者名（漢字）（３５桁） */
     ztyyobiv3                                          VARCHAR     (3)                                                                 ,  /* （中継用）予備項目Ｖ３ */
     ztyyobiv25                                         VARCHAR     (25)                                                                ,  /* （中継用）予備項目Ｖ２５ */
     ztyoldkykadrcd                                     VARCHAR     (7)                                                                 ,  /* （中継用）旧契約者住所コード */
     ztykjoldkykadr                                     VARCHAR     (62)                                                                ,  /* （中継用）漢字旧契約者住所 */
     ztykjoldkyknm35                                    VARCHAR     (35)                                                                ,  /* （中継用）漢字旧契約者名（３５桁） */
     ztyyobiv3x2                                        VARCHAR     (3)                                                                 ,  /* （中継用）予備項目Ｖ３＿２ */
     ztyyobiv25x1                                       VARCHAR     (25)                                                                ,  /* （中継用）予備項目Ｖ２５＿１ */
     ztyhhknnmkj                                        VARCHAR     (15)                                                                ,  /* （中継用）被保険者名（漢字） */
     ztyyobiv3x3                                        VARCHAR     (3)                                                                 ,  /* （中継用）予備項目Ｖ３＿３ */
     ztyyobiv17                                         VARCHAR     (17)                                                                ,  /* （中継用）予備項目Ｖ１７ */
     ztykyksibouymd                                     VARCHAR     (8)                                                                 ,  /* （中継用）契約者死亡年月日 */
     ztykouryokuhasseiymd                               VARCHAR     (8)                                                                 ,  /* （中継用）効力発生日 */
     ztykyksiboumeihensyoriymd                          VARCHAR     (8)                                                                 ,  /* （中継用）契約者死亡名義変更処理年月日 */
     ztyyobiv8                                          VARCHAR     (8)                                                                 ,  /* （中継用）予備項目Ｖ８ */
     ztyyobiv8x2                                        VARCHAR     (8)                                                                 ,  /* （中継用）予備項目Ｖ８＿２ */
     ztyyobiv8x3                                        VARCHAR     (8)                                                                 ,  /* （中継用）予備項目Ｖ８＿３ */
     ztyyobiv8x4                                        VARCHAR     (8)                                                                 ,  /* （中継用）予備項目Ｖ８＿４ */
     ztykyksibouhyoukagk                                NUMBER      (11)                                                                ,  /* （中継用）契約者死亡評価額 */
     ztykihrkmp                                         NUMBER      (11)                                                                ,  /* （中継用）既払込保険料 */
     ztyoldkykkihrkmpyouhyj                             VARCHAR     (1)                                                                 ,  /* （中継用）旧契約者既払込保険料要表示 */
     ztyoldkykkihrkmp                                   NUMBER      (11)                                                                ,  /* （中継用）旧契約者既払込保険料 */
     ztyyobin11                                         NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿２ */
     ztyyobin11x3                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿３ */
     ztyyobin11x4                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿４ */
     ztysakuseiymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）作成日 */
     ztyhuho2kykdisp                                    VARCHAR     (1)                                                                 ,  /* （中継用）普保Ⅱ契約表示 */
     ztyshrtysyhknsyukbn                                VARCHAR     (15)                                                                ,  /* （中継用）支払調書保険種類区分 */
     ztyyobiv9                                          VARCHAR     (9)                                                                 ,  /* （中継用）予備項目Ｖ９ */
     ztytekiyouranhensyuukbn1                           VARCHAR     (2)                                                                 ,  /* （中継用）摘要欄編集区分１ */
     ztytekiyouranhensyuukbn2                           VARCHAR     (2)                                                                 ,  /* （中継用）摘要欄編集区分２ */
     ztytekiyouranhensyuukbn3                           VARCHAR     (2)                                                                 ,  /* （中継用）摘要欄編集区分３ */
     ztytekiyouranhensyuukbn4                           VARCHAR     (2)                                                                 ,  /* （中継用）摘要欄編集区分４ */
     ztytekiyouranhensyuukbn5                           VARCHAR     (2)                                                                 ,  /* （中継用）摘要欄編集区分５ */
     ztyyobiv116                                        VARCHAR     (116)                                                               ,  /* （中継用）予備項目Ｖ１１６ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_IdouTyousyoTy ADD CONSTRAINT PK_IdouTyousyoTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;
