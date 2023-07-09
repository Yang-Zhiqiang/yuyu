CREATE TABLE ZT_HrhnTtdkKanTy_Z (
     ztysyoruicd                                        VARCHAR     (5)                                                                 ,  /* （中継用）書類コード */
     ztyhassoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）発送区分 */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztytyouhyouymdkj                                   VARCHAR     (24)                                                                ,  /* （中継用）帳票作成日（漢字） */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztysikibetuno                                      VARCHAR     (20)                                                      NOT NULL  ,  /* （中継用）識別番号 */
     ztyyobiv7                                          VARCHAR     (7)                                                                 ,  /* （中継用）予備項目Ｖ７ */
     ztyansyuyouyobin10                                 VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０ */
     ztyshskyno                                         VARCHAR     (7)                                                                 ,  /* （中継用）送付先郵便番号 */
     ztyshskadr1kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所１（漢字） */
     ztyshskadr2kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所２（漢字） */
     ztyshskadr3kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所３（漢字） */
     ztyshsnmkj                                         VARCHAR     (32)                                                                ,  /* （中継用）送付先名（漢字） */
     ztyyobiv43                                         VARCHAR     (43)                                                                ,  /* （中継用）予備項目Ｖ４３ */
     ztyansyuyouyobin10x2                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿２ */
     ztytawsosikikj                                     VARCHAR     (32)                                                                ,  /* （中継用）問合せ先組織名（漢字） */
     ztytawyno                                          VARCHAR     (8)                                                                 ,  /* （中継用）問合せ先郵便番号 */
     ztytawadr1kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所１（漢字） */
     ztytawadr2kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所２（漢字） */
     ztytawadr3kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所３（漢字） */
     ztytawtelnov14                                     VARCHAR     (14)                                                                ,  /* （中継用）問合せ先電話番号Ｖ１４ */
     ztytawteluktkkanou1                                VARCHAR     (52)                                                                ,  /* （中継用）問合せ先電話受付可能時間１ */
     ztytawteluktkkanou2                                VARCHAR     (52)                                                                ,  /* （中継用）問合せ先電話受付可能時間２ */
     ztydai2tawsosikinmkj                               VARCHAR     (32)                                                                ,  /* （中継用）第２問合せ先組織名（漢字） */
     ztydai2tawtelno                                    VARCHAR     (14)                                                                ,  /* （中継用）第２問合せ先電話番号 */
     ztysclatosyono                                     VARCHAR     (11)                                                                ,  /* （中継用）スクランブル後証券番号 */
     ztysakunm15keta                                    VARCHAR     (15)                                                                ,  /* （中継用）作成番号（１５桁） */
     ztyyobiv63                                         VARCHAR     (63)                                                                ,  /* （中継用）予備項目Ｖ６３ */
     ztyansyuyouyobin10x3                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿３ */
     ztykouzamaskingmsg                                 VARCHAR     (66)                                                                ,  /* （中継用）口座マスキングＭＳＧ */
     ztyhrkkaisuutkiktbrisyu                            VARCHAR     (20)                                                                ,  /* （中継用）払込回数・定期一括払種類 */
     ztyhrkkeiro                                        VARCHAR     (1)                                                                 ,  /* （中継用）払込経路 */
     ztyhrkp                                            VARCHAR     (13)                                                                ,  /* （中継用）払込保険料 */
     ztykouryokuhasseiymmsg                             VARCHAR     (28)                                                                ,  /* （中継用）効力発生年月ＭＳＧ */
     ztysakuseijitenmsg                                 VARCHAR     (42)                                                                ,  /* （中継用）作成時点メッセージ */
     ztykingakumidasi1                                  VARCHAR     (42)                                                                ,  /* （中継用）金額見出し１ */
     ztykingaku1                                        VARCHAR     (13)                                                                ,  /* （中継用）金額１ */
     ztykingakumidasi2                                  VARCHAR     (42)                                                                ,  /* （中継用）金額見出し２ */
     ztykingaku2                                        VARCHAR     (13)                                                                ,  /* （中継用）金額２ */
     ztykingakumidasi3                                  VARCHAR     (42)                                                                ,  /* （中継用）金額見出し３ */
     ztykingaku3                                        VARCHAR     (13)                                                                ,  /* （中継用）金額３ */
     ztyyobiv64                                         VARCHAR     (64)                                                                ,  /* （中継用）予備項目Ｖ６４ */
     ztyansyuyouyobin10x4                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿４ */
     ztymsgarea34keta1                                  VARCHAR     (70)                                                                ,  /* （中継用）メッセージエリア（３４桁）１ */
     ztymsgarea34keta2                                  VARCHAR     (70)                                                                ,  /* （中継用）メッセージエリア（３４桁）２ */
     ztymsgarea34keta3                                  VARCHAR     (70)                                                                ,  /* （中継用）メッセージエリア（３４桁）３ */
     ztymsgarea34keta4                                  VARCHAR     (70)                                                                ,  /* （中継用）メッセージエリア（３４桁）４ */
     ztymsgarea34keta5                                  VARCHAR     (70)                                                                ,  /* （中継用）メッセージエリア（３４桁）５ */
     ztymsgarea34keta6                                  VARCHAR     (70)                                                                ,  /* （中継用）メッセージエリア（３４桁）６ */
     ztymsgarea34keta7                                  VARCHAR     (70)                                                                ,  /* （中継用）メッセージエリア（３４桁）７ */
     ztyyobiv95                                         VARCHAR     (95)                                                                ,  /* （中継用）予備項目Ｖ９５ */
     ztyansyuyouyobin10x5                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿５ */
     ztyhurikaeyokokumsg34keta1                         VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）１ */
     ztyhurikaeyokokumsg34keta2                         VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）２ */
     ztyhurikaeyokokumsg34keta3                         VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）３ */
     ztyhurikaeyokokumsg34keta4                         VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）４ */
     ztyhurikaeyokokumsg34keta5                         VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）５ */
     ztyhurikaeyokokumsg34keta6                         VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）６ */
     ztyhurikaeyokokumsg34keta7                         VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）７ */
     ztyhurikaeyokokumsg34keta8                         VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）８ */
     ztyhurikaeyokokumsg34keta9                         VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）９ */
     ztyhurikaeyokokumsg34keta10                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）１０ */
     ztyhurikaeyokokumsg34keta11                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）１１ */
     ztyhurikaeyokokumsg34keta12                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）１２ */
     ztyhurikaeyokokumsg34keta13                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）１３ */
     ztyhurikaeyokokumsg34keta14                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）１４ */
     ztyhurikaeyokokumsg34keta15                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）１５ */
     ztyhurikaeyokokumsg34keta16                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）１６ */
     ztyhurikaeyokokumsg34keta17                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）１７ */
     ztyhurikaeyokokumsg34keta18                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）１８ */
     ztyhurikaeyokokumsg34keta19                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）１９ */
     ztyhurikaeyokokumsg34keta20                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）２０ */
     ztyhurikaeyokokumsg34keta21                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）２１ */
     ztyhurikaeyokokumsg34keta22                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）２２ */
     ztyhurikaeyokokumsg34keta23                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）２３ */
     ztyhurikaeyokokumsg34keta24                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）２４ */
     ztyhurikaeyokokumsg34keta25                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）２５ */
     ztyhurikaeyokokumsg34keta26                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）２６ */
     ztyhurikaeyokokumsg34keta27                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）２７ */
     ztyhurikaeyokokumsg34keta28                        VARCHAR     (70)                                                                ,  /* （中継用）振替予告メッセージ（３４桁）２８ */
     ztyyobiv131                                        VARCHAR     (131)                                                               ,  /* （中継用）予備項目Ｖ１３１ */
     ztyyobiv250                                        VARCHAR     (250)                                                               ,  /* （中継用）予備項目Ｖ２５０ */
     ztyansyuyouyobin10x6                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿６ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_HrhnTtdkKanTy_Z ADD CONSTRAINT PK_HrhnTtdkKanTy PRIMARY KEY (
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysyono                                                 , /* （中継用）証券番号 */
     ztysikibetuno                                              /* （中継用）識別番号 */
) ;
