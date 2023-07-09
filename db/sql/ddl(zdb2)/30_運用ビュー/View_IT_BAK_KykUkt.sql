CREATE VIEW IT_BAK_KykUkt AS SELECT
     kbnkey ,         /* 区分キー */
     syono ,         /* 証券番号 */
     trkssikibetukey ,         /* 取消識別キー */
     uktsyukbn ,         /* 受取人種類区分 */
     uktsyurenno ,         /* 受取人種類別連番 */
     kokno ,         /* 顧客番号 */
     uktkbn ,         /* 受取人区分 */
     uktnmkn ,         /* 受取人名（カナ） */
     uktnmkj ,         /* 受取人名（漢字） */
     uktnmkjkhukakbn ,         /* 受取人名漢字化不可区分 */
     uktseiymd ,         /* 受取人生年月日 */
     ukttdk ,         /* 受取人続柄 */
     uktbnwari ,         /* 受取人分割割合 */
     gyoumuKousinKinou ,         /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId ,         /* 業務用更新者ＩＤ */
     gyoumuKousinTime ,         /* 業務用更新時間 */
     kousinsyaId ,         /* 更新者ＩＤ */
     kousinTime ,         /* 更新時間 */
     kousinKinou ,         /* 更新機能 */
     version           /* バージョン */
FROM IT_BAK_KykUkt_Z;