CREATE VIEW JT_MisyuupRendo AS SELECT
     syono ,         /* 証券番号 */
     datarenno ,         /* データ連番 */
     nykkeiro ,         /* 入金経路 */
     hrkkaisuu ,         /* 払込回数 */
     nyknaiyoukbn ,         /* 入金内容区分 */
     iktnyuukinnumu ,         /* 一括入金有無 */
     misyuupjyuutouym ,         /* 未収保険料充当年月 */
     misyuupjyuutoukaisuuy ,         /* 未収保険料充当回数（年） */
     misyuupjyuutoukaisuum ,         /* 未収保険料充当回数（月） */
     misyuup ,         /* 未収保険料 */
     misyuup$ ,         /* 未収保険料(通貨型) */
     ryosyuymd ,         /* 領収日 */
     denymd ,         /* 伝票日付 */
     tikiktbrisyuruikbn ,         /* 定期一括払種類区分 */
     shrtuukasyu ,         /* 支払通貨種類 */
     nyknkwsratekijyunymd ,         /* 入金用為替レート基準日 */
     syoriYmd ,         /* 処理年月日 */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_MisyuupRendo_Z;