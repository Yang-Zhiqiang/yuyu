CREATE VIEW ZT_SkKsnKubunKeiriTy AS SELECT
     ztykaikeitani ,         /* （中継用）会計単位 */
     ztysystemkbnnum ,         /* （中継用）システム区分（数値） */
     ztysyoricd ,         /* （中継用）処理コード */
     ztytorihikiymd ,         /* （中継用）取引年月日 */
     ztytorihikinon7 ,         /* （中継用）取引番号Ｎ７ */
     ztynyuuryokubasyo ,         /* （中継用）入力場所 */
     ztynyuuryokusyacd ,         /* （中継用）入力者コード */
     ztysyoriymdn ,         /* （中継用）処理年月日（数値） */
     ztykessankbn ,         /* （中継用）決算区分 */
     ztyonlinesyorikbn ,         /* （中継用）オンライン処理区分 */
     ztyyobiv28 ,         /* （中継用）予備項目Ｖ２８ */
     ztykanjyoukbnn ,         /* （中継用）勘定区分（数値） */
     ztytaisyakukbnn ,         /* （中継用）貸借区分（数値） */
     ztykanjyoukamokucdn ,         /* （中継用）勘定科目コード（数値） */
     ztyyobiv4 ,         /* （中継用）予備項目Ｖ４ */
     ztysuitoubumoncd ,         /* （中継用）出納部門コード */
     ztykingaku ,         /* （中継用）金額 */
     ztykizokusegment ,         /* （中継用）帰属セグメント */
     ztyaitesegment ,         /* （中継用）相手セグメント */
     ztyyobiv23 ,         /* （中継用）予備項目Ｖ２３ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_SkKsnKubunKeiriTy_Z;