CREATE VIEW ZT_UriageSousinTy AS SELECT
     ztycreditkessaiyouno ,         /* （中継用）クレジットカード決済用番号 */
     ztyauthorikbn ,         /* （中継用）オーソリ区分 */
     ztyuriageseikyuuymd ,         /* （中継用）売上請求年月日 */
     ztyrsgaku ,         /* （中継用）領収金額 */
     ztyfukusuukameitennokey ,         /* （中継用）複数加盟店番号設定キー情報 */
     ztysyono ,         /* （中継用）証券番号 */
     ztyrecordno ,         /* （中継用）レコード番号 */
     ztyuriagetaisyouym ,         /* （中継用）売上対象年月 */
     ztyyobiv33 ,         /* （中継用）予備項目Ｖ３３ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM ZT_UriageSousinTy_Z;