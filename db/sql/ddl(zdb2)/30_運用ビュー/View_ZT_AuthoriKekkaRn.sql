CREATE VIEW ZT_AuthoriKekkaRn AS SELECT
     zrnrecordkbn ,         /* （連携用）レコード区分 */
     zrnkaiintourokukbn ,         /* （連携用）会員登録区分 */
     zrncreditkessaiyouno ,         /* （連携用）クレジットカード決済用番号 */
     zrnyobiv34 ,         /* （連携用）予備項目Ｖ３４ */
     zrncardno ,         /* （連携用）カード番号 */
     zrncardyuukoukigen ,         /* （連携用）カード有効期限 */
     zrnauthorigkjyusin ,         /* （連携用）オーソリ金額（受信） */
     zrnauthorikekkaerrorcd ,         /* （連携用）オーソリ結果エラーコード */
     zrnbluegateerrorcd ,         /* （連携用）ＢｌｕｅＧａｔｅエラーコード */
     zrnyobiv25 ,         /* （連携用）予備項目Ｖ２５ */
     zrnhisimukekaisyacd ,         /* （連携用）被仕向会社コード */
     zrnyobiv5 ,         /* （連携用）予備項目Ｖ５ */
     zrnwentryuserid ,         /* （連携用）ＷエントリユーザＩＤ */
     zrnerrorcomment ,         /* （連携用）エラーコメント */
     zrnniniinfo ,         /* （連携用）任意情報 */
     zrnskjkssityuumonno ,         /* （連携用）即時決済注文番号 */
     zrnskjkssiauthorigk ,         /* （連携用）即時決済オーソリ金額 */
     zrnskjkssiyosinkekka ,         /* （連携用）即時決済与信結果 */
     zrnskjkssibunruikbn ,         /* （連携用）即時決済分類区分 */
     zrndatasyorijyoukyou ,         /* （連携用）データ処理状況 */
     zrndatajyusinymd ,         /* （連携用）データ受信日 */
     zrnyobiv25x2 ,         /* （連携用）予備項目Ｖ２５＿２ */
     zrnrenno7 ,         /* （連携用）連番７桁 */
     zrnyobiv33           /* （連携用）予備項目Ｖ３３ */
FROM ZT_AuthoriKekkaRn_Z;