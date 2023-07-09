CREATE TABLE ZT_HrhnTtdkKanRn_Z (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrntyouhyouymdkj                                   GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（漢字） */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnsikibetuno                                      CHAR        (20)                                                      NOT NULL  ,  /* （連携用）識別番号 */
     zrnyobiv7                                          CHAR        (7)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ７ */
     zrnansyuyouyobin10                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０ */
     zrnshskyno                                         CHAR        (7)                                                       NOT NULL  ,  /* （連携用）送付先郵便番号 */
     zrnshskadr1kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所１（漢字） */
     zrnshskadr2kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所２（漢字） */
     zrnshskadr3kj                                      GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所３（漢字） */
     zrnshsnmkj                                         GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）送付先名（漢字） */
     zrnyobiv43                                         CHAR        (43)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ４３ */
     zrnansyuyouyobin10x2                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿２ */
     zrntawsosikikj                                     GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先組織名（漢字） */
     zrntawyno                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）問合せ先郵便番号 */
     zrntawadr1kj                                       GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所１（漢字） */
     zrntawadr2kj                                       GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所２（漢字） */
     zrntawadr3kj                                       GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所３（漢字） */
     zrntawtelnov14                                     CHAR        (14)                                                      NOT NULL  ,  /* （連携用）問合せ先電話番号Ｖ１４ */
     zrntawteluktkkanou1                                GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間１ */
     zrntawteluktkkanou2                                GRAPHIC     (25)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間２ */
     zrndai2tawsosikinmkj                               GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）第２問合せ先組織名（漢字） */
     zrndai2tawtelno                                    CHAR        (14)                                                      NOT NULL  ,  /* （連携用）第２問合せ先電話番号 */
     zrnsclatosyono                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）スクランブル後証券番号 */
     zrnsakunm15keta                                    CHAR        (15)                                                      NOT NULL  ,  /* （連携用）作成番号（１５桁） */
     zrnyobiv63                                         CHAR        (63)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６３ */
     zrnansyuyouyobin10x3                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿３ */
     zrnkouzamaskingmsg                                 GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）口座マスキングＭＳＧ */
     zrnhrkkaisuutkiktbrisyu                            GRAPHIC     (9)                                                       NOT NULL  ,  /* （連携用）払込回数・定期一括払種類 */
     zrnhrkkeiro                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路 */
     zrnhrkp                                            CHAR        (13)                                                      NOT NULL  ,  /* （連携用）払込保険料 */
     zrnkouryokuhasseiymmsg                             GRAPHIC     (13)                                                      NOT NULL  ,  /* （連携用）効力発生年月ＭＳＧ */
     zrnsakuseijitenmsg                                 GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）作成時点メッセージ */
     zrnkingakumidasi1                                  GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）金額見出し１ */
     zrnkingaku1                                        CHAR        (13)                                                      NOT NULL  ,  /* （連携用）金額１ */
     zrnkingakumidasi2                                  GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）金額見出し２ */
     zrnkingaku2                                        CHAR        (13)                                                      NOT NULL  ,  /* （連携用）金額２ */
     zrnkingakumidasi3                                  GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）金額見出し３ */
     zrnkingaku3                                        CHAR        (13)                                                      NOT NULL  ,  /* （連携用）金額３ */
     zrnyobiv64                                         CHAR        (64)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６４ */
     zrnansyuyouyobin10x4                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿４ */
     zrnmsgarea34keta1                                  GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）メッセージエリア（３４桁）１ */
     zrnmsgarea34keta2                                  GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）メッセージエリア（３４桁）２ */
     zrnmsgarea34keta3                                  GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）メッセージエリア（３４桁）３ */
     zrnmsgarea34keta4                                  GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）メッセージエリア（３４桁）４ */
     zrnmsgarea34keta5                                  GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）メッセージエリア（３４桁）５ */
     zrnmsgarea34keta6                                  GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）メッセージエリア（３４桁）６ */
     zrnmsgarea34keta7                                  GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）メッセージエリア（３４桁）７ */
     zrnyobiv95                                         CHAR        (95)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ９５ */
     zrnansyuyouyobin10x5                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿５ */
     zrnhurikaeyokokumsg34keta1                         GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）１ */
     zrnhurikaeyokokumsg34keta2                         GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）２ */
     zrnhurikaeyokokumsg34keta3                         GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）３ */
     zrnhurikaeyokokumsg34keta4                         GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）４ */
     zrnhurikaeyokokumsg34keta5                         GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）５ */
     zrnhurikaeyokokumsg34keta6                         GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）６ */
     zrnhurikaeyokokumsg34keta7                         GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）７ */
     zrnhurikaeyokokumsg34keta8                         GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）８ */
     zrnhurikaeyokokumsg34keta9                         GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）９ */
     zrnhurikaeyokokumsg34keta10                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）１０ */
     zrnhurikaeyokokumsg34keta11                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）１１ */
     zrnhurikaeyokokumsg34keta12                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）１２ */
     zrnhurikaeyokokumsg34keta13                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）１３ */
     zrnhurikaeyokokumsg34keta14                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）１４ */
     zrnhurikaeyokokumsg34keta15                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）１５ */
     zrnhurikaeyokokumsg34keta16                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）１６ */
     zrnhurikaeyokokumsg34keta17                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）１７ */
     zrnhurikaeyokokumsg34keta18                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）１８ */
     zrnhurikaeyokokumsg34keta19                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）１９ */
     zrnhurikaeyokokumsg34keta20                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）２０ */
     zrnhurikaeyokokumsg34keta21                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）２１ */
     zrnhurikaeyokokumsg34keta22                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）２２ */
     zrnhurikaeyokokumsg34keta23                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）２３ */
     zrnhurikaeyokokumsg34keta24                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）２４ */
     zrnhurikaeyokokumsg34keta25                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）２５ */
     zrnhurikaeyokokumsg34keta26                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）２６ */
     zrnhurikaeyokokumsg34keta27                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）２７ */
     zrnhurikaeyokokumsg34keta28                        GRAPHIC     (34)                                                      NOT NULL  ,  /* （連携用）振替予告メッセージ（３４桁）２８ */
     zrnyobiv131                                        CHAR        (131)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１３１ */
     zrnyobiv250                                        CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０ */
     zrnansyuyouyobin10x6                               CHAR        (10)                                                      NOT NULL     /* （連携用）案内収納用予備項目Ｎ１０＿６ */
)
;

ALTER TABLE ZT_HrhnTtdkKanRn_Z ADD CONSTRAINT PK_HrhnTtdkKanRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrnsikibetuno                                              /* （連携用）識別番号 */
) ;
