CREATE TABLE ZT_YuukouseiNgTuutiRn_Z (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrntyouhyouymdkj                                   GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（漢字） */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnyobiv9                                          CHAR        (9)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ９ */
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
     zrnyobiv62                                         CHAR        (62)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６２ */
     zrnansyuyouyobin10x3                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿３ */
     zrnosirasemongon46keta1                            GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）お知らせ文言（４６桁）１ */
     zrnosirasemongon46keta2                            GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）お知らせ文言（４６桁）２ */
     zrnosirasemongon46keta3                            GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）お知らせ文言（４６桁）３ */
     zrnosirasemongon46keta4                            GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）お知らせ文言（４６桁）４ */
     zrnosirasemongon46keta5                            GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）お知らせ文言（４６桁）５ */
     zrnosirasemongon46keta6                            GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）お知らせ文言（４６桁）６ */
     zrnosirasemongon46keta7                            GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）お知らせ文言（４６桁）７ */
     zrnosirasemongon46keta8                            GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）お知らせ文言（４６桁）８ */
     zrnosirasemongon46keta9                            GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）お知らせ文言（４６桁）９ */
     zrnosirasemongon46keta10                           GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）お知らせ文言（４６桁）１０ */
     zrnyobiv184                                        CHAR        (184)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１８４ */
     zrnansyuyouyobin10x4                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿４ */
     zrnkyknmkj                                         GRAPHIC     (15)                                                      NOT NULL  ,  /* （連携用）契約者名（漢字） */
     zrnpkngk                                           CHAR        (13)                                                      NOT NULL  ,  /* （連携用）保険料金額 */
     zrncreditcardinfo1                                 GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）クレジットカード情報１ */
     zrncreditcardinfo2                                 GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）クレジットカード情報２ */
     zrncreditcardinfo3                                 GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）クレジットカード情報３ */
     zrncreditcardmaskingmsg                            GRAPHIC     (39)                                                      NOT NULL  ,  /* （連携用）クレジットカードマスキングＭＳＧ */
     zrngoiraijikoutoumongon1                           GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）ご依頼事項等文言１ */
     zrngoiraijikoutoumongon2                           GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）ご依頼事項等文言２ */
     zrngoiraijikoutoumongon3                           GRAPHIC     (35)                                                      NOT NULL  ,  /* （連携用）ご依頼事項等文言３ */
     zrnphrkmongon1                                     GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）保険料のお払込み文言１ */
     zrnphrkmongon2                                     GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）保険料のお払込み文言２ */
     zrnphrkmongon3                                     GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）保険料のお払込み文言３ */
     zrnphrkmongon4                                     GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）保険料のお払込み文言４ */
     zrnphrkmongon5                                     GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）保険料のお払込み文言５ */
     zrnphrkmongon6                                     GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）保険料のお払込み文言６ */
     zrnphrkmongon7                                     GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）保険料のお払込み文言７ */
     zrnphrkmongon8                                     GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）保険料のお払込み文言８ */
     zrnphrkmongon9                                     GRAPHIC     (46)                                                      NOT NULL  ,  /* （連携用）保険料のお払込み文言９ */
     zrnyobiv17                                         CHAR        (17)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ１７ */
     zrnyobiv250                                        CHAR        (250)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ２５０ */
     zrnansyuyouyobin10x5                               CHAR        (10)                                                      NOT NULL     /* （連携用）案内収納用予備項目Ｎ１０＿５ */
)
;

ALTER TABLE ZT_YuukouseiNgTuutiRn_Z ADD CONSTRAINT PK_YuukouseiNgTuutiRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
