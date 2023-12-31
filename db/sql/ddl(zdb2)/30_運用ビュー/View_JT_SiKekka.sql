CREATE VIEW JT_SiKekka AS SELECT
     shiharaikekkadatakbn ,         /* 支払結果データ区分 */
     syono ,         /* 証券番号 */
     syouhncd ,         /* 商品コード */
     syouhnsdno ,         /* 商品世代番号 */
     kyksyouhnrenno ,         /* 契約商品連番 */
     syutkkbn ,         /* 主契約特約区分 */
     nexthrkym ,         /* 次回払込年月 */
     kouryokuhasseiymd ,         /* 効力発生日 */
     syoumetujiyuu ,         /* 消滅事由 */
     gansindankakuteiymd ,         /* がん診断確定日 */
     krkgk ,         /* 仮受金額 */
     krkgk$ ,         /* 仮受金額(通貨型) */
     denymd ,         /* 伝票日付 */
     misyuumikeikakbn ,         /* 未収未経過区分 */
     jyuutouym ,         /* 充当年月 */
     jyutoukaisuuy ,         /* 充当回数（年） */
     jyutoukaisuum ,         /* 充当回数（月） */
     seisanpgoukei ,         /* 精算保険料合計 */
     seisanpgoukei$ ,         /* 精算保険料合計(通貨型) */
     hushrgeninkbn ,         /* 不支払原因区分 */
     syoriYmd ,         /* 処理年月日 */
     zennouseisankgk ,         /* 前納精算金額 */
     zennouseisankgk$ ,         /* 前納精算金額(通貨型) */
     zitkazukarikingksiteituuka ,         /* 税適預り金額（指定通貨） */
     zitkazukarikingksiteituuka$ ,         /* 税適預り金額（指定通貨）(通貨型) */
     zitkazukarikingkyen ,         /* 税適預り金額（円貨） */
     zitkazukarikingkyen$ ,         /* 税適預り金額（円貨）(通貨型) */
     kossyoricd ,         /* 更新処理コード */
     kossyorisscd ,         /* 更新処理詳細コード */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM JT_SiKekka_Z;