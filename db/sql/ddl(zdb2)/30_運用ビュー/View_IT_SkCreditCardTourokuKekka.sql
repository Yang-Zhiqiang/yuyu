CREATE VIEW IT_SkCreditCardTourokuKekka AS SELECT
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     datajyusinymd ,         /* データ受信日 */
     syoriYmd ,         /* 処理年月日 */
     kaiintourokukbn ,         /* 会員登録区分 */
     creditcardno ,         /* クレジットカード番号 */
     cardyuukoukigen4keta ,         /* クレジットカード有効期限（４桁） */
     authorigk7keta ,         /* オーソリ金額（７桁） */
     authorikekkaerrorcd ,         /* オーソリ結果エラーコード */
     bluegateerrorcd ,         /* ＢｌｕｅＧａｔｅエラーコード */
     hisimukekaisyacd ,         /* 被仕向会社コード */
     wentryuserid ,         /* ＷエントリユーザＩＤ */
     errorcomment ,         /* エラーコメント */
     niniinfo ,         /* 任意情報 */
     datasyorijyoukyou ,         /* データ処理状況 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_SkCreditCardTourokuKekka_Z;