CREATE VIEW ZT_FstpUriageSeikyuuKekkaTr AS SELECT
     ztrrecordkbn ,         /* （取込用）レコード区分 */
     ztrauthorikbn ,         /* （取込用）オーソリ区分 */
     ztruriageseikyuutorihikicd ,         /* （取込用）売上請求取引コード */
     ztryobiv14 ,         /* （取込用）予備項目Ｖ１４ */
     ztruriagetaisyouym ,         /* （取込用）売上対象年月 */
     ztruriageymd6keta ,         /* （取込用）売上年月日（６桁） */
     ztrcreditkigyoucd ,         /* （取込用）クレジット企業コード */
     ztrcreditkessaiyouno ,         /* （取込用）クレジットカード決済用番号 */
     ztrsyono ,         /* （取込用）証券番号 */
     ztrrecordno ,         /* （取込用）レコード番号 */
     ztryobiv3 ,         /* （取込用）予備項目Ｖ３ */
     ztrcardyuukoukigen ,         /* （取込用）カード有効期限 */
     ztrseikyuukngk ,         /* （取込用）請求金額 */
     ztryobiv5 ,         /* （取込用）予備項目Ｖ５ */
     ztrcreditkaiinnokami6keta ,         /* （取込用）クレジット会員番号（上６桁） */
     ztryobiv6 ,         /* （取込用）予備項目Ｖ６ */
     ztrcreditkaiinnosimo4keta ,         /* （取込用）クレジット会員番号（下４桁） */
     ztruriageseikyuuerrorcd ,         /* （取込用）売上請求エラーコード */
     ztrhurikaekekkacd ,         /* （取込用）振替結果コード */
     ztrfukusuukameitennokey ,         /* （取込用）複数加盟店番号設定キー情報 */
     ztryobiv1 ,         /* （取込用）予備項目Ｖ１ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_FstpUriageSeikyuuKekkaTr_Z;