CREATE VIEW IT_HokenSyoukenHukaInfo AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     tyouhyouymd ,         /* 帳票作成日 */
     henkousikibetukey ,         /* 変更識別キー */
     nksyuruinmsyouken ,         /* 年金種類名称（証券用） */
     teikiikkatubaraitukisuu ,         /* 定期一括払月数 */
     znntikiktbriyhrkgktuktype ,         /* 前納定期一括払円貨払込額通貨タイプ */
     znntikiktbriyenhrkgk ,         /* 前納定期一括払円貨払込額 */
     znntikiktbriyenhrkgk$ ,         /* 前納定期一括払円貨払込額(通貨型) */
     znnkai2 ,         /* 前納回数（２桁） */
     hutanhiyustmkyakkjrtmin ,         /* ご負担費用説明欄解約控除率最小 */
     hutanhiyustmkyakkjrtmax ,         /* ご負担費用説明欄解約控除率最大 */
     fstpznnkngktuktype ,         /* 初回Ｐご確認欄前納金額通貨タイプ */
     fstpznnkngk ,         /* 初回Ｐご確認欄前納金額 */
     fstpznnkngk$ ,         /* 初回Ｐご確認欄前納金額(通貨型) */
     dskjnkngkktuktype ,         /* ＤＳ基準金額通貨タイプ */
     dskjnkngk ,         /* ＤＳ基準金額 */
     dskjnkngk$ ,         /* ＤＳ基準金額(通貨型) */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     tikiktbriyhrkgktuktype ,         /* 定期一括払円貨払込額通貨タイプ */
     tikiktbriyenhrkgk ,         /* 定期一括払円貨払込額 */
     tikiktbriyenhrkgk$           /* 定期一括払円貨払込額(通貨型) */
FROM IT_HokenSyoukenHukaInfo_Z;