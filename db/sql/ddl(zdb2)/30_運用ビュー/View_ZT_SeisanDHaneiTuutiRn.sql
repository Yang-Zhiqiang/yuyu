CREATE VIEW ZT_SeisanDHaneiTuutiRn AS SELECT
     zrnsyoruicd ,         /* （連携用）書類コード */
     zrntyouhyouymd ,         /* （連携用）帳票作成日 */
     zrnkeysyono ,         /* （連携用）キー証券番号 */
     zrnhaitounendo ,         /* （連携用）配当年度 */
     zrnhassoukbn ,         /* （連携用）発送区分 */
     zrnatesakiyno ,         /* （連携用）宛先郵便番号 */
     zrnrigikbn ,         /* （連携用）例外区分 */
     zrnhrkkeiro ,         /* （連携用）払込経路 */
     zrnsclatosyono ,         /* （連携用）スクランブル後証券番号 */
     zrnatesakiadr1 ,         /* （連携用）宛先住所１ */
     zrnatesakiadr2 ,         /* （連携用）宛先住所２ */
     zrnatesakiadr3 ,         /* （連携用）宛先住所３ */
     zrnatena1 ,         /* （連携用）宛名１ */
     zrndai1syoukaisakifreearea1 ,         /* （連携用）第１照会先フリーエリア１ */
     zrndai1syoukaisakifreearea2 ,         /* （連携用）第１照会先フリーエリア２ */
     zrndai1syoukaisakifreearea3 ,         /* （連携用）第１照会先フリーエリア３ */
     zrndai1syoukaisakifreearea4 ,         /* （連携用）第１照会先フリーエリア４ */
     zrndai1syoukaisakifreearea5 ,         /* （連携用）第１照会先フリーエリア５ */
     zrnsakunm ,         /* （連携用）作成番号 */
     zrnsakuseiymdseireki ,         /* （連携用）作成年月日（西暦） */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnkykymdseireki ,         /* （連携用）契約年月日（西暦） */
     zrnseisikihknnm ,         /* （連携用）正式保険名称 */
     zrnhhknnmkj17 ,         /* （連携用）被保険者名（漢字）（１７桁） */
     zrnfreearea37keta11 ,         /* （連携用）フリーエリア（３７桁）１＿１ */
     zrnfreearea37keta12 ,         /* （連携用）フリーエリア（３７桁）１＿２ */
     zrnfreearea37keta13 ,         /* （連携用）フリーエリア（３７桁）１＿３ */
     zrnfreearea37keta14 ,         /* （連携用）フリーエリア（３７桁）１＿４ */
     zrnfreearea37keta15 ,         /* （連携用）フリーエリア（３７桁）１＿５ */
     zrnfreearea37keta16 ,         /* （連携用）フリーエリア（３７桁）１＿６ */
     zrnfreearea37keta17 ,         /* （連携用）フリーエリア（３７桁）１＿７ */
     zrnfreearea37keta18 ,         /* （連携用）フリーエリア（３７桁）１＿８ */
     zrnfreearea37keta19 ,         /* （連携用）フリーエリア（３７桁）１＿９ */
     zrnfreearea37keta110 ,         /* （連携用）フリーエリア（３７桁）１＿１０ */
     zrnfreearea37keta111 ,         /* （連携用）フリーエリア（３７桁）１＿１１ */
     zrnfreearea37keta112 ,         /* （連携用）フリーエリア（３７桁）１＿１２ */
     zrnfreearea37keta113 ,         /* （連携用）フリーエリア（３７桁）１＿１３ */
     zrnfreearea37keta114 ,         /* （連携用）フリーエリア（３７桁）１＿１４ */
     zrnfreearea37keta115 ,         /* （連携用）フリーエリア（３７桁）１＿１５ */
     zrnfreearea37keta116 ,         /* （連携用）フリーエリア（３７桁）１＿１６ */
     zrnfreearea37keta117 ,         /* （連携用）フリーエリア（３７桁）１＿１７ */
     zrnfreearea37keta118 ,         /* （連携用）フリーエリア（３７桁）１＿１８ */
     zrnfreearea37keta119 ,         /* （連携用）フリーエリア（３７桁）１＿１９ */
     zrnfreearea37keta120 ,         /* （連携用）フリーエリア（３７桁）１＿２０ */
     zrnfreearea37keta121 ,         /* （連携用）フリーエリア（３７桁）１＿２１ */
     zrnfreearea37keta122 ,         /* （連携用）フリーエリア（３７桁）１＿２２ */
     zrnfreearea37keta123 ,         /* （連携用）フリーエリア（３７桁）１＿２３ */
     zrnfreearea37keta124 ,         /* （連携用）フリーエリア（３７桁）１＿２４ */
     zrnfreearea37keta125 ,         /* （連携用）フリーエリア（３７桁）１＿２５ */
     zrnmidasi11 ,         /* （連携用）見出し１＿１ */
     zrntouduketorihouhou ,         /* （連携用）当Ｄ受取方法 */
     zrnmidasi21 ,         /* （連携用）見出し２＿１ */
     zrnkakuteidkgk ,         /* （連携用）確定Ｄ金額 */
     zrnmidasi31 ,         /* （連携用）見出し３＿１ */
     zrnnaiteidkgk ,         /* （連携用）内定Ｄ金額 */
     zrnmidasi41 ,         /* （連携用）見出し４＿１ */
     zrnseisandkgk ,         /* （連携用）精算Ｄ金額 */
     zrnfreearea21 ,         /* （連携用）フリーエリア２＿１ */
     zrnfreearea22 ,         /* （連携用）フリーエリア２＿２ */
     zrnfreearea23 ,         /* （連携用）フリーエリア２＿３ */
     zrnfreearea24 ,         /* （連携用）フリーエリア２＿４ */
     zrnfreearea25 ,         /* （連携用）フリーエリア２＿５ */
     zrnyobiv141           /* （連携用）予備項目Ｖ１４１ */
FROM ZT_SeisanDHaneiTuutiRn_Z;