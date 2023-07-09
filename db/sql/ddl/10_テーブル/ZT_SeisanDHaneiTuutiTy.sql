CREATE TABLE ZT_SeisanDHaneiTuutiTy (
     ztysyoruicd                                        VARCHAR     (5)                                                                 ,  /* （中継用）書類コード */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztykeysyono                                        VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）キー証券番号 */
     ztyhaitounendo                                     VARCHAR     (4)                                                                 ,  /* （中継用）配当年度 */
     ztyhassoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）発送区分 */
     ztyatesakiyno                                      VARCHAR     (8)                                                                 ,  /* （中継用）宛先郵便番号 */
     ztyrigikbn                                         VARCHAR     (2)                                                                 ,  /* （中継用）例外区分 */
     ztyhrkkeiro                                        VARCHAR     (1)                                                                 ,  /* （中継用）払込経路 */
     ztysclatosyono                                     VARCHAR     (11)                                                                ,  /* （中継用）スクランブル後証券番号 */
     ztyatesakiadr1                                     VARCHAR     (30)                                                                ,  /* （中継用）宛先住所１ */
     ztyatesakiadr2                                     VARCHAR     (30)                                                                ,  /* （中継用）宛先住所２ */
     ztyatesakiadr3                                     VARCHAR     (30)                                                                ,  /* （中継用）宛先住所３ */
     ztyatena1                                          VARCHAR     (19)                                                                ,  /* （中継用）宛名１ */
     ztydai1syoukaisakifreearea1                        VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア１ */
     ztydai1syoukaisakifreearea2                        VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア２ */
     ztydai1syoukaisakifreearea3                        VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア３ */
     ztydai1syoukaisakifreearea4                        VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア４ */
     ztydai1syoukaisakifreearea5                        VARCHAR     (20)                                                                ,  /* （中継用）第１照会先フリーエリア５ */
     ztysakunm                                          VARCHAR     (7)                                                                 ,  /* （中継用）作成番号 */
     ztysakuseiymdseireki                               VARCHAR     (11)                                                                ,  /* （中継用）作成年月日（西暦） */
     ztysyono                                           VARCHAR     (11)                                                                ,  /* （中継用）証券番号 */
     ztykykymdseireki                                   VARCHAR     (11)                                                                ,  /* （中継用）契約年月日（西暦） */
     ztyseisikihknnm                                    VARCHAR     (40)                                                                ,  /* （中継用）正式保険名称 */
     ztyhhknnmkj17                                      VARCHAR     (17)                                                                ,  /* （中継用）被保険者名（漢字）（１７桁） */
     ztyfreearea37keta11                                VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿１ */
     ztyfreearea37keta12                                VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿２ */
     ztyfreearea37keta13                                VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿３ */
     ztyfreearea37keta14                                VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿４ */
     ztyfreearea37keta15                                VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿５ */
     ztyfreearea37keta16                                VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿６ */
     ztyfreearea37keta17                                VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿７ */
     ztyfreearea37keta18                                VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿８ */
     ztyfreearea37keta19                                VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿９ */
     ztyfreearea37keta110                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿１０ */
     ztyfreearea37keta111                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿１１ */
     ztyfreearea37keta112                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿１２ */
     ztyfreearea37keta113                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿１３ */
     ztyfreearea37keta114                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿１４ */
     ztyfreearea37keta115                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿１５ */
     ztyfreearea37keta116                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿１６ */
     ztyfreearea37keta117                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿１７ */
     ztyfreearea37keta118                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿１８ */
     ztyfreearea37keta119                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿１９ */
     ztyfreearea37keta120                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿２０ */
     ztyfreearea37keta121                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿２１ */
     ztyfreearea37keta122                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿２２ */
     ztyfreearea37keta123                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿２３ */
     ztyfreearea37keta124                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿２４ */
     ztyfreearea37keta125                               VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア（３７桁）１＿２５ */
     ztymidasi11                                        VARCHAR     (19)                                                                ,  /* （中継用）見出し１＿１ */
     ztytouduketorihouhou                               VARCHAR     (16)                                                                ,  /* （中継用）当Ｄ受取方法 */
     ztymidasi21                                        VARCHAR     (19)                                                                ,  /* （中継用）見出し２＿１ */
     ztykakuteidkgk                                     VARCHAR     (17)                                                                ,  /* （中継用）確定Ｄ金額 */
     ztymidasi31                                        VARCHAR     (19)                                                                ,  /* （中継用）見出し３＿１ */
     ztynaiteidkgk                                      VARCHAR     (17)                                                                ,  /* （中継用）内定Ｄ金額 */
     ztymidasi41                                        VARCHAR     (19)                                                                ,  /* （中継用）見出し４＿１ */
     ztyseisandkgk                                      VARCHAR     (17)                                                                ,  /* （中継用）精算Ｄ金額 */
     ztyfreearea21                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿１ */
     ztyfreearea22                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿２ */
     ztyfreearea23                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿３ */
     ztyfreearea24                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿４ */
     ztyfreearea25                                      VARCHAR     (37)                                                                ,  /* （中継用）フリーエリア２＿５ */
     ztyyobiv141                                        VARCHAR     (141)                                                               ,  /* （中継用）予備項目Ｖ１４１ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SeisanDHaneiTuutiTy ADD CONSTRAINT PK_SeisanDHaneiTuutiTy PRIMARY KEY (
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztykeysyono                                                /* （中継用）キー証券番号 */
) ;
