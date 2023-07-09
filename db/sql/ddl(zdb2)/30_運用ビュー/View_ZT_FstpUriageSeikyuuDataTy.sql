CREATE VIEW ZT_FstpUriageSeikyuuDataTy AS SELECT
     ztyrecordkbn ,         /* （中継用）レコード区分 */
     ztyauthorikbn ,         /* （中継用）オーソリ区分 */
     ztyuriageseikyuutorihikicd ,         /* （中継用）売上請求取引コード */
     ztyyobiv14 ,         /* （中継用）予備項目Ｖ１４ */
     ztyuriagetaisyouym ,         /* （中継用）売上対象年月 */
     ztyuriageymd6keta ,         /* （中継用）売上年月日（６桁） */
     ztycreditkigyoucd ,         /* （中継用）クレジット企業コード */
     ztycreditkessaiyouno ,         /* （中継用）クレジットカード決済用番号 */
     ztysyono ,         /* （中継用）証券番号 */
     ztyrecordno ,         /* （中継用）レコード番号 */
     ztyyobiv3 ,         /* （中継用）予備項目Ｖ３ */
     ztycardyuukoukigen ,         /* （中継用）カード有効期限 */
     ztyseikyuukngk11keta ,         /* （中継用）請求金額（１１桁） */
     ztyyobiv2 ,         /* （中継用）予備項目Ｖ２ */
     ztycreditkaiinnokami6keta ,         /* （中継用）クレジット会員番号（上６桁） */
     ztyyobiv6 ,         /* （中継用）予備項目Ｖ６ */
     ztycreditkaiinnosimo4keta ,         /* （中継用）クレジット会員番号（下４桁） */
     ztyuriageseikyuuerrorcd ,         /* （中継用）売上請求エラーコード */
     ztyhurikaekekkacd ,         /* （中継用）振替結果コード */
     ztyfukusuukameitennokey ,         /* （中継用）複数加盟店番号設定キー情報 */
     ztyyobiv1 ,         /* （中継用）予備項目Ｖ１ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_FstpUriageSeikyuuDataTy_Z;