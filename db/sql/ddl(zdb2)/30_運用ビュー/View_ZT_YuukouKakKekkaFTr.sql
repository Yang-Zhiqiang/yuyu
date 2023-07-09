CREATE VIEW ZT_YuukouKakKekkaFTr AS SELECT
     ztrrecordkbn ,         /* （取込用）レコード区分 */
     ztryobiv1 ,         /* （取込用）予備項目Ｖ１ */
     ztrcreditkessaiyouno ,         /* （取込用）クレジットカード決済用番号 */
     ztrdbkeykugirimoji1 ,         /* （取込用）ＤＢキー区切り文字１ */
     ztrdbkeykugirimoji2 ,         /* （取込用）ＤＢキー区切り文字２ */
     ztryobiv32 ,         /* （取込用）予備項目Ｖ３２ */
     ztrcardno ,         /* （取込用）カード番号 */
     ztrcardyuukoukigen ,         /* （取込用）カード有効期限 */
     ztryuukouhanteikekka ,         /* （取込用）有効性判定結果 */
     ztryobiv59 ,         /* （取込用）予備項目Ｖ５９ */
     ztrcreditkigyoucd ,         /* （取込用）クレジット企業コード */
     ztryobiv53 ,         /* （取込用）予備項目Ｖ５３ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_YuukouKakKekkaFTr_Z;