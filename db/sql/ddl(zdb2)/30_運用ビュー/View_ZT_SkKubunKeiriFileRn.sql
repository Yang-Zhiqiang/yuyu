CREATE VIEW ZT_SkKubunKeiriFileRn AS SELECT
     zrnkaikeitani ,         /* （連携用）会計単位 */
     zrnsystemkbnnum ,         /* （連携用）システム区分（数値） */
     zrnsyoricd ,         /* （連携用）処理コード */
     zrntorihikiymd ,         /* （連携用）取引年月日 */
     zrntorihikinon7 ,         /* （連携用）取引番号Ｎ７ */
     zrnnyuuryokubasyo ,         /* （連携用）入力場所 */
     zrnnyuuryokusyacd ,         /* （連携用）入力者コード */
     zrnsyoriymdn ,         /* （連携用）処理年月日（数値） */
     zrnkessankbn ,         /* （連携用）決算区分 */
     zrnonlinesyorikbn ,         /* （連携用）オンライン処理区分 */
     zrnyobiv28 ,         /* （連携用）予備項目Ｖ２８ */
     zrnkanjyoukbnn ,         /* （連携用）勘定区分（数値） */
     zrntaisyakukbnn ,         /* （連携用）貸借区分（数値） */
     zrnkanjyoukamokucdn ,         /* （連携用）勘定科目コード（数値） */
     zrnyobiv4 ,         /* （連携用）予備項目Ｖ４ */
     zrnsuitoubumoncd ,         /* （連携用）出納部門コード */
     zrnkingaku ,         /* （連携用）金額 */
     zrnkizokusegment ,         /* （連携用）帰属セグメント */
     zrnaitesegment ,         /* （連携用）相手セグメント */
     zrnyobiv23           /* （連携用）予備項目Ｖ２３ */
FROM ZT_SkKubunKeiriFileRn_Z;