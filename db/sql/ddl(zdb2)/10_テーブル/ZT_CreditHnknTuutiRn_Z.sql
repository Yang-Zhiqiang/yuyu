CREATE TABLE ZT_CreditHnknTuutiRn_Z (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrntyouhyouymdkj                                   GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（漢字） */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnsikibetuno                                      CHAR        (20)                                                      NOT NULL  ,  /* （連携用）識別番号 */
     zrnyobiv14                                         CHAR        (14)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１４ */
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
     zrnyobiv62                                         CHAR        (62)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６２ */
     zrnansyuyouyobin10x3                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿３ */
     zrnhnknmsgmongon1                                  GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ文言１ */
     zrnhnknmsgmongon2                                  GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ文言２ */
     zrnhnknmsgmongon3                                  GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ文言３ */
     zrnhnknmsgmongon4                                  GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ文言４ */
     zrnhnknmsgmongon5                                  GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ文言５ */
     zrnhnknmsgmongon6                                  GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ文言６ */
     zrnhnknmsgmongon7                                  GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ文言７ */
     zrnhnknmsgmongon8                                  GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ文言８ */
     zrnhnknmsgmongon9                                  GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ文言９ */
     zrnhnknmsgmongon10                                 GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ文言１０ */
     zrnyobiv128                                        CHAR        (128)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１２８ */
     zrnansyuyouyobin10x4                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿４ */
     zrntuutisakuseiymdv32                              GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）通知作成年月日Ｖ３２ */
     zrnyobiv64                                         CHAR        (64)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６４ */
     zrnansyuyouyobin10x5                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿５ */
     zrnhnknnaiyoumongon1                               GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金内容文言１ */
     zrnhnknnaiyoumongon2                               GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金内容文言２ */
     zrnhnknnaiyoumongon3                               GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金内容文言３ */
     zrnhnknnaiyoumongon4                               GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金内容文言４ */
     zrnhnknnaiyoumongon5                               GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金内容文言５ */
     zrnhnknnaiyoumongon6                               GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金内容文言６ */
     zrnhnknnaiyoumongon7                               GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金内容文言７ */
     zrnhnknnaiyoumongon8                               GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金内容文言８ */
     zrnyobiv128x2                                      CHAR        (128)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１２８＿２ */
     zrnansyuyouyobin10x6                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿６ */
     zrnhnknmsghsk1                                     GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足１ */
     zrnhnknmsghsk2                                     GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足２ */
     zrnhnknmsghsk3                                     GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足３ */
     zrnhnknmsghsk4                                     GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足４ */
     zrnhnknmsghsk5                                     GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足５ */
     zrnhnknmsghsk6                                     GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足６ */
     zrnhnknmsghsk7                                     GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足７ */
     zrnhnknmsghsk8                                     GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足８ */
     zrnhnknmsghsk9                                     GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足９ */
     zrnhnknmsghsk10                                    GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足１０ */
     zrnhnknmsghsk11                                    GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足１１ */
     zrnhnknmsghsk12                                    GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足１２ */
     zrnhnknmsghsk13                                    GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足１３ */
     zrnhnknmsghsk14                                    GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足１４ */
     zrnhnknmsghsk15                                    GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足１５ */
     zrnhnknmsghsk16                                    GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足１６ */
     zrnhnknmsghsk17                                    GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足１７ */
     zrnhnknmsghsk18                                    GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足１８ */
     zrnhnknmsghsk19                                    GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足１９ */
     zrnhnknmsghsk20                                    GRAPHIC     (32)                                                      NOT NULL  ,  /* （連携用）返金メッセージ補足２０ */
     zrnyobiv128x3                                      CHAR        (128)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１２８＿３ */
     zrnansyuyouyobin10x7                               CHAR        (10)                                                      NOT NULL     /* （連携用）案内収納用予備項目Ｎ１０＿７ */
)
;

ALTER TABLE ZT_CreditHnknTuutiRn_Z ADD CONSTRAINT PK_CreditHnknTuutiRn PRIMARY KEY (
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsikibetuno                                              /* （連携用）識別番号 */
) ;
