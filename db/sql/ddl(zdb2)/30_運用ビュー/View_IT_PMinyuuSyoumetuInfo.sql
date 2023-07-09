CREATE VIEW IT_PMinyuuSyoumetuInfo AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     henkousikibetukey ,         /* 変更識別キー */
     syoriYmd ,         /* 処理年月日 */
     syoriym ,         /* 処理年月 */
     syoumetuymd ,         /* 消滅日 */
     jidousoukinhukariyuu ,         /* 自動送金不可理由 */
     ttdktyuuihanteikekka ,         /* 手続注意判定結果 */
     stknsetkbn ,         /* 質権設定区分 */
     shrgkkei ,         /* 支払額合計 */
     shrgkkei$ ,         /* 支払額合計(通貨型) */
     shrtuukasyu ,         /* 支払通貨種類 */
     shrkwsrate ,         /* 支払時為替レート */
     shrtuukakaiyakuhrkngkkei ,         /* 支払通貨解約返戻金額合計 */
     shrtuukakaiyakuhrkngkkei$ ,         /* 支払通貨解約返戻金額合計(通貨型) */
     kaiyakuhrkngkkeisiteituuka ,         /* 解約返戻金額合計（指定通貨） */
     kaiyakuhrkngkkeisiteituuka$ ,         /* 解約返戻金額合計（指定通貨）(通貨型) */
     sonotaseisan ,         /* その他精算金 */
     sonotaseisan$ ,         /* その他精算金(通貨型) */
     yenkansanhaitoukin ,         /* 円換算配当金 */
     yenkansanhaitoukin$ ,         /* 円換算配当金(通貨型) */
     yensonotahaitoukin ,         /* 円換算その他配当金 */
     yensonotahaitoukin$ ,         /* 円換算その他配当金(通貨型) */
     shrtuukagstszeigk ,         /* 支払通貨源泉徴収税額 */
     shrtuukagstszeigk$ ,         /* 支払通貨源泉徴収税額(通貨型) */
     zitkazukarikingksiteituuka ,         /* 税適預り金額（指定通貨） */
     zitkazukarikingksiteituuka$ ,         /* 税適預り金額（指定通貨）(通貨型) */
     zitkazukarikingkyen ,         /* 税適預り金額（円貨） */
     zitkazukarikingkyen$ ,         /* 税適預り金額（円貨）(通貨型) */
     kaiyakuhrknsiteituuka ,         /* 解約返戻金（指定通貨） */
     kaiyakuhrknsiteituuka$ ,         /* 解約返戻金（指定通貨）(通貨型) */
     kaiyakuhryen ,         /* 解約返戻金（円貨） */
     kaiyakuhryen$ ,         /* 解約返戻金（円貨）(通貨型) */
     yenkrkgk ,         /* 円換算仮受金額 */
     yenkrkgk$ ,         /* 円換算仮受金額(通貨型) */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_PMinyuuSyoumetuInfo_Z;