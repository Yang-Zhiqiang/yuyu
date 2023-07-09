CREATE VIEW IT_BAK_KhHaitouKanri AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     haitounendo ,         /* 配当年度 */
     renno ,         /* 連番 */
     haitoukinskskbn ,         /* 配当金作成区分 */
     haitoumeisaikbn ,         /* 配当明細区分 */
     fstkariwariatednendo ,         /* 初回仮割当Ｄ年度 */
     tounendod ,         /* 当年度Ｄ */
     tounendod$ ,         /* 当年度Ｄ(通貨型) */
     naiteikakuteikbn ,         /* 内定確定区分 */
     kariwariatedshrymd ,         /* 仮割当Ｄ支払年月日 */
     kariwariatedruigk ,         /* 仮割当Ｄ累計額 */
     kariwariatedruigk$ ,         /* 仮割当Ｄ累計額(通貨型) */
     kariwariatedgngkkngk ,         /* 仮割当Ｄ減額金額 */
     kariwariatedgngkkngk$ ,         /* 仮割当Ｄ減額金額(通貨型) */
     kariwariatedshrgk ,         /* 仮割当Ｄ支払額 */
     kariwariatedshrgk$ ,         /* 仮割当Ｄ支払額(通貨型) */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_BAK_KhHaitouKanri_Z;