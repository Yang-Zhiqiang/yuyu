CREATE VIEW IT_KhDenpyoData AS SELECT
     denrenno ,         /* 伝票データ連番 */
     edano ,         /* 枝番号 */
     densyskbn ,         /* 伝票用システム区分 */
     syono ,         /* 証券番号 */
     huridenatesakicd ,         /* 振替伝票宛先部課コード */
     tantocd ,         /* 担当コード */
     denymd ,         /* 伝票日付 */
     taisyakukbn ,         /* 貸借区分 */
     kanjyoukmkcd ,         /* 勘定科目コード */
     suitoubumoncd ,         /* 出納部門コード */
     tuukasyu ,         /* 通貨種類 */
     dengaikagk ,         /* 伝票金額（外貨） */
     dengaikagk$ ,         /* 伝票金額（外貨）(通貨型) */
     denkawaserate ,         /* 伝票用為替レート */
     denyenkagk ,         /* 伝票金額（円） */
     denyenkagk$ ,         /* 伝票金額（円）(通貨型) */
     huridenskskbn ,         /* 振替伝票作成区分 */
     denhnknhoukbn ,         /* 伝票用返金方法区分 */
     denshrhoukbn ,         /* 伝票用支払方法区分 */
     syoriYmd ,         /* 処理年月日 */
     syoricd ,         /* 処理コード */
     syorisosikicd ,         /* 処理組織コード */
     seg1cd ,         /* セグメント１コード */
     seg2cd ,         /* セグメント２コード */
     kakokawaserateshiteiflg ,         /* 過去為替レート指定フラグ */
     kakokawaserateshiteiymd ,         /* 過去為替レート指定年月日 */
     kyktuukasyu ,         /* 契約通貨種類 */
     keiyakutuukagk ,         /* 契約通貨金額 */
     keiyakutuukagk$ ,         /* 契約通貨金額(通貨型) */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version ,         /* バージョン */
     dengyoumucd ,         /* 伝票用業務コード */
     syusyouhncd ,         /* 主契約商品コード */
     syouhnsdno ,         /* 商品世代番号 */
     kawasetekiyokbn ,         /* 為替適用区分 */
     denkarikanjyono ,         /* 伝票用仮勘定番号 */
     taisyakutyouseiflg ,         /* 貸借調整フラグ */
     densyorisyousaikbn           /* 伝票用処理詳細区分 */
FROM IT_KhDenpyoData_Z;