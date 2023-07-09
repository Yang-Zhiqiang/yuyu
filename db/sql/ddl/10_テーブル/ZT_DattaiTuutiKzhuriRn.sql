CREATE TABLE ZT_DattaiTuutiKzhuriRn (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrntyouhyouymdkj                                   VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）帳票作成日（漢字） */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnyobiv9                                          CHAR        (9)                                                       NOT NULL  ,  /* （連携用）予備項目Ｖ９ */
     zrnansyuyouyobin10                                 CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０ */
     zrnshskyno                                         CHAR        (7)                                                       NOT NULL  ,  /* （連携用）送付先郵便番号 */
     zrnshskadr1kj                                      VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所１（漢字） */
     zrnshskadr2kj                                      VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所２（漢字） */
     zrnshskadr3kj                                      VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）送付先住所３（漢字） */
     zrnshsnmkj                                         VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）送付先名（漢字） */
     zrnyobiv43                                         CHAR        (43)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ４３ */
     zrnansyuyouyobin10x2                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿２ */
     zrntawsosikikj                                     VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先組織名（漢字） */
     zrntawyno                                          CHAR        (8)                                                       NOT NULL  ,  /* （連携用）問合せ先郵便番号 */
     zrntawadr1kj                                       VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所１（漢字） */
     zrntawadr2kj                                       VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所２（漢字） */
     zrntawadr3kj                                       VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）問合せ先住所３（漢字） */
     zrntawtelnov14                                     CHAR        (14)                                                      NOT NULL  ,  /* （連携用）問合せ先電話番号Ｖ１４ */
     zrntawteluktkkanou1                                VARCHAR     (25)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間１ */
     zrntawteluktkkanou2                                VARCHAR     (25)                                                      NOT NULL  ,  /* （連携用）問合せ先電話受付可能時間２ */
     zrndai2tawsosikinmkj                               VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）第２問合せ先組織名（漢字） */
     zrndai2tawtelno                                    CHAR        (14)                                                      NOT NULL  ,  /* （連携用）第２問合せ先電話番号 */
     zrnsclatosyono                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）スクランブル後証券番号 */
     zrnsakunm15keta                                    CHAR        (15)                                                      NOT NULL  ,  /* （連携用）作成番号（１５桁） */
     zrnyobiv62                                         CHAR        (62)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ６２ */
     zrnansyuyouyobin10x3                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿３ */
     zrnosirasemongon1                                  VARCHAR     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言１ */
     zrnosirasemongon2                                  VARCHAR     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言２ */
     zrnosirasemongon3                                  VARCHAR     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言３ */
     zrnosirasemongon4                                  VARCHAR     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言４ */
     zrnosirasemongon5                                  VARCHAR     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言５ */
     zrnosirasemongon6                                  VARCHAR     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言６ */
     zrnosirasemongon7                                  VARCHAR     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言７ */
     zrnosirasemongon8                                  VARCHAR     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言８ */
     zrnosirasemongon9                                  VARCHAR     (52)                                                      NOT NULL  ,  /* （連携用）お知らせ文言９ */
     zrnyobiv181                                        CHAR        (181)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ１８１ */
     zrnansyuyouyobin10x4                               CHAR        (10)                                                      NOT NULL  ,  /* （連携用）案内収納用予備項目Ｎ１０＿４ */
     zrnsyono2                                          CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号２ */
     zrnhhknnmkj                                        VARCHAR     (15)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字） */
     zrnkzinfo30keta1                                   VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）口座情報（３０桁）１ */
     zrnkzinfo30keta2                                   VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）口座情報（３０桁）２ */
     zrnkzinfo30keta3                                   VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）口座情報（３０桁）３ */
     zrnkouzamaskingmsg                                 VARCHAR     (32)                                                      NOT NULL  ,  /* （連携用）口座マスキングＭＳＧ */
     zrnyobiv50                                         CHAR        (50)                                                      NOT NULL  ,  /* （連携用）予備項目Ｖ５０ */
     zrnansyuyouyobin10x5                               CHAR        (10)                                                      NOT NULL     /* （連携用）案内収納用予備項目Ｎ１０＿５ */
)
;

ALTER TABLE ZT_DattaiTuutiKzhuriRn ADD CONSTRAINT PK_DattaiTuutiKzhuriRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsyono                                                   /* （連携用）証券番号 */
) ;
