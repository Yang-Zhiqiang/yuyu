CREATE TABLE ZT_SiharaiTyousyoTy (
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
     ztyuktnmkj35                                       VARCHAR     (35)                                                                ,  /* （中継用）受取人名（漢字）（３５桁） */
     ztydaihyouktkbn                                    VARCHAR     (1)                                                                 ,  /* （中継用）代表受取人区分 */
     ztykjdaihyouuktnm                                  VARCHAR     (15)                                                                ,  /* （中継用）漢字代表受取人名 */
     ztyuktmnmeigibangou                                VARCHAR     (3)                                                                 ,  /* （中継用）受取人ＭＮ名義番号 */
     ztyyobiv24                                         VARCHAR     (24)                                                                ,  /* （中継用）予備項目Ｖ２４ */
     ztymfjyuusyocd                                     VARCHAR     (7)                                                                 ,  /* （中継用）ＭＦ住所コード */
     ztymfjyuusyo                                       VARCHAR     (62)                                                                ,  /* （中継用）ＭＦ住所 */
     ztykyknmkj35                                       VARCHAR     (35)                                                                ,  /* （中継用）契約者名（漢字）（３５桁） */
     ztykykmnmeigibangou                                VARCHAR     (3)                                                                 ,  /* （中継用）契約者ＭＮ名義番号 */
     ztyjigyoukykmndantaicd                             VARCHAR     (8)                                                                 ,  /* （中継用）事業契約用ＭＮ団体コード */
     ztyyobiv17                                         VARCHAR     (17)                                                                ,  /* （中継用）予備項目Ｖ１７ */
     ztyhhknnmkj                                        VARCHAR     (15)                                                                ,  /* （中継用）被保険者名（漢字） */
     ztyyobiv3                                          VARCHAR     (3)                                                                 ,  /* （中継用）予備項目Ｖ３ */
     ztyyobiv17x2                                       VARCHAR     (17)                                                                ,  /* （中継用）予備項目Ｖ１７＿２ */
     ztyoldkykkihontikucd                               VARCHAR     (7)                                                                 ,  /* （中継用）旧契約者基本地区コード */
     ztykjoldkykkaiadr                                  VARCHAR     (62)                                                                ,  /* （中継用）漢字旧契約者下位住所 */
     ztykjoldkyknm                                      VARCHAR     (35)                                                                ,  /* （中継用）漢字旧契約者名 */
     ztykykhnkkaisuu                                    VARCHAR     (2)                                                                 ,  /* （中継用）契約者変更回数 */
     ztyyobiv3x2                                        VARCHAR     (3)                                                                 ,  /* （中継用）予備項目Ｖ３＿２ */
     ztyyobiv23                                         VARCHAR     (23)                                                                ,  /* （中継用）予備項目Ｖ２３ */
     ztyshrymd                                          VARCHAR     (8)                                                                 ,  /* （中継用）支払年月日 */
     ztysakuseiymd                                      VARCHAR     (8)                                                                 ,  /* （中継用）作成日 */
     ztykouryokuhasseiymd                               VARCHAR     (8)                                                                 ,  /* （中継用）効力発生日 */
     ztyyobiv8                                          VARCHAR     (8)                                                                 ,  /* （中継用）予備項目Ｖ８ */
     ztyyobiv8x2                                        VARCHAR     (8)                                                                 ,  /* （中継用）予備項目Ｖ８＿２ */
     ztyyobiv8x3                                        VARCHAR     (8)                                                                 ,  /* （中継用）予備項目Ｖ８＿３ */
     ztyyobiv8x4                                        VARCHAR     (8)                                                                 ,  /* （中継用）予備項目Ｖ８＿４ */
     ztyshrgk11                                         NUMBER      (11)                                                                ,  /* （中継用）支払金額Ｎ１１ */
     ztywarimsishrgk                                    NUMBER      (11)                                                                ,  /* （中継用）割増支払金額 */
     ztyznnphr                                          NUMBER      (11)                                                                ,  /* （中継用）前納Ｐ等返戻金 */
     ztyttkekstkganri                                   NUMBER      (11)                                                                ,  /* （中継用）立替貸付元利金 */
     ztysshkd                                           NUMBER      (11)                                                                ,  /* （中継用）差引Ｄ */
     ztysasihikisiharaigaku                             NUMBER      (11)                                                                ,  /* （中継用）差引支払金額 */
     ztymihrkmp                                         NUMBER      (11)                                                                ,  /* （中継用）未払込Ｐ */
     ztyshrtienrsk11                                    NUMBER      (11)                                                                ,  /* （中継用）支払遅延利息Ｎ１１ */
     ztytysyouhtykeihi                                  NUMBER      (11)                                                                ,  /* （中継用）調書用必要経費 */
     ztygenkykhtykeihiyouhyj                            VARCHAR     (1)                                                                 ,  /* （中継用）現契約者必要経費要表示 */
     ztygenkykhtykeihi                                  NUMBER      (11)                                                                ,  /* （中継用）現契約者必要経費 */
     ztyyobin11                                         NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１ */
     ztyyobin11x2                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿２ */
     ztyyobin11x3                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿３ */
     ztyyobin11x4                                       NUMBER      (11)                                                                ,  /* （中継用）予備項目Ｎ１１＿４ */
     ztygensenkbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）源泉徴収区分 */
     ztygensentaisyoukkngai                             VARCHAR     (4)                                                                 ,  /* （中継用）源泉徴収対象外期間 */
     ztygensentaisyoukkn                                VARCHAR     (4)                                                                 ,  /* （中継用）源泉徴収対象期間 */
     ztymnsaiannaihnskakbn                              VARCHAR     (2)                                                                 ,  /* （中継用）ＭＮ再案内本社回送区分 */
     ztyshrhousiteikbn                                  VARCHAR     (2)                                                                 ,  /* （中継用）支払方法指定区分 */
     ztyshrtysykurikosidisp                             VARCHAR     (1)                                                                 ,  /* （中継用）支払調書繰越表示 */
     ztymfadrsiyouhyouji                                VARCHAR     (1)                                                                 ,  /* （中継用）ＭＦ住所使用表示 */
     ztynkshrhkjksyuruikbn                              VARCHAR     (2)                                                                 ,  /* （中継用）年金支払用保険事故種類区分 */
     ztynenkinkkn                                       VARCHAR     (2)                                                                 ,  /* （中継用）年金期間 */
     ztysynyhsjykykndisp                                VARCHAR     (1)                                                                 ,  /* （中継用）収入保障年金受給権表示 */
     ztyonlinecentercutkbn                              VARCHAR     (1)                                                                 ,  /* （中継用）オンラインセンターカット区分 */
     ztyhuho2kykdisp                                    VARCHAR     (1)                                                                 ,  /* （中継用）普保Ⅱ契約表示 */
     ztyshrtysyhknsyukbn                                VARCHAR     (15)                                                                ,  /* （中継用）支払調書保険種類区分 */
     ztyyobiv9x5                                        VARCHAR     (9)                                                                 ,  /* （中継用）予備項目Ｖ９＿５ */
     ztytekiyouranhensyuukbn1                           VARCHAR     (2)                                                                 ,  /* （中継用）摘要欄編集区分１ */
     ztytekiyouranhensyuukbn2                           VARCHAR     (2)                                                                 ,  /* （中継用）摘要欄編集区分２ */
     ztytekiyouranhensyuukbn3                           VARCHAR     (2)                                                                 ,  /* （中継用）摘要欄編集区分３ */
     ztytekiyouranhensyuukbn4                           VARCHAR     (2)                                                                 ,  /* （中継用）摘要欄編集区分４ */
     ztytekiyouranhensyuukbn5                           VARCHAR     (2)                                                                 ,  /* （中継用）摘要欄編集区分５ */
     ztyyobiv181                                        VARCHAR     (181)                                                               ,  /* （中継用）予備項目Ｖ１８１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SiharaiTyousyoTy ADD CONSTRAINT PK_SiharaiTyousyoTy PRIMARY KEY (
     ztysequenceno                                              /* （中継用）シーケンス番号 */
) ;
