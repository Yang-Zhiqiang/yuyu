CREATE VIEW BT_SinkeiyakuHurikaeDen AS SELECT
     densyskbn ,         /* 伝票用システム区分 */
     denrenno ,         /* 伝票データ連番 */
     edano ,         /* 枝番号 */
     torihikino ,         /* 取引番号 */
     keirisyskbn ,         /* 経理システム区分 */
     keirisyono ,         /* 経理用証券番号 */
     huridenatesakicd ,         /* 振替伝票宛先部課コード */
     tantocd ,         /* 担当コード */
     denymd ,         /* 伝票日付 */
     taisyakukbn ,         /* 貸借区分 */
     kanjyoukmkcd ,         /* 勘定科目コード */
     denkanjokamokucd ,         /* 伝票用勘定科目コード */
     kanjyoukmkgroupkbn ,         /* 勘定科目グループ区分 */
     suitoubumoncd ,         /* 出納部門コード */
     denyenkagk ,         /* 伝票金額（円） */
     denyenkagk$ ,         /* 伝票金額（円）(通貨型) */
     syoriYmd ,         /* 処理年月日 */
     naibukeiyakukbn ,         /* 内部契約区分 */
     tekiyoukbn ,         /* 摘要区分 */
     tekiyoucd ,         /* 摘要コード */
     huridenpyoukyktuukakbn ,         /* 振替伝票用契約通貨区分 */
     tuukasyu ,         /* 通貨種類 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     dengyoumucd ,         /* 伝票用業務コード */
     version           /* バージョン */
FROM BT_SinkeiyakuHurikaeDen_Z;