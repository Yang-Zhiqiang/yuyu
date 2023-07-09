CREATE VIEW IT_BAK_KykDairiten AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     drtenrenno ,         /* 代理店連番 */
     drtencd ,         /* 代理店コード */
     drtenkanrisosikicd ,         /* 代理店管理組織コード */
     gyousekikeijyousakisosikicd ,         /* 業績計上先組織コード */
     oyadrtencd ,         /* 親代理店コード */
     bosyuucd ,         /* 募集人コード */
     daibosyuucd ,         /* 代表募集人コード */
     drtenbunumu ,         /* 代理店分担有無 */
     kanjidrtflg ,         /* 幹事代理店フラグ */
     bunwari ,         /* 分担割合 */
     ikanymd ,         /* 移管日 */
     bsyujoyadrtencd ,         /* 募集時親代理店コード */
     bsyujdrtencd ,         /* 募集時代理店コード */
     bsyujbosyuutrkno ,         /* 募集時募集人登録番号 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_BAK_KykDairiten_Z;