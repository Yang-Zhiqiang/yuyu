CREATE VIEW BT_KbtKarikanjyou AS SELECT
     kbtkarikanjyouskbtkey ,         /* 個別仮勘定識別キー */
     densyskbn ,         /* 伝票用システム区分 */
     denrenno ,         /* 伝票データ連番 */
     edano ,         /* 枝番号 */
     keirisyono ,         /* 経理用証券番号 */
     nyuukinkakusyouno ,         /* 入金確証番号 */
     hurikaedenskssyoriymd ,         /* 振替伝票作成処理年月日 */
     denymd ,         /* 伝票日付 */
     huridenatesakicd ,         /* 振替伝票宛先部課コード */
     taisyakukbn ,         /* 貸借区分 */
     kanjyoukmkcd ,         /* 勘定科目コード */
     denyenkagk ,         /* 伝票金額（円） */
     denyenkagk$ ,         /* 伝票金額（円）(通貨型) */
     syoricd ,         /* 処理コード */
     syorisosikicd ,         /* 処理組織コード */
     kbtkarikanjyoukbn ,         /* 個別仮勘定区分 */
     kskmkanryouymd ,         /* 消込完了年月日 */
     seg1cd ,         /* セグメント１コード */
     syoriYmd ,         /* 処理年月日 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM BT_KbtKarikanjyou_Z;