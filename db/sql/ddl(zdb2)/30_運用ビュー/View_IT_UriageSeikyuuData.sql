CREATE VIEW IT_UriageSeikyuuData AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     creditkessaiyouno ,         /* クレジットカード決済用番号 */
     uriagenengappi ,         /* 売上年月日 */
     renno3keta ,         /* 連番（３桁） */
     recordno ,         /* レコード番号 */
     syoriYmd ,         /* 処理年月日 */
     credituriageseikyuukbn ,         /* クレジットカード売上請求区分 */
     authorikbn ,         /* オーソリ区分 */
     credituriagegk ,         /* クレジットカード売上金額 */
     credituriagegk$ ,         /* クレジットカード売上金額(通貨型) */
     fukusuukameitennokey ,         /* 複数加盟店番号設定キー情報 */
     jyuutouym ,         /* 充当年月 */
     jyutoukaisuum ,         /* 充当回数（月） */
     jyutoukaisuuy ,         /* 充当回数（年） */
     hrkkaisuu ,         /* 払込回数 */
     tikiktbrisyuruikbn ,         /* 定期一括払種類区分 */
     nyknaiyoukbn ,         /* 入金内容区分 */
     annaino ,         /* 案内番号 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_UriageSeikyuuData_Z;