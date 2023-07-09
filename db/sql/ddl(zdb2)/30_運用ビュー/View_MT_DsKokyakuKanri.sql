CREATE VIEW MT_DsKokyakuKanri AS SELECT
     dskokno ,         /* ＤＳ顧客番号 */
     dskokyakujtkbn ,         /* ＤＳ顧客状態区分 */
     dskokyakusakuseiymd ,         /* ＤＳ顧客作成年月日 */
     dsteisiriyuukbn ,         /* ＤＳ停止理由区分 */
     dskokyakumukouymd ,         /* ＤＳ顧客無効年月日 */
     seisahuyouhyj ,         /* 精査不要表示 */
     dskokyakunmkn ,         /* ＤＳ顧客名（カナ） */
     dskokyakunmkj ,         /* ＤＳ顧客名（漢字） */
     dskokyakuseiymd ,         /* ＤＳ顧客生年月日 */
     dskokyakuyno ,         /* ＤＳ顧客郵便番号 */
     dskanyuukeirokbn ,         /* ＤＳ加入経路区分 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM MT_DsKokyakuKanri_Z;