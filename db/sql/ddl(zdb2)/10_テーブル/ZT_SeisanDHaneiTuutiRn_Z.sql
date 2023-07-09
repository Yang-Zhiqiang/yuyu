CREATE TABLE ZT_SeisanDHaneiTuutiRn_Z (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrnkeysyono                                        CHAR        (11)                                                      NOT NULL  ,  /* （連携用）キー証券番号 */
     zrnhaitounendo                                     CHAR        (4)                                                       NOT NULL  ,  /* （連携用）配当年度 */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrnatesakiyno                                      GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）宛先郵便番号 */
     zrnrigikbn                                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）例外区分 */
     zrnhrkkeiro                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路 */
     zrnsclatosyono                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）スクランブル後証券番号 */
     zrnatesakiadr1                                     GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所１ */
     zrnatesakiadr2                                     GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所２ */
     zrnatesakiadr3                                     GRAPHIC     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所３ */
     zrnatena1                                          GRAPHIC     (19)                                                      NOT NULL  ,  /* （連携用）宛名１ */
     zrndai1syoukaisakifreearea1                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１ */
     zrndai1syoukaisakifreearea2                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア２ */
     zrndai1syoukaisakifreearea3                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア３ */
     zrndai1syoukaisakifreearea4                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア４ */
     zrndai1syoukaisakifreearea5                        GRAPHIC     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア５ */
     zrnsakunm                                          CHAR        (7)                                                       NOT NULL  ,  /* （連携用）作成番号 */
     zrnsakuseiymdseireki                               GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）作成年月日（西暦） */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnkykymdseireki                                   GRAPHIC     (11)                                                      NOT NULL  ,  /* （連携用）契約年月日（西暦） */
     zrnseisikihknnm                                    GRAPHIC     (40)                                                      NOT NULL  ,  /* （連携用）正式保険名称 */
     zrnhhknnmkj17                                      GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字）（１７桁） */
     zrnfreearea37keta11                                GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１ */
     zrnfreearea37keta12                                GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２ */
     zrnfreearea37keta13                                GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿３ */
     zrnfreearea37keta14                                GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿４ */
     zrnfreearea37keta15                                GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿５ */
     zrnfreearea37keta16                                GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿６ */
     zrnfreearea37keta17                                GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿７ */
     zrnfreearea37keta18                                GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿８ */
     zrnfreearea37keta19                                GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿９ */
     zrnfreearea37keta110                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１０ */
     zrnfreearea37keta111                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１１ */
     zrnfreearea37keta112                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１２ */
     zrnfreearea37keta113                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１３ */
     zrnfreearea37keta114                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１４ */
     zrnfreearea37keta115                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１５ */
     zrnfreearea37keta116                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１６ */
     zrnfreearea37keta117                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１７ */
     zrnfreearea37keta118                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１８ */
     zrnfreearea37keta119                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１９ */
     zrnfreearea37keta120                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２０ */
     zrnfreearea37keta121                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２１ */
     zrnfreearea37keta122                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２２ */
     zrnfreearea37keta123                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２３ */
     zrnfreearea37keta124                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２４ */
     zrnfreearea37keta125                               GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２５ */
     zrnmidasi11                                        GRAPHIC     (19)                                                      NOT NULL  ,  /* （連携用）見出し１＿１ */
     zrntouduketorihouhou                               GRAPHIC     (16)                                                      NOT NULL  ,  /* （連携用）当Ｄ受取方法 */
     zrnmidasi21                                        GRAPHIC     (19)                                                      NOT NULL  ,  /* （連携用）見出し２＿１ */
     zrnkakuteidkgk                                     GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）確定Ｄ金額 */
     zrnmidasi31                                        GRAPHIC     (19)                                                      NOT NULL  ,  /* （連携用）見出し３＿１ */
     zrnnaiteidkgk                                      GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）内定Ｄ金額 */
     zrnmidasi41                                        GRAPHIC     (19)                                                      NOT NULL  ,  /* （連携用）見出し４＿１ */
     zrnseisandkgk                                      GRAPHIC     (17)                                                      NOT NULL  ,  /* （連携用）精算Ｄ金額 */
     zrnfreearea21                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１ */
     zrnfreearea22                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２ */
     zrnfreearea23                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿３ */
     zrnfreearea24                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿４ */
     zrnfreearea25                                      GRAPHIC     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿５ */
     zrnyobiv141                                        CHAR        (141)                                                     NOT NULL     /* （連携用）予備項目Ｖ１４１ */
)
;

ALTER TABLE ZT_SeisanDHaneiTuutiRn_Z ADD CONSTRAINT PK_SeisanDHaneiTuutiRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnkeysyono                                                /* （連携用）キー証券番号 */
) ;
