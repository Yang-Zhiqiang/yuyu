CREATE VIEW MT_DsNeugokiHanteiKekka AS SELECT
     dsdatasakuseiymd ,         /* ＤＳデータ作成日 */
     syono ,         /* 証券番号 */
     dskokno ,         /* ＤＳ顧客番号 */
     dsmailaddressrenban ,         /* ＤＳメールアドレス連番 */
     kyknmkn ,         /* 契約者名（カナ） */
     kykymd ,         /* 契約日 */
     bosyuujiaatukaidrtencd ,         /* 募集時Ａ扱代理店コード */
     bosyuujibatukaidrtencd ,         /* 募集時Ｂ扱代理店コード */
     aisyoumeikbn ,         /* 愛称名区分 */
     kyktuukasyu ,         /* 契約通貨種類 */
     kaiyakuhryen ,         /* 解約返戻金（円貨） */
     kaiyakuhryen$ ,         /* 解約返戻金（円貨）(通貨型) */
     itijibrp ,         /* 一時払保険料 */
     itijibrp$ ,         /* 一時払保険料(通貨型) */
     neugokihanteikjnkngk ,         /* 値動き判定基準金額 */
     neugokihanteikjnkngk$ ,         /* 値動き判定基準金額(通貨型) */
     neugokiwari ,         /* 値動き割合 */
     neugokitoutatulinefile ,         /* 値動き到達ライン（ファイル） */
     neugokitoutatulinemail ,         /* 値動き到達ライン（メール） */
     neugokihanteiumukbn ,         /* 値動き判定有無区分 */
     mailsousinyhkbn ,         /* メール送信要否区分 */
     mailaddresstourokuumukbn ,         /* メールアドレス登録有無区分 */
     dssousinno ,         /* ＤＳ送信番号 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsNeugokiHanteiKekka_Z;