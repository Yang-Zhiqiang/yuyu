CREATE TABLE ZT_SeisanDHaneiTuutiRn (
     zrnsyoruicd                                        CHAR        (5)                                                       NOT NULL  ,  /* （連携用）書類コード */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrnkeysyono                                        CHAR        (11)                                                      NOT NULL  ,  /* （連携用）キー証券番号 */
     zrnhaitounendo                                     CHAR        (4)                                                       NOT NULL  ,  /* （連携用）配当年度 */
     zrnhassoukbn                                       CHAR        (1)                                                       NOT NULL  ,  /* （連携用）発送区分 */
     zrnatesakiyno                                      VARCHAR     (8)                                                       NOT NULL  ,  /* （連携用）宛先郵便番号 */
     zrnrigikbn                                         CHAR        (2)                                                       NOT NULL  ,  /* （連携用）例外区分 */
     zrnhrkkeiro                                        CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込経路 */
     zrnsclatosyono                                     CHAR        (11)                                                      NOT NULL  ,  /* （連携用）スクランブル後証券番号 */
     zrnatesakiadr1                                     VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所１ */
     zrnatesakiadr2                                     VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所２ */
     zrnatesakiadr3                                     VARCHAR     (30)                                                      NOT NULL  ,  /* （連携用）宛先住所３ */
     zrnatena1                                          VARCHAR     (19)                                                      NOT NULL  ,  /* （連携用）宛名１ */
     zrndai1syoukaisakifreearea1                        VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア１ */
     zrndai1syoukaisakifreearea2                        VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア２ */
     zrndai1syoukaisakifreearea3                        VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア３ */
     zrndai1syoukaisakifreearea4                        VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア４ */
     zrndai1syoukaisakifreearea5                        VARCHAR     (20)                                                      NOT NULL  ,  /* （連携用）第１照会先フリーエリア５ */
     zrnsakunm                                          CHAR        (7)                                                       NOT NULL  ,  /* （連携用）作成番号 */
     zrnsakuseiymdseireki                               VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）作成年月日（西暦） */
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrnkykymdseireki                                   VARCHAR     (11)                                                      NOT NULL  ,  /* （連携用）契約年月日（西暦） */
     zrnseisikihknnm                                    VARCHAR     (40)                                                      NOT NULL  ,  /* （連携用）正式保険名称 */
     zrnhhknnmkj17                                      VARCHAR     (17)                                                      NOT NULL  ,  /* （連携用）被保険者名（漢字）（１７桁） */
     zrnfreearea37keta11                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１ */
     zrnfreearea37keta12                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２ */
     zrnfreearea37keta13                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿３ */
     zrnfreearea37keta14                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿４ */
     zrnfreearea37keta15                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿５ */
     zrnfreearea37keta16                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿６ */
     zrnfreearea37keta17                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿７ */
     zrnfreearea37keta18                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿８ */
     zrnfreearea37keta19                                VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿９ */
     zrnfreearea37keta110                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１０ */
     zrnfreearea37keta111                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１１ */
     zrnfreearea37keta112                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１２ */
     zrnfreearea37keta113                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１３ */
     zrnfreearea37keta114                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１４ */
     zrnfreearea37keta115                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１５ */
     zrnfreearea37keta116                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１６ */
     zrnfreearea37keta117                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１７ */
     zrnfreearea37keta118                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１８ */
     zrnfreearea37keta119                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿１９ */
     zrnfreearea37keta120                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２０ */
     zrnfreearea37keta121                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２１ */
     zrnfreearea37keta122                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２２ */
     zrnfreearea37keta123                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２３ */
     zrnfreearea37keta124                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２４ */
     zrnfreearea37keta125                               VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア（３７桁）１＿２５ */
     zrnmidasi11                                        VARCHAR     (19)                                                      NOT NULL  ,  /* （連携用）見出し１＿１ */
     zrntouduketorihouhou                               VARCHAR     (16)                                                      NOT NULL  ,  /* （連携用）当Ｄ受取方法 */
     zrnmidasi21                                        VARCHAR     (19)                                                      NOT NULL  ,  /* （連携用）見出し２＿１ */
     zrnkakuteidkgk                                     VARCHAR     (17)                                                      NOT NULL  ,  /* （連携用）確定Ｄ金額 */
     zrnmidasi31                                        VARCHAR     (19)                                                      NOT NULL  ,  /* （連携用）見出し３＿１ */
     zrnnaiteidkgk                                      VARCHAR     (17)                                                      NOT NULL  ,  /* （連携用）内定Ｄ金額 */
     zrnmidasi41                                        VARCHAR     (19)                                                      NOT NULL  ,  /* （連携用）見出し４＿１ */
     zrnseisandkgk                                      VARCHAR     (17)                                                      NOT NULL  ,  /* （連携用）精算Ｄ金額 */
     zrnfreearea21                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿１ */
     zrnfreearea22                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿２ */
     zrnfreearea23                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿３ */
     zrnfreearea24                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿４ */
     zrnfreearea25                                      VARCHAR     (37)                                                      NOT NULL  ,  /* （連携用）フリーエリア２＿５ */
     zrnyobiv141                                        CHAR        (141)                                                     NOT NULL     /* （連携用）予備項目Ｖ１４１ */
)
;

ALTER TABLE ZT_SeisanDHaneiTuutiRn ADD CONSTRAINT PK_SeisanDHaneiTuutiRn PRIMARY KEY (
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnkeysyono                                                /* （連携用）キー証券番号 */
) ;
