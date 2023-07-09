CREATE VIEW ZT_SkCreditTourokukekkaQrRn AS SELECT
     zrnrecordkbn ,         /* （連携用）レコード区分 */
     zrnsystemjyusinymd ,         /* （連携用）システム受信日 */
     zrnsystemjyusintime ,         /* （連携用）システム受信時刻 */
     zrncreditqrtrkkbn ,         /* （連携用）クレジットカードＱＲ登録区分 */
     zrncreditqrsousinkbn ,         /* （連携用）クレジットカードＱＲ送信区分 */
     zrncreditkessaiyouno ,         /* （連携用）クレジットカード決済用番号 */
     zrnyobiv34 ,         /* （連携用）予備項目Ｖ３４ */
     zrncreditkaiinno ,         /* （連携用）クレジット会員番号 */
     zrncardyuukoukigen ,         /* （連携用）カード有効期限 */
     zrnauthorigkjyusin ,         /* （連携用）オーソリ金額（受信） */
     zrnyobiv153 ,         /* （連携用）予備項目Ｖ１５３ */
     zrntyuumonno ,         /* （連携用）注文番号 */
     zrnyobiv50 ,         /* （連携用）予備項目Ｖ５０ */
     zrnbluegateshopid ,         /* （連携用）ＢｌｕｅＧａｔｅショップＩＤ */
     zrnyobiv81 ,         /* （連携用）予備項目Ｖ８１ */
     zrnkessaisyoriymd ,         /* （連携用）決済処理日 */
     zrnyobiv24 ,         /* （連携用）予備項目Ｖ２４ */
     zrncreditqrerrorcd ,         /* （連携用）クレジットカードＱＲエラーコード */
     zrnsyouninno7keta ,         /* （連携用）承認番号（７桁） */
     zrnbluegateerrorcd ,         /* （連携用）ＢｌｕｅＧａｔｅエラーコード */
     zrnhisimukekaisyacd ,         /* （連携用）被仕向会社コード */
     zrnbluegatejyusinymdtime ,         /* （連携用）ＢｌｕｅＧａｔｅ受付日時 */
     zrnyobiv160           /* （連携用）予備項目Ｖ１６０ */
FROM ZT_SkCreditTourokukekkaQrRn_Z;