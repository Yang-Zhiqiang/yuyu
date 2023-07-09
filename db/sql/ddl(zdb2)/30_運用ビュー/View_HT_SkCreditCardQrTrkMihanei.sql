CREATE VIEW HT_SkCreditCardQrTrkMihanei AS SELECT
     syoriYmd ,         /* 処理年月日 */
     systemjyusinymd ,         /* システム受信日 */
     systemjyusintime ,         /* システム受信時刻 */
     creditqrtrkkbn ,         /* クレジットカードＱＲ登録区分 */
     creditqrsousinkbn ,         /* クレジットカードＱＲ送信区分 */
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     nykmosno ,         /* 入金用申込番号 */
     syorizumiflg ,         /* 処理済フラグ */
     creditauthorigk ,         /* クレジットカードオーソリ金額 */
     creditauthorigk$ ,         /* クレジットカードオーソリ金額(通貨型) */
     tyuumonno ,         /* 注文番号 */
     bluegateshopid ,         /* ＢｌｕｅＧａｔｅショップＩＤ */
     kessaisyoriymd ,         /* 決済処理日 */
     creditqrerrorcd ,         /* クレジットカードＱＲエラーコード */
     syouninnoseven ,         /* 承認番号（７桁） */
     bluegateerrorcd ,         /* ＢｌｕｅＧａｔｅエラーコード */
     hisimukekaisyacd ,         /* 被仕向会社コード */
     bluegatejyusinymdtime ,         /* ＢｌｕｅＧａｔｅ受付日時 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM HT_SkCreditCardQrTrkMihanei_Z;