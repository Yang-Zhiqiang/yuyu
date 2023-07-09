CREATE VIEW MT_DsTourokuUkKouzaAnsyono AS SELECT
     syono ,         /* 証券番号 */
     dsttdksyubetukbn ,         /* ＤＳ手続種別区分 */
     datarenno ,         /* データ連番 */
     kzsyuruikbn ,         /* 口座種類区分 */
     soukinkzyennrkumu ,         /* 送金用口座（円貨）入力有無 */
     tokuteitrhkansyononrkumu ,         /* 特定取引用暗証番号入力有無 */
     dstrhkserviceknykeironrumu ,         /* ＤＳ取引サービス加入経路入力有無 */
     bankcd ,         /* 銀行コード */
     sitencd ,         /* 支店コード */
     yokinkbn ,         /* 預金種目区分 */
     kouzano ,         /* 口座番号 */
     kzdoukbn ,         /* 口座名義人同一区分 */
     kzmeiginmkn ,         /* 口座名義人氏名（カナ） */
     tokuteitrhkansyono ,         /* 特定取引用暗証番号 */
     trksriyuukbn ,         /* 取消理由区分 */
     dstrhkservicekanyukeirokbn ,         /* ＤＳ取引サービス加入経路区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsTourokuUkKouzaAnsyono_Z;