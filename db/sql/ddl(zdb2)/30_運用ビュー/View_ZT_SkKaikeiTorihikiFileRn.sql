CREATE VIEW ZT_SkKaikeiTorihikiFileRn AS SELECT
     zrnlen ,         /* （連携用）ＬＥＮ */
     zrnkaikeitani ,         /* （連携用）会計単位 */
     zrnsystemkbnnum ,         /* （連携用）システム区分（数値） */
     zrnsyoricd ,         /* （連携用）処理コード */
     zrntorihikiymd ,         /* （連携用）取引年月日 */
     zrntorihikinon7 ,         /* （連携用）取引番号Ｎ７ */
     zrnnyuuryokubasyo ,         /* （連携用）入力場所 */
     zrnnyuuryokusyacd ,         /* （連携用）入力者コード */
     zrnsyoriymdn ,         /* （連携用）処理年月日（数値） */
     zrnsimekirikbn ,         /* （連携用）締切区分 */
     zrnkessankbn ,         /* （連携用）決算区分 */
     zrnyobiv20 ,         /* （連携用）予備項目Ｖ２０ */
     zrnkaisyakantorihikikbn ,         /* （連携用）会社間取引区分 */
     zrntukekaekbn ,         /* （連携用）付替区分 */
     zrntablekosuu ,         /* （連携用）テーブル個数 */
     zrnkanjyoukbnn ,         /* （連携用）勘定区分（数値） */
     zrntaisyakukbnn ,         /* （連携用）貸借区分（数値） */
     zrnkanjyoukamokucdn ,         /* （連携用）勘定科目コード（数値） */
     zrnyobiv4 ,         /* （連携用）予備項目Ｖ４ */
     zrnsuitoubumon ,         /* （連携用）出納部門 */
     zrnkingaku ,         /* （連携用）金額 */
     zrntekiyoucd ,         /* （連携用）摘要コード */
     zrnyobiv10 ,         /* （連携用）予備項目Ｖ１０ */
     zrnmeisaikanryoukbn           /* （連携用）明細完了区分 */
FROM ZT_SkKaikeiTorihikiFileRn_Z;