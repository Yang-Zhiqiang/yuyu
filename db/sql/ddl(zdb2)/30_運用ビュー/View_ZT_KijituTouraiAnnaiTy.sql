CREATE VIEW ZT_KijituTouraiAnnaiTy AS SELECT
     ztysyoruicd ,         /* （中継用）書類コード */
     ztyhassoukbn ,         /* （中継用）発送区分 */
     ztytyouhyouymd ,         /* （中継用）帳票作成日 */
     ztytyouhyouymdkj ,         /* （中継用）帳票作成日（漢字） */
     ztysyono ,         /* （中継用）証券番号 */
     ztyyobiv9 ,         /* （中継用）予備項目Ｖ９ */
     ztyansyuyouyobin10 ,         /* （中継用）案内収納用予備項目Ｎ１０ */
     ztyshskyno ,         /* （中継用）送付先郵便番号 */
     ztyshskadr1kj ,         /* （中継用）送付先住所１（漢字） */
     ztyshskadr2kj ,         /* （中継用）送付先住所２（漢字） */
     ztyshskadr3kj ,         /* （中継用）送付先住所３（漢字） */
     ztyshsnmkj ,         /* （中継用）送付先名（漢字） */
     ztyyobiv43 ,         /* （中継用）予備項目Ｖ４３ */
     ztyansyuyouyobin10x2 ,         /* （中継用）案内収納用予備項目Ｎ１０＿２ */
     ztytawsosikikj ,         /* （中継用）問合せ先組織名（漢字） */
     ztytawyno ,         /* （中継用）問合せ先郵便番号 */
     ztytawadr1kj ,         /* （中継用）問合せ先住所１（漢字） */
     ztytawadr2kj ,         /* （中継用）問合せ先住所２（漢字） */
     ztytawadr3kj ,         /* （中継用）問合せ先住所３（漢字） */
     ztytawtelnov14 ,         /* （中継用）問合せ先電話番号Ｖ１４ */
     ztytawteluktkkanou1 ,         /* （中継用）問合せ先電話受付可能時間１ */
     ztytawteluktkkanou2 ,         /* （中継用）問合せ先電話受付可能時間２ */
     ztydai2tawsosikinmkj ,         /* （中継用）第２問合せ先組織名（漢字） */
     ztydai2tawtelno ,         /* （中継用）第２問合せ先電話番号 */
     ztysclatosyono ,         /* （中継用）スクランブル後証券番号 */
     ztysakunm15keta ,         /* （中継用）作成番号（１５桁） */
     ztyyobiv60 ,         /* （中継用）予備項目Ｖ６０ */
     ztyansyuyouyobin10x3 ,         /* （中継用）案内収納用予備項目Ｎ１０＿３ */
     ztytuutinm ,         /* （中継用）通知名称 */
     ztyhurikaeyokokumsg32keta1 ,         /* （中継用）振替予告メッセージ（３２桁）１ */
     ztyhurikaeyokokumsg32keta2 ,         /* （中継用）振替予告メッセージ（３２桁）２ */
     ztyhurikaeyokokumsg32keta3 ,         /* （中継用）振替予告メッセージ（３２桁）３ */
     ztyhurikaeyokokumsg32keta4 ,         /* （中継用）振替予告メッセージ（３２桁）４ */
     ztyhurikaeyokokumsg32keta5 ,         /* （中継用）振替予告メッセージ（３２桁）５ */
     ztyhurikaeyokokumsg32keta6 ,         /* （中継用）振替予告メッセージ（３２桁）６ */
     ztyhurikaeyokokumsg32keta7 ,         /* （中継用）振替予告メッセージ（３２桁）７ */
     ztyhurikaeyokokumsg32keta8 ,         /* （中継用）振替予告メッセージ（３２桁）８ */
     ztyyobiv110 ,         /* （中継用）予備項目Ｖ１１０ */
     ztyansyuyouyobin10x4 ,         /* （中継用）案内収納用予備項目Ｎ１０＿４ */
     ztyhrkkeiro ,         /* （中継用）払込経路 */
     ztysyono2 ,         /* （中継用）証券番号２ */
     ztysyouhnnm ,         /* （中継用）商品名 */
     ztykykymdseireki ,         /* （中継用）契約年月日（西暦） */
     ztyhhknnmkj ,         /* （中継用）被保険者名（漢字） */
     ztyyobiv30 ,         /* （中継用）予備項目Ｖ３０ */
     ztyansyuyouyobin10x5 ,         /* （中継用）案内収納用予備項目Ｎ１０＿５ */
     ztykjttrnnfreearea1 ,         /* （中継用）期日到来案内フリーエリア１ */
     ztykjttrnnfreearea2 ,         /* （中継用）期日到来案内フリーエリア２ */
     ztykjttrnnfreearea3 ,         /* （中継用）期日到来案内フリーエリア３ */
     ztykjttrnnfreearea4 ,         /* （中継用）期日到来案内フリーエリア４ */
     ztykjttrnnfreearea5 ,         /* （中継用）期日到来案内フリーエリア５ */
     ztykjttrnnfreearea6 ,         /* （中継用）期日到来案内フリーエリア６ */
     ztykjttrnnfreearea7 ,         /* （中継用）期日到来案内フリーエリア７ */
     ztyyobiv99 ,         /* （中継用）予備項目Ｖ９９ */
     ztyansyuyouyobin10x6 ,         /* （中継用）案内収納用予備項目Ｎ１０＿６ */
     ztytuutisakuseiymdseireki ,         /* （中継用）通知作成年月日（西暦） */
     ztykzhurikaeymdseireki ,         /* （中継用）口座振替日（西暦） */
     ztykzinfo1 ,         /* （中継用）口座情報１ */
     ztykzinfo2 ,         /* （中継用）口座情報２ */
     ztykzinfo3 ,         /* （中継用）口座情報３ */
     ztykzinfo4 ,         /* （中継用）口座情報４ */
     ztykzinfo5 ,         /* （中継用）口座情報５ */
     ztykzinfo6 ,         /* （中継用）口座情報６ */
     ztykzinfo7 ,         /* （中継用）口座情報７ */
     ztykzinfo8 ,         /* （中継用）口座情報８ */
     ztyhknjytukikan ,         /* （中継用）保険料充当期間 */
     ztyhrkgk1 ,         /* （中継用）払込金額１ */
     ztyhrkgk2 ,         /* （中継用）払込金額２ */
     ztyhrkgk3 ,         /* （中継用）払込金額３ */
     ztyhrkgk4 ,         /* （中継用）払込金額４ */
     ztyyobiv146 ,         /* （中継用）予備項目Ｖ１４６ */
     ztyansyuyouyobin10x7 ,         /* （中継用）案内収納用予備項目Ｎ１０＿７ */
     ztykjttrnnfreearea8 ,         /* （中継用）期日到来案内フリーエリア８ */
     ztykjttrnnfreearea9 ,         /* （中継用）期日到来案内フリーエリア９ */
     ztykjttrnnfreearea10 ,         /* （中継用）期日到来案内フリーエリア１０ */
     ztykjttrnnfreearea11 ,         /* （中継用）期日到来案内フリーエリア１１ */
     ztykjttrnnfreearea12 ,         /* （中継用）期日到来案内フリーエリア１２ */
     ztykjttrnnfreearea13 ,         /* （中継用）期日到来案内フリーエリア１３ */
     ztyyobiv84 ,         /* （中継用）予備項目Ｖ８４ */
     ztyansyuyouyobin10x8 ,         /* （中継用）案内収納用予備項目Ｎ１０＿８ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_KijituTouraiAnnaiTy_Z;