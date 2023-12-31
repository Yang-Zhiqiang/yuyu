CREATE VIEW ZT_CreditHnknTuutiRn AS SELECT
     zrnsyoruicd ,         /* （連携用）書類コード */
     zrnhassoukbn ,         /* （連携用）発送区分 */
     zrntyouhyouymd ,         /* （連携用）帳票作成日 */
     zrntyouhyouymdkj ,         /* （連携用）帳票作成日（漢字） */
     zrnsyono ,         /* （連携用）証券番号 */
     zrnsikibetuno ,         /* （連携用）識別番号 */
     zrnyobiv14 ,         /* （連携用）予備項目Ｖ１４ */
     zrnansyuyouyobin10 ,         /* （連携用）案内収納用予備項目Ｎ１０ */
     zrnshskyno ,         /* （連携用）送付先郵便番号 */
     zrnshskadr1kj ,         /* （連携用）送付先住所１（漢字） */
     zrnshskadr2kj ,         /* （連携用）送付先住所２（漢字） */
     zrnshskadr3kj ,         /* （連携用）送付先住所３（漢字） */
     zrnshsnmkj ,         /* （連携用）送付先名（漢字） */
     zrnyobiv43 ,         /* （連携用）予備項目Ｖ４３ */
     zrnansyuyouyobin10x2 ,         /* （連携用）案内収納用予備項目Ｎ１０＿２ */
     zrntawsosikikj ,         /* （連携用）問合せ先組織名（漢字） */
     zrntawyno ,         /* （連携用）問合せ先郵便番号 */
     zrntawadr1kj ,         /* （連携用）問合せ先住所１（漢字） */
     zrntawadr2kj ,         /* （連携用）問合せ先住所２（漢字） */
     zrntawadr3kj ,         /* （連携用）問合せ先住所３（漢字） */
     zrntawtelnov14 ,         /* （連携用）問合せ先電話番号Ｖ１４ */
     zrntawteluktkkanou1 ,         /* （連携用）問合せ先電話受付可能時間１ */
     zrntawteluktkkanou2 ,         /* （連携用）問合せ先電話受付可能時間２ */
     zrndai2tawsosikinmkj ,         /* （連携用）第２問合せ先組織名（漢字） */
     zrndai2tawtelno ,         /* （連携用）第２問合せ先電話番号 */
     zrnsclatosyono ,         /* （連携用）スクランブル後証券番号 */
     zrnsakunm15keta ,         /* （連携用）作成番号（１５桁） */
     zrnyobiv62 ,         /* （連携用）予備項目Ｖ６２ */
     zrnansyuyouyobin10x3 ,         /* （連携用）案内収納用予備項目Ｎ１０＿３ */
     zrnhnknmsgmongon1 ,         /* （連携用）返金メッセージ文言１ */
     zrnhnknmsgmongon2 ,         /* （連携用）返金メッセージ文言２ */
     zrnhnknmsgmongon3 ,         /* （連携用）返金メッセージ文言３ */
     zrnhnknmsgmongon4 ,         /* （連携用）返金メッセージ文言４ */
     zrnhnknmsgmongon5 ,         /* （連携用）返金メッセージ文言５ */
     zrnhnknmsgmongon6 ,         /* （連携用）返金メッセージ文言６ */
     zrnhnknmsgmongon7 ,         /* （連携用）返金メッセージ文言７ */
     zrnhnknmsgmongon8 ,         /* （連携用）返金メッセージ文言８ */
     zrnhnknmsgmongon9 ,         /* （連携用）返金メッセージ文言９ */
     zrnhnknmsgmongon10 ,         /* （連携用）返金メッセージ文言１０ */
     zrnyobiv128 ,         /* （連携用）予備項目Ｖ１２８ */
     zrnansyuyouyobin10x4 ,         /* （連携用）案内収納用予備項目Ｎ１０＿４ */
     zrntuutisakuseiymdv32 ,         /* （連携用）通知作成年月日Ｖ３２ */
     zrnyobiv64 ,         /* （連携用）予備項目Ｖ６４ */
     zrnansyuyouyobin10x5 ,         /* （連携用）案内収納用予備項目Ｎ１０＿５ */
     zrnhnknnaiyoumongon1 ,         /* （連携用）返金内容文言１ */
     zrnhnknnaiyoumongon2 ,         /* （連携用）返金内容文言２ */
     zrnhnknnaiyoumongon3 ,         /* （連携用）返金内容文言３ */
     zrnhnknnaiyoumongon4 ,         /* （連携用）返金内容文言４ */
     zrnhnknnaiyoumongon5 ,         /* （連携用）返金内容文言５ */
     zrnhnknnaiyoumongon6 ,         /* （連携用）返金内容文言６ */
     zrnhnknnaiyoumongon7 ,         /* （連携用）返金内容文言７ */
     zrnhnknnaiyoumongon8 ,         /* （連携用）返金内容文言８ */
     zrnyobiv128x2 ,         /* （連携用）予備項目Ｖ１２８＿２ */
     zrnansyuyouyobin10x6 ,         /* （連携用）案内収納用予備項目Ｎ１０＿６ */
     zrnhnknmsghsk1 ,         /* （連携用）返金メッセージ補足１ */
     zrnhnknmsghsk2 ,         /* （連携用）返金メッセージ補足２ */
     zrnhnknmsghsk3 ,         /* （連携用）返金メッセージ補足３ */
     zrnhnknmsghsk4 ,         /* （連携用）返金メッセージ補足４ */
     zrnhnknmsghsk5 ,         /* （連携用）返金メッセージ補足５ */
     zrnhnknmsghsk6 ,         /* （連携用）返金メッセージ補足６ */
     zrnhnknmsghsk7 ,         /* （連携用）返金メッセージ補足７ */
     zrnhnknmsghsk8 ,         /* （連携用）返金メッセージ補足８ */
     zrnhnknmsghsk9 ,         /* （連携用）返金メッセージ補足９ */
     zrnhnknmsghsk10 ,         /* （連携用）返金メッセージ補足１０ */
     zrnhnknmsghsk11 ,         /* （連携用）返金メッセージ補足１１ */
     zrnhnknmsghsk12 ,         /* （連携用）返金メッセージ補足１２ */
     zrnhnknmsghsk13 ,         /* （連携用）返金メッセージ補足１３ */
     zrnhnknmsghsk14 ,         /* （連携用）返金メッセージ補足１４ */
     zrnhnknmsghsk15 ,         /* （連携用）返金メッセージ補足１５ */
     zrnhnknmsghsk16 ,         /* （連携用）返金メッセージ補足１６ */
     zrnhnknmsghsk17 ,         /* （連携用）返金メッセージ補足１７ */
     zrnhnknmsghsk18 ,         /* （連携用）返金メッセージ補足１８ */
     zrnhnknmsghsk19 ,         /* （連携用）返金メッセージ補足１９ */
     zrnhnknmsghsk20 ,         /* （連携用）返金メッセージ補足２０ */
     zrnyobiv128x3 ,         /* （連携用）予備項目Ｖ１２８＿３ */
     zrnansyuyouyobin10x7           /* （連携用）案内収納用予備項目Ｎ１０＿７ */
FROM ZT_CreditHnknTuutiRn_Z;